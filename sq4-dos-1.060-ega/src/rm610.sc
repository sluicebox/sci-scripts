;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 610)
(include sci.sh)
(use Main)
(use Interface)
(use ulence)
(use eRS)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm610 0
)

(instance rm610 of SQRoom
	(properties
		picture 610
		horizon 110
		north 613
		east 611
		west 609
	)

	(method (init)
		(ulence roomVer: 22891)
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
		(if (not (OneOf gPrevRoomNum 615 620))
			(gLongSong2 vol: 70 number: 804 loop: -1 playBed:)
		)
		(if (not (IsFlag 75))
			(bike1 init:)
			(bike2 init:)
			(bike3 init:)
			((ScriptID 706 1) init:) ; theBiker
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
					init: 0 0 319 0 319 158 295 158 295 162 283 162 253 162 253 158 225 158 225 148 207 148 207 142 176 142 176 135 214 135 214 132 149 132 131 126 123 121 94 103 68 103 73 123 63 131 44 136 0 136
					yourself:
				)
		)
		(if (not (IsFlag 75))
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 129 153 177 151 210 165 249 185 191 187 170 180 153 170 136 171 124 160
						yourself:
					)
			)
		)
		(Load rsSOUND 804)
		(Load rsVIEW 615)
		(Load rsVIEW 610)
		(Load rsSOUND 147)
		(Load rsSOUND 836)
		(if (== (ulence status:) 1)
			(ulence status: 2 bikerComing: 1)
			(Load rsVIEW 632)
			(Load rsVIEW 634)
			(Load rsVIEW 633)
			(Load rsVIEW 635)
			(Load rsSOUND 50)
			(Load rsSOUND 837)
			(Load rsSOUND 841)
			(ulence status: 2)
		else
			(ulence bikerComing: 0)
		)
		((ScriptID 706 8) init: nsLeft: 0 nsTop: -1 nsBottom: 86 nsRight: 319) ; theDunes
		((ScriptID 706 7) init: nsLeft: 0 nsTop: 88 nsBottom: 189 nsRight: 319) ; theSand
	)

	(method (doit)
		(if
			(and
				(== (ulence status:) 4)
				(< ((ScriptID 706 1) distanceTo: gEgo) 20) ; theBiker
			)
			(HandsOff)
			(ulence status: 6)
			(gEgo setScript: 0)
			(ulence deathLoop: 1)
			(self setScript: (ScriptID 706 3)) ; theDeathScript
		)
		(cond
			(script 0)
			((== (gEgo edgeHit:) EDGE_TOP)
				(gLongSong2 fade: 0 30 5 0)
			)
			((== (gEgo edgeHit:) EDGE_RIGHT)
				(gLongSong2 fade: 0 30 5 0)
			)
			((== (gEgo edgeHit:) EDGE_LEFT)
				(gLongSong2 fade: 0 30 5 0)
			)
			((gEgo inRect: 192 122 221 137)
				(self setScript: enterBar)
			)
			(
				(and
					(> (Random 0 100) 85)
					(== (ulence status:) 2)
					(gEgo inRect: 116 154 146 164)
				)
				(HandsOff)
				(ulence status: 3)
				((ScriptID 706 1) ; theBiker
					view: 633
					init:
					hide:
					posn: -30 127
					setLoop: 0
					setScript: runOverScript1
				)
				(gEgo setScript: (ScriptID 706 5)) ; theDodgeL
			)
			(
				(and
					(> (Random 0 100) 85)
					(== (ulence status:) 2)
					(gEgo inRect: 196 175 222 185)
				)
				(HandsOff)
				(ulence status: 3)
				((ScriptID 706 1) ; theBiker
					view: 632
					init:
					hide:
					posn: -28 (- (gEgo y:) 5)
					setLoop: 0
					setStep: 15 15
					setScript: runOverScript2
				)
				(gEgo setScript: (ScriptID 706 5)) ; theDodgeL
			)
			(
				(and
					(> (Random 0 100) 85)
					(== (ulence status:) 2)
					(gEgo inRect: 90 143 120 152)
				)
				(HandsOff)
				(ulence status: 3)
				((ScriptID 706 1) ; theBiker
					view: 634
					init:
					hide:
					posn: 347 176
					setLoop: 1
					setScript: runOverScript3
				)
				(gEgo setScript: (ScriptID 706 4)) ; theDodgeR
			)
		)
		(super doit: &rest)
	)
)

(instance flyOut of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(gLongSong stop: number: 127 vol: 127)
				(= cycles 2)
			)
			(1
				(thumpSound vol: 127 loop: 1 number: 836 play:)
				(= cycles 1)
			)
			(2
				(gEgo
					setLoop: 0
					cel: 0
					setCycle: CT 3 1
					setMotion: MoveTo 130 127 self
				)
			)
			(3
				(= cycles 2)
			)
			(4
				(thumpSound number: 147 play:)
				(= seconds 4)
			)
			(5
				(gEgo setCycle: End self)
			)
			(6
				(gEgo
					view: 0
					setLoop: 1
					heading: 270
					posn: (- (gEgo x:) 25) (+ (gEgo y:) 25)
				)
				(= cycles 1)
			)
			(7
				(NormalEgo (gEgo loop:) 0)
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
				(gLongSong loop: 1 number: 140 play:)
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
				(gEgo setMotion: PolyPath 150 135 self)
			)
			(1
				(NormalEgo (gEgo loop:) 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance bikerScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				((ScriptID 706 1) ; theBiker
					setLoop: 0
					setCycle: Fwd
					setStep: 4 4
					setMotion: MoveTo 159 134 self
				)
			)
			(1
				((ScriptID 706 1) setMotion: MoveTo 133 146 self) ; theBiker
			)
			(2
				((ScriptID 706 1) ; theBiker
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
				((ScriptID 706 1) ; theBiker
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
				(bike1Sound init: play:)
				(bike2Sound init:)
				(bike3Sound init:)
				(bike1 setCel: 0)
			)
			(6
				(bike1 dispose:)
				((ScriptID 706 1) ; theBiker
					view: 634
					setLoop: 1
					setStep: 10 10
					setMotion: MoveTo -50 (- (gEgo y:) 40) self
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
				(bike2Sound play:)
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
				(bike3Sound play:)
				(biker3
					view: 632
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
				(gEgo setMotion: PolyPath 214 135 self)
			)
			(1
				(if (or (IsFlag 75) (not (IsFlag 15)))
					(gLongSong2 fade: 85 10 10 0)
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
				(thumpSound vol: 127 loop: 1 number: 836 play:)
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
				(thumpSound number: 147 play:)
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
				(NormalEgo (gEgo loop:) 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance runOverScript1 of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(ulence egoBusy: 1)
				(gLongSong2
					vol: 25
					number: 50
					loop: -1
					playBed:
					fade: 127 10 10 0
				)
				(= seconds 2)
			)
			(1
				((ScriptID 706 6) init: play:) ; theBikeSound
				((ScriptID 706 1) show: setMotion: MoveTo 40 127 self) ; theBiker
			)
			(2
				(ulence status: 4)
				(HandsOn)
				((ScriptID 706 1) ; theBiker
					setLoop: 4
					posn: 57 129
					setPri: (+ (gEgo priority:) 1)
					setMotion: MoveTo 192 174 self
				)
			)
			(3
				((ScriptID 706 1) ; theBiker
					setLoop: 0
					posn: 209 177
					setMotion: MoveTo 369 177 self
				)
			)
			(4
				(gLongSong2 fade: 0 10 10 0)
				((ScriptID 706 6) fade:) ; theBikeSound
				(= seconds 3)
			)
			(5
				(gLongSong2 vol: 70 number: 804 loop: -1 playBed:)
				((ScriptID 706 1) hide:) ; theBiker
				(= seconds 3)
			)
			(6
				(if (!= (ulence status:) 6)
					(ulence status: 1 fieldOff: 0 bikerComing: 0 egoBusy: 0)
					(gEgo setScript: 0)
					(Print 610 0) ; "Boy, that was close!"
				)
				(= cycles 2)
			)
			(7
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance runOverScript2 of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(ulence egoBusy: 1)
				(gLongSong2
					vol: 25
					number: 50
					loop: -1
					playBed:
					fade: 127 10 10 0
				)
				(= seconds 2)
			)
			(1
				((ScriptID 706 6) init: play:) ; theBikeSound
				((ScriptID 706 1) ; theBiker
					show:
					setMotion: MoveTo 132 (- (gEgo y:) 7) self
				)
			)
			(2
				(ulence status: 4)
				(HandsOn)
				((ScriptID 706 1) ; theBiker
					setPri: (+ (gEgo priority:) 1)
					setMotion: MoveTo 372 (- (gEgo y:) 7) self
				)
			)
			(3
				(gLongSong2 fade: 0 10 10 0)
				((ScriptID 706 6) fade:) ; theBikeSound
				(= seconds 3)
			)
			(4
				(gLongSong2 vol: 70 number: 804 loop: -1 playBed:)
				((ScriptID 706 1) hide:) ; theBiker
				(= seconds 3)
			)
			(5
				(if (!= (ulence status:) 6)
					(ulence status: 1 fieldOff: 0 bikerComing: 0 egoBusy: 0)
					(gEgo setScript: 0)
					(Print 610 0) ; "Boy, that was close!"
				)
				(= cycles 2)
			)
			(6
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance runOverScript3 of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(ulence egoBusy: 1)
				(gLongSong2
					vol: 25
					number: 50
					loop: -1
					playBed:
					fade: 127 10 10 0
				)
				(= seconds 2)
			)
			(1
				((ScriptID 706 6) init: play:) ; theBikeSound
				((ScriptID 706 1) ; theBiker
					show:
					setPri: 15
					setMotion: MoveTo 182 176 self
				)
			)
			(2
				(ulence status: 4)
				(HandsOn)
				((ScriptID 706 1) ; theBiker
					setPri: (+ (gEgo priority:) 1)
					posn: 165 167
					setLoop: 7
					setMotion: MoveTo 75 106 self
				)
			)
			(3
				((ScriptID 706 1) setPri: -1 setMotion: MoveTo 53 91 self) ; theBiker
			)
			(4
				((ScriptID 706 1) hide:) ; theBiker
				(gLongSong2 fade: 0 10 10 0)
				((ScriptID 706 6) init: play:) ; theBikeSound
				(= seconds 3)
			)
			(5
				(gLongSong2 vol: 70 number: 804 loop: -1 playBed:)
				(if (!= (ulence status:) 6)
					(ulence status: 1 fieldOff: 0 bikerComing: 0 egoBusy: 0)
					(gEgo setScript: 0)
					(Print 610 0) ; "Boy, that was close!"
				)
				(= cycles 2)
			)
			(6
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
				(ulence status: 99)
				(Load rsVIEW 615)
				(Load rsVIEW 616)
				(Load rsVIEW 632)
				(Load rsVIEW 633)
				(Load rsVIEW 634)
				(Load rsSOUND 50)
				(Load rsSOUND 140)
				(SetScore 75 5)
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
				(NormalEgo (gEgo loop:) 0)
				(gEgo posn: (- (gEgo x:) 2) (gEgo y:) setLoop: 0)
				(= cycles 1)
			)
			(6
				(gEgo setLoop: -1 setHeading: 270 self)
			)
			(7
				(ulence fieldOff: 1)
				(gEgo
					view: 615
					setLoop: 5
					setCycle: Walk
					setStep: 6 4
					setMotion: MoveTo 25 (+ (gEgo y:) 20) self
				)
			)
			(8
				(gLongSong number: 0 vol: 0 stop:)
				(gLongSong2 vol: 127 number: 50 loop: -1 playBed:)
				(= seconds 1)
			)
			(9
				((ScriptID 706 1) ; theBiker
					init:
					view: 616
					posn: 210 134
					setScript: bikerScript
				)
				(gEgo setMotion: MoveTo -30 (+ (gEgo y:) 20) self)
			)
			(10
				(ulence fieldOff: 0)
				(gEgo dispose:)
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

(instance bike1 of Prop
	(properties
		x 159
		y 150
		description {bike}
		lookStr {As you check these sand bikes out, you wonder what kind of cheeseball would own one.}
		view 615
		loop 4
		priority 12
		signal 16401
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Do
				(cond
					((not (IsFlag 15))
						(Print 610 1) ; "Why would you want to wreck the nice bike?"
					)
					((not (IsFlag 75))
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
		description {bike}
		lookStr {As you check these sand bikes out, you wonder what kind of cheeseball would own one.}
		view 615
		loop 3
		priority 13
		signal 16401
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Do
				(cond
					((not (IsFlag 15))
						(Print 610 1) ; "Why would you want to wreck the nice bike?"
					)
					((not (IsFlag 75))
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
		x 211
		y 168
		description {bike}
		lookStr {As you check these sand bikes out, you wonder what kind of cheeseball would own one.}
		view 615
		loop 2
		priority 14
		signal 16401
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Do
				(cond
					((not (IsFlag 15))
						(Print 610 1) ; "Why would you want to wreck the nice bike?"
					)
					((not (IsFlag 75))
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

(instance ship1 of Feature
	(properties
		x 34
		y 88
		nsTop 49
		nsBottom 128
		nsRight 69
		description {space ship}
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
		description {space ship}
		sightAngle 45
		onMeCheck 8
		lookStr {It looks like it came from the Planet of the Warts! This ship must be the Plantars Deluxe model with authentic Mosaic upholstery.}
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

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Do
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

(instance thumpSound of Sound
	(properties
		number 147
		flags 1
	)
)

(instance bike1Sound of Sound
	(properties
		number 837
		flags 1
	)
)

(instance bike2Sound of Sound
	(properties
		number 837
		flags 1
	)
)

(instance bike3Sound of Sound
	(properties
		number 837
		flags 1
	)
)

