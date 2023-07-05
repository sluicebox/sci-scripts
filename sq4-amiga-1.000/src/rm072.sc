;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 72)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use Feature)
(use LoadMany)
(use Jump)
(use Motion)
(use Actor)
(use System)

(public
	rm072 0
)

(local
	local0 = 282
	local1 = 56
	local2 = 291
	local3 = 62
	[local4 2] = [277 62]
	local6 = 195
	local7 = 54
	local8 = 325
	local9 = 72
)

(instance rm072 of SQRoom
	(properties
		picture 72
	)

	(method (init &tmp temp0)
		(HandsOff)
		(LoadMany rsVIEW 73 72)
		(Load rsSOUND 109)
		(switch gPrevRoomNum
			(45
				(if (IsFlag 0)
					(Load rsSOUND 73)
				else
					(Load rsSOUND 77)
				)
				(HandsOff)
				(self setScript: shipLeaves)
			)
			(90
				(LoadMany rsSOUND 123 811)
				(if (IsFlag 16)
					(ship x: 267 y: 45 init:)
					(gear x: 267 y: 45 cel: 5 init:)
					(manhole setMotion: MoveTo 117 144 manhole)
					(gLongSong2 number: 123 loop: 1 vol: 127 flags: 0 play:)
					(gEgo z: 1000 init:)
					(HandsOff)
					(manholeScript start: 19)
					(self setScript: manholeScript)
				else
					(= temp0 Jump)
					(Load rsSOUND 72)
					(HandsOff)
					(self setScript: manholeScript)
				)
			)
			(else
				(LoadMany rsSOUND 75 76)
				(SetFlag 18)
				(= temp0 Jump)
				(HandsOff)
				(ClearFlag 0)
				(self setScript: xenonLanding)
			)
		)
		(theGreenBldg init:)
		(theWhiteBldg init:)
		(theManhole init:)
		(manhole init:)
		(manholeFeature init:)
		(theRoom init:)
		(rogersHead init:)
		(super init:)
	)

	(method (doit)
		(super doit:)
		(if (and (== (gCurRoom script:) manholeScript) (gEgo mover:))
			(HandsOff)
			(gCurRoom setScript: goto40Script)
		)
	)

	(method (newRoom newRoomNumber)
		(switch newRoomNumber
			(40
				(gLongSong2 fade:)
			)
			(90
				(gLongSong fade:)
			)
		)
		(if (== newRoomNumber 90)
			(SetFlag 16)
		else
			(ClearFlag 16)
		)
		(super newRoom: newRoomNumber)
		(gEgo z: 0)
	)

	(method (dispose)
		(DisposeScript 991)
		(super dispose:)
	)
)

(instance manholeScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 2) (>= (gLongSong prevSignal:) 128))
			(self cue:)
		)
		(if (and (== state 5) (>= (gLongSong prevSignal:) 129))
			(self cue:)
		)
		(if (and (== state 10) (>= (gLongSong prevSignal:) 130))
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 3)
			)
			(1
				(HandsOff)
				(gLongSong number: 72 loop: 1 vol: 127 flags: 0 playBed:)
				(manhole setMotion: MoveTo 117 144 self)
				(gLongSong2 number: 123 loop: 1 vol: 127 flags: 0 play:)
			)
			(2
				(HandsOff)
				(if
					(or
						(< (gLongSong prevSignal:) 1)
						(> (gLongSong prevSignal:) 128)
					)
					(self cue:)
				)
			)
			(3
				(manhole stopUpd:)
				(gEgo z: 1000 init:)
				(gLongSong2 number: 109 loop: -1 vol: 100 flags: 1 play:)
				(ship init: moveSpeed: 1 setMotion: MoveTo 267 24)
				(dust init: cycleSpeed: 2 setCycle: End self)
			)
			(4
				(dust loop: 1 cycleSpeed: 1 setCycle: Fwd)
				(ship setMotion: MoveTo 267 24 self)
			)
			(5
				(if
					(or
						(< (gLongSong prevSignal:) 1)
						(> (gLongSong prevSignal:) 129)
					)
					(self cue:)
				)
			)
			(6
				(ship moveSpeed: 0 setMotion: MoveTo (ship x:) 45)
				(gear
					posn: (ship x:) (ship y:)
					init:
					setCycle: End
					setMotion: MoveTo (ship x:) 45
				)
				(= cycles 1)
			)
			(7
				(= cycles 4)
			)
			(8
				(ship setCel: 0)
				(= cycles 25)
			)
			(9
				(gLongSong2 fade:)
				(= cycles 30)
			)
			(10
				(dust dispose:)
				(if
					(or
						(< (gLongSong prevSignal:) 1)
						(> (gLongSong prevSignal:) 130)
					)
					(self cue:)
				)
			)
			(11
				(HandsOn)
				(sp2 init:)
				(sp3 init:)
				(sp4 init:)
				(sp1
					posn: local0 local1
					setLoop: 3
					init:
					setMotion: JumpTo local2 local3 self
				)
			)
			(12
				(sp1
					setStep: 2 2
					setLoop: 2
					setCycle: Walk
					setMotion: MoveTo local6 local7
				)
				(= cycles 6)
			)
			(13
				(sp2
					posn: local0 local1
					setLoop: 3
					setMotion: JumpTo local2 local3 self
				)
			)
			(14
				(sp2
					setStep: 2 2
					setLoop: 2
					setCycle: Walk
					setMotion: MoveTo local6 local7
				)
				(= cycles 10)
			)
			(15
				(sp3 posn: local0 local1 setMotion: JumpTo local2 local3 self)
			)
			(16
				(sp4 posn: local0 local1 setMotion: JumpTo local2 local3 self)
				(sp3
					setStep: 2 2
					setCycle: Walk
					setMotion: MoveTo local8 local9
				)
			)
			(17
				(sp4
					setStep: 2 2
					setCycle: Walk
					setMotion: MoveTo local8 local9 self
				)
			)
			(18
				(= seconds 15)
			)
			(19
				(= seconds 10)
			)
			(20
				(Print 72 0) ; "The manhole cover is getting heavy!"
				(manhole
					yStep: 2
					setMotion: MoveTo (manhole x:) (+ (manhole y:) 8)
				)
				(= seconds 3)
			)
			(21
				(manhole
					setMotion: MoveTo (manhole x:) (+ (manhole y:) 12) self
				)
				(= seconds 3)
			)
			(22
				(HandsOff)
				(Print 72 1) ; "You slide down the slimy ladder as the manhole cover slams back into place."
				(manhole yStep: 12 setMotion: MoveTo (manhole x:) 188 self)
			)
			(23
				(gLongSong2 number: 811 loop: 1 vol: 127 flags: 0 play:)
				(= cycles 1)
			)
			(24
				(gCurRoom newRoom: 90)
			)
		)
	)
)

(instance xenonLanding of Script
	(properties)

	(method (doit)
		(if (and (== state 17) (== (gLongSong prevSignal:) -1))
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(manhole stopUpd:)
				(= seconds 2)
			)
			(1
				(gLongSong2 number: 109 loop: -1 vol: 100 flags: 0 play:)
				(ship init: setMotion: MoveTo 267 24)
				(dust init: cycleSpeed: 2 setCycle: End self)
			)
			(2
				(gLongSong number: 75 loop: 1 vol: 127 flags: 1 play:)
				(dust loop: 1 cycleSpeed: 1 setCycle: Fwd)
				(ship setMotion: MoveTo 267 24 self)
			)
			(3
				(= cycles 20)
			)
			(4
				(ship setMotion: MoveTo (ship x:) 45)
				(gear
					posn: (ship x:) (ship y:)
					init:
					setCycle: End
					setMotion: MoveTo (ship x:) 45
				)
				(= cycles 1)
			)
			(5
				(= cycles 4)
			)
			(6
				(ship setCel: 0)
				(= cycles 25)
			)
			(7
				(gLongSong2 fade:)
				(= cycles 30)
				(gLongSong number: 76 loop: 1 vol: 127 flags: 1 playBed:)
			)
			(8
				(dust dispose:)
				(= cycles 8)
			)
			(9
				(sp1
					init:
					setLoop: 3
					setStep: 2 2
					moveSpeed: 1
					cycleSpeed: 1
					setCycle: Walk
					x: local6
					y: local7
					setMotion: MoveTo local2 local3
				)
				(= cycles 12)
			)
			(10
				(sp2
					init:
					setLoop: 3
					setStep: 2 2
					moveSpeed: 1
					cycleSpeed: 1
					setCycle: Walk
					x: local6
					y: local7
					setMotion: MoveTo local2 local3
				)
				(= cycles 88)
			)
			(11
				(sp1 setLoop: 2 setMotion: JumpTo local0 (- local1 4) sp1)
				(= cycles 12)
			)
			(12
				(sp2 setLoop: 2 setMotion: JumpTo local0 (- local1 4) sp2)
				(= cycles 1)
			)
			(13
				(sp3
					init:
					x: local8
					y: local9
					setLoop: 2
					setStep: 2 2
					moveSpeed: 1
					cycleSpeed: 1
					setCycle: Walk
					setMotion: MoveTo local2 local3
				)
				(= cycles 12)
			)
			(14
				(sp4
					init:
					x: local8
					y: local9
					setLoop: 2
					setStep: 2 2
					setCycle: Walk
					moveSpeed: 1
					cycleSpeed: 1
					setMotion: MoveTo local2 local3
				)
				(= cycles 20)
			)
			(15
				(sp3 setMotion: JumpTo local0 (- local1 4) sp3)
				(= cycles 12)
			)
			(16
				(sp4 setMotion: JumpTo local0 (- local1 4) sp4)
				(= cycles 12)
			)
			(17 0)
			(18
				(gLongSong2 number: 802 loop: -1 vol: 127 flags: 1 playBed:)
				(gCurRoom newRoom: 45)
			)
		)
	)
)

(instance shipLeaves of Script
	(properties)

	(method (doit &tmp [temp0 5])
		(gear x: (ship x:) y: (- (ship y:) 1))
		(if (and (== state 0) (== (gLongSong2 prevSignal:) 128))
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(manhole stopUpd:)
				(gLongSong number: 109 loop: -1 vol: 100 flags: 0 play:)
				(if (IsFlag 0)
					(gLongSong2 number: 73 loop: 1 vol: 127 flags: 0 playBed:)
				else
					(gLongSong2 number: 77 loop: 1 vol: 127 flags: 1 playBed:)
					(= cycles 30)
				)
				(ship x: 267 y: 45 moveSpeed: 1 init:)
				(dust loop: 1 init: cycleSpeed: 1 setCycle: Fwd)
			)
			(1
				(if (not (IsFlag 18))
					(gLongSong fade:)
				)
				(if (IsFlag 0)
					(gLongSong2 hold: 1)
				)
				(ship setMotion: MoveTo (ship x:) -10 self)
			)
			(2
				(dust loop: 0 cel: 9 cycleSpeed: 1 setCycle: Beg self)
				(if (IsFlag 18)
					(gLongSong2 number: 0 stop:)
				)
			)
			(3
				(if (IsFlag 18)
					(ClearFlag 18)
					(gLongSong fade:)
					(gCurRoom newRoom: 60)
					(self dispose:)
				else
					(gCurRoom newRoom: 59)
					(self dispose:)
				)
			)
		)
	)
)

(instance sewerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(manhole setMotion: MoveTo (manhole x:) 188 self)
			)
			(1
				(gLongSong2 number: 811 loop: 1 vol: 127 flags: 0 play:)
				(= cycles 1)
			)
			(2
				(gCurRoom newRoom: 90)
			)
		)
	)
)

(instance manholeFeature of Feature
	(properties
		x 160
		y 186
		nsBottom 200
		nsRight 320
		description {manhole cover}
		onMeCheck 2
		lookStr {The manhole cover is simply an incredibly heavy slab of metal trying to tamp you back into the tube.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if (!= (gCurRoom script:) xenonLanding)
					(HandsOff)
					(gCurRoom setScript: sewerScript)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance manhole of Actor
	(properties
		x 117
		y 186
		yStep 4
		view 72
		loop 4
		signal 2048
	)

	(method (cue)
		(HandsOn)
		(manhole stopUpd:)
	)
)

(instance ship of Actor
	(properties
		x 210
		y -6
		description {ship}
		lookStr {A sleek patrol transport occupies the area presently.}
		yStep 1
		view 72
		priority 4
		signal 30736
		xStep 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if (== (gCurRoom script:) xenonLanding)
					(gCurRoom newRoom: 45)
				else
					(Print 72 2) ; "If you can do anything with the ship you certainly can't do it from here."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance gear of Actor
	(properties
		yStep 1
		view 72
		loop 1
		priority 5
		signal 26640
		xStep 1
	)
)

(instance dust of Prop
	(properties
		x 213
		y 52
		view 73
		priority 3
		signal 24592
	)
)

(instance sp1 of Actor
	(properties
		yStep 1
		view 72
		loop 2
		priority 6
		signal 18448
		xStep 1
	)

	(method (cue)
		(super cue:)
		(self dispose:)
	)
)

(instance sp2 of Actor
	(properties
		yStep 1
		view 72
		loop 2
		priority 6
		signal 18448
		xStep 1
	)

	(method (cue)
		(super cue:)
		(self dispose:)
	)
)

(instance sp3 of Actor
	(properties
		yStep 1
		view 72
		loop 3
		priority 6
		signal 18448
		xStep 1
	)

	(method (cue)
		(super cue:)
		(self dispose:)
	)
)

(instance sp4 of Actor
	(properties
		yStep 1
		view 72
		loop 3
		priority 6
		signal 18448
		xStep 1
	)

	(method (cue)
		(super cue:)
		(self dispose:)
	)
)

(instance theGreenBldg of Feature
	(properties
		nsBottom 200
		nsRight 320
		description {green building}
		onMeCheck 16
		lookStr {There's that green building again.}
	)
)

(instance theWhiteBldg of Feature
	(properties
		nsBottom 200
		nsRight 320
		description {white building}
		onMeCheck 32
		lookStr {That white building sits over yonder. You start to become properly oriented regarding your position.}
	)
)

(instance theManhole of Feature
	(properties
		x 120
		y 187
		nsBottom 200
		nsRight 320
		description {manhole}
		onMeCheck 64
		lookStr {The dank and slimy conduit calls to you.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(manholeFeature doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rogersHead of Feature
	(properties
		x 120
		y 188
		nsBottom 189
		nsRight 319
		description {head}
		sightAngle 45
		onMeCheck 4
		lookStr {Your head is unusually well suited to serve as a manhole coaster.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 72 3) ; "The only thing you can do to avoid flattening your head any further is get in or get out."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theRoom of Feature
	(properties
		x 152
		nsBottom 189
		nsRight 319
		description {street}
		sightAngle 180
		lookStr {You have a low-level view of the street from your manhole perch.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(HandsOff)
				(gCurRoom setScript: goto40Script)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance goto40Script of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(cond
			((not (IsFlag 73))
				(if (== state 0)
					(if (== register 80)
						(self cue:)
					else
						(++ register)
					)
				)
			)
			((== state 0)
				(self cue:)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetScore 73 3)
				(gLongSong2 fade:)
			)
			(1
				(gCurRoom newRoom: 40)
			)
		)
	)
)

