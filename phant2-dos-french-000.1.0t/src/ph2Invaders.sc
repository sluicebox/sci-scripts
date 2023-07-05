;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6868)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use BorderWindow)
(use PolyEdit)
(use DialogEditor)
(use Cycle)
(use Jump)
(use Menu)
(use System)

(public
	ph2Invaders 0
)

(local
	local0 = 1
	local1 = 1
	local2
	local3
	local4
	local5
	local6
	local7
	local8 = 60
	local9 = 498
	local10 = 280
	local11 = 200
	local12
	local13
	local14
	local15
)

(procedure (localproc_0 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
	(= temp4 12)
	(= temp3 12)
	(= temp5 200)
	(= temp6 30)
	(= temp7 18)
	(= temp8 (Random 3 4))
	(= temp9 (Random 3 8))
	(for ((= temp0 0)) (< temp0 temp8) ((++ temp0))
		(for ((= temp1 0)) (< temp1 temp9) ((++ temp1))
			(= temp2 (View new:))
			(temp2
				view: 3009
				x: (+ (* (+ temp7 temp3) temp1) temp5)
				y: (+ (* (+ temp7 temp4) temp0) temp6)
				loop: (+ (mod temp0 3) 8)
				init:
			)
			(local12 add: temp2)
		)
	)
	(localproc_1)
)

(procedure (localproc_1 &tmp temp0 temp1)
	(if (and local12 (local12 size:))
		(= local2 10)
		(= local3 600)
		(= local4 10)
		(= local5 600)
		(for ((= temp0 0)) (< temp0 (local12 size:)) ((++ temp0))
			(= temp1 (local12 at: temp0))
			(= local2 (Max local2 (temp1 x:)))
			(= local3 (Min local3 (temp1 x:)))
			(= local4 (Max local4 (temp1 y:)))
			(= local5 (Min local5 (temp1 y:)))
		)
	)
)

(procedure (localproc_2 param1)
	(switch local1
		(1
			(if (> (+ param1 local4) local10)
				(= local1 -1)
			)
		)
		(-1
			(if (< (- local5 param1) 30)
				(= local1 1)
			)
		)
	)
	(= local6 (* param1 local1))
)

(procedure (localproc_3)
	((gUser orphans:) delete: myHandler)
	(moveEnemies dispose:)
	(fire dispose:)
	(local12 eachElementDo: #dispose)
	(local12 release:)
	(local12 dispose:)
	(= local12 0)
	(local13 eachElementDo: #dispose)
	(local13 release:)
	(local13 dispose:)
	(= local13 0)
)

(instance ph2Invaders of P2Room
	(properties
		picture 3000
	)

	(method (init)
		(Load 140 4830) ; WAVE
		(Load 140 4831) ; WAVE
		(Load 140 4832) ; WAVE
		(Load 140 4833) ; WAVE
		(Lock 140 4832 1) ; WAVE
		(gP2SoundFX play: 4830)
		(= local12 (List new:))
		(= local13 (List new:))
		(localproc_0)
		(gTheCursor hide:)
		((gUser orphans:) add: myHandler)
		(player init:)
		(moveEnemies init: cue:)
		(gPlanes plane: gThePlane)
		(super init: &rest)
		(gGame handsOn: 1)
		(SetCursor (player x:) (+ (player y:) 70))
	)

	(method (dispose)
		(gPlanes plane: 0)
		((gUser orphans:) delete: myHandler)
		(Lock 140 4832 0) ; WAVE
		(UnLoad 140 4830)
		(UnLoad 140 4831)
		(UnLoad 140 4832)
		(UnLoad 140 4833)
		(wonGame dispose:)
		(killed dispose:)
		(gTheCursor show:)
		(super dispose: &rest)
	)
)

(instance player of Prop
	(properties
		x 320
		y 280
		view 3009
		loop 6
	)

	(method (init)
		(super init: &rest)
		((gUser mousers:) add: self)
		(SetCursor x (+ y 70))
	)

	(method (handleEvent event &tmp temp0 temp1)
		(event localize: gThePlane)
		(= temp0 (event x:))
		(= temp1 (event y:))
		(if (> temp0 local9)
			(= temp0 local9)
			(SetCursor temp0 gMouseY)
		)
		(if (< temp0 local8)
			(= temp0 local8)
			(SetCursor temp0 gMouseY)
		)
		(if (> temp1 local10)
			(= temp1 local10)
			(SetCursor gMouseX (+ temp1 70))
		)
		(if (< temp1 local11)
			(= temp1 local11)
			(SetCursor gMouseX (+ temp1 70))
		)
		(self posn: temp0 temp1)
		(return 0)
	)

	(method (dispose)
		((gUser mousers:) delete: self)
		(super dispose:)
	)
)

(instance myHandler of EventHandler
	(properties)

	(method (handleEvent event)
		(if (and (& (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
			(gCast delete: moveEnemies)
			(= local14 1)
			(killed init:)
			(return 0)
		)
		(if (& (event type:) evMOUSEBUTTON)
			(event claimed: 1)
			(player setCycle: fireCycle)
			(fire init:)
		)
		(event claimed:)
	)
)

(instance fireCycle of Cycle
	(properties)

	(method (nextCel &tmp temp0)
		(return
			(if (== (= temp0 (super nextCel:)) (client lastCel:))
				(= completed 1)
				(= temp0 0)
			else
				temp0
			)
		)
	)
)

(instance ph2ton of View
	(properties
		view 3009
		loop 7
	)

	(method (init)
		(= x (player x:))
		(= y (player y:))
		(super init: &rest)
	)

	(method (dispose)
		(if local15
			(super dispose: &rest)
		)
	)
)

(instance fire of Script
	(properties)

	(method (doit)
		(if (not local14)
			(super doit: &rest)
		)
	)

	(method (init &tmp temp0)
		(ph2ton init:)
		(= local15 1)
		(super init: &rest)
	)

	(method (dispose)
		(super dispose: &rest)
		(ph2ton dispose:)
		(= local15 0)
	)

	(method (cue &tmp temp0 temp1)
		(= ticks 1)
		(if (< (= temp0 (- (ph2ton y:) 5)) 10)
			(self dispose:)
			(return 0)
		)
		(return (ph2ton posn: (ph2ton x:) temp0))
	)
)

(class missleAway of Script
	(properties)

	(method (doit)
		(if (not local14)
			(super doit: &rest)
		)
	)

	(method (new param1 param2 &tmp temp0)
		(= temp0 (Clone self))
		(temp0 client: (View new:))
		((temp0 client:) view: 3009 loop: 12)
		((temp0 client:) x: param1 y: param2)
		((temp0 client:) init:)
		(local13 add: temp0)
		(temp0 init: &rest)
	)

	(method (dispose)
		(client dispose:)
		(= client 0)
		(local13 delete: self)
		(super dispose: &rest)
	)

	(method (cue &tmp temp0 temp1)
		(= ticks (Random 1 5))
		(if (> (= temp0 (+ (client y:) 5)) local10)
			(self dispose:)
			(return 0)
		)
		(client posn: (client x:) temp0)
		(return
			(if (proc63002_13 player client)
				(player loop: 11 setCel: 0)
				(player setCycle: End)
				(gCast delete: moveEnemies)
				(= local14 1)
				(killed init:)
			)
		)
	)
)

(instance moveEnemies of Script
	(properties)

	(method (doit)
		(if (not local14)
			(super doit: &rest)
		)
	)

	(method (cue &tmp [temp0 2] temp2 temp3 temp4 temp5 temp6)
		(= temp4 15)
		(= temp5 20)
		(= ticks (local12 size:))
		(if (> ticks 10)
			(= temp4 (= ticks 10))
		)
		(localproc_1)
		(for ((= temp2 0)) (< temp2 (local12 size:)) ((++ temp2))
			(= temp3 (local12 at: temp2))
			(temp3 setCel: (Abs (- (temp3 cel:) 1)))
			(if (and local15 (proc63002_13 ph2ton temp3))
				(fire dispose:)
				(local12 delete: temp3)
				(temp3 dispose:)
				(if (== (local12 size:) 0)
					(gCast delete: self)
					(= local14 1)
					(wonGame init:)
					(return 0)
				else
					(gP2SoundFX play: 4832)
				)
			)
		)
		(FrameOut)
		(switch local0
			(1
				(if (> (+ temp4 local2) (+ local9 10))
					(= local0 -1)
					(localproc_2 temp5)
				)
			)
			(-1
				(if (< (- local3 temp4) (- local8 10))
					(= local0 1)
					(localproc_2 temp5)
				)
			)
		)
		(for ((= temp2 0)) (< temp2 (local12 size:)) ((++ temp2))
			(= temp3 (local12 at: temp2))
			(if local6
				(temp3 y: (+ (temp3 y:) local6))
			else
				(temp3 x: (+ (temp3 x:) (* temp4 local0)))
			)
			(if (> (local12 size:) 16)
				(= temp6 (Random 0 40))
			else
				(= temp6 (Random 0 20))
			)
			(if (not temp6)
				(missleAway new: (temp3 x:) (temp3 y:))
			)
			(if
				(and
					(or
						(<= local3 (player x:) local2)
						(<= local5 (player y:) local4)
					)
					(proc63002_13 player temp3)
				)
				(player loop: 11 setCel: 0)
				(player setCycle: End)
				(gCast delete: self)
				(= local14 1)
				(killed init:)
				(return 0)
			)
		)
		(localproc_1)
		(return (= local6 0))
	)
)

(instance wonGame of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 30)
			)
			(1
				(gGame handsOff:)
				(localproc_3)
				(gP2SoundFX play: 4833)
				(= seconds 3)
			)
			(2
				(gGame handsOn:)
				(player dispose:)
				(if (IsFlag 1004)
					(= global240 gPrevRoomNum)
					(gCurRoom newRoom: 6869) ; bossInvaders
				else
					(gCurRoom newRoom: gPrevRoomNum)
				)
				(= cycles 1)
			)
		)
	)
)

(instance killed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 30)
			)
			(1
				(gGame handsOff:)
				(localproc_3)
				(gP2SoundFX play: 4831)
				(= seconds 3)
			)
			(2
				(gGame handsOn:)
				(player dispose:)
				(gCurRoom newRoom: gPrevRoomNum)
				(= cycles 1)
			)
		)
	)
)

