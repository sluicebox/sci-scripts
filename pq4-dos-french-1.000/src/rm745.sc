;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 745)
(include sci.sh)
(use Main)
(use Scaler)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use Jump)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm745 0
)

(local
	local0 = 125
	local1 = 100
)

(instance rm745 of Room
	(properties
		noun 7
		picture 745
	)

	(method (init)
		(if (== gPrevRoomNum 710)
			(gTheIconBar curIcon: (gTheIconBar at: 0))
			(gTheIconBar curInvIcon: 0)
		)
		(gPqFlags set: 125)
		(super init: &rest)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 23 162 158 162 197 133 299 133 299 124 115 120 63 111 23 123 23 139 0 139 0 147 22 147
					yourself:
				)
		)
		(stereo init:)
		(theClock init:)
		(couch init:)
		(armchair init:)
		(theWindow init:)
		(drapes1 init:)
		(drapes2 init:)
		(pillows init:)
		(floor init:)
		(roomFeat init:)
		(if (== gPrevRoomNum 710)
			(gEgo
				view: 9745
				setLoop: 0
				cel: 0
				posn: 223 127
				setScale: 0
				init:
			)
			(dog init:)
			(ourBall init:)
			(gWalkHandler addToFront: self)
			(gMouseDownHandler addToFront: self)
			(self setScript: wakeUp)
		else
			(gEgo
				view: 0
				setHeading: (if (== gPrevRoomNum 725) 270 else 90)
				normalize: 0
				x: (if (== gPrevRoomNum 725) 295 else 25)
				y: (if (== gPrevRoomNum 725) 133 else 138)
				setScaler: Scaler 125 100 151 120
				init:
			)
			(theWindow approachVerbs: 1) ; Look
			(gMouseDownHandler addToFront: self)
			(gGame handsOn:)
		)
	)

	(method (handleEvent event)
		(cond
			((& (event type:) evMOVE)
				(if (gCast contains: dog)
					(self setScript: tryToRise)
				else
					(self setScript: rise)
				)
				(event claimed: 1)
				(return)
			)
			(
				(and
					(== (gTheIconBar curIcon:) (gTheIconBar useIconItem:))
					(== (gTheIconBar curInvIcon:) (gInventory at: 27)) ; ball
					(& (event type:) evMOUSEBUTTON)
					(not (event modifiers:))
				)
				(cond
					((theWindow onMe: event)
						(self setScript: throwBallWindow)
					)
					((> (event x:) 125)
						(self setScript: throwBallMid)
					)
					(else
						(self setScript: throwBallLeft)
					)
				)
				(event claimed: 1)
				(return)
			)
			(
				(and
					(== (gTheIconBar curIcon:) (gTheIconBar useIconItem:))
					(== (gTheIconBar curInvIcon:) (gInventory at: 35)) ; stickMirror
					(& (event type:) evMOUSEBUTTON)
					(not (event modifiers:))
				)
				(cond
					((InRect 0 4 4 127 (event x:) (event y:))
						(gMessager say: 13 49 0 0) ; "Proceed at your own risk."
						(event claimed: 1)
						(return)
					)
					((InRect 305 0 319 72 (event x:) (event y:))
						(gMessager say: 14 49 0 0) ; "The coast is clear."
						(event claimed: 1)
						(return)
					)
					(else
						(event claimed: 0)
						(return)
					)
				)
			)
			(else
				(event claimed: 0)
				(return)
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(script 0)
			((< (gEgo x:) 20)
				(self newRoom: 750)
			)
			((> (gEgo x:) 297)
				(self newRoom: 725)
			)
		)
	)

	(method (dispose)
		(if (!= gPrevRoomNum 710)
			(gMouseDownHandler delete: self)
		)
		(super dispose:)
	)
)

(instance shrinkCode of Code
	(properties)

	(method (doit)
		(if (< (-= local0 3) 108)
			(= local0 108)
		)
		(if (> (+= local1 1) 108)
			(= local1 108)
		)
		(gEgo setScaler: Scaler local0 local1 151 120)
	)
)

(instance wakeUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= ticks 240)
			)
			(1
				(gGlobalSound0 number: 745 loop: 1 play:)
				(gEgo
					signal: (| (gEgo signal:) $1000)
					cycleSpeed: 12
					setCycle: CT 4 1 self
				)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(= ticks 120)
			)
			(4
				(gEgo cycleSpeed: 12 setCycle: End self)
			)
			(5
				(gEgo loop: 1 cel: 0 cycleSpeed: 6)
				(gGlobalSound1 number: 995 loop: 1 play:)
				(dog setCycle: ForwardCounter 3 self)
			)
			(6
				(dog cel: 0)
				(gGlobalSound0 number: 731 loop: -1 play:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rise of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 9751
					loop: 0
					cel: 0
					posn: 221 124
					code: shrinkCode
					setCycle: End self
				)
			)
			(1
				(gEgo
					loop: 1
					cel: 0
					y: 126
					code: shrinkCode
					setCycle: End self
				)
			)
			(2
				(gEgo loop: 2 cel: 0 code: shrinkCode setCycle: End self)
			)
			(3
				(gWalkHandler delete: gCurRoom)
				(gMouseDownHandler delete: gCurRoom)
				(gEgo
					view: 0
					heading: 270
					normalize: 0
					posn: 209 122
					setScaler: Scaler 125 100 151 120
				)
				(theWindow approachVerbs: 1) ; Look
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance tryToRise of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 9745
					loop: 1
					cel: 0
					posn: 223 127
					setCycle: End self
				)
				(gGlobalSound1 number: 995 loop: 1 play:)
				(dog view: 740 loop: 0 cel: 0 posn: 99 154 setCycle: Fwd)
			)
			(1
				(= ticks 10)
			)
			(2
				(= ticks 45)
				(gEgo setCycle: Beg)
			)
			(3
				(dog setCycle: End self)
			)
			(4
				(dog cel: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getBall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame points: 2 85)
				(gEgo
					view: (if (== (ourBall y:) 121) 9748 else 9746)
					loop: 0
					cel: 0
					x: (if (== (ourBall y:) 121) 223 else 225)
					y: (if (== (ourBall y:) 121) 128 else 125)
					setCycle: CT 10 1 self
				)
			)
			(1
				(ourBall hide:)
				(gEgo get: 27 setCycle: End self) ; ball
			)
			(2
				(gEgo loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(gMessager say: 9 4 0 0 self) ; "You take the ball. It's wet and slimy!"
			)
			(4
				(gGame handsOn:)
				(gTheIconBar enable: 4 curInvIcon: (gInventory at: 27)) ; ball
				((gTheIconBar at: 4) setCursor: ((gInventory at: 27) getCursor:)) ; ball
				(gTheIconBar curIcon: (gTheIconBar at: 4))
				(gTheIconBar show: 0)
				(gGame setCursor: ((gTheIconBar curIcon:) cursorView:) 1)
				(self dispose:)
			)
		)
	)
)

(instance throwBallWindow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame points: 4)
				(gEgo
					view: 9750
					loop: 0
					cel: 0
					posn: 223 128
					setCycle: CT 9 1 self
				)
			)
			(1
				(dog
					setPri: 315
					view: 745
					loop: 0
					cel: 0
					posn: 88 147
					setCycle: End self
				)
				(ourBall posn: 172 79 setPri: 79 show: setMotion: JumpTo 0 64)
				(gEgo setCycle: End)
			)
			(2
				(ourBall dispose:)
				(dog loop: 1 cel: 0 setCycle: End)
				(gEgo put: 27 loop: 1 cel: 0 setCycle: End self) ; ball
			)
			(3
				(= cycles 1)
			)
			(4
				(gPqFlags set: 126)
				(dog dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance throwBallMid of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 9747
					loop: 0
					cel: 0
					posn: 223 127
					setCycle: CT 9 1 self
				)
			)
			(1
				(Load rsVIEW 743)
				(ourBall
					posn: 173 90
					setPri: 15
					show:
					setMotion: JumpTo 107 169
				)
				(dog view: 743 loop: 0 cel: 0 posn: 94 147 setCycle: End self)
				(gEgo put: 27 loop: 1 cel: 0 setCycle: End) ; ball
			)
			(2
				(dog loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(ourBall setMotion: 0 hide:)
				(dog hide:)
				(= cycles 1)
			)
			(4
				(gEgo
					view: 9745
					loop: 1
					cel: 0
					posn: 223 127
					setCycle: End self
				)
			)
			(5
				(= ticks 60)
			)
			(6
				(gGlobalSound1 number: 995 loop: 1 play:)
				(gEgo setCycle: Beg self)
			)
			(7
				(Load rsVIEW 744)
				(dog
					view: 744
					loop: 0
					cel: 0
					posn: 81 148
					show:
					setCycle: End self
				)
				(gGlobalSound1 number: 991 loop: 1 play:)
			)
			(8
				(dog loop: 1 cel: 0 setCycle: CT 4 1 self)
			)
			(9
				(ourBall
					posn: 157 99
					setMotion: 0
					show:
					setMotion: JumpTo 160 121 self
				)
				(dog setCycle: End self)
			)
			(10 0)
			(11
				(Load rsVIEW 741)
				(dog view: 741 loop: 2 cel: 0 posn: 90 147 setCycle: End self)
				(ourBall setMotion: 0)
			)
			(12
				(Load rsVIEW 746)
				(dog view: 746 loop: 0 cel: 0 posn: 88 150 setCycle: End self)
			)
			(13
				(Load rsVIEW 740)
				(dog view: 740 loop: 0 cel: 0 posn: 99 154)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance throwBallLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 9749
					loop: 0
					cel: 0
					posn: 223 128
					setCycle: CT 9 1 self
				)
			)
			(1
				(Load rsVIEW 740)
				(ourBall
					posn: 167 93
					setPri: 15
					show:
					setMotion: JumpTo -15 150
				)
				(dog view: 740 loop: 1 cel: 0 posn: 99 154 setCycle: End self)
				(gEgo put: 27 loop: 1 cel: 0 setCycle: End) ; ball
			)
			(2
				(dog loop: 2 cel: 0 setCycle: End self)
			)
			(3
				(ourBall setMotion: 0 hide:)
				(dog hide:)
				(= cycles 1)
			)
			(4
				(gEgo
					view: 9745
					loop: 1
					cel: 0
					posn: 223 127
					setCycle: End self
				)
			)
			(5
				(= ticks 60)
			)
			(6
				(gGlobalSound1 number: 995 loop: 1 play:)
				(gEgo setCycle: Beg self)
			)
			(7
				(Load rsVIEW 741)
				(dog
					view: 741
					loop: 0
					cel: 0
					posn: 90 147
					show:
					setCycle: End self
				)
				(gGlobalSound1 number: 991 loop: 1 play:)
			)
			(8
				(ourBall
					posn: 157 105
					setMotion: 0
					setPri: -1
					show:
					setMotion: JumpTo 160 121 self
				)
				(dog loop: 1 cel: 0 setCycle: End self)
			)
			(9 0)
			(10
				(dog view: 741 loop: 2 cel: 0 posn: 90 147 setCycle: End self)
			)
			(11
				(Load rsVIEW 746)
				(dog view: 746 loop: 0 cel: 0 posn: 88 150 setCycle: End self)
			)
			(12
				(Load rsVIEW 740)
				(dog view: 740 loop: 0 cel: 0 posn: 99 154)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance dog of Actor
	(properties
		noun 8
		x 99
		y 154
		view 740
		signal 20481
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: tryToRise)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance ourBall of Actor
	(properties
		noun 9
		x 170
		y 111
		view 9752
		signal 16385
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: getBall)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance roomFeat of Feature
	(properties
		noun 7
		nsRight 319
		nsBottom 153
		sightAngle 360
		x 159
	)
)

(instance stereo of Feature
	(properties
		noun 1
		x 95
		y 75
	)

	(method (init)
		(super init:)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 57 72 92 71 93 73 120 73 126 69 133 69 134 74 134 85 131 86 129 107 57 103
				yourself:
			)
		)
	)
)

(instance theClock of Feature
	(properties
		noun 2
		x 167
		y 27
	)

	(method (init)
		(super init:)
		(= onMeCheck
			((Polygon new:) type: PBarredAccess init: 159 21 175 21 175 33 159 33 yourself:)
		)
	)
)

(instance couch of Feature
	(properties
		noun 3
		x 218
		y 79
	)

	(method (init)
		(super init:)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 134 86 144 83 145 73 274 78 274 88 267 88 266 118 130 111
				yourself:
			)
		)
	)
)

(instance armchair of Feature
	(properties
		noun 4
		x 287
		y 133
	)

	(method (init)
		(super init:)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 214 125 273 128 277 122 294 117 304 110 309 105 319 109 319 153 193 153 208 145 214 140 214 135 207 135 206 133
				yourself:
			)
		)
	)
)

(instance theWindow of Feature
	(properties
		noun 5
		approachX 42
		approachY 118
		x 30
		y 57
	)

	(method (init)
		(super init:)
		(= onMeCheck
			((Polygon new:) type: PBarredAccess init: 10 13 43 17 45 81 10 86 yourself:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cond
					((> (gEgo view:) 5)
						(gMessager say: noun theVerb 2 0) ; "You can't see out the window from this position."
					)
					((gPqFlags test: 126)
						(gMessager say: noun theVerb 1 0) ; "A gruesome sight. The dog did not survive the fall."
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance floor of Feature
	(properties
		noun 10
		sightAngle 360
		x 59
		y 104
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 173 115 265 119 264 126 214 124 206 132 206 135 212 135 211 140 191 153 0 153 0 116 57 103
					yourself:
				)
		)
	)
)

(instance pillows of Feature
	(properties
		noun 11
		x 224
		y 65
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 145 73 150 69 154 69 159 69 162 72 167 72 166 68 167 64 171 63 176 62 181 62 187 72 187 63 188 55 188 54 215 54 215 63 252 63 255 67 260 60 284 65 280 76 273 78
					yourself:
				)
		)
	)
)

(instance drapes1 of Feature
	(properties
		noun 6
		x 5
		y 7
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 41 10 44 6 72 9 71 67 66 67 64 70 58 71 56 87 48 87 44 82 46 14
					yourself:
				)
		)
	)
)

(instance drapes2 of Feature
	(properties
		noun 6
		x 61
		y 13
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 0 2 10 3 12 5 10 7 10 91 3 92 0 94
					yourself:
				)
		)
	)
)

