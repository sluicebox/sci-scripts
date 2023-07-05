;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 455)
(include sci.sh)
(use Main)
(use SQRoom)
(use SQNarrator)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm455 0
	Storm_Pooper 1
)

(local
	local0 = 9
)

(instance rm455 of SQRoom
	(properties
		picture 450
	)

	(method (init)
		(Load rsVIEW 453 454 455 456)
		(Load rsSOUND 456)
		(super init:)
		(gGame handsOff:)
		(gGSound1 number: 456 loop: -1 play: setVol: 127)
		(exitDoor init:)
		(light1 init: setCycle: Fwd)
		(light2 init: setCycle: Fwd)
		(shuttleDoor init:)
		(PalCycle 0 210 220 -1 5) ; Start
		(gCurRoom setScript: sStormPooper)
	)
)

(instance sStormPooper of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(Load rsSOUND 455)
				(Load 140 44001 224) ; WAVE
				(= ticks 360)
			)
			(2
				(gGSound1 number: 455 loop: -1 play:)
				(stormPooper1 init: setCycle: Fwd setMotion: MoveTo 78 55)
				(= ticks 15)
			)
			(3
				(stormPooper4 init:)
				(stormPooper5 init:)
				(stormPooper6 init: setCycle: Fwd setMotion: MoveTo 55 55 self)
			)
			(4
				(fishGuy init: setCycle: Fwd setMotion: MoveTo 158 83)
				(stormPooper7 init: setCycle: Fwd setMotion: MoveTo 157 52)
				(doorSnd play: 50 0)
				(exitDoor setCycle: End)
				(stormPooper5 setCycle: Fwd setMotion: MoveTo 223 54)
				(stormPooper6 hide:)
				(stormPooper1
					posn: 78 54
					view: 454
					loop: 3
					cel: 0
					setCycle: End self
				)
			)
			(5
				(self setScript: sShootSnd)
				(stormPooper4 setCycle: Fwd setMotion: MoveTo 230 54 self)
				(stormPooper6
					posn: 73 54
					view: 455
					loop: 0
					cel: 0
					show:
					cycleSpeed: 1
					setCycle: Fwd
				)
				(stormPooper1
					posn: 94 55
					view: 455
					loop: 1
					cel: 0
					cycleSpeed: 1
				)
			)
			(6
				(doorSnd play: 50 0)
				(exitDoor cel: 10 setCycle: Beg)
				(stormPooper1 setCycle: Fwd)
				(stormPooper5 hide:)
				(stormPooper4
					posn: 225 54
					view: 454
					loop: 1
					cel: 0
					setCycle: End self
				)
			)
			(7
				(stormPooper8 init:)
				(stormPooper5 show: setMotion: MoveTo 139 49)
				(stormPooper4
					posn: 221 52
					view: 455
					loop: 4
					cel: 0
					cycleSpeed: 1
					setCycle: Fwd
				)
				(= ticks 60)
			)
			(8
				(stormPooper8 setCycle: Fwd setMotion: MoveTo 157 52 self)
				(doorSnd play: 50 0)
				(exitDoor cel: 0 setCycle: End)
			)
			(9
				(doorSnd play: 50 0)
				(exitDoor cel: 10 setCycle: Beg)
				(stormPooper8 hide:)
				(stormPooper7
					posn: 157 52
					view: 454
					loop: 2
					cel: 0
					setCycle: End
				)
				(fishGuy
					posn: 158 83
					view: 457
					loop: 0
					cel: 0
					setPri: 100
					setCycle: CT 3 1 self
				)
			)
			(10
				(fishGuy cel: 0 setCycle: End)
				(gMessager say: 0 0 3 0 self 450) ; "Hey! Here's your fish!"
			)
			(11
				(= ticks 60)
			)
			(12
				(self setScript: 0)
				(sShootSnd dispose:)
				(shootSnd stop:)
				(gGSound1 fade:)
				(proc0_7 1 1 self)
			)
			(13
				(PalCycle 4) ; Off
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: -1 0)
				(gTheIconBar clearInvItem:)
				(= global148 0)
				(ClearFlag 73)
				(= cycles 1)
			)
			(14
				(proc0_7 0 1 self)
			)
			(15
				(if (<= gHowFast 3)
					(PlayVMD 0 {450.vmd}) ; Open
					(PlayVMD 1 0 0) ; Put
				else
					(PlayVMD 0 {1450.vmd}) ; Open
					(PlayVMD 1 109 57) ; Put
				)
				(PlayVMD 21 0 0 320 138) ; Black
				(PlayVMD 14 7) ; WaitEvent
				(PlayVMD 6) ; Close
				(= cycles 3)
			)
			(16
				(gCurRoom newRoom: 490)
				(self dispose:)
			)
		)
	)
)

(instance sShootSnd of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(shootSnd play: 45 0)
				(= ticks (proc0_8 2 60))
			)
			(1
				(self changeState: 0)
			)
		)
	)
)

(instance fishGuy of Actor
	(properties
		x -5
		y 79
		view 453
		cel 6
	)
)

(instance light1 of Prop
	(properties
		x 22
		y 111
		priority 200
		fixPriority 1
		view 456
	)
)

(instance light2 of Prop
	(properties
		x 294
		y 24
		priority 200
		fixPriority 1
		view 456
		loop 1
		cel 7
	)
)

(instance stormPooper1 of Actor
	(properties
		x 15
		y 63
		view 453
		signal 16385
	)
)

(instance stormPooper6 of Actor
	(properties
		x 8
		y 57
		view 453
		cel 6
		signal 16385
	)
)

(instance stormPooper4 of Actor
	(properties
		x 183
		y 46
		view 453
		loop 4
		cel 3
		signal 2049
	)
)

(instance stormPooper5 of Actor
	(properties
		x 320
		y 53
		view 453
		loop 5
		signal 2049
	)
)

(instance stormPooper7 of Actor
	(properties
		x -2
		y 57
		view 453
		cel 1
	)
)

(instance stormPooper8 of Actor
	(properties
		x 182
		y 46
		view 453
		loop 5
		signal 2049
	)
)

(instance exitDoor of Prop
	(properties
		x 179
		y 51
		z 20
		view 4501
		signal 20513
		cycleSpeed 4
	)
)

(instance shuttleDoor of Prop
	(properties
		approachX 238
		approachY 103
		x 239
		y 101
		view 450
		signal 20513
	)
)

(instance comet of Prop ; UNUSED
	(properties
		y 13
		view 458
		signal 20513
	)
)

(instance waxingGuy of Prop ; UNUSED
	(properties
		x 131
		y 124
		view 458
		loop 1
		signal 20513
	)
)

(instance workingGuy of Prop ; UNUSED
	(properties
		x 125
		y 79
		view 458
		loop 2
		signal 20513
	)
)

(instance shuttleLights of Prop ; UNUSED
	(properties
		x 207
		y 94
		view 452
	)
)

(instance Storm_Pooper of SmallTalker
	(properties
		name {Storm Pooper}
	)

	(method (init)
		(= client stormPooper8)
		(= showTalk 0)
		(super init:)
	)
)

(instance doorSnd of Sound
	(properties
		number 44001
		loop 0
	)
)

(instance shootSnd of Sound
	(properties
		number 224
		loop -1
	)
)

