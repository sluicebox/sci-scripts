;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12)
(include sci.sh)
(use Main)
(use PolyPath)
(use System)

(public
	proc12_0 0
	proc12_1 1
	proc12_2 2
	walkEgoInScr 3
)

(local
	local0
	local1
)

(procedure (proc12_1 param1 param2 param3 &tmp temp0 temp1 temp2)
	(= temp0 0)
	(switch gPrevRoomNum
		((gCurRoom north:)
			(gEgo posn: param1 -60)
		)
		((gCurRoom south:)
			(gEgo posn: param1 250)
		)
		((gCurRoom east:)
			(gEgo posn: 370 param2)
		)
		((gCurRoom west:)
			(gEgo posn: -20 param2)
		)
		(else
			(= temp0 1)
			(gEgo posn: param1 param2)
		)
	)
	(if (> argc 2)
		(= temp1 (- (gEgo x:) param1))
		(= temp2 (- (gEgo y:) param2))
		(localproc_0 @temp1 @temp2 param3)
		(gEgo reset: posn: (+ param1 temp1) (+ param2 temp2))
	)
	(if (not temp0)
		(= local0 param1)
		(= local1 param2)
		(gCurRoom setScript: walkEgoInScr)
	else
		(DisposeScript 12)
	)
)

(procedure (proc12_0 param1 param2 &tmp temp0 temp1 temp2)
	(gGame handsOff:)
	(switch param1
		(1
			(= temp0 0)
			(= temp1 -70)
			(= temp2 (gCurRoom north:))
		)
		(3
			(= temp0 0)
			(= temp1 70)
			(= temp2 (gCurRoom south:))
		)
		(2
			(= temp0 20)
			(= temp1 0)
			(= temp2 (gCurRoom east:))
		)
		(4
			(= temp0 -20)
			(= temp1 0)
			(= temp2 (gCurRoom west:))
		)
	)
	(if (> argc 1)
		(localproc_0 @temp0 @temp1 param2)
	)
	(= local0 (+ (gEgo x:) temp0))
	(= local1 (+ (gEgo y:) temp1))
	(gCurRoom setScript: walkEgoOutScr 0 temp2)
)

(procedure (localproc_0 param1 param2 param3 &tmp temp0 temp1 temp2)
	(= temp0 (= temp2 (Memory memPEEK param1)))
	(= temp1 (Memory memPEEK param2))
	(= temp0 (- (CosMult param3 temp0) (SinMult param3 temp1)))
	(= temp1 (+ (SinMult param3 temp2) (CosMult param3 temp1)))
	(Memory memPOKE param1 temp0)
	(Memory memPOKE param2 temp1)
)

(procedure (proc12_2 param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3) ; UNUSED
	(= temp3 0)
	(if (IsObject param2)
		(= temp1 (param2 x:))
		(= temp2 (param2 y:))
		(if (== argc 3)
			(= temp3 param3)
		)
	else
		(= temp1 param2)
		(= temp2 param3)
		(if (== argc 4)
			(= temp3 param4)
		)
	)
	(= temp0 (GetAngle (param1 x:) (param1 y:) temp1 temp2))
	(param1 setHeading: temp0 (and (IsObject temp3) temp3))
	(DisposeScript 12)
)

(instance walkEgoInScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo reset: setMotion: PolyPath local0 local1 self)
			)
			(1
				((ScriptID 10 0) setIt: 4096) ; rgCrown
				(if (not script)
					(= cycles 1)
				)
			)
			(2
				((ScriptID 10 0) clrIt: 4096) ; rgCrown
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(= register 0)
		(DisposeScript 12)
	)
)

(instance walkEgoOutScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: 0)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath local0 local1 self)
			)
			(2
				(gCurRoom newRoom: register)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 12)
	)
)

