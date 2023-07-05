;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 72)
(include sci.sh)
(use Main)
(use Interface)
(use SQRoom)
(use Feature)
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
	local2 = 294
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
		(Load rsVIEW 72)
		(cond
			((== gPrevRoomNum 45)
				(HandsOff)
				(self setScript: shipLeaves)
			)
			((== gPrevRoomNum 90)
				(= temp0 Jump)
				(self setScript: manholeScript)
			)
			(else
				(SetFlag 19)
				(= temp0 Jump)
				(HandsOff)
				(ClearFlag 0)
				(self setScript: xenonLanding)
			)
		)
		(theGreenBldg init:)
		(theWhiteBldg init:)
		(manhole init:)
		(theRoom init:)
		(rogersHead init:)
		(super init:)
	)

	(method (doit)
		(super doit:)
		(if (and (== (gCurRoom script:) manholeScript) (gEgo mover:))
			(gCurRoom newRoom: 40)
		)
	)

	(method (newRoom newRoomNumber)
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

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(manhole setMotion: MoveTo 117 144 self)
			)
			(2
				(manhole stopUpd:)
				(= seconds 5)
			)
			(3
				(HandsOn)
				(gEgo z: 1000 init:)
				(gLongSong2 number: 109 loop: -1 vol: 127 play:)
				(ship init: setMotion: MoveTo 267 24)
				(dust init: cycleSpeed: 2 setCycle: End self)
			)
			(4
				(dust loop: 1 cycleSpeed: 1 setCycle: Fwd)
				(ship setMotion: MoveTo 267 24 self)
			)
			(5
				(= cycles 20)
			)
			(6
				(ship setMotion: MoveTo (ship x:) 45)
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
				(= cycles 20)
			)
			(11
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
				(= seconds 25)
			)
			(19
				(Print 72 0) ; "The manhole cover is getting heavy!"
				(manhole
					yStep: 2
					setMotion: MoveTo (manhole x:) (+ (manhole y:) 8)
				)
				(= seconds 3)
			)
			(20
				(manhole
					setMotion: MoveTo (manhole x:) (+ (manhole y:) 12) self
				)
				(= seconds 3)
			)
			(21
				(HandsOff)
				(Print 72 1) ; "You slide down the slimey ladder as the manhole cover slams back into place."
				(manhole yStep: 12 setMotion: MoveTo (manhole x:) 188 self)
			)
			(22
				(= cycles 1)
			)
			(23
				(gCurRoom newRoom: 90)
			)
		)
	)
)

(instance xenonLanding of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(gLongSong2 number: 109 loop: -1 vol: 127 play:)
				(ship init: setMotion: MoveTo 267 24)
				(dust init: cycleSpeed: 2 setCycle: End self)
			)
			(2
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
			)
			(8
				(dust dispose:)
				(= cycles 20)
			)
			(9
				(sp1
					init:
					setLoop: 3
					setStep: 2 2
					setCycle: Walk
					x: local6
					y: local7
					setMotion: MoveTo local2 local3
				)
				(= cycles 6)
			)
			(10
				(sp2
					init:
					setLoop: 3
					setStep: 2 2
					setCycle: Walk
					x: local6
					y: local7
					setMotion: MoveTo local2 local3
				)
				(= cycles 15)
			)
			(11
				(sp3
					init:
					setLoop: 2
					setStep: 2 2
					setCycle: Walk
					x: local8
					y: local9
					setMotion: MoveTo local2 local3
				)
				(= cycles 6)
			)
			(12
				(sp4
					init:
					setLoop: 2
					setStep: 2 2
					setCycle: Walk
					x: local8
					y: local9
					setMotion: MoveTo local2 local3
				)
				(= cycles 5)
			)
			(13
				(sp1 setMotion: JumpTo local0 local1 sp1)
				(= cycles 6)
			)
			(14
				(sp2 setMotion: JumpTo local0 local1 sp2)
				(= cycles 15)
			)
			(15
				(sp3 setMotion: JumpTo local0 local1 sp3)
				(= cycles 6)
			)
			(16
				(sp4 setMotion: JumpTo local0 local1 sp4)
				(= cycles 5)
			)
			(17
				(gCurRoom newRoom: 45)
			)
		)
	)
)

(instance shipLeaves of Script
	(properties)

	(method (doit)
		(gear x: (ship x:) y: (- (ship y:) 1))
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ship x: 267 y: 45 init:)
				(gear x: 267 y: 44 cel: 0 init:)
				(dust loop: 1 init: cycleSpeed: 1 setCycle: Fwd)
				(= cycles 30)
			)
			(1
				(ship setMotion: MoveTo (ship x:) -10 self)
			)
			(2
				(dust loop: 0 cel: 9 cycleSpeed: 1 setCycle: Beg self)
				(if (IsFlag 19)
					(gLongSong2 number: 0 stop:)
				)
			)
			(3
				(if (IsFlag 19)
					(ClearFlag 19)
					(gCurRoom newRoom: 60)
				else
					(gCurRoom newRoom: 59)
				)
				(self dispose:)
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
				(= cycles 1)
			)
			(2
				(gCurRoom newRoom: 90)
			)
		)
	)
)

(instance manhole of Actor
	(properties
		x 117
		y 188
		description {manhole cover}
		lookStr {The manhole cover is simply an incredibly heavy slab of metal trying to tamp you back into the tube.}
		yStep 4
		view 72
		loop 4
		signal 2048
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
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

(instance ship of Actor
	(properties
		x 210
		y -6
		description {ship}
		lookStr {A sleek ship occupies the area presently.}
		yStep 1
		view 72
		priority 4
		signal 30736
		xStep 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== (gCurRoom script:) xenonLanding)
					(gCurRoom newRoom: 45)
				else
					(Print 72 2) ; "*** You can't do anything with the ship from here."
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

	(method (doVerb theVerb)
		(switch theVerb
			(4) ; Do
			(else
				(super doVerb: theVerb)
			)
		)
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

	(method (doVerb theVerb)
		(switch theVerb
			(4) ; Do
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rogersHead of Feature
	(properties
		x 120
		y 189
		description {head}
		sightAngle 45
		onMeCheck 4
		lookStr {** Your head is flattening out very nicely.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
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
			(4 ; Do
				(gLongSong2 fade:)
				(gCurRoom newRoom: 40)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

