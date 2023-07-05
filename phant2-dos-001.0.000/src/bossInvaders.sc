;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6869)
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

(public
	bossInvaders 0
)

(local
	local0 = 1
	local1 = 1
	local2
	local3 = 5
	local4 = 60
	local5 = 498
	local6 = 260
	local7 = 180
	local8
	local9
	local10
	local11
)

(procedure (localproc_0 param1)
	(switch local1
		(1
			(if (> (+ param1 (daBoss y:)) 85)
				(= local1 -1)
			)
		)
		(-1
			(if (< (- (daBoss y:) param1) 38)
				(= local1 1)
			)
		)
	)
	(= local2 (* param1 local1))
)

(procedure (localproc_1)
	((gUser orphans:) delete: myHandler)
	(moveEnemies dispose:)
	(fire dispose:)
	(daBoss dispose:)
	(local8 eachElementDo: #dispose)
	(local8 release:)
	(local8 dispose:)
	(= local8 0)
)

(instance bossInvaders of P2Room
	(properties
		picture 3000
	)

	(method (init)
		(gGame handsOff:)
		(super init: &rest)
		(Load rsVIEW 3009)
		(Load 140 4834) ; WAVE
		(Load 140 4835) ; WAVE
		(Load 140 4836) ; WAVE
		(Load 140 4837) ; WAVE
		(Lock 140 4836 1) ; WAVE
		(bossShield init:)
		(bounceAndy init:)
		(= local8 (List new:))
		(gTheCursor hide:)
		(gGame handsOn: 1)
	)

	(method (dispose)
		((gUser orphans:) delete: myHandler)
		(Lock 140 4836 0) ; WAVE
		(UnLoad 140 4834)
		(UnLoad 140 4835)
		(UnLoad 140 4836)
		(UnLoad 140 4837)
		(wonGame dispose:)
		(killed dispose:)
		(gTheCursor show:)
		(super dispose: &rest)
	)
)

(instance player of Prop
	(properties
		x 262
		y 260
		view 3009
		loop 15
	)

	(method (init)
		(super init: &rest)
		(SetCursor x (+ y 70))
	)

	(method (handleEvent event &tmp temp0 temp1)
		(event localize: gThePlane)
		(= temp0 (event x:))
		(= temp1 (event y:))
		(if (> temp0 local5)
			(= temp0 local5)
			(SetCursor temp0 gMouseY)
		)
		(if (< temp0 local4)
			(= temp0 local4)
			(SetCursor temp0 gMouseY)
		)
		(if (> temp1 local6)
			(= temp1 local6)
			(SetCursor gMouseX (+ temp1 70))
		)
		(if (< temp1 local7)
			(= temp1 local7)
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
			(= local9 1)
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
		(if local11
			(super dispose: &rest)
		)
	)
)

(instance fire of Script
	(properties)

	(method (doit)
		(if (not local9)
			(super doit: &rest)
		)
	)

	(method (init &tmp temp0)
		(ph2ton init:)
		(= local11 1)
		(super init: &rest)
	)

	(method (dispose)
		(super dispose: &rest)
		(ph2ton dispose:)
		(= local11 0)
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

(class bombsAway of Script
	(properties
		dX 0
		cy 0
	)

	(method (doit)
		(if (not local9)
			(super doit: &rest)
		)
	)

	(method (new param1 param2 &tmp temp0)
		(= dX (- (Random 0 8) 4))
		(= cy (Random 1 5))
		(= temp0 (Clone self))
		(temp0 client: (View new:))
		((temp0 client:) view: 3009 loop: 12)
		((temp0 client:) x: param1 y: param2)
		((temp0 client:) init: setPri: (+ (daBoss priority:) 1))
		(local8 add: temp0)
		(temp0 init: &rest)
	)

	(method (dispose)
		(client dispose:)
		(= client 0)
		(local8 delete: self)
		(super dispose: &rest)
	)

	(method (cue &tmp temp0 temp1 temp2)
		(= ticks cy)
		(if (> (= temp0 (+ (client y:) 5)) (+ local6 10))
			(self dispose:)
			(return 0)
		)
		(if (not (Random 0 4))
			(= dX (- (Random 0 8) 4))
		)
		(if
			(or
				(> (= temp1 (+ (client x:) dX)) (+ local5 20))
				(< temp1 (- local4 20))
			)
			(self dispose:)
			(return 0)
		)
		(client posn: temp1 temp0)
		(return
			(if (proc63002_13 client player)
				(player loop: 11 setCel: 0)
				(player setCycle: End)
				(gCast delete: moveEnemies)
				(= local9 1)
				(killed init:)
			)
		)
	)
)

(instance daBoss of View
	(properties
		x 208
		y 38
		view 3009
		loop 13
	)

	(method (init)
		(super init: &rest)
		(self setPri: 200)
	)
)

(instance bossShield of View
	(properties
		x 208
		y 38
		view 3009
		loop 14
	)

	(method (init)
		(super init: &rest)
		(self setPri: 800)
	)
)

(instance bringOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gP2SoundFX play: 4834)
				(= seconds 2)
			)
			(1
				(gGame handsOff:)
				(daBoss init:)
				(= ticks 45)
			)
			(2
				(= ticks 10)
				(daBoss posn: (+ (daBoss x:) 2) 38)
				(if (< (daBoss x:) 250)
					(-= state 1)
				)
			)
			(3
				(bossShield dispose:)
				((gUser mousers:) add: player)
				((gUser orphans:) add: myHandler)
				(gGame handsOn:)
				(SetCursor (player x:) (+ (player y:) 70))
				(= ticks 10)
			)
			(4
				(moveEnemies init: cue:)
				(= ticks 1)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance moveEnemies of Script
	(properties)

	(method (init)
		(super init: &rest)
		(= scratch (daBoss y:))
	)

	(method (doit)
		(if (not local9)
			(super doit: &rest)
		)
	)

	(method (cue &tmp [temp0 4] temp4)
		(= temp4 5)
		(if (!= (self scratch:) (daBoss y:))
			(= scratch (daBoss y:))
			(= local3 (Random 4 8))
		)
		(= ticks 2)
		(if (and local11 (proc63002_13 daBoss ph2ton))
			(fire dispose:)
			(++ local10)
			(gP2SoundFX play: 4836)
			(if (>= local10 20)
				(gCast delete: self)
				(= local9 1)
				(wonGame init:)
				(return 0)
			)
		)
		(FrameOut)
		(switch local0
			(1
				(if (> (+ local3 (daBoss x:)) (+ local5 10))
					(= local0 -1)
					(localproc_0 temp4)
				)
			)
			(-1
				(if (< (- (daBoss x:) local3) (- local4 10))
					(= local0 1)
					(localproc_0 temp4)
				)
			)
		)
		(if local2
			(daBoss y: (+ (daBoss y:) local2))
			(= scratch 0)
		else
			(daBoss x: (+ (daBoss x:) (* local3 local0)))
		)
		(daBoss update:)
		(if (not (Random 0 8))
			(bombsAway new: (+ (daBoss x:) 20) (+ (daBoss y:) 40))
			(daBoss setCel: 1)
		else
			(daBoss setCel: 0)
		)
		(return (= local2 0))
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
				(localproc_1)
				(gP2SoundFX play: 4837)
				(= seconds 3)
			)
			(2
				(gGame handsOn:)
				(player dispose:)
				(gCurRoom newRoom: global240)
				(= ticks 1)
			)
		)
	)
)

(instance killed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 30)
			)
			(1
				(gGame handsOff:)
				(localproc_1)
				(gP2SoundFX play: 4835)
				(= seconds 3)
			)
			(2
				(gGame handsOn:)
				(player dispose:)
				(gCurRoom newRoom: global240)
				(= ticks 1)
			)
		)
	)
)

(instance andy of Prop
	(properties
		x -30
		y 270
		view 909
		cycleSpeed 5
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance bounceAndy of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(andy init:)
				(= ticks 1)
			)
			(1
				(if (> (= temp0 (+ (= temp0 (andy x:)) 3)) (player x:))
					(= temp0 (player x:))
				else
					(-- state)
				)
				(= ticks 1)
				(andy x: temp0)
			)
			(2
				(gP2SoundFX play: 4801)
				(= ticks 60)
				(player init:)
			)
			(3
				(if (<= (= temp0 (+ (= temp0 (andy x:)) 3)) local5)
					(-- state)
				)
				(= ticks 1)
				(andy x: temp0)
			)
			(4
				(bringOut init:)
				(andy dispose:)
				(self dispose:)
			)
		)
	)
)

