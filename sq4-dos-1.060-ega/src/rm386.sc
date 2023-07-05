;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 386)
(include sci.sh)
(use Main)
(use Interface)
(use mall)
(use rmnScript)
(use eRS)
(use n940)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use Window)
(use User)
(use Actor)
(use System)

(public
	rm386 0
)

(local
	local0
	local1
	[local2 22] = [268 99 246 130 86 129 61 105 61 90 110 61 118 32 127 16 162 5 206 27 214 66]
)

(instance rm386 of SQRoom
	(properties
		picture 386
		style 30
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
		(mouth init:)
		(arm init:)
		(gLongSong number: 0 stop:)
		(gLongSong2 vol: 127 changeState:)
		(thePig init:)
		(pigPoly points: @local2 size: 11)
		(theRoom init:)
		(self setScript: talkScript 0 0)
		(super init:)
		(self setRegions: 700) ; mall
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 387)
			(gLongSong2 fade:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance theRoom of Feature
	(properties
		x 160
		y 100
		nsBottom 200
		nsRight 320
		description {Monolith Burger interior}
		lookStr {This is just one of over 2.5 million Monolith Burger franchises scattered around the known universes.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(0
				(gCurRoom newRoom: 385)
			)
			(11 ; Smell
				(Print 386 0) ; "You smell that famous but unidentifiable Monolith Burger Secret Smell(tm)."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance thePig of Feature
	(properties
		x 160
		y 100
		description {pig}
		sightAngle 180
		lookStr {It's the gruff, unpersonable manager of this particular Monolith Burger franchise.}
	)

	(method (init)
		(super init:)
		(self onMeCheck: pigPoly)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Talk
				(if (not (gCurRoom script:))
					(HandsOff)
					(talkScript register: (+ (talkScript register:) 1))
					(gCurRoom setScript: talkScript)
				)
			)
			(3 ; Inventory
				(switch invItem
					(0 ; buckazoid
						(Print 386 1) ; "No, Roger, the idea is to earn money, not give it away!"
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(10 ; Taste
				(Print 386 2) ; "Maybe it's not wise to order a bacon burger..."
			)
			(11 ; Smell
				(Print 386 3) ; "Woof! This dude smells like a pig sty."
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

(instance arm of Prop
	(properties
		x 94
		y 134
		description {pig}
		sightAngle 180
		lookStr {It's the gruff, unpersonable manager of this particular Monolith Burger franchise.}
		view 386
		loop 2
		cel 1
		priority 2
		signal 2064
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Talk
				(if (not (gCurRoom script:))
					(HandsOff)
					(talkScript register: (+ (talkScript register:) 1))
					(gCurRoom setScript: talkScript)
				)
			)
			(3 ; Inventory
				(switch invItem
					(0 ; buckazoid
						(Print 386 1) ; "No, Roger, the idea is to earn money, not give it away!"
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(10 ; Taste
				(Print 386 2) ; "Maybe it's not wise to order a bacon burger..."
			)
			(11 ; Smell
				(Print 386 3) ; "Woof! This dude smells like a pig sty."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mouth of Prop
	(properties
		x 158
		y 63
		view 386
		loop 1
		priority 1
		signal 2064
	)
)

(instance talkScript of rmnScript
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
						(self
							save1:
								(proc0_12
									(if (== (gEgo view:) 373)
										{I would like to buy a Mommy burger, please.}
									else
										{"I'd like a..."}
									)
									67
									5
									150
									70
									310
									30
									1
									28
									global140
									29
									global129
								)
						)
						(= seconds 5)
					)
					(2
						(switch
							(PrintD
								{Would you like to apply for a job?}
								67
								100
								60
								101
								81
								{Here!? I'd rather not.}
								0
								101
								81
								{Yes! I'm hard up for cash!}
								1
							)
							(0
								(gCurRoom newRoom: 385)
							)
							(1
								(self
									save1:
										(proc0_12
											(if (== (gEgo view:) 373)
												{I can cook.}
											else
												{I want a job.}
											)
											67
											5
											150
											70
											310
											30
											1
											28
											global140
											29
											global129
										)
								)
								(= seconds 5)
							)
						)
					)
				)
			)
			(2
				(self restore:)
				(arm setCel: 0)
				(mouth setLoop: 0 posn: 155 39)
				(= cycles 5)
			)
			(3
				(switch register
					(0
						(self
							save1:
								(proc0_12
									(if (== (gEgo view:) 373)
										{"What can I do for ya, doll?"}
									else
										{"Yeah?"}
									)
									67
									5
									150
									70
									310
									30
									1
								)
						)
						(arm setCel: 2)
						(mouth init: setCycle: ForwardCounter 8 self)
					)
					(1
						(self
							save1:
								(proc0_12
									(if
										(and
											(IsFlag 70)
											(not
												(OneOf
													(gEgo view:)
													373
													374
												)
											)
										)
										{"Oh, you again, whatdaya want?"}
									else
										{"We're out of it. We're outta everything, including employees."}
									)
									67
									5
									150
									70
									310
									30
									1
								)
						)
						(arm setCel: 2)
						(mouth init: setCycle: ForwardCounter 8 self)
					)
					(2
						(if (and (>= global172 34) (!= (gEgo view:) 373))
							(self
								save1:
									(proc0_12
										{"I'm tired of firing ya, now scram!"}
										67
										5
										150
										70
										310
										30
										1
									)
							)
							(= seconds 3)
						else
							(self
								save1:
									(proc0_12
										(cond
											((== (gEgo view:) 373) {No can do, what with you bein' female and all.})
											((IsFlag 70) {"You would, huh? Well, this is the greatest oppor... aah, ya heard the pitch before, just don't screw up or I'll land ya on yer ear again, GOT IT?"})
											(else {"You would, huh? Well, this is the greatest opportunity you've ever had, kid. Benefits up the wazoo, and if ya stick wit' me a half an hour or so, I'll make ya my Assistant Manager. How wouldja like that?"})
										)
										67
										5
										150
										70
										310
										30
										1
									)
							)
						)
						(arm setCel: 2)
						(mouth init: setCycle: ForwardCounter 25 self)
					)
				)
			)
			(4
				(if (and (>= register 2) (>= global172 34))
					(gCurRoom newRoom: 385)
				else
					(= cycles 1)
				)
			)
			(5
				(self restore:)
				(mouth setCycle: 0)
				(arm setCel: 0)
				(mouth setLoop: 1 cel: 0 posn: 158 63)
				(if (== register 2)
					(self
						save1:
							(proc0_12
								(cond
									((== (gEgo view:) 373) {You male sexist pig!!})
									((IsFlag 70) {"Gee, thanks, what a swell boss!"})
									(else {"Gee, thanks."})
								)
								67
								5
								150
								70
								310
								30
								1
								28
								global140
								29
								global129
							)
					)
				)
				(= seconds 2)
			)
			(6
				(arm setCel: 1)
				(mouth setLoop: 1 cel: 0 posn: 158 63)
				(HandsOn)
				(User canControl: 0)
				(gNarrator disable: 0 2)
				(if (== register 2)
					(= seconds 3)
				else
					(self dispose:)
				)
			)
			(7
				(self restore:)
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
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 803)
				(= seconds 2)
			)
			(1
				(gNarrator curIcon: (gNarrator at: 2))
				(gGame setCursor: ((gNarrator curIcon:) cursor:))
				(gNarrator disable:)
				(= gSystemWindow BlackWindow)
				(BlackWindow color: global131 back: global129)
				(switch
					(PrintD
						{WARNING:\nTHE FOLLOWING SEQUENCE CONTAINS EXPLICIT ARCADE ACTION AND IS NOT RECOMMENDED FOR DIE-HARD ADVENTURE PLAYERS, THE ARCADE-SQUEAMISH, OR THOSE WITH POOR TO NON-EXISTENT MOTOR SKILLS.}
						101
						{ }
						101
						67
						60
						36
						101
						81
						{Let me at it! I love a challenge!}
						1
						101
						81
						{Please let me WIMP OUT.\n(But can I have the cash?)}
						0
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
							(Print 386 4) ; "Oh, by the way, you are about to be fired."
						else
							(Print 386 5) ; "Decided to WIMP out eh? Well, we decided not to give you the cash."
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
			(2
				(= gSystemWindow local1)
				(gNarrator enable:)
				(= cycles 2)
			)
			(3
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

(instance redStuff of Feature
	(properties
		x 306
		y 105
		nsTop 75
		nsLeft 294
		nsBottom 135
		nsRight 318
		description {ketchup}
		sightAngle 180
		lookStr {Mmmm! Famous Mono sauce!}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Taste
				(Print 386 6) ; "Sucking on a bottle of ketchup doesn't seem to satisfy your hunger no matter what the government thinks."
			)
			(11 ; Smell
				(Print 386 7) ; "Smells like a synthesized version of an ancient vegetable sauce."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance yellowStuff of Feature
	(properties
		x 282
		y 104
		nsTop 75
		nsLeft 272
		nsBottom 134
		nsRight 293
		description {mustard}
		sightAngle 180
		lookStr {Mmmm! Famous Mono sauce No. 2!}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Taste
				(Print 386 8) ; "Sucking on a bottle of mustard doesn't seem to satisfy your hunger."
			)
			(11 ; Smell
				(Print 386 9) ; "Smells like a synthesized version of an ancient sauce."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance microwave of Feature
	(properties
		x 24
		y 106
		nsTop 84
		nsBottom 128
		nsRight 49
		description {microwave}
		sightAngle 180
		lookStr {It's a microwave.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Do
				(Print 386 10) ; "The microwave quit a long time ago."
			)
			(11 ; Smell
				(Print 386 11) ; "It smells dusty."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bottomCigar of Feature
	(properties
		x 93
		y 150
		nsTop 93
		nsLeft 79
		nsBottom 110
		nsRight 108
		description {stogie}
		sightAngle 180
		lookStr {It's a cigar}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Do
				(Print 386 12) ; "Whatever would you want tho use that for?"
			)
			(11 ; Smell
				(Print 386 13) ; "Sniffing the cigar makes you lose what little appetite you had after smelling the air in this place."
			)
			(10 ; Taste
				(Print 386 14) ; "Yuck! You rapidly remove the ashes from your tongue."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

