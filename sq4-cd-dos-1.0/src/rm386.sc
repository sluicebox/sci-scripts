;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 386)
(include sci.sh)
(use Main)
(use mall)
(use eRS)
(use Sq4Dialog)
(use Sq4Narrator)
(use Sq4Feature)
(use Polygon)
(use Window)
(use System)

(public
	rm386 0
)

(local
	local0
	local1
	[local2 22] = [268 99 246 130 86 129 61 105 61 90 110 61 118 32 127 16 162 5 206 27 214 66]
)

(procedure (localproc_0 &tmp temp0 [temp1 100] [temp101 30] [temp131 30])
	(Message msgGET 386 24 0 1 1 @temp1) ; "Would you like to apply for a job?"
	(Message msgGET 386 97 0 1 1 @temp101) ; "Here!? I'd rather not."
	(Message msgGET 386 97 0 2 1 @temp131) ; "Yes! I'm hard up for cash!"
	(= temp0 (proc816_3 @temp1 64 100 100 109 78 @temp101 0 109 78 @temp131 1))
)

(instance rm386 of SQRoom
	(properties
		picture 386
		style 10
	)

	(method (init)
		(Load rsVIEW 386)
		(Load rsSOUND 4)
		(= local1 gSystemWindow)
		(HandsOff)
		(bottomCigar init:)
		(redStuff init:)
		(yellowStuff init:)
		(microwave init:)
		(theMouth init:)
		(arm init:)
		(gLongSong number: 0 stop:)
		(gLongSong2 vol: 127 changeState:)
		(thePig init:)
		(pigPoly points: @local2 size: 11)
		(theRoom init:)
		(self setScript: talkScript 0 0)
		(super init:)
		(self setRegions: 700) ; mall
		(gEgo setCycle: 0)
		(tPig init: 0 0 theMouth)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 387)
			(gLongSong2 fade:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance sJob of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(arm setCel: 0)
				(= seconds 2)
			)
			(1
				(theMouth setLoop: 0 posn: 155 39)
				(arm setCel: 2)
				(= seconds 1)
			)
			(2
				(theMouth setLoop: 0 posn: 155 39)
				(tPig ; "Would you like to apply for a job?"
					modNum: 386
					talkerNum: 24
					say: 1 self 2 64 5 150 67 310 27 1
				)
			)
			(3
				(switch (localproc_0)
					(0
						(gCurRoom newRoom: 385)
					)
					(1)
				)
				(= cycles 2)
			)
			(4
				(if (== (gEgo view:) 373)
					(tRogette say: 2 self) ; "I can cook."
				else
					(= cycles 2)
				)
			)
			(5
				(client setScript: 0)
			)
		)
	)
)

(instance theRoom of Sq4Feature
	(properties
		x 160
		y 100
		nsBottom 200
		nsRight 320
		lookStr 1 ; "This is just one of over 2.5 million Monolith Burger franchises scattered around the known universes."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; ???
				(gCurRoom newRoom: 385)
			)
			(6 ; Smell
				(proc816_1 386 0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance thePig of Sq4Feature
	(properties
		x 160
		y 100
		sightAngle 180
		lookStr 2 ; "It's the gruff, unpersonable manager of this particular Monolith Burger franchise."
	)

	(method (init)
		(super init:)
		(self onMeCheck: pigPoly)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 2) ; "It's the gruff, unpersonable manager of this particular Monolith Burger franchise."
			)
			(2 ; Talk
				(if (not (gCurRoom script:))
					(HandsOff)
					(talkScript register: (+ (talkScript register:) 1))
					(gCurRoom setScript: talkScript)
				)
			)
			(8 ; buckazoid
				(gNarrator say: 3) ; "No, Roger, the idea is to earn money, not give it away!"
			)
			(7 ; Taste
				(gNarrator say: 4) ; "Maybe it would be unwise to order a bacon burger..."
			)
			(6 ; Smell
				(gNarrator say: 5) ; "Woof! This dude smells like a pig sty."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pigPoly of Polygon
	(properties)
)

(instance arm of Sq4Prop
	(properties
		x 94
		y 134
		sightAngle 180
		view 386
		loop 2
		cel 1
		priority 2
		signal 2064
		lookStr 2 ; "It's the gruff, unpersonable manager of this particular Monolith Burger franchise."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 2) ; "It's the gruff, unpersonable manager of this particular Monolith Burger franchise."
			)
			(2 ; Talk
				(if (not (gCurRoom script:))
					(HandsOff)
					(talkScript register: (+ (talkScript register:) 1))
					(gCurRoom setScript: talkScript)
				)
			)
			(8 ; buckazoid
				(gNarrator say: 3) ; "No, Roger, the idea is to earn money, not give it away!"
			)
			(7 ; Taste
				(gNarrator say: 4) ; "Maybe it would be unwise to order a bacon burger..."
			)
			(6 ; Smell
				(gNarrator say: 5) ; "Woof! This dude smells like a pig sty."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theMouth of Sq4Prop
	(properties
		x 158
		y 63
		view 1386
		loop 1
		priority 1
		signal 2064
	)

	(method (doVerb)
		(arm doVerb:)
	)
)

(instance talkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: 0)
				(if register
					(= cycles 1)
				else
					(= seconds 1)
				)
			)
			(1
				(switch register
					(0
						(= cycles 1)
					)
					(1
						(if (== (gEgo view:) 373)
							(tRogette modNum: 388 say: 1 self) ; "I'd like a..."
						else
							(tRog modNum: 388 say: 1 self) ; "I'd like a..."
						)
					)
					(2
						(self setScript: sJob self)
					)
				)
			)
			(2
				(arm setCel: 0)
				(theMouth setLoop: 0 posn: 155 39)
				(= seconds 2)
			)
			(3
				(switch register
					(0
						(if (== (gEgo view:) 373)
							(tPig ; "What can I do for ya, doll?"
								modNum: 388
								say: 2 self 2 64 5 150 67 310 27 1
							)
						else
							(tPig say: 3 self 2 64 5 150 67 310 27 1) ; "Yeah?"
						)
						(arm setCel: 2)
					)
					(1
						(tPig
							modNum:
								(if
									(and
										(IsFlag 70)
										(not
											(OneOf (gEgo view:) 373 374)
										)
									)
									gCurRoomNum
								else
									388
								)
							say:
								(if
									(and
										(IsFlag 70)
										(not
											(OneOf (gEgo view:) 373 374)
										)
									)
									4
								else
									10
								)
								self
								2
								64
								5
								150
								67
								310
								27
								1
						)
						(arm setCel: 2)
					)
					(2
						(arm setCel: 2)
						(cond
							((and (>= global172 34) (!= (gEgo view:) 373))
								(tPig say: 6 self 2 64 5 150 67 310 27 1) ; "I'm tired of firing ya, now scram!"
							)
							((== (gEgo view:) 373)
								(tPig ; "No can do, what with you bein' female and all."
									modNum: 388
									say: 7 self 2 64 5 150 67 310 27 1
								)
							)
							((IsFlag 70)
								(tPig say: 8 self 2 64 5 150 67 310 27 1) ; "You would, huh? Well, this is the greatest oppor... aah, ya heard the pitch before, just don't screw up or I'll land ya on yer ear again, GOT IT?"
							)
							(else
								(tPig ; "You would, huh? Well, this is the greatest opportunity you've ever had, kid. Benefits up the wazoo, and if ya stick wit' me a half an hour or so, I'll make ya my Assistant Manager. How wouldja like that?"
									modNum: 388
									say: 9 self 2 64 5 150 67 310 27 1
								)
							)
						)
						(HandsOff)
						(cond
							((and (>= global172 34) (!= (gEgo view:) 373))
								(tPig say: 6 self 2 64 5 150 67 310 27 1) ; "I'm tired of firing ya, now scram!"
							)
							((== (gEgo view:) 373)
								(tPig ; "No can do, what with you bein' female and all."
									modNum: 388
									say: 7 self 2 64 5 150 67 310 27 1
								)
							)
							((IsFlag 70)
								(tPig say: 8 self 2 64 5 150 67 310 27 1) ; "You would, huh? Well, this is the greatest oppor... aah, ya heard the pitch before, just don't screw up or I'll land ya on yer ear again, GOT IT?"
							)
							(else
								(tPig say: 9 self 2 64 5 150 67 310 27 1)
							)
						)
						(arm setCel: 2)
					)
				)
			)
			(4
				(if
					(and
						(>= register 2)
						(>= global172 34)
						(!= (gEgo view:) 373)
					)
					(gCurRoom newRoom: 385)
				else
					(= cycles 2)
				)
			)
			((arm setCel: 0)
				(= cycles 5)
			)
			((arm setCel: 1)
				(= cycles 5)
			)
			(5
				(arm setCel: 0)
				(if (== register 2)
					(cond
						((== (gEgo view:) 373)
							(tRogette modNum: 388 say: 4 self) ; "You male sexist pig!!"
						)
						((IsFlag 70)
							(tRog say: 5 self) ; "Gee, thanks, what a swell boss!"
						)
						(else
							(tRog say: 6 self) ; "Gee, thanks."
						)
					)
				else
					(= seconds 2)
				)
			)
			(6
				(if (== register 2)
					(arm setCel: 0)
				)
				(theMouth setLoop: 1 cel: 0 posn: 158 63)
				(if (< register 2)
					(HandsOn)
					(gUser canControl: 0)
					(gTheIconBar disable: 0 2)
				)
				(if (== register 2)
					(= cycles 6)
				else
					(self dispose:)
				)
			)
			(7
				(arm setCel: 1)
				(if (== (gEgo view:) 373)
					(gCurRoom newRoom: 385)
				else
					(gCurRoom setScript: warningScript)
				)
			)
		)
	)
)

(instance warningScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 803)
				(= seconds 2)
			)
			(2
				(gTheIconBar curIcon: (gTheIconBar at: 2))
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
				(gTheIconBar disable:)
				(= gSystemWindow BlackWindow)
				(BlackWindow color: global131 back: global129)
				(switch
					(narratorWarning ; "WARNING: THE FOLLOWING SEQUENCE CONTAINS EXPLICIT ARCADE ACTION AND IS NOT RECOMMENDED FOR DIE-HARD ADVENTURE PLAYERS, THE ARCADE-SQUEAMISH, OR THOSE WITH POOR TO NON-EXISTENT MOTOR SKILLS."
						x: 60
						y: 36
						say: 6 0 0 64 (narratorWarning x:) (narratorWarning y:)
					)
					(0
						(if
							(and
								(< global172 34)
								(not (TestMallFlag (ScriptID 700 0) #rFlag3 4)) ; mall
								(not (IsFlag 29))
							)
							(gEgo get: 0) ; buckazoid
							(+= gBuckazoidCount (- 34 global172))
							(= global172 34)
							(mall rFlag4: (| (mall rFlag4:) $0001))
							(SetScore 52 -3)
							(gNarrator say: 7 self) ; "Oh, by the way, you are about to be fired."
						else
							(gNarrator say: 8 self) ; "Decided to WIMP out eh? Well, we decided not to give you the cash."
						)
						(= cycles 1)
					)
					(1
						(= local0 1)
						(SetScore 51 3)
						(= cycles 1)
					)
				)
			)
			(3
				(= gSystemWindow local1)
				(gTheIconBar enable:)
				(= cycles 2)
			)
			(4
				(if local0
					(gCurRoom newRoom: 387)
				else
					(gCurRoom newRoom: 385)
				)
			)
		)
	)
)

(instance BlackWindow of SysWindow
	(properties)
)

(instance redStuff of Sq4Feature
	(properties
		x 306
		y 105
		nsTop 75
		nsLeft 294
		nsBottom 135
		nsRight 318
		sightAngle 180
		lookStr 9 ; "Mmmm! Famous Mono sauce!"
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Taste
				(gNarrator say: 10) ; "Sucking on a bottle of ketchup doesn't seem to satisfy your hunger no matter what the government thinks."
			)
			(6 ; Smell
				(gNarrator say: 11) ; "Smells like a synthesized version of an ancient vegetable sauce."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance yellowStuff of Sq4Feature
	(properties
		x 282
		y 104
		nsTop 75
		nsLeft 272
		nsBottom 134
		nsRight 293
		sightAngle 180
		lookStr 12 ; "Mmmm! Famous Mono sauce No. 2!"
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Taste
				(gNarrator say: 13) ; "Sucking on a bottle of mustard doesn't seem to satisfy your hunger."
			)
			(6 ; Smell
				(gNarrator say: 11) ; "Smells like a synthesized version of an ancient vegetable sauce."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance microwave of Sq4Feature
	(properties
		x 24
		y 106
		nsTop 84
		nsBottom 128
		nsRight 49
		sightAngle 180
		lookStr 14 ; "It's a microwave."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gNarrator say: 15) ; "The microwave quit a long time ago."
			)
			(6 ; Smell
				(gNarrator say: 16) ; "It smells dusty."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bottomCigar of Sq4Feature
	(properties
		x 93
		y 150
		nsTop 93
		nsLeft 79
		nsBottom 110
		nsRight 108
		sightAngle 180
		lookStr 14 ; "It's a microwave."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1) ; Look
			(4 ; Do
				(gNarrator say: 17) ; "Whatever would you want to use that for?"
			)
			(6 ; Smell
				(gNarrator say: 18) ; "Sniffing the cigar makes you lose what little appetite you had after smelling the air in this place."
			)
			(7 ; Taste
				(if (== (gEgo view:) 373)
					(tRogette say: 7) ; "Yuck! Plllllap! Chhhhhhuh! (Assorted comical spitting-out-the-ashes sounds)"
				else
					(tRog say: 7) ; "Yuck! Plllllap! Chhhhhhuh! (Assorted comical spitting-out-the-ashes sounds)"
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance narratorWarning of Sq4Narrator
	(properties
		noun 99
		modNum 386
		modeless 1
		nMsgType 3
	)

	(method (say param1 &tmp temp0 [temp1 100] [temp101 30] [temp131 30])
		(super say: param1 &rest)
		(Message msgGET 386 99 0 param1 1 @temp1)
		(Message msgGET 386 97 0 3 1 @temp101) ; "Let me at it! I love a challenge!"
		(Message msgGET 386 97 0 4 1 @temp131) ; "Please let me WIMP OUT.  (But can I have the cash?)"
		(= temp0 (proc816_3 @temp1 109 64 x y 109 78 @temp101 1 109 78 @temp131 0))
		(self dispose:)
		(return temp0)
	)

	(method (display))

	(method (dispose &tmp temp0)
		(if returnVal
			(proc0_12 returnVal)
		)
		(super dispose: &rest)
	)
)

(instance tPig of FaceTalker
	(properties
		noun 24
		modNum 386
		talkerNum 24
		tpType 2
	)
)

(instance tRog of Sq4Talker
	(properties
		z 400
		noun 7
		view 1008
		talkerNum 7
		mouthOffsetX 21
		mouthOffsetY 32
		eyeOffsetX 27
		eyeOffsetY 21
	)
)

(instance tRogette of Sq4Talker
	(properties
		z 400
		noun 7
		view 1009
		talkerNum 7
		mouthOffsetX 21
		mouthOffsetY 32
		eyeOffsetX 26
		eyeOffsetY 21
	)
)

