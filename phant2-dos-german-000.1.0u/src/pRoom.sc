;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3009)
(include sci.sh)
(use Main)
(use nExit)
(use BorderWindow)
(use PolyEdit)

(public
	pRoom 0
)

(local
	local0 = 1
	local1 = 1
	local2 = 5
	local3 = 4
	local4 = -1
	local5 = 6
	local6 = 38
	local7 = 520
	local8 = 60
	local9 = 498
	local10
	local11
)

(procedure (localproc_0 param1 param2)
	(return
		(cond
			(
				(or
					(> (param1 left:) (param2 right:))
					(< (param1 right:) (param2 left:))
					(> (param1 top:) (param2 bottom:))
					(< (param1 bottom:) (param2 top:))
				)
				0
			)
			(
				(and
					(<= (param1 left:) (param2 left:))
					(>= (param1 right:) (param2 right:))
					(<= (param1 top:) (param2 top:))
					(>= (param1 bottom:) (param2 bottom:))
				)
				2
			)
			(
				(and
					(>= (param1 left:) (param2 left:))
					(<= (param1 right:) (param2 right:))
					(>= (param1 top:) (param2 top:))
					(<= (param1 bottom:) (param2 bottom:))
				)
				3
			)
			(else 1)
		)
	)
)

(instance pRoom of P2Room
	(properties
		picture 3000
	)

	(method (init)
		(gPlanes plane: gThePlane)
		(Load 140 30091) ; WAVE
		(Lock 140 30091 1) ; WAVE
		(Load 140 30092) ; WAVE
		(Lock 140 30092 1) ; WAVE
		(Load 140 30093) ; WAVE
		(Lock 140 30093 1) ; WAVE
		(= north gPrevRoomNum)
		(super init: &rest)
		((ScriptID 63000 0) exitDir: 8) ; nExit
		(ball init:)
		(cPad init:)
		(pPad init:)
		(csv init:)
		(psv init:)
		(gGame handsOn:)
	)

	(method (newRoom)
		(gPlanes plane: 0)
		(super newRoom: &rest)
		(gTheCursor show:)
		(Lock 140 30091 0) ; WAVE
		(UnLoad 140 30091)
		(Lock 140 30092 0) ; WAVE
		(UnLoad 140 30092)
		(Lock 140 30093 0) ; WAVE
		(UnLoad 140 30093)
	)

	(method (dispose)
		(gTheCursor show:)
		((ScriptID 63000 0) exitDir: 0) ; nExit
		(super dispose: &rest)
	)
)

(instance ball of View
	(properties
		x 320
		y 100
		view 3009
	)

	(method (init)
		(super init: &rest)
		(sBall init: self)
	)
)

(instance sBall of Script
	(properties)

	(method (cue &tmp temp0 temp1 temp2)
		(= cycles local2)
		(if (== (client loop:) 0)
			(= temp0 (+ (client x:) (* local0 local3)))
			(= temp1 (+ (client y:) (* local1 local3)))
			(if (> temp0 local7)
				(= local0 (* (Abs local0) -1))
				(gP2SoundFX play: 30092)
			)
			(if (< temp0 local6)
				(= local0 (Abs local0))
				(gP2SoundFX play: 30092)
			)
			(if (and (!= local1 1) (!= 0 (localproc_0 client cPad)))
				(gP2SoundFX play: 30091)
				(= local1 1)
				(if
					(>
						(= local0
							(cond
								((> (cPad x:) (client x:))
									(- local0 1)
								)
								((< (cPad x:) (client x:))
									(+ local0 1)
								)
								(else local0)
							)
						)
						3
					)
					(= local0 3)
				)
				(if (< local0 -3)
					(= local0 -3)
				)
			)
			(while (not local0)
				(= local0 (- (Random 0 2) 1))
			)
			(if (and (!= local1 -1) (!= 0 (localproc_0 client pPad)))
				(gP2SoundFX play: 30091)
				(pPad setCel: 0)
				(= local1 -1)
				(if
					(>
						(= local0
							(cond
								((> (pPad x:) (client x:))
									(- local0 1)
								)
								((< (pPad x:) (client x:))
									(+ local0 1)
								)
								(else local0)
							)
						)
						3
					)
					(= local0 3)
				)
				(if (< local0 -3)
					(= local0 -3)
				)
			)
			(if (or (> temp1 (pPad y:)) (< temp1 (cPad y:)))
				(gP2SoundFX play: 30093)
				(client setLoop: 1 setCel: 0)
				(= cycles 10)
				(if (> temp1 (pPad y:))
					(++ local11)
					(csv update:)
				else
					(++ local10)
					(if (< (-= local5 2) 1)
						(= local5 1)
					)
					(if (< (-= local2 2) 1)
						(= local2 1)
					)
					(psv update:)
				)
			)
			(= temp2 (client cel:))
			(if (== (client loop:) 0)
				(if (> (+= temp2 (* local0 local1)) 3)
					(= temp2 0)
				)
				(if (< temp2 0)
					(= temp2 3)
				)
			)
			(client setCel: temp2 posn: temp0 temp1)
		else
			(= cycles (if (!= -1 (DoAudio audPOSITION 30093)) 10 else 1))
			(= temp2 (client cel:))
			(if (> (++ temp2) 4)
				(= temp2 0)
				(client setLoop: 0 posn: 320 100)
				(for ((= local0 0)) (not local0) ((= local0 (- (Random 0 4) 2)))
				)
				(= local1 1)
			)
			(client setCel: temp2)
		)
	)
)

(instance cPad of View
	(properties
		x 320
		y 50
		view 3009
		loop 3
	)

	(method (init)
		(super init: &rest)
		(sCPad init: self)
	)
)

(instance sCPad of Script
	(properties)

	(method (cue &tmp temp0 temp1 temp2)
		(= cycles local5)
		(= temp0 (client x:))
		(= temp1 (ball x:))
		(= temp2 (- (ball y:) (cPad y:)))
		(if (== local1 1)
			(+= temp2 (* 2 (- (pPad y:) (ball y:))))
		)
		(if (> (+= temp1 (* temp2 local0)) local7)
			(= temp1 (- local7 (- temp1 local7)))
		)
		(if (< temp1 local6)
			(= temp1 (+ local6 (- temp1 local6)))
		)
		(if (> temp1 temp0)
			(+= temp0 (Random (/ (* local3 2) 3) local3))
		else
			(-= temp0 (Random (/ (* local3 2) 3) local3))
		)
		(if (> temp0 local9)
			(= temp0 local9)
		)
		(if (< temp0 local8)
			(= temp0 local8)
		)
		(client posn: temp0 (client y:))
	)
)

(instance pPad of View
	(properties
		x 320
		y 280
		view 3009
		loop 2
	)

	(method (init)
		(super init: &rest)
		(sPPad init: self)
		((gUser mousers:) add: self)
		(= local4 ((gUser curEvent:) x:))
	)

	(method (handleEvent event &tmp temp0 temp1)
		(event localize: gThePlane)
		(= temp0 (- (event x:) local4))
		(= local4 (event x:))
		(if (> (= temp1 (+ x temp0)) local9)
			(= temp1 local9)
		)
		(if (< temp1 local8)
			(= temp1 local8)
		)
		(self posn: temp1 y)
		(return 0)
	)

	(method (dispose)
		((gUser mousers:) delete: self)
		(super dispose:)
	)
)

(instance sPPad of Script
	(properties)

	(method (cue &tmp temp0 temp1)
		(= temp1 (Clone (gUser curEvent:)))
		(temp1 globalize:)
		(if
			(or
				(not (gThePlane onMe: temp1))
				(and (temp1 localize: gThePlane) 0)
				((ScriptID 63000 0) onMe: temp1) ; nExit
			)
			(gTheCursor show:)
		else
			(gTheCursor hide:)
		)
		(temp1 dispose:)
		(= cycles 4)
		(if (< (= temp0 (+ (client cel:) 1)) 11)
			(client setCel: temp0)
		)
	)
)

(instance csv of View
	(properties
		view 3009
		loop 4
	)

	(method (init)
		(= x (+ local9 75))
		(= y (- (/ (+ (cPad y:) (pPad y:)) 2) 50))
		(super init: &rest)
	)

	(method (update)
		(self setCel: local11)
		(super update:)
		(if (> local11 4)
			(gCurRoom newRoom: gPrevRoomNum)
		)
	)
)

(instance psv of View
	(properties
		view 3009
		loop 4
	)

	(method (init)
		(= x (+ local9 75))
		(= y (+ (/ (+ (cPad y:) (pPad y:)) 2) 50))
		(super init: &rest)
	)

	(method (update)
		(self setCel: local10)
		(super update:)
		(if (> local10 4)
			(gCurRoom newRoom: gPrevRoomNum)
		)
	)
)

