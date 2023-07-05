;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 280)
(include sci.sh)
(use Main)
(use SQRoom)
(use ExitFeature)
(use SQNarrator)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm280 0
	Pa_Conshohoken 1
)

(local
	local0 = 2
	local1 = 2
	local2 = 4
	local3 = 4
	local4
	local5 = 7
	local6
	local7
	local8
	local9
	local10 = 16
	local11 = 9
	local12
	local13
	local14
)

(instance rm280 of SQRoom
	(properties
		noun 1
		picture 280
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 307 97 244 102 237 105 211 105 202 102 149 95 4 95 4 98 151 98 148 105 4 105 4 107 130 107 96 124 1 124 2 134 313 135 312 100
					yourself:
				)
		)
		(super init:)
		(Load 140 281 282 283 284 285) ; WAVE
		(gEgo normalize: posn: 330 102 init:)
		(case1 init:)
		(case2 init:)
		(drawer init:)
		(leftCamera init:)
		(rightCamera init:)
		(counter init:)
		(magazines init:)
		(poster init:)
		(mainShelf init:)
		(backShelfMain init:)
		(backShelfPart init:)
		(frontShelf init:)
		(counterShelf init:)
		(iceBox init:)
		(redBtls init:)
		(greenBtls init:)
		(blueBtls init:)
		(amberCans init:)
		(purpleBtls init:)
		(theGreenStuff init:)
		(blackBtls init:)
		(keyPad1 init:)
		(keyPad2 init:)
		(stackOfPapers init:)
		(bigBtls init:)
		(blueCans init:)
		(greenCans init:)
		(monitors init: setCycle: Fwd)
		(camera init: setScript: sCamera)
		(camera2 init:)
		(led1 init: setCycle: Fwd)
		(led2 init: setCycle: Fwd)
		(brandyBottle init:)
		(et init: approachVerbs: 4 setScript: sDrunkenET) ; Do
		(pa init: approachVerbs: 64 2 setScript: sPaScratches) ; Buckazoids, Talk
		(gGame handsOff:)
		(gEgo enterRoom: 330 102 282 102 self)
		(exit340 init: gTheExitECursor approachVerbs: 7) ; ExitRight
		(gGSound1 number: 280 loop: -1 play:)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			((and (>= (gEgo x:) 280) (< (gEgo x:) 310))
				(= local7 1)
				(= local11 8)
			)
			((and (>= (gEgo x:) 250) (< (gEgo x:) 280))
				(= local7 2)
				(= local11 9)
			)
			((and (>= (gEgo x:) 220) (< (gEgo x:) 250))
				(= local7 3)
				(= local11 10)
			)
			((and (>= (gEgo x:) 190) (< (gEgo x:) 220))
				(cond
					((< (gEgo y:) 105)
						(= local7 4)
						(= local11 11)
					)
					((> (gEgo y:) 105)
						(= local7 3)
						(= local11 10)
					)
				)
			)
			((and (>= (gEgo x:) 160) (< (gEgo x:) 190))
				(cond
					((< (gEgo y:) 105)
						(= local7 5)
						(= local11 12)
					)
					((and (>= (gEgo y:) 105) (< (gEgo y:) 115))
						(= local7 4)
						(= local11 11)
					)
					((> (gEgo y:) 125)
						(= local7 3)
						(= local11 10)
					)
				)
			)
			((< (gEgo y:) 100)
				(= local7 6)
				(= local11 22)
			)
			((and (>= (gEgo y:) 100) (< (gEgo y:) 105))
				(= local7 5)
				(= local11 12)
			)
			((and (>= (gEgo y:) 105) (< (gEgo y:) 115))
				(= local7 4)
				(= local11 11)
			)
			((> (gEgo y:) 125)
				(= local7 3)
				(= local11 10)
			)
		)
		(cond
			((not (< local6 local7))
				(= local6 local7)
				(= local8 local5)
				(= local4 1)
				(camera2 setScript: sCameraTwo)
			)
			((not (> local6 local7))
				(= local6 local7)
				(= local8 local5)
				(= local4 -1)
				(camera2 setScript: sCameraTwo)
			)
		)
	)

	(method (cue)
		(gGame handsOn:)
	)

	(method (dispose)
		(gGSound1 fade:)
		(super dispose:)
	)
)

(instance sCameraTwo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local5 local11)
				(camera2 cel: local8 setCycle: CT local11 local4 self)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance sCamera of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(camera cel: local9 setCycle: CT local10 1 self)
			)
			(1
				(camera cel: local10 setCycle: CT local9 -1 self)
			)
			(2
				(= local10 (Random 6 16))
				(= local9 (Random 0 5))
				(= ticks 60)
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance sDrunkenET of Script
	(properties)

	(method (init)
		(cond
			((== local13 0)
				(= start 0)
			)
			((== local13 1)
				(et cel: (et cel:))
				(= start 2)
			)
			((== local13 2)
				(et cel: (et cel:))
				(= start 4)
			)
			((== local13 3)
				(et cel: (et cel:))
				(= start 6)
			)
			((== local13 4)
				(et cel: (et cel:))
				(= start 8)
			)
		)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local13 0)
				(et
					view: 287
					setLoop: 0 1
					cel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(1
				(if (== local14 0)
					(self changeState: 9)
				else
					(= cycles 1)
				)
			)
			(2
				(= local13 1)
				(et setLoop: 1 1 setCycle: End self)
			)
			(3
				(if (== local14 1)
					(self changeState: 9)
				else
					(= cycles 1)
				)
			)
			(4
				(= local13 2)
				(et setLoop: 2 1 setCycle: End self)
			)
			(5
				(if (== local14 2)
					(self changeState: 9)
				else
					(= cycles 1)
				)
			)
			(6
				(= local13 3)
				(et setLoop: 3 1 setCycle: End self)
			)
			(7
				(if (== local14 2)
					(self changeState: 9)
				else
					(= cycles 1)
				)
			)
			(8
				(= local13 4)
				(et setLoop: 4 1 setCycle: End self)
			)
			(9
				(cond
					((== local12 1)
						(self changeState: 11)
					)
					((== local13 1)
						(et setLoop: 1 1 cel: 5 setCycle: Beg self)
					)
					((== local13 2)
						(et setLoop: 2 1 cel: 4 setCycle: Beg self)
					)
					((or (== local13 3) (== local13 4))
						(et setLoop: 3 1 cel: 6 setCycle: Beg self)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(10
				(et setLoop: 0 1 cel: 0 setCycle: Fwd)
				(= seconds 6)
			)
			(11
				(= local14 (Random 0 4))
				(if (not local12)
					(self changeState: 0)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance sRogerTouchesET of Script
	(properties)

	(method (init)
		(sDrunkenET dispose:)
		(= local14 4)
		(= local12 1)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 270)
				(self setScript: sDrunkenET self)
			)
			(1
				(gEgo hide:)
				(et view: 288 loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(sound1 number: 283 loop: 0 play:)
				(et loop: 1 cel: 0 cycleSpeed: 12 setCycle: End self)
			)
			(3
				(et loop: 1 cel: 2 cycleSpeed: 12 setCycle: End self)
			)
			(4
				(sound1 stop:)
				(et loop: 1 cel: 2 cycleSpeed: 12 setCycle: End self)
			)
			(5
				(et loop: 1 cel: 3)
				(= ticks 60)
			)
			(6
				(if (== global177 4)
					(et loop: 2 cel: 0 setCycle: CT 2 1 self)
				else
					(= cycles 1)
				)
			)
			(7
				(if (== global177 4)
					(gGame points: 5 490)
					(= global177 0)
					(sound1 number: 284 loop: 0 play:)
					(et loop: 2 cel: 3 setCycle: End self)
				else
					(+= global177 1)
					(= cycles 1)
				)
			)
			(8
				(= local12 0)
				(= local13 0)
				(gEgo show: normalize: 1)
				(et setScript: sDrunkenET)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPaScratches of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load 140 281) ; WAVE
				(= local2 (Random 3 4))
				(= cycles 1)
			)
			(1
				(if (and (== local3 3) (== local2 4))
					(if (== local0 2)
						(pa view: 280 loop: 2 cel: 4 setCycle: Beg self)
					else
						(pa view: 280 loop: 3 cel: 4 setCycle: Beg self)
					)
				else
					(= cycles 1)
				)
			)
			(2
				(= local0 (Random 2 2))
				(= cycles 1)
			)
			(3
				(cond
					((and (== local1 2) (== local0 2))
						(pa view: 280 loop: 1 cel: 0)
					)
					((and (== local1 2) (== local0 2))
						(pa view: 280 loop: 0 cel: 0)
					)
				)
				(= cycles 1)
			)
			(4
				(= local3 local2)
				(= local1 local0)
				(if (Random 0 1)
					(if (== local0 2)
						(pa view: 281 loop: 6 cel: 0 setCycle: End)
					else
						(pa view: 281 loop: 7 cel: 0 setCycle: End)
					)
				)
				(= ticks (Random 180 360))
			)
			(5
				(if (== local2 4)
					(self changeState: 6)
				else
					(self changeState: 8)
				)
			)
			(6
				(if (== local0 2)
					(pa view: 280 loop: 0 cel: 0 setCycle: Fwd)
				else
					(pa view: 280 loop: 1 cel: 0 setCycle: Fwd)
				)
				(= ticks (Random 60 90))
			)
			(7
				(if (== local0 2)
					(pa view: 280 loop: 0 cel: 0 setCycle: End)
				else
					(pa view: 280 loop: 1 cel: 0 setCycle: End)
				)
				(self changeState: 0)
			)
			(8
				(if (== local0 2)
					(pa view: 280 loop: 2 cel: 0 setCycle: End self)
				else
					(pa view: 280 loop: 3 cel: 0 setCycle: End self)
				)
			)
			(9
				(if (== local0 2)
					(pa view: 280 loop: 4 cel: 0 setCycle: Fwd)
				else
					(pa view: 280 loop: 5 cel: 0 setCycle: Fwd)
				)
				(= ticks (Random 60 240))
			)
			(10
				(self changeState: 0)
			)
		)
	)
)

(instance sRogerPaysPa of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 281 282 286 287) ; WAVE
				(if (<= (-= global150 20) 0)
					(gEgo put: 13) ; Buckazoids
				)
				(= cycles 1)
			)
			(1
				(gMessager say: 41 64 2 1 self) ; "I'd like a bottle of your Coldsorian Brandy, please."
			)
			(2
				(if (not (IsFlag 145))
					(gEgo setMotion: PolyPath 269 102 self)
				else
					(= cycles 1)
				)
			)
			(3
				(if (not (IsFlag 145))
					(SetFlag 145)
					(SetFlag 146)
					(SetFlag 147)
					(Pa_Conshohoken talkLoop: 2)
					(gEgo setHeading: 270)
				)
				(= cycles 1)
			)
			(4
				(sound1 number: 281 loop: 0 play:)
				(drawer setCycle: End self)
			)
			(5
				(sound1 number: 286 loop: 0 play:)
				(gEgo
					view: 282
					loop: 2
					cel: 0
					cycleSpeed: 10
					setCycle: CT 5 1 self
				)
			)
			(6
				(gEgo
					view: 282
					loop: 2
					cel: 6
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(7
				(gEgo normalize: 1)
				(sound1 number: 282 loop: 0 play:)
				(drawer cel: 5 setCycle: Beg self)
			)
			(8
				(gMessager sayRange: 41 64 2 2 3 self) ; "Well, so you're interested in the good stuff, eh?"
			)
			(9
				(pa view: 282 cel: 0 setLoop: 1 1 setCycle: CT 2 1 self)
			)
			(10
				(sound1 number: 285 loop: 0 play:)
				(pa view: 282 cel: 2 setCycle: End self)
			)
			(11
				(pa view: 283 cel: 0 setLoop: 0 1 setCycle: CT 13 1 self)
			)
			(12
				(sound1 number: 287 loop: 0 play:)
				(brandyBottle dispose:)
				(pa cel: 13 setLoop: 0 1 setCycle: End self)
			)
			(13
				(sound1 number: 281 loop: 0 play:)
				(drawer cel: 0 setCycle: End self)
			)
			(14
				(gGame points: 5 470)
				(gEgo
					get: 12 ; Brandy
					view: 282
					loop: 3
					cel: 0
					cycleSpeed: 10
					setCycle: End self
				)
				(pa view: 281 loop: 6 cel: 0 setCycle: End self)
			)
			(15
				(sound1 number: 282 loop: 0 play:)
				(drawer cel: 5 setCycle: Beg self)
			)
			(16
				(Pa_Conshohoken talkLoop: 1)
				(pa approachX: 186 approachY: 97 sightAngle: 90)
				(gEgo normalize: 1)
				(= next sPaScratches)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTalksToPaFirst of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 41 2 4 0 self) ; "Hi there."
			)
			(1
				(= next sPaScratches)
				(self dispose:)
			)
		)
	)
)

(instance sEnterRoom of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 900
					cel: 0
					loop: 0
					setCycle: Walk
					setMotion: MoveTo 310 102 self
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 900
					cel: 0
					loop: 0
					setCycle: Walk
					setMotion: MoveTo 330 93 self
				)
			)
			(1
				(gCurRoom newRoom: 340)
				(self dispose:)
			)
		)
	)
)

(instance pa of Prop
	(properties
		sightAngle 270
		approachX 265
		approachY 102
		x 236
		y 98
		z 25
		view 280
		signal 20513
	)

	(method (init)
		(super init:)
		(cond
			((IsFlag 145)
				(self approachX: 265 approachY 102 sightAngle 270)
			)
			((IsFlag 148)
				(self approachX: 186 approachY 97 sightAngle 90)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(64 ; Buckazoids
				(if (not (IsFlag 148))
					(if (and (>= global150 20) (gEgo has: 13)) ; Buckazoids
						(SetFlag 148)
						(pa setScript: sRogerPaysPa)
					else
						(gMessager say: 41 64 5) ; "Crud. It looks like I still don't have enough money. This is embarrassing."
					)
				else
					(gMessager say: 41 64 6) ; "On Polysorbate, it appears that you only have to pay once for a purchase."
				)
			)
			(2 ; Talk
				(cond
					((and (not (IsFlag 145)) (not (IsFlag 148)))
						(SetFlag 145)
						(self setScript: sTalksToPaFirst)
					)
					((and (not (IsFlag 146)) (not (IsFlag 148)))
						(SetFlag 146)
						(gMessager say: 41 2 0 0 self) ; "So, Pa, what's the stuff behind you?"
					)
					((and (not (IsFlag 147)) (not (IsFlag 148)))
						(gMessager say: 41 2 1 0 self) ; "Got the twenty there, Buster? Otherwise, you can swill thruster drippings with the rest of the deadbeats around here. I don't mean that in a bad way, mind you."
					)
					((and (IsFlag 148) (== global120 1))
						(gMessager say: 41 2 3 0 self) ; "What? What's the problem, Sonny? Havin' trouble with the bottle? Oh yeah, those highly complex twist tops can really boggle a mind, can't they? Just grab the bottle with one hand and twist the top with the other. You'll get the hang of it. Now run along. I'm a real busy man."
					)
					((and (IsFlag 148) (> global120 1))
						(gMessager say: 41 2 7 0 self) ; "Run along. I'm a real busy man."
					)
				)
			)
			(1 ; Look
				(gMessager say: 41 1 0 0 self) ; "Pa Conshohocken sits behind the counter by his favorite possession, something he values greater than his own life, the cash register. Pa's been in business for quite a while, as his grizzled look might attest."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(self setScript: sPaScratches)
	)
)

(instance monitors of Prop
	(properties
		noun 39
		x 265
		y 84
		z 50
		view 284
		signal 20513
		cycleSpeed 40
	)
)

(instance camera of Prop
	(properties
		noun 5
		x 167
		y 86
		z 60
		view 284
		loop 1
		signal 20513
		cycleSpeed 12
	)
)

(instance camera2 of Prop
	(properties
		noun 4
		x 265
		y 85
		z 60
		view 284
		loop 2
		signal 20513
		cycleSpeed 20
	)
)

(instance led1 of Prop
	(properties
		noun 45
		x 38
		y 180
		z 100
		view 284
		loop 3
	)

	(method (init)
		(self setPri: 120)
		(super init:)
	)
)

(instance led2 of Prop
	(properties
		noun 45
		x 131
		y 175
		z 100
		view 284
		loop 4
	)

	(method (init)
		(self setPri: 102)
		(super init:)
	)
)

(instance et of Prop
	(properties
		noun 44
		approachX 104
		approachY 120
		x 59
		y 119
		view 287
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sRogerTouchesET)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance drawer of Prop
	(properties
		noun 43
		sightAngle 40
		x 246
		y 87
		z 10
		view 282
		signal 20513
	)

	(method (doVerb theVerb)
		(switch theVerb
			(64 ; Buckazoids
				(if (not (IsFlag 148))
					(if (and (>= global150 20) (gEgo has: 13)) ; Buckazoids
						(SetFlag 148)
						(pa setScript: sRogerPaysPa)
					else
						(gMessager say: 41 64 5) ; "Crud. It looks like I still don't have enough money. This is embarrassing."
					)
				else
					(gMessager say: 41 64 6) ; "On Polysorbate, it appears that you only have to pay once for a purchase."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance brandyBottle of View
	(properties
		noun 7
		x 196
		y 89
		z 50
		view 283
		loop 1
	)
)

(instance exit340 of ExitFeature
	(properties
		noun 25
		approachX 310
		approachY 93
		message 7
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 287 20 319 13 319 105 315 101 315 99 304 97 287 97
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; ExitRight
				(gCurRoom setScript: sExitRoom)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance case1 of Feature
	(properties
		noun 2
		sightAngle 40
		x 101
		y 127
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 83 123 80 138 123 138 118 117 93 117
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance case2 of Feature
	(properties
		noun 3
		sightAngle 40
		x 142
		y 131
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 126 125 123 138 161 138 160 131 160 124
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance leftCamera of Feature
	(properties
		noun 4
		sightAngle 270
		x 169
		y 17
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 168 8 168 8 166 10 167 19 171 22 174 26 176 26 178 29 174 30 173 28 172 28 170 29 168 28 166 29 161 24 162 20 164 20 164 18 163 15 162 13 162 10 162 8 167 5 170 8
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance rightCamera of Feature
	(properties
		noun 4
		sightAngle 90
		x 266
		y 41
		z 20
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 268 9 268 21 267 24 265 27 264 28 262 28 260 30 257 30 258 33 262 34 264 31 268 32 274 30 276 26 275 24 272 23 272 21 272 20 274 17 276 12 273 8
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance counter of Feature
	(properties
		noun 6
		sightAngle 40
		x 219
		y 85
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 157 93 157 72 282 72 282 97 236 98 235 95 230 92 214 92 215 97 188 97
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance backShelfMain of Feature
	(properties
		noun 8
		sightAngle 40
		x 98
		y 97
		z 30
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 55 31 139 31 142 32 142 101 139 104 55 104 55 98 127 98 127 82 55 82 55 77 128 77 129 61 55 61 55 57 129 57 129 40 55 40
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance backShelfPart of Feature
	(properties
		noun 38
		sightAngle 40
		x 16
		y 37
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 40 0 40 32 40 32 35 0 35 0 40
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance frontShelf of Feature
	(properties
		noun 8
		sightAngle 40
		x 27
		y 70
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 21 48 21 55 24 55 115 48 119 0 118 0 109 33 109 33 89 0 89 0 83 32 83 32 63 32 62 0 62 0 56 34 56 34 33 0 33
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance counterShelf of Feature
	(properties
		noun 9
		sightAngle 40
		x 227
		y 45
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 175 71 175 70 175 31 179 30 178 26 175 25 177 23 186 21 209 19 237 19 267 22 265 25 264 28 261 28 257 30 258 34 261 35 265 33 265 32 266 32 273 33 276 25 279 29 279 71
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance iceBox of Feature
	(properties
		noun 13
		sightAngle 40
		x 246
		y 121
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 172 137 174 103 307 103 320 107 320 139 172 138
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance greenBtls of Feature
	(properties
		noun 12
		sightAngle 40
		x 65
		y 50
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 56 44 58 50 59 46 62 45 64 50 64 45 66 45 69 45 70 50 71 45 74 45 75 56 55 57
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance redBtls of Feature
	(properties
		noun 10
		sightAngle 40
		x 90
		y 48
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 78 55 81 41 83 42 84 48 86 43 84 43 90 47 90 42 101 41 99 45 100 48 102 55 78 55
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance blueBtls of Feature
	(properties
		noun 11
		sightAngle 40
		x 115
		y 50
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 103 55 103 54 104 45 105 45 108 56 109 44 112 49 113 46 116 44 127 45 127 56
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance amberCans of Feature
	(properties
		noun 14
		sightAngle 40
		x 71
		y 71
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 61 76 61 76 61 67 82 67 82 76
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance purpleBtls of Feature
	(properties
		noun 15
		sightAngle 40
		x 112
		y 69
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 100 75 100 77 100 68 103 63 103 62 105 64 108 68 112 62 113 63 115 75 118 63 121 62 124 75
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance blueCans of Feature
	(properties
		noun 21
		sightAngle 40
		x 79
		y 90
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 57 96 57 96 57 85 102 85 102 96
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance greenCans of Feature
	(properties
		noun 20
		sightAngle 40
		x 117
		y 92
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 107 98 109 88 113 86 117 96 121 96 123 88 127 88 127 97
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance bigBtls of Feature
	(properties
		noun 22
		sightAngle 40
		x 16
		y 48
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 48 4 42 6 41 7 46 9 42 12 41 15 45 15 42 14 40 17 41 18 47 21 42 24 41 23 48 25 42 27 42 29 48 31 42 31 42 33 42 33 56 0 56
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance theGreenStuff of Feature
	(properties
		noun 16
		sightAngle 40
		x 16
		y 99
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 108 0 108 32 108 32 90 0 90
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance blackBtls of Feature
	(properties
		noun 17
		sightAngle 40
		x 15
		y 72
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 68 2 68 1 66 3 64 5 67 7 69 7 67 8 63 11 65 11 68 13 66 13 66 14 64 15 70 16 67 20 69 21 73 22 68 24 68 25 64 27 64 31 69 31 82 0 82
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance keyPad1 of Feature
	(properties
		noun 18
		sightAngle 40
		x 40
		y 87
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 37 84 37 92 44 92 44 83 37 83
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance keyPad2 of Feature
	(properties
		noun 18
		sightAngle 40
		x 133
		y 80
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 130 84 137 84 137 77 130 77
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance stackOfPapers of Feature
	(properties
		noun 19
		sightAngle 40
		x 224
		y 97
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 214 94 216 97 213 99 217 102 235 102 235 95 230 92 215 92
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance bottomGreenCans of Feature ; UNUSED
	(properties
		noun 24
		sightAngle 40
		x 115
		y 92
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 105 96 106 89 110 86 113 87 116 90 117 95 120 95 122 91 123 89 126 89 126 98 105 97
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance topLeft1 of Feature ; UNUSED
	(properties
		noun 26
		sightAngle 40
		x 200
		y 46
		z 13
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 195 39 191 36 194 32 195 30 195 29 198 29 199 32 201 35 202 33 203 30 203 29 207 28 207 33 209 37 207 39
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance topLeft2 of Feature ; UNUSED
	(properties
		noun 27
		sightAngle 40
		x 218
		y 46
		z 11
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 210 35 210 33 213 31 217 32 218 34 220 31 224 33 226 35 225 39 211 39
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance topLeft3 of Feature ; UNUSED
	(properties
		noun 28
		sightAngle 40
		x 238
		y 46
		z 12
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 226 33 227 30 231 30 234 34 235 30 240 29 241 34 244 30 248 30 250 34 250 38 245 39 242 38 240 38 234 38 226 38
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance bottomLeft of Feature ; UNUSED
	(properties
		noun 29
		sightAngle 40
		x 215
		y 58
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 208 63 209 54 222 53 222 63
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance bottomRight of Feature ; UNUSED
	(properties
		noun 30
		sightAngle 40
		x 240
		y 58
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 224 62 226 62 227 54 256 54 254 62
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance midRight1 of Feature ; UNUSED
	(properties
		noun 35
		sightAngle 40
		x 233
		y 45
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 223 50 223 45 228 44 227 42 243 41 241 50
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance midRight2 of Feature ; UNUSED
	(properties
		noun 34
		sightAngle 40
		x 249
		y 46
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 244 50 245 43 252 42 254 50
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance midLeft1 of Feature ; UNUSED
	(properties
		noun 32
		sightAngle 40
		x 198
		y 46
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 194 50 195 48 196 44 197 43 200 43 200 45 202 48 202 50
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance midLeft2 of Feature ; UNUSED
	(properties
		noun 33
		sightAngle 40
		x 211
		y 46
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 207 50 207 50 207 49 209 46 210 43 214 43 215 47 216 50
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance magazines of Feature
	(properties
		noun 36
		sightAngle 40
		x 206
		y 86
		z 5
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 178 84 185 78 234 79 236 84
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance poster of Feature
	(properties
		noun 37
		sightAngle 40
		x 271
		y 105
		z 20
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 262 77 281 76 281 95 262 95 261 77
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance mainShelf of Feature
	(properties
		noun 7
		sightAngle 40
		x 228
		y 45
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 174 72 174 24 180 22 199 19 212 19 240 19 266 21 282 26 283 72
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance Pa_Conshohoken of SmallTalker
	(properties
		name {Pa Conshohoken}
		talkView 281
		talkLoop 2
	)

	(method (init)
		(= client pa)
		(super init:)
	)
)

(instance sound1 of Sound
	(properties
		flags 1
	)
)

