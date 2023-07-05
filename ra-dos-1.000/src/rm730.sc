;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 730)
(include sci.sh)
(use Main)
(use eRS)
(use Talker)
(use PChase)
(use Feature)
(use ForwardCounter)
(use LoadMany)
(use Sound)
(use Jump)
(use Motion)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	rm730 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
)

(instance rm730 of LBRoom
	(properties
		noun 1
		east 740
		south 720
	)

	(method (init)
		(gCurRoom obstacles: (List new:))
		((ScriptID 2730 0) doit: (gCurRoom obstacles:)) ; poly2730Code
		(gEgo init: normalize: 732 actions: egoActions)
		(self picture: (if ((Inv at: 15) cel:) 730 else 780)) ; lantern
		(if ((Inv at: 15) cel:) ; lantern
			(piece1 init:)
			(piece2 init:)
			(piece3 init:)
			(Palette palSET_INTENSITY 0 255 0)
		)
		(LoadMany rsSOUND 732)
		(gGame handsOff:)
		(super init:)
		(if (!= (gGameMusic2 number:) 17)
			(gGameMusic2 number: 17 loop: -1 flags: 1 play:)
		)
		(gTheIconBar disable: 7)
		(steve init:)
		(snake1 init:)
		(snake2 init:)
		(snake3 init:)
		(snake4 init:)
		(snake5 init:)
		(floor init:)
		(wall init:)
		(hieroglyphics init:)
		(if ((Inv at: 15) cel:) ; lantern
			(= local0 1)
			(self setScript: sEnterSouthLight)
		else
			(self setScript: sEnterDark)
		)
	)

	(method (doit)
		(super doit: &rest)
		(if (and (== (self picture:) 780) ((Inv at: 15) cel:)) ; lantern
			(= local0 1)
			(Palette palSET_INTENSITY 0 255 0)
			(piece1 init:)
			(piece2 init:)
			(piece3 init:)
			(self picture: 730 drawPic: 730)
			(gGame handsOff:)
			(gTheIconBar disable: 7)
			(sFX number: 732 flags: 1 loop: -1 play:)
			(gEgo
				view: 732
				setLoop: 0
				posn: 96 161
				cycleSpeed: 4
				moveSpeed: 4
				xStep: 2
				setCycle: Walk
			)
			(steve
				setLoop: 0
				posn: 65 180
				setCycle: Walk
				cycleSpeed: 4
				moveSpeed: 4
				xStep: 2
				setMotion: PFollow gEgo 36
			)
			(snake1
				view: 731
				setLoop: 2
				setCel: 0
				posn: 248 72
				cycleSpeed: 6
				setCycle: Fwd
			)
			(snake2
				view: 731
				setLoop: 2
				setCel: 2
				posn: 252 59
				cycleSpeed: 6
				setCycle: Fwd
			)
			(snake3
				view: 731
				setLoop: 2
				setCel: 0
				posn: 266 62
				cycleSpeed: 6
				setCycle: Fwd
			)
			(snake4
				view: 731
				setLoop: 2
				setCel: 2
				posn: 265 57
				cycleSpeed: 6
				setCycle: Fwd
			)
			(snake5
				view: 731
				setLoop: 2
				setCel: 0
				posn: 276 55
				cycleSpeed: 6
				setCycle: Fwd
			)
			(snake6 cycleSpeed: 6 setCycle: Fwd init:)
			(snake7 cycleSpeed: 6 setCycle: Fwd init:)
			(Load rsVIEW 734)
			(Load rsSOUND 3)
			(= local9 1)
		)
		(if local0
			(Palette palSET_INTENSITY 0 255 (+= local2 2))
			(if (>= local2 100)
				(= local0 0)
				(if (!= (gCurRoom script:) sEnterSouthLight)
					(gGame handsOn:)
					(gTheIconBar disable: 7)
				)
				(piece1 addToPic:)
				(piece2 addToPic:)
				(piece3 addToPic:)
				(if local9
					(self setScript: sLetThereBeLight)
				)
			)
		)
		(if local1
			(Palette palSET_INTENSITY 0 255 (Max 0 (-= local2 3)))
			(if (== local2 0)
				(= local1 0)
			)
		)
		(cond
			(script 0)
			((StepOn gEgo 8)
				(gGame handsOff:)
				(= local1 1)
				(self setScript: sExitEast)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (== (self picture:) 780)
					(gMessager say: 1 1 1) ; "It's too dark to see anything in here."
				else
					(gMessager say: 1 1 11) ; "This is a tunnel with hieroglyphics on the walls."
				)
			)
			(4 ; Do
				(if (== (self picture:) 780)
					(gMessager say: 1 4 1) ; "Reaching out, you feel smooth stone and something else you don't want to touch."
				else
					(gMessager say: 1 4 11) ; "You feel cool, smooth stone."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(LoadMany 0 930 991)
		(DisposeScript 2730)
		(super dispose:)
	)
)

(instance sEnterSouthLight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(steve
					setLoop: 0
					setCycle: Walk
					cycleSpeed: 4
					moveSpeed: 4
					xStep: 2
					setMotion: PFollow gEgo 36
				)
				(gEgo
					setLoop: 0
					posn: -10 240
					edgeHit: EDGE_NONE
					setCycle: Walk
					cycleSpeed: 4
					moveSpeed: 4
					xStep: 2
					setMotion: MoveTo 96 161 self
				)
				(snake1
					view: 731
					setLoop: 2
					setCel: 0
					posn: 248 72
					cycleSpeed: 6
					setCycle: Fwd
				)
				(snake2
					view: 731
					setLoop: 2
					setCel: 2
					posn: 252 59
					cycleSpeed: 6
					setCycle: Fwd
				)
				(snake3
					view: 731
					setLoop: 2
					setCel: 0
					posn: 266 62
					cycleSpeed: 6
					setCycle: Fwd
				)
				(snake4
					view: 731
					setLoop: 2
					setCel: 2
					posn: 265 57
					cycleSpeed: 6
					setCycle: Fwd
				)
				(snake5
					view: 731
					setLoop: 2
					setCel: 0
					posn: 276 55
					cycleSpeed: 6
					setCycle: Fwd
				)
				(snake6 cycleSpeed: 6 setCycle: Fwd init:)
				(snake7 cycleSpeed: 6 setCycle: Fwd init:)
				(Load rsVIEW 734)
				(Load rsSOUND 3)
			)
			(1
				(gGame handsOn:)
				(gTheIconBar disable: 7)
				(= seconds 5)
			)
			(2
				(snake1 setLoop: 0 setCycle: Walk setMotion: MoveTo 58 184)
				(snake2 setLoop: 0 setCycle: Walk setMotion: MoveTo 45 180)
				(snake3 setLoop: 0 setCycle: Walk setMotion: MoveTo 59 183)
				(snake4 setLoop: 0 setCycle: Walk setMotion: MoveTo 58 178)
				(snake5 setLoop: 0 setCycle: Walk setMotion: MoveTo 69 176)
				(snake6 setLoop: 0 setCycle: Walk setMotion: MoveTo 72 170)
				(snake7 setLoop: 0 setCycle: Walk setMotion: MoveTo 73 165)
				(self dispose:)
			)
		)
	)
)

(instance sExitEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 335 23 self)
			)
			(1
				(gCurRoom newRoom: (gCurRoom east:))
			)
		)
	)
)

(instance sEnterDark of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(User canControl: 0)
				(User canInput: 1)
				(gTheIconBar disable: 0 3 4 5 7)
				(steve setLoop: 2 posn: 66 148 setCycle: Blink 150)
				(gEgo view: 733 setLoop: 1 posn: 85 135 setCycle: Blink 150)
				(= seconds 6)
			)
			(1
				(snake1 setCycle: Beg)
				(snake2 setCycle: Beg)
				(snake3 setCycle: Beg)
				(snake4 setCycle: Beg)
				(snake5 setCycle: Beg)
				(= ticks 60)
			)
			(2
				(snake1 setCycle: Blink 200)
				(snake2 setCycle: Blink 200)
				(snake3 setCycle: Blink 200)
				(snake4 setCycle: Blink 200)
				(snake5 setCycle: Blink 200)
				(= seconds 15)
			)
			(3
				(gGame handsOff:)
				(snake1 setLoop: 4 setMotion: MoveTo 110 127)
				(snake2 setLoop: 4 setMotion: MoveTo 123 117)
				(snake3 setLoop: 4 setMotion: MoveTo 137 127)
				(snake4 setLoop: 4 setMotion: MoveTo 134 106)
				(snake5 setLoop: 4 setMotion: MoveTo 152 118 self)
				(= ticks 60)
			)
			(4
				(gGameMusic2 stop:)
				(gGameMusic1 number: 3 flags: 1 loop: 1 play:)
				(steve
					setLoop: 6
					setCel: 0
					cycleSpeed: 3
					setCycle: ForwardCounter 4
				)
				(gEgo
					setLoop: 5
					setCel: 0
					cycleSpeed: 3
					setCycle: ForwardCounter 4 self
				)
			)
			(5
				(steve setLoop: 2 cycleSpeed: 6 setCycle: Blink 150)
				(gEgo setLoop: 1 cycleSpeed: 6 setCycle: Blink 150)
			)
			(6
				(gEgo setLoop: 1 setCel: 1 setMotion: JumpTo 98 148 self)
			)
			(7
				(gEgo cycleSpeed: 18 setCycle: End self)
			)
			(8
				(snake1 setLoop: 4 setMotion: MoveTo 89 140)
				(snake2 setLoop: 4 setMotion: MoveTo 102 130)
				(snake3 setLoop: 4 setMotion: MoveTo 118 140)
				(snake4 setLoop: 4 setMotion: MoveTo 110 118)
				(snake5 setLoop: 4 setMotion: MoveTo 127 129 self)
			)
			(9
				(steve setLoop: 2 setCel: 1 setMotion: JumpTo 77 163 self)
			)
			(10
				(steve cycleSpeed: 18 setCycle: End self)
			)
			(11
				(= ticks 60)
			)
			(12
				(= global145 11) ; "Your dying thought is, "Venom I ever going to learn?""
				(gCurRoom newRoom: 99) ; deathRoom
				(self dispose:)
			)
		)
	)
)

(instance sLetThereBeLight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 7)
			)
			(1
				(snake1 setLoop: 0 setCycle: Walk setMotion: MoveTo 58 184)
				(snake2 setLoop: 0 setCycle: Walk setMotion: MoveTo 45 180)
				(snake3 setLoop: 0 setCycle: Walk setMotion: MoveTo 59 183)
				(snake4 setLoop: 0 setCycle: Walk setMotion: MoveTo 58 178)
				(snake5 setLoop: 0 setCycle: Walk setMotion: MoveTo 69 176)
				(snake6 setLoop: 0 setCycle: Walk setMotion: MoveTo 72 170)
				(snake7 setLoop: 0 setCycle: Walk setMotion: MoveTo 73 165)
				(self dispose:)
			)
		)
	)
)

(instance sSteveDies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(steve
					view: 734
					setLoop: 1
					setCel: 0
					cycleSpeed: 12
					ignoreActors: 1
					setCycle: End self
				)
			)
			(1
				(snake1 setCycle: Fwd setMotion: 0)
				(snake2 setCycle: Fwd setMotion: 0)
				(snake3 setCycle: Fwd setMotion: 0)
				(snake4 setCycle: Fwd setMotion: 0)
				(snake5 setCycle: Fwd setMotion: 0)
				(snake6 setCycle: Fwd setMotion: 0)
				(snake7 setCycle: Fwd setMotion: 0)
				(= ticks 120)
			)
			(2
				(= global145 11) ; "Your dying thought is, "Venom I ever going to learn?""
				(gCurRoom newRoom: 99) ; deathRoom
				(self dispose:)
			)
		)
	)
)

(instance sSprinkleOil of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setLoop: 1 setCel: 0 setCycle: CT 4 1 self)
			)
			(1
				(oil
					init:
					posn: (+ (gEgo x:) 23) (- (gEgo y:) 27)
					setMotion:
						JumpTo
						(+ (gEgo x:) 59)
						(- (gEgo y:) 39)
						self
				)
				(gEgo setCel: 5)
			)
			(2
				(= local3 1)
				(oil stopUpd:)
				(gEgo
					view: 732
					setLoop: 0
					cycleSpeed: 4
					moveSpeed: 4
					xStep: 2
					setCycle: Walk
				)
				(if local8
					(sRepelSnakes cue:)
				)
				(self dispose:)
			)
		)
	)
)

(instance sRepelSnakes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(snake1 setCycle: Fwd setMotion: 0)
				(snake2 setCycle: Fwd setMotion: 0)
				(snake3 setCycle: Fwd setMotion: 0)
				(snake4 setCycle: Fwd setMotion: 0)
				(snake5 setCycle: Fwd setMotion: 0)
				(snake6 setCycle: Fwd setMotion: 0)
				(snake7 setCycle: Fwd setMotion: 0)
				(if local3
					(= cycles 1)
				else
					(= local8 1)
					(gEgo setScript: sSprinkleOil)
				)
			)
			(1
				(= ticks 90)
			)
			(2
				(snake1
					setLoop: 1
					posn: (snake1 x:) (- (snake1 y:) 3)
					setCycle: Walk
					setMotion: MoveTo 320 27 self
				)
				(snake2
					setLoop: 1
					posn: (snake2 x:) (- (snake2 y:) 3)
					setCycle: Walk
					setMotion: MoveTo 324 14
				)
				(snake3
					setLoop: 1
					posn: (snake3 x:) (- (snake3 y:) 3)
					setCycle: Walk
					setMotion: MoveTo 338 17
				)
				(snake4
					setLoop: 1
					posn: (snake4 x:) (- (snake4 y:) 3)
					setCycle: Walk
					setMotion: MoveTo 337 12
				)
				(snake5
					setLoop: 1
					posn: (snake5 x:) (- (snake5 y:) 3)
					setCycle: Walk
					setMotion: MoveTo 348 10
				)
				(snake6
					setLoop: 1
					posn: (snake6 x:) (- (snake6 y:) 3)
					setCycle: Walk
					setMotion: MoveTo 351 4
				)
				(snake7
					setLoop: 1
					posn: (snake7 x:) (- (snake7 y:) 3)
					setCycle: Walk
					setMotion: MoveTo 352 -1
				)
			)
			(3
				(snake1 dispose:)
				(snake2 dispose:)
				(snake3 dispose:)
				(snake4 dispose:)
				(snake5 dispose:)
				(snake6 dispose:)
				(snake7 dispose:)
				(sFX stop:)
				(= local4 1)
				(gGame handsOn:)
				(gTheIconBar disable: 7)
				(self dispose:)
			)
		)
	)
)

(instance sThrowBottle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setLoop: 1 setCel: 0 setCycle: CT 4 1 self)
			)
			(1
				(oilBottle
					init:
					setCycle: Fwd
					posn: (+ (gEgo x:) 23) (- (gEgo y:) 27)
					setMotion:
						JumpTo
						(+ (gEgo x:) 59)
						(- (gEgo y:) 39)
						self
				)
				(gEgo setCel: 5)
			)
			(2
				(oilBottle setLoop: 4 setCel: 0 setCycle: End self)
			)
			(3
				(oilBottle setCycle: 0 addToPic:)
				(gEgo
					view: 732
					setLoop: 0
					put: 14 ; snakeOil
					cycleSpeed: 4
					moveSpeed: 4
					xStep: 2
					setCycle: Walk
				)
				(self dispose:)
			)
		)
	)
)

(instance egoActions of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (== (gCurRoom picture:) 780)
					(gMessager say: 3 1 1) ; "They're YOUR eyes, Laura."
				else
					0
				)
			)
			(25 ; snakeOil
				(gMessager say: 11 25) ; "Oh, my, that smells terrible!"
			)
			(else 0)
		)
	)
)

(instance steve of Actor
	(properties
		x -30
		y 260
		noun 9
		view 733
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (== (gCurRoom picture:) 780)
					(gMessager say: 4 1 1) ; "Steve's eyes are a lovely shade of blue, aren't they."
				else
					(gMessager say: 1 1 27 0 0 1887) ; "Steve has a lump on his head, his rumpled tuxedo has black smudges on it, and he's looking rather tired. However, his eyes still sparkle when he looks at you."
				)
			)
			(4 ; Do
				(if (== (gCurRoom picture:) 780)
					(super doVerb: theVerb)
				else
					(gMessager say: 1 4 27 0 0 1887) ; "Don't touch me right now, Laura. I'm bruised all over."
				)
			)
			(8 ; magnifier
				(if (== (gCurRoom picture:) 780)
					(super doVerb: theVerb)
				else
					(gMessager say: 1 8 27 0 0 1887) ; "Don't look at me too close. I'm not at my best right now."
				)
			)
			(2 ; Talk
				(if local4
					(gMessager say: 9 2 9) ; "Let's get out of this place. My skin is crawling."
				else
					(switch local7
						(0
							(gMessager say: 9 2 5) ; "Steve, what are we going to do?"
						)
						(else
							(gMessager say: 9 2 6) ; "Have you got any ideas, Laura? I hope so..."
						)
					)
					(++ local7)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance snake1 of Actor
	(properties
		x 226
		y 60
		noun 7
		view 733
		loop 4
		cel 3
		signal 16384
	)

	(method (doit)
		(super doit: &rest)
		(cond
			(script)
			((== (gCurRoom script:) sRepelSnakes))
			((and local3 (< (gEgo distanceTo: snake1) 65))
				(gCurRoom setScript: sRepelSnakes)
			)
			(
				(and
					(< (self distanceTo: gEgo) 14)
					(== (gEgo view:) 732)
					(== (self view:) 731)
				)
				(gGame handsOff:)
				(gGameMusic2 stop:)
				(gGameMusic1 number: 3 flags: 1 loop: 1 play:)
				(gEgo
					view: 734
					setLoop: 0
					setCel: 0
					cycleSpeed: 12
					setCycle: End
				)
			)
			(
				(and
					(< (self distanceTo: steve) 14)
					(== (steve view:) 733)
					(== (self view:) 731)
				)
				(gCurRoom setScript: sSteveDies)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (== (gCurRoom picture:) 780)
					(gMessager say: 5 1 1) ; "Oh, dear, THOSE aren't Steve's eyes..."
				else
					(switch local5
						(0
							(gMessager say: 7 1 2) ; "If your herpitology doesn't fail you, you're pretty sure these are king cobras!"
						)
						(1
							(gMessager say: 7 1 3) ; "The cobras really don't look happy to see you."
						)
						(else
							(gMessager say: 7 1 4) ; "The cobras glisten hypnotically as they slither closer and closer..."
						)
					)
					(++ local5)
				)
			)
			(2 ; Talk
				(switch local6
					(0
						(gMessager say: 7 2 5) ; "The snakes are hissing, but you can't understand them."
					)
					(else
						(gMessager say: 7 2 6) ; "This ain't King's Quest, Laura."
					)
				)
				(++ local6)
			)
			(25 ; snakeOil
				(cond
					((== (gCurRoom picture:) 780) 0)
					((== global150 0)
						(gEgo setScript: sThrowBottle)
					)
					((< (gEgo distanceTo: snake1) 65)
						(gCurRoom setScript: sRepelSnakes)
					)
					(else
						(gGame handsOff:)
						(gEgo setScript: sSprinkleOil)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance snake2 of Actor
	(properties
		x 240
		y 51
		noun 7
		view 733
		loop 4
		cel 3
		signal 16384
	)

	(method (doVerb)
		(snake1 doVerb: &rest)
	)
)

(instance snake3 of Actor
	(properties
		x 256
		y 57
		noun 7
		view 733
		loop 4
		cel 3
		signal 16384
	)

	(method (doVerb)
		(snake1 doVerb: &rest)
	)
)

(instance snake4 of Actor
	(properties
		x 248
		y 40
		noun 7
		view 733
		loop 4
		cel 3
		signal 16384
	)

	(method (doVerb)
		(snake1 doVerb: &rest)
	)
)

(instance snake5 of Actor
	(properties
		x 271
		y 49
		noun 7
		view 733
		loop 4
		cel 3
		signal 16384
	)

	(method (doVerb)
		(snake1 doVerb: &rest)
	)
)

(instance snake6 of Actor
	(properties
		x 279
		y 49
		noun 7
		view 731
		loop 2
		signal 16384
	)

	(method (doVerb)
		(snake1 doVerb: &rest)
	)
)

(instance snake7 of Actor
	(properties
		x 280
		y 44
		noun 7
		view 731
		loop 2
		cel 2
		signal 16384
	)

	(method (doVerb)
		(snake1 doVerb: &rest)
	)
)

(instance oil of Actor
	(properties
		view 732
		loop 2
		priority 2
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 10 1 10) ; "There seems to be Snake Oil on the floor."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance oilBottle of Actor
	(properties
		view 732
		loop 3
		signal 16384
	)
)

(instance piece1 of View
	(properties
		x 37
		y 126
		view 731
		loop 3
		priority 1
		signal 16401
	)

	(method (onMe)
		(return 0)
	)
)

(instance piece2 of View
	(properties
		x 115
		y 74
		view 731
		loop 3
		cel 1
		priority 1
		signal 16401
	)

	(method (onMe)
		(return 0)
	)
)

(instance piece3 of View
	(properties
		x 207
		y 46
		view 731
		loop 3
		cel 2
		priority 1
		signal 16401
	)

	(method (onMe)
		(return 0)
	)
)

(instance floor of Feature
	(properties
		y 1
		noun 10
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(25 ; snakeOil
				(cond
					(local4 0)
					((> gMouseX (gEgo x:))
						(cond
							((== global150 0)
								(gEgo setScript: sThrowBottle)
							)
							((< (gEgo distanceTo: snake1) 65)
								(gCurRoom setScript: sRepelSnakes)
							)
							(else
								(gGame handsOff:)
								(gEgo setScript: sSprinkleOil)
							)
						)
					)
					(else
						(gMessager say: 10 25 8) ; "That wouldn't be the smartest thing you've done all day."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hieroglyphics of Feature
	(properties
		y 1
		noun 2
		onMeCheck 2
	)
)

(instance wall of Feature
	(properties
		y 1
		noun 6
		onMeCheck 16
	)
)

(instance sFX of Sound
	(properties
		flags 1
	)
)

