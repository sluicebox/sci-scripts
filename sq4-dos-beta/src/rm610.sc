;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 610)
(include sci.sh)
(use Main)
(use Interface)
(use ulence)
(use SQRoom)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm610 0
)

(instance rm610 of SQRoom
	(properties
		picture 610
		horizon 105
		north 613
		east 611
		west 609
	)

	(method (init)
		(ulence roomVer: 11891)
		(switch gPrevRoomNum
			(615
				(gEgo posn: 206 135)
				(self setScript: exitBar)
			)
			(620
				(gEgo
					posn: 192 113
					view: 615
					setLoop: 0
					cel: 0
					setPri: 9
					looper: 0
					normal: 0
					setStep: 14 14
					cycleSpeed: 0
				)
				(self setScript: flyOut)
			)
			(613
				(gEgo x: 87 y: 124)
			)
			(else
				(gEgo x: 24 y: 165)
			)
		)
		(if (not (IsFlag 15))
			(bike1 init:)
			(bike2 init:)
			(bike3 init:)
			((ScriptID 706 2) init:) ; theBiker
			(biker2 init:)
			(biker3 init:)
		)
		(theSign init: setCycle: Fwd)
		(gEgo init: ignoreActors: 1 illegalBits: 0)
		(super init:)
		(self
			setFeatures: ship1 ship3 building door
			setRegions: 706 ; ulence
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 166 270 166 165 142 171 135 214 135 214 132 149 132 127 125 166 125 163 121 123 121 94 103 58 103 49 107 73 121 63 131 44 136 0 136
					yourself:
				)
		)
		(if (not (IsFlag 15))
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 121 155 179 153 210 165 253 182 191 186
						yourself:
					)
			)
		)
		(Load rsSOUND 804)
		(Load rsVIEW 615)
		(Load rsVIEW 610)
	)

	(method (doit)
		(cond
			(script 0)
			((gEgo inRect: 192 122 221 137)
				(self setScript: enterBar)
			)
		)
		(super doit: &rest)
	)
)

(instance bike1 of Prop
	(properties
		x 159
		y 150
		description {bike1}
		lookStr {As you check these sand bikes out you wonder what kind of cheeseball would own one.}
		view 615
		loop 2
		priority 12
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((not (IsFlag 16))
						(Print 610 0) ; "*** You can't do that -- at least not now!!!"
					)
					((not (IsFlag 15))
						(gCurRoom setScript: kickScript)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bike2 of Prop
	(properties
		x 187
		y 160
		description {bike2}
		lookStr {As you check these sand bikes out you wonder what kind of cheeseball would own one.}
		view 615
		loop 3
		priority 13
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((not (IsFlag 16))
						(Print 610 0) ; "*** You can't do that -- at least not now!!!"
					)
					((not (IsFlag 15))
						(gCurRoom setScript: kickScript)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bike3 of Prop
	(properties
		x 213
		y 170
		description {bike3}
		lookStr {As you check these sand bikes out you wonder what kind of cheeseball would own one.}
		view 615
		loop 4
		priority 14
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((not (IsFlag 16))
						(Print 610 0) ; "*** You can't do that -- at least not now!!!"
					)
					((not (IsFlag 15))
						(gCurRoom setScript: kickScript)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance flyOut of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 2)
			)
			(1
				(gEgo
					setLoop: 0
					cel: 0
					setCycle: CT 3 1
					setMotion: MoveTo 130 127 self
				)
			)
			(2
				(= seconds 3)
			)
			(3
				(gEgo setCycle: End self)
			)
			(4
				(gEgo
					view: 0
					setLoop: 1
					heading: 270
					posn: (- (gEgo x:) 25) (+ (gEgo y:) 25)
				)
				(= cycles 1)
			)
			(5
				(proc706_1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance bikesFall of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(bike1 setCycle: End self)
			)
			(1
				(bike2 setCycle: End self)
			)
			(2
				(bike3 setCycle: End self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance exitBar of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(gLongSong fade:)
				(gEgo setMotion: PolyPath 150 135 self)
			)
			(1
				(proc706_1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance biker2 of Actor
	(properties
		x 223
		y 134
		yStep 4
		view 630
		priority 9
		signal 24593
		illegalBits 0
		xStep 4
	)
)

(instance biker3 of Actor
	(properties
		x 223
		y 134
		yStep 4
		view 631
		priority 9
		signal 24593
		illegalBits 0
		xStep 4
	)
)

(instance ship1 of Feature
	(properties
		x 34
		y 88
		nsTop 49
		nsBottom 128
		nsRight 69
		description {ship1}
		sightAngle 45
		onMeCheck 16
		lookStr {This long-legged beauty stands silently waiting for its jet-faced owner to return.}
	)
)

(instance ship3 of Feature
	(properties
		x 150
		y 85
		nsTop 52
		nsLeft 105
		nsBottom 118
		nsRight 196
		description {ship3}
		sightAngle 45
		onMeCheck 8
		lookStr {It looks like it came from the Planet of the Warts! This ship must be the Planters Deluxe model with authentic Mosaic upholstery.}
	)
)

(instance door of Feature
	(properties
		x 178
		y 111
		nsTop 85
		nsLeft 162
		nsBottom 138
		nsRight 194
		description {door}
		sightAngle 45
		onMeCheck 4
		lookStr {This must be the entrance to this building.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: enterBar)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance building of Feature
	(properties
		x 225
		y 93
		nsTop 23
		nsLeft 132
		nsBottom 164
		nsRight 319
		description {building}
		sightAngle 45
		onMeCheck 2
		lookStr {The Ulence Flats Bar. My, this place brings back some memories - most of them painful.}
	)
)

(instance theSign of Prop
	(properties
		x 209
		y 75
		description {sign}
		sightAngle 45
		lookStr {The sign suggests that this place might be a bar.}
		view 610
		priority 12
		signal 24592
	)
)

(instance bikerScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				((ScriptID 706 2) ; theBiker
					setLoop: 0
					setCycle: Fwd
					setStep: 4 4
					setMotion: MoveTo 159 134 self
				)
			)
			(1
				((ScriptID 706 2) setMotion: MoveTo 133 146 self) ; theBiker
			)
			(2
				((ScriptID 706 2) ; theBiker
					setLoop: 1
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(3
				(= seconds 2)
			)
			(4
				(biker2 setScript: biker2Script)
				((ScriptID 706 2) ; theBiker
					setPri: 12
					setLoop: 2
					cel: 0
					posn: 121 147
					cycleSpeed: 0
					setCycle: End self
					setMotion: MoveTo 133 156
				)
				(= cycles 3)
			)
			(5
				(bike1 setCel: 0)
			)
			(6
				(bike1 dispose:)
				((ScriptID 706 2) ; theBiker
					view: 632
					setLoop: 1
					setStep: 10 10
					setMotion: MoveTo -50 (gEgo y:) self
				)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance biker2Script of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(biker2
					view: 630
					cycleSpeed: 0
					setLoop: 0
					posn: 213 133
					setCycle: Fwd
					setStep: 4 4
					setPri: 9
					setMotion: MoveTo 167 133 self
				)
			)
			(1
				(biker2 setMotion: MoveTo 134 162 self)
			)
			(2
				(biker2
					setLoop: 1
					cycleSpeed: 1
					cel: 0
					posn: 138 163
					setCycle: End self
				)
			)
			(3
				(biker2 setPri: 12)
				(= seconds 2)
			)
			(4
				(biker3 setScript: biker3Script)
				(biker2 setLoop: 2 setCel: 0 posn: 146 162)
				(= cycles 1)
			)
			(5
				(biker2 setCel: 1 posn: 149 162)
				(= cycles 1)
			)
			(6
				(biker2 setCel: 2 posn: 155 162)
				(= cycles 1)
			)
			(7
				(biker2 setCel: 3 posn: 164 172)
				(= cycles 1)
			)
			(8
				(biker2 setCel: 4 posn: 176 172)
				(= cycles 1)
			)
			(9
				(biker2 setCel: 5 posn: 176 178)
				(bike2 setCel: 0)
				(= cycles 1)
			)
			(10
				(bike2 dispose:)
				(biker2
					view: 633
					setLoop: 7
					setStep: 10 10
					setPri: -1
					setMotion: MoveTo 44 83 self
				)
			)
			(11
				(biker2 hide:)
				(self dispose:)
			)
		)
	)
)

(instance biker3Script of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(biker3
					view: 631
					posn: 217 133
					setLoop: 0
					setCycle: Fwd
					setPri: 9
					setMotion: MoveTo 161 133 self
				)
			)
			(1
				(biker3 setMotion: MoveTo 133 161 self)
			)
			(2
				(biker3 setLoop: 1 posn: 132 163 cel: 0 setCycle: End self)
			)
			(3
				(biker3 setPri: 12)
				(= seconds 2)
			)
			(4
				(biker3 setLoop: 2 setCel: 0 posn: 145 167)
				(= cycles 1)
			)
			(5
				(biker3 setCel: 1 posn: 168 168)
				(= cycles 1)
			)
			(6
				(biker3 setCel: 2 posn: 176 170)
				(= cycles 1)
			)
			(7
				(biker3 setCel: 3 posn: 194 170)
				(= cycles 1)
			)
			(8
				(biker3
					view: 634
					setLoop: 5
					posn: 205 173
					setStep: 10 10
					setMotion: MoveTo 126 225 self
				)
				(bike3 dispose:)
			)
			(9
				(= seconds 2)
			)
			(10
				(gCurRoom newRoom: 609)
			)
		)
	)
)

(instance enterBar of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(Load rsSOUND 804)
				(gEgo setMotion: PolyPath 214 135 self)
			)
			(1
				(if (or (IsFlag 15) (not (IsFlag 16)))
					(gLongSong
						vol: 5
						number: 804
						loop: -1
						playBed:
						fade: 127 20 20 0
					)
					(gCurRoom newRoom: 615)
				else
					(gEgo
						view: 615
						setLoop: 0
						setCel: 3
						setPri: 9
						posn: 227 114
					)
					(= seconds 2)
				)
			)
			(2
				(gEgo posn: 205 104)
				(= cycles 1)
			)
			(3
				(gEgo posn: 188 95)
				(= cycles 1)
			)
			(4
				(gEgo posn: 160 87)
				(= cycles 1)
			)
			(5
				(gEgo posn: 146 88)
				(= cycles 1)
			)
			(6
				(gEgo posn: 128 99)
				(= cycles 1)
			)
			(7
				(gEgo posn: 116 112)
				(= cycles 1)
			)
			(8
				(gEgo posn: 88 123)
				(= seconds 2)
			)
			(9
				(gEgo setCycle: End self)
			)
			(10
				(gEgo
					view: 0
					setLoop: 1
					setHeading: 270
					posn: (- (gEgo x:) 25) (+ (gEgo y:) 25)
				)
				(= cycles 1)
			)
			(11
				(proc706_1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance kickScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 15)
				(ulence status: 99)
				(Load rsVIEW 615)
				(Load rsVIEW 616)
				(Load rsVIEW 632)
				(Load rsVIEW 633)
				(Load rsVIEW 634)
				(Load rsSOUND 50)
				(gEgo setMotion: PolyPath 130 169 self)
			)
			(1
				(gEgo setHeading: 90 self)
			)
			(2
				(gEgo view: 615 setLoop: 1 cel: 0 setCycle: End self)
			)
			(3
				(self setScript: bikesFall self)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(proc706_1)
				(gEgo posn: (- (gEgo x:) 2) (gEgo y:) setLoop: 0)
				(= cycles 1)
			)
			(6
				(gEgo setLoop: -1 setHeading: 270 self)
			)
			(7
				(gEgo
					view: 615
					setLoop: 5
					setCycle: Walk
					setStep: 6 4
					setMotion: MoveTo 25 (gEgo y:) self
				)
			)
			(8
				(gLongSong number: 50 loop: -1 playBed: fade: 127 10 10 0)
				(= seconds 1)
			)
			(9
				((ScriptID 706 2) ; theBiker
					init:
					view: 616
					posn: 210 134
					setScript: bikerScript
				)
				(gEgo setMotion: MoveTo -30 (gEgo y:) self)
			)
			(10
				(gEgo dispose:)
			)
		)
	)
)

