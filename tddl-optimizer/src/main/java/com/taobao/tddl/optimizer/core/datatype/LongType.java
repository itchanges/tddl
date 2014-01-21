package com.taobao.tddl.optimizer.core.datatype;

import com.taobao.tddl.common.exception.TddlRuntimeException;

public class LongType extends CommonType {

    @Override
    public int encodeToBytes(Object value, byte[] dst, int offset) {
        return DataEncoder.encode(this.convertFrom(value), dst, offset);
    }

    @Override
    public int getLength(Object value) {
        if (value == null) {
            return 1;
        } else {
            return 9;
        }
    }

    @Override
    public DecodeResult decodeFromBytes(byte[] bytes, int offset) {
        try {
            Long v = DataDecoder.decodeLongObj(bytes, offset);
            return new DecodeResult(v, getLength(v));
        } catch (CorruptEncodingException e) {
            throw new TddlRuntimeException(e);
        }
    }

    @Override
    public Long convertFrom(Object value) {
        return (Long) super.convertFrom(value);
    }

    @Override
    public Long incr(Object value) {
        return convertFrom(value) + 1;
    }

    @Override
    public Long decr(Object value) {
        return convertFrom(value) - 1;
    }

    @Override
    public Long getMaxValue() {
        return Long.MAX_VALUE;
    }

    @Override
    public Long getMinValue() {
        return Long.MIN_VALUE;
    }

    @Override
    public Class getDataClass() {
        return Long.class;
    }

}