;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17)
(include sci.sh)
(use Main)
(use eRS)
(use Language)
(use RandCycle)
(use ForwardCounter)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm017 0
)

(local
	local0
)

(instance rm017 of SQRoom
	(properties
		picture 17
	)

	(method (init &tmp [temp0 50])
		(HandsOff)
		(Load rsVIEW 6)
		(Load rsVIEW 12)
		(super init:)
		(rogHead init:)
		(spArm init:)
		(self setScript: rmScript setRegions: 707) ; intro
	)
)

(instance rmScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== (gLongSong prevSignal:) 10) (== state 1))
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong number: 22 loop: -1 vol: 127 play:)
				(= seconds 3)
			)
			(1
				(spArm setCel: 1)
			)
			(2
				(static init: play:)
				(vohaulHolo init: setCycle: End self)
			)
			(3
				(rogHead setCel: 2)
				(vohaulHolo setLoop: 1 cel: 0 setCycle: Fwd)
				(= seconds 3)
			)
			(4
				(= cycles 10)
			)
			(5
				(vohaulHolo setLoop: 2 cel: 0 setCycle: RandCycle 50 self)
				(= local0
					(proc0_12
						17
						0
						67
						100
						15
						70
						218
						28
						global136
						29
						global129
						30
						1
						33
						68
					)
				)
			)
			(6
				(vohaulHolo setLoop: 1 cel: 0 setCycle: Fwd)
				(= seconds 5)
			)
			(7
				(rogHead setCel: 1)
				(proc0_12 local0)
				(Animate (gCast elements:) 0)
				(= local0
					(proc0_12
						17
						1
						67
						100
						15
						70
						218
						28
						global136
						29
						global129
						30
						1
						33
						68
					)
				)
				(vohaulHolo setLoop: 2 cel: 0 setCycle: RandCycle 50 self)
			)
			(8
				(vohaulHolo setLoop: 1 cel: 0 setCycle: Fwd)
				(= seconds 5)
			)
			(9
				(proc0_12 local0)
				(Animate (gCast elements:) 0)
				(= local0
					(proc0_12
						17
						2
						67
						100
						(LangSwitch 15 11)
						70
						(LangSwitch 218 228)
						28
						global136
						29
						global129
						30
						1
						33
						68
					)
				)
				(vohaulHolo setLoop: 2 cel: 0 setCycle: RandCycle 50 self)
			)
			(10
				(vohaulHolo setLoop: 1 cel: 0 setCycle: Fwd)
				(= seconds 7)
			)
			(11
				(proc0_12 local0)
				(Animate (gCast elements:) 0)
				(= local0
					(proc0_12
						17
						3
						67
						100
						(LangSwitch 12 3)
						70
						(LangSwitch 218 238)
						28
						global136
						29
						global129
						30
						1
						33
						68
					)
				)
				(vohaulHolo setLoop: 2 cel: 0 setCycle: ForwardCounter 15 self)
			)
			(12
				(vohaulHolo setLoop: 1 cel: 0 setCycle: Fwd)
				(= seconds 7)
			)
			(13
				(proc0_12 local0)
				(vohaulHolo setLoop: 0 setCel: 16 setCycle: Beg self)
			)
			(14
				(static dispose:)
				(vohaulHolo dispose:)
				(= seconds 2)
			)
			(15
				(spArm setCel: 0)
				(Animate (gCast elements:) 0)
				(gCurRoom newRoom: 15)
			)
		)
	)
)

(instance spArm of Prop
	(properties
		x 223
		y 109
		view 12
	)
)

(instance rogHead of Prop
	(properties
		x 61
		y 129
		view 12
		loop 1
		priority 14
		signal 16
	)
)

(instance vohaulHolo of Prop
	(properties
		x 173
		y 91
		view 6
		signal 16384
	)
)

(instance static of Sound
	(properties
		number 111
		loop -1
	)
)

