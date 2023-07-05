;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 760)
(include sci.sh)
(use Main)
(use Sync)
(use RandCycle)
(use Actor)
(use System)

(class RTRandCycle of RandCycle
	(properties)

	(method (doit &tmp temp0)
		(if (> count (= temp0 (GetTime)))
			(if (> (- temp0 cycleCnt) (client cycleSpeed:))
				(if (== (client cel:) 0)
					(switch (Random 1 7)
						(1
							(client cel: (self nextCel:))
						)
					)
				else
					(client cel: (self nextCel:))
				)
				(= cycleCnt (GetTime))
			)
		else
			(client cel: 0)
			(self cycleDone:)
		)
	)

	(method (init param1 param2 param3)
		(super init: param1)
		(client cel: 0)
		(= cycleCnt (GetTime))
		(if (>= argc 2)
			(= count (+ (GetTime) param2))
			(if (>= argc 3)
				(= caller param3)
			)
		else
			(= count -1)
		)
	)
)

(class Kq5Talker of View
	(properties
		bust 0
		eyes 0
		mouth 0
	)

	(method (init param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3 temp4 [temp5 10])
		(= nsRight (+ nsLeft (CelWide view loop cel)))
		(= nsBottom (+ nsTop (CelHigh view loop cel)))
		(= underBits (Graph grSAVE_BOX nsTop nsLeft nsBottom nsRight 1))
		(= temp0 (PicNotValid))
		(PicNotValid 1)
		(= bust param1)
		(= mouth param3)
		(DrawCel
			(param1 view:)
			(param1 loop:)
			(param1 cel:)
			(param1 nsLeft:)
			(param1 nsTop:)
			-1
		)
		(DrawCel
			(param2 view:)
			(param2 loop:)
			(param2 cel:)
			(param2 nsLeft:)
			(param2 nsTop:)
			-1
		)
		(DrawCel
			(param3 view:)
			(param3 loop:)
			(param3 cel:)
			(param3 nsLeft:)
			(param3 nsTop:)
			-1
		)
		(DrawCel view loop cel nsLeft nsTop -1)
		(param3 setCycle: MouthSync param4)
		(if (not (IsObject (param3 cycler:)))
			(param3 cycler: 0)
		)
		(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
		((= eyes param2) setCycle: RTRandCycle (= temp4 (DoAudio audPLAY param4)))
		(+= temp4 (+ 60 (GetTime)))
		(PicNotValid temp0)
		(if global100
			(Display
				(Format @temp5 760 0 param4) ; "%d"
				dsCOORD
				(+ nsLeft 15)
				(+ nsTop 3)
				dsFONT
				999
				dsCOLOR
				1
			)
		)
		(while
			(and
				(or (not ((= temp1 (Event new:)) type:)) (== (temp1 type:) evMOUSERELEASE))
				(< (GetTime) temp4)
			)
			(= temp2 (param2 cel:))
			(= temp3 (param3 cel:))
			(if (param2 cycler:)
				((param2 cycler:) doit:)
			)
			(if (param3 cycler:)
				((param3 cycler:) doit:)
			)
			(if (>= (GetTime) (- temp4 60))
				(param3 setCel: 4)
			)
			(if (!= temp2 (param2 cel:))
				(DrawCel
					(param2 view:)
					(param2 loop:)
					(param2 cel:)
					(param2 nsLeft:)
					(param2 nsTop:)
					-1
				)
				(param2
					nsRight:
						(+
							(param2 nsLeft:)
							(CelWide
								(param2 view:)
								(param2 loop:)
								(param2 cel:)
							)
						)
				)
				(param2
					nsBottom:
						(+
							(param2 nsTop:)
							(CelHigh
								(param2 view:)
								(param2 loop:)
								(param2 cel:)
							)
						)
				)
				(Graph
					grUPDATE_BOX
					(param2 nsTop:)
					(param2 nsLeft:)
					(param2 nsBottom:)
					(param2 nsRight:)
					1
				)
			)
			(if (!= temp3 (param3 cel:))
				(DrawCel
					(param3 view:)
					(param3 loop:)
					(param3 cel:)
					(param3 nsLeft:)
					(param3 nsTop:)
					-1
				)
				(param3
					nsRight:
						(+
							(param3 nsLeft:)
							(CelWide
								(param3 view:)
								(param3 loop:)
								(param3 cel:)
							)
						)
				)
				(param3
					nsBottom:
						(+
							(param3 nsTop:)
							(CelHigh
								(param3 view:)
								(param3 loop:)
								(param3 cel:)
							)
						)
				)
				(Graph
					grUPDATE_BOX
					(param3 nsTop:)
					(param3 nsLeft:)
					(param3 nsBottom:)
					(param3 nsRight:)
					1
				)
			)
			(if (IsObject temp1)
				(temp1 dispose:)
				(= temp1 0)
			)
		)
		(if (param3 cycler:)
			((param3 cycler:) cue: dispose:)
			(param3 cycler: 0)
		)
		(DoAudio audSTOP)
		(param2 setCycle: 0 dispose: delete:)
		(param3 dispose: delete:)
		(param1 dispose: delete:)
		(self dispose:)
		(if (IsObject temp1)
			(if
				(or
					(== (temp1 type:) evMOUSEBUTTON)
					(and (== (temp1 type:) evKEYBOARD) (== (temp1 message:) KEY_RETURN))
				)
				(= global381 1)
			)
			(temp1 dispose:)
		)
	)

	(method (dispose)
		(Graph grRESTORE_BOX underBits)
		(Graph grREDRAW_BOX nsTop nsLeft nsBottom nsRight)
	)
)

