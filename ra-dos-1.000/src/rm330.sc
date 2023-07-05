;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 330)
(include sci.sh)
(use Main)
(use eRS)
(use Inset)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use MoveFwd)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm330 0
	Laura 2
	Steve 12
)

(local
	local0 = 1
)

(instance rm330 of LBRoom
	(properties
		noun 7
		picture 330
		horizon 125
		north 335
		south 250
		vanishingX 400
		vanishingY 78
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if local0
					(gMessager say: 7 1 1) ; "The famous Leyendecker Museum, named after Ignatz Leyendecker, who financed the construction of the museum as a tax dodge. Ignatz made his fortune in the late 1800's by defying the Banana Embargo and smuggling bananas into the country disguised as miniature squash."
					(= local0 0)
				else
					(gMessager say: 7 1 2) ; "The exterior of this museum was hand-painted."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(LoadMany rsVIEW 1410 1411 330 331 213)
		(LoadMany rsSOUND 332 330 40)
		(LoadMany rsPIC 415 410)
		(gEgo normalize: (if (gEgo wearingGown:) 831 else 830) init:)
		(switch gPrevRoomNum
			(north
				(gEgo posn: 158 146 signal: (| (gEgo signal:) $4000))
				(if
					(not
						(and (== gAct 2) (TimeCheck $0008) (not (IsFlag 133)))
					)
					(gGameMusic1 number: 330 flags: 1 loop: 1 play:)
				)
				(if (and (== gAct 2) (TimeCheck $0008) (not (IsFlag 133)))
					(steve init: loop: 1 setCycle: Walk)
					(gEgo setScale: 179)
					(gCurRoom setScript: sKissAndHug)
				else
					(gGame handsOn:)
					(gEgo setScale: 179)
				)
			)
			(else
				(gGameMusic1 number: 330 flags: 1 loop: 1 play:)
				(gEgo posn: 178 136)
				(gEgo setScale: 179)
				(if (gEgo wearingGown:)
					(taxi posn: 196 161 init: stopUpd:)
					(gCurRoom setScript: sTaxiLeave)
					(gGame handsOff:)
				else
					(gGame handsOn:)
				)
			)
		)
		(if (> gAct 1)
			(Palette palSET_INTENSITY 0 255 60)
		)
		(super init:)
		(gGameMusic2 number: 333 flags: 1 loop: -1 play:)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 0 143 0 169 62 162 106 158 178 152 196 144 305 139 319 139 319 127 277 128 270 134 239 134 212 116 166 116 150 116 154 131 110 140 62 144 32 139 0 141
					yourself:
				)
		)
		(larch init:)
		(lawn1 init:)
		(lawn2 init:)
		(car1 init:)
		(car2 init:)
		(clouds init:)
		(dome init:)
		(entrance init:)
		(bigWindow init:)
		(sidewalk init:)
		(steps init:)
		(if (< gAct 2)
			(taxi init: stopUpd:)
		)
		(street init:)
		(fountain1 init: setCycle: Fwd)
		(fountain2 init: setCycle: Fwd)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((StepOn gEgo 256)
				(gCurRoom setScript: sHitEdgeScreen)
			)
		)
	)

	(method (dispose)
		(carSound dispose:)
		(gGameMusic1 fade: 0 30 12 1)
		(gGameMusic2 fade: 0 30 12 1)
		(super dispose: &rest)
	)
)

(instance sHitEdgeScreen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 4 3 0 0 self 91) ; "Don't stray too far in The Big Apple. It's a big city, and you're not familiar with it yet."
			)
			(1
				(if (> (gEgo heading:) 180)
					(gEgo setHeading: 90)
				else
					(gEgo setHeading: 270)
				)
				(gEgo setMotion: MoveFwd 10 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTaxiLeave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(taxi setMotion: MoveTo 369 125 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sInTaxi of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 146 151 self)
			)
			(1
				(carSound play:)
				(= ticks 30)
			)
			(2
				(gEgo setMotion: MoveTo 146 163 self)
			)
			(3
				(gEgo hide:)
				(= cycles 2)
			)
			(4
				(gCurRoom newRoom: 250)
			)
		)
	)
)

(instance sKissAndHug of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 58 150 self)
			)
			(1
				(Face gEgo steve)
				(Face steve gEgo)
				(= seconds 4)
			)
			(2
				(gGame points: 1 133)
				(gCurRoom picture: 780 setInset: closeUp self)
			)
			(3
				(gCast eachElementDo: #hide)
				(= cycles 2)
			)
			(4
				(gCurRoom drawPic: 330)
				(Palette palSET_INTENSITY 0 255 60)
				(gCast eachElementDo: #show)
				(steve setLoop: 0)
				(gEgo setMotion: PolyPath 158 146 self)
			)
			(5
				(DrawPic 780 10)
				(gCast eachElementDo: #hide)
				(= cycles 2)
			)
			(6
				(Palette palSET_INTENSITY 0 255 100)
				(gCurRoom newRoom: 350)
				(self dispose:)
			)
		)
	)
)

(instance sCloseUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gGameMusic1 number: 332 flags: 1 loop: -1 play:)
				(gMessager say: 6 0 0 0 self 330) ; "I just...wanted to explain to you...who I really am."
				(gGameMusic2 fade: 0 12 30 0)
			)
			(2
				(DrawPic 415 -32758)
				(gGameMusic1 number: 334 flags: 1 loop: 1 play:)
				(= seconds 4)
			)
			(3
				(DrawPic 410 -32758)
				(= ticks 30)
			)
			(4
				(gMessager say: 12 0 0 0 self 330) ; "Let's go back to the party, Steve. I've got work to do."
			)
			(5
				(gGameMusic2 fade: 127 12 30 0)
				(closeUp dispose:)
				(self dispose:)
			)
		)
	)
)

(instance taxi of Actor
	(properties
		x 139
		y 146
		noun 5
		view 213
		cel 2
		priority 15
		signal 16400
		moveSpeed 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sInTaxi)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance steve of Actor
	(properties
		x 156
		y 142
		view 331
		signal 16384
	)

	(method (doit)
		(= cel (gEgo cel:))
		(= x (- (gEgo x:) 2))
		(= y (- (gEgo y:) 4))
		(super doit: &rest)
	)
)

(instance fountain1 of Prop
	(properties
		x 77
		y 137
		noun 4
		view 330
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Ask
				(gMessager say: 4 6 3) ; "The fountain is too busy fountaining to respond to your question."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fountain2 of Prop
	(properties
		x 263
		y 126
		noun 4
		view 330
		loop 1
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Ask
				(gMessager say: 4 6 3) ; "The fountain is too busy fountaining to respond to your question."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Laura of Talker
	(properties
		x 0
		y 0
		view 1411
		loop 3
		disposeWhenDone 0
		talkWidth 250
		back 15
		textX 15
		textY 120
	)

	(method (init)
		(= font gUserFont)
		(super init: lauraBust lauraEyes lauraMouth &rest)
	)
)

(instance lauraBust of Prop
	(properties
		view 1411
		loop 1
	)
)

(instance lauraEyes of Prop
	(properties
		nsTop 65
		nsLeft 182
		view 1411
		loop 2
		signal 16384
	)
)

(instance lauraMouth of Prop
	(properties
		nsTop 70
		nsLeft 182
		view 1411
		signal 16384
	)
)

(instance Steve of Talker
	(properties
		x 0
		y 0
		view 1410
		loop 3
		disposeWhenDone 0
		talkWidth 250
		back 15
		textX 15
		textY 120
	)

	(method (init)
		(= font gUserFont)
		(super init: steveBust steveEyes steveMouth &rest)
	)
)

(instance steveBust of Prop
	(properties
		view 1410
		loop 1
	)
)

(instance steveEyes of Prop
	(properties
		nsTop 50
		nsLeft 140
		view 1410
		loop 2
		signal 16384
	)
)

(instance steveMouth of Prop
	(properties
		nsTop 62
		nsLeft 130
		view 1410
		signal 16384
	)
)

(instance lawn1 of Feature
	(properties
		x 27
		y 130
		noun 8
		nsTop 127
		nsBottom 134
		nsRight 54
		sightAngle 40
	)
)

(instance lawn2 of Feature
	(properties
		x 297
		y 122
		noun 8
		nsTop 119
		nsLeft 275
		nsBottom 125
		nsRight 319
		sightAngle 40
	)
)

(instance car1 of Feature
	(properties
		y 3
		noun 2
		nsTop 148
		nsBottom 174
		nsRight 69
	)
)

(instance car2 of Feature
	(properties
		y 3
		noun 2
		nsTop 126
		nsLeft 204
		nsBottom 143
		nsRight 276
	)
)

(instance larch of Feature
	(properties
		y 3
		noun 3
		nsTop 78
		nsLeft 44
		nsBottom 110
		nsRight 92
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Ask
				(gMessager say: 3 6 3) ; "The tree considers your question, but you're going to die of old age if you choose to wait for a response."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance clouds of Feature
	(properties
		y 3
		noun 11
		onMeCheck 128
	)
)

(instance dome of Feature
	(properties
		y 3
		noun 13
		onMeCheck 8
	)
)

(instance entrance of Feature
	(properties
		y 3
		noun 14
		onMeCheck 32
	)
)

(instance bigWindow of Feature
	(properties
		y 3
		noun 15
		onMeCheck 2
	)
)

(instance sidewalk of Feature
	(properties
		y 3
		noun 1
		onMeCheck 4
	)
)

(instance steps of Feature
	(properties
		y 3
		noun 9
		onMeCheck 16384
	)
)

(instance street of Feature
	(properties
		y 3
		noun 10
		onMeCheck 64
	)
)

(instance closeUp of Inset
	(properties
		picture 410
		style -32758
		hideTheCast 1
	)

	(method (init)
		(super init: &rest)
		(self setScript: sCloseUp)
	)
)

(instance carSound of Sound
	(properties
		flags 5
		number 40
	)
)

