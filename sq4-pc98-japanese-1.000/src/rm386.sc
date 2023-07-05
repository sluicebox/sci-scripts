;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 386)
(include sci.sh)
(use Main)
(use Interface)
(use mall)
(use rmnScript)
(use eRS)
(use Language)
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
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 386 0) ; "This is just one of over 2.5 million Monolith Burger franchises scattered around the known universes."
			)
			(1 ; Walk
				(gCurRoom newRoom: 385)
			)
			(11 ; Smell
				(Print 386 1) ; "You smell that famous but unidentifiable Monolith Burger Secret Smell(tm)."
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
	)

	(method (init)
		(super init:)
		(self onMeCheck: pigPoly)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 386 2) ; "It's the gruff, unpersonable manager of this particular Monolith Burger franchise."
			)
			(5 ; Talk
				(if (not (gCurRoom script:))
					(HandsOff)
					(talkScript register: (+ (talkScript register:) 1))
					(gCurRoom setScript: talkScript)
				)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; buckazoid
						(Print 386 3) ; "No, Roger, the idea is to earn money, not give it away!"
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(10 ; Taste
				(Print 386 4) ; "Maybe it's not wise to order a bacon burger..."
			)
			(11 ; Smell
				(Print 386 5) ; "Woof! This dude smells like a pig sty."
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
		view 386
		loop 2
		cel 1
		priority 2
		signal 2064
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 386 2) ; "It's the gruff, unpersonable manager of this particular Monolith Burger franchise."
			)
			(5 ; Talk
				(if (not (gCurRoom script:))
					(HandsOff)
					(talkScript register: (+ (talkScript register:) 1))
					(gCurRoom setScript: talkScript)
				)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; buckazoid
						(Print 386 3) ; "No, Roger, the idea is to earn money, not give it away!"
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(10 ; Taste
				(Print 386 4) ; "Maybe it's not wise to order a bacon burger..."
			)
			(11 ; Smell
				(Print 386 5) ; "Woof! This dude smells like a pig sty."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theMouth of Prop
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
										{"I would like to buy a Mommy burger, please."#j\a2\cf\d0\b0\ca\de\b0\b6\de\b0\86\eb\e4\e2\98\e0\de\9b\92\a1\a3}
									else
										{"I'd like a..."#j\a2\94\94\8f\e4\a5\a5\a5\a5\a5\a5\a1\a3}
									)
									67
									5
									150
									70
									310
									30
									1
									28
									global137
									29
									global129
								)
						)
						(= seconds 5)
					)
					(2
						(switch
							(PrintD
								{"Would you like to apply for a job?"}
								67
								100
								60
								106
								81
								{Here!? I'd rather not.#j\9a\9a\e3\de\ff\fe \ea\e0\f7\97\e0\98\e5\92\e5\a1}
								0
								106
								81
								{Yes! I'm hard up for cash!#j\ea\92\a4\95\96\e8\96\de \e5\98\e3 \9a\ef\8f\e3\f9\fd\e3\de\9d\a1}
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
												{"I can cook."#j\a2\f8\8e\93\f8\96\de\a0 \e3\de\97\ef\9d\a1\a3}
											else
												{"I want a job."#j\a2\9c\9a\de\e4\96\de\a0 \ee\9c\92\fd\e3\de\9d\a1\a3}
											)
											67
											5
											150
											70
											310
											30
											1
											28
											global137
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
				(theMouth setLoop: 0 posn: 155 39)
				(= cycles 5)
			)
			(3
				(switch register
					(0
						(self
							save1:
								(proc0_12
									(if (== (gEgo view:) 373)
										{"What can I do for ya, doll?"#j\a2\e5\e6\96\de\ee\9c\92\fd\e0\de\92\fe\a3}
									else
										{"Yeah?"#j\a2\e5\fd\96 \f6\93\96\fe\a3}
									)
									67
									5
									(LangSwitch 150 140)
									70
									310
									30
									1
								)
						)
						(arm setCel: 2)
						(theMouth init: setCycle: ForwardCounter 8 self)
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
										{"Oh, you again, whatdaya want?"#j\a2\ec\f1\a4\ef\e0\95\ef\94\96\a1 \92\8f\e0\92\e5\e6\96\de\ee\9c\92\fd\e0\de\fe\a3}
									else
										{"We're out of it. We're outta everything, including employees."#j\a2\f0\fd\e5 \9c\e5\97\de\fa \e0\de\f6\a1\b1\d9\ca\de\b2\c4\f3 \e0\de\fa\f3\92\e5\92\fd\e0\de\ff\a3}
									)
									67
									5
									(LangSwitch 150 140)
									70
									310
									30
									1
								)
						)
						(arm setCel: 2)
						(theMouth init: setCycle: ForwardCounter 15 self)
					)
					(2
						(if (and (>= global172 34) (!= (gEgo view:) 373))
							(self
								save1:
									(proc0_12
										{"I'm tired of firing ya, now scram!"#j\a2\95\ef\94\86\b8\cb\de\e6\9d\f9\e9\e6\f3\93\e2\96\fa\e0\a1\f3\93\e3\de\e3\92\99\ff\a3}
										67
										5
										(LangSwitch 150 140)
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
											((== (gEgo view:) 373) {"No can do, what with you bein' female and all."#j\a2\c0\de\d2\e0\de\ff\a0 \9c\de\8e\9e\92\e0\de\96\f7\8f\e3\a4\a0 \f5\93\98\de\93\ea\e3\de\97\e5\92\fd\e3\de\e8\a1\a3})
											((IsFlag 70) {"You would, huh? Well, this is the greatest oppor... aah, ya heard the pitch before, just don't screw up or I'll land ya on yer ear again, GOT IT?"#j\a2\9f\93\96\92\fe\a0 \9a\fa\ea\a4\95\ef\94\e6\e4\8f\e3 \9b\92\a5\a5\a5\a5 \a1 \n\92\f4\a4\9f\e9\a4\f3\93\92\92\e0\92\9a\e4\ea \fc\96\8f\e3\f9\e0\de\fb\93\a1 \n\e0\e0\de \9c\8f\ea\df\92\9c\e5\92\f6\93\e6\e5\a1 \9a\fd\e4\de\ef\e0\a4\9c\8f\ea\df\92\9c\e0\f7\a4 \n\91\e0\ef\86\9c\de\f2\fd\e6\95\9c\e2\99\e3\f4\f9\96\f7\e5\a1\fc\96\8f\e0\96\fe\a3})
											(else {"You would, huh? Well, this is the greatest opportunity you've ever had, kid. Benefits up the wazoo, and if ya stick wit' me a half an hour or so, I'll make ya my Assistant Manager. How wouldja like that?"#j\a2\9f\93\96\92\fe\a0 \9a\fa\ea\a4\95\ef\94\e6\e4\8f\e3 \9b\92\9a\93\e9\c1\ac\dd\bd\e0\de\9e\de\a1\a0 \n\e0\92\98\de\93\ea\e4\8f\e3\f3\92\92\9c\a4\f3\9c30\ec\df\fd\92\9c\de\8e\93\n\96\de\fd\ea\de\fa\ea\de\a4\95\ef\94\86\b1\bc\bd\c0\dd\c4\cf\c8\b0\bc\de\ac\b0\e6 \9c\e3\f4\f9\f6\a1\n\e4\de\93\e0\de\92\fe\a3})
										)
										67
										5
										(LangSwitch 150 140)
										70
										310
										30
										1
									)
							)
						)
						(arm setCel: 2)
						(theMouth init: setCycle: ForwardCounter 35 self)
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
				(theMouth setCycle: 0)
				(arm setCel: 0)
				(theMouth setLoop: 1 cel: 0 posn: 158 63)
				(if (== register 2)
					(self
						save1:
							(proc0_12
								(cond
									((== (gEgo view:) 373) {"You male sexist pig!!"#j\a2\e0\de\fd\9f\fd \9c\de\8e\eb\e9\cc\de\c0\ff\ff\a3})
									((IsFlag 70) {"Gee, thanks, what a swell boss!"#j\a2\fc\87\ff\a0 \91\f8\96\de\e4\93\a1 \e5\fd\e3\92\92\ce\de\bd\e5\fd\e0\de\ff\a3})
									(else {"Gee, thanks."#j\a2\fc\87\ff\a0 \91\f8\96\de\e4\93\a1\a3})
								)
								67
								5
								150
								70
								310
								30
								1
								28
								global137
								29
								global129
							)
					)
				)
				(= seconds 2)
			)
			(6
				(arm setCel: 1)
				(theMouth setLoop: 1 cel: 0 posn: 158 63)
				(HandsOn)
				(User canControl: 0)
				(gTheIconBar disable: 0 2)
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
				(gTheIconBar curIcon: (gTheIconBar at: 2))
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
				(gTheIconBar disable:)
				(= gSystemWindow BlackWindow)
				(BlackWindow color: global132 back: global129)
				(switch
					(PrintD
						{WARNING:\nTHE FOLLOWING SEQUENCE CONTAINS EXPLICIT ARCADE ACTION AND IS NOT RECOMMENDED FOR DIE-HARD ADVENTURE PLAYERS, THE ARCADE-SQUEAMISH, OR THOSE WITH POOR TO NON-EXISTENT MOTOR SKILLS.}
						106
						{ }
						106
						67
						60
						36
						106
						81
						{Let me at it! I love a challenge!#j\f4\f7\9e\e3\98\fa\ff\a0 \c1\ac\da\dd\bc\de\96\de\9d\97\e5\fd\e0\de\ff}
						1
						106
						81
						{Please let me WIMP OUT.\n(But can I have the cash?)#j\f4\f2\9b\9e\e3\98\e0\de\9b\92\a1\n(\e3\de\f3 \97\8d\93\f8\8e\93\ea \98\fa\ef\9e\fd\96\fe)}
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
							(Print 386 6) ; "Oh, by the way, you are about to be fired."
						else
							(Print 386 7) ; "Decided to WIMP out eh? Well, we decided not to give you the cash."
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
				(gTheIconBar enable:)
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
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 386 8) ; "Mmmm! Famous Mono sauce!"
			)
			(10 ; Taste
				(Print 386 9) ; "Sucking on a bottle of ketchup doesn't seem to satisfy your hunger no matter what the government thinks."
			)
			(11 ; Smell
				(Print 386 10) ; "Smells like a synthesized version of an ancient vegetable sauce."
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
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 386 11) ; "Mmmm! Famous Mono sauce No. 2!"
			)
			(10 ; Taste
				(Print 386 12) ; "Sucking on a bottle of mustard doesn't seem to satisfy your hunger."
			)
			(11 ; Smell
				(Print 386 13) ; "Smells like a synthesized version of an ancient sauce."
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
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 386 14) ; "It's a microwave."
			)
			(3 ; Do
				(Print 386 15) ; "The microwave quit a long time ago."
			)
			(11 ; Smell
				(Print 386 16) ; "It smells dusty."
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
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 386 17) ; "It's a cigar"
			)
			(3 ; Do
				(Print 386 18) ; "Whatever would you want to use that for?"
			)
			(11 ; Smell
				(Print 386 19) ; "Sniffing the cigar makes you lose what little appetite you had after smelling the air in this place."
			)
			(10 ; Taste
				(Print 386 20) ; "Yuck! You rapidly remove the ashes from your tongue."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

