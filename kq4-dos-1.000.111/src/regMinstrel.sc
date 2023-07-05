;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 516)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	regMinstrel 0
	notes 1
)

(synonyms
	(man man man man boy person bard)
	(kiss kiss embrace)
)

(local
	local0
	local1
)

(instance thisSong of Sound
	(properties)
)

(instance notes of Prop
	(properties)

	(method (cue)
		(notes dispose:)
	)
)

(instance regMinstrel of Rgn
	(properties)

	(method (init)
		(Load rsVIEW 171)
		(Load rsVIEW 681)
		(super init:)
		(if
			(or
				(and (== gCurRoomNum 13) (== gMinstrelRoom 1))
				(and (== gCurRoomNum 14) (== gMinstrelRoom 2))
				(and (== gCurRoomNum 19) (== gMinstrelRoom 3))
			)
			(gMinstrelActor setScript: minstrelActions)
			(notes
				view: 888
				ignoreActors:
				cycleSpeed: 1
				setCycle: Fwd
				posn: (+ (gMinstrelActor x:) 16) (- (gMinstrelActor y:) 20)
				init:
			)
			(thisSong number: 19 play: minstrelActions)
			(minstrelActions changeState: 1)
		)
		(= global189 1)
	)

	(method (dispose)
		(gSounds eachElementDo: #dispose)
		((ScriptID 0 4) dispose: delete:) ; timer1
		((ScriptID 0 5) dispose: delete:) ; timer2
		((ScriptID 0 6) dispose: delete:) ; timer3
		(= global189 0)
		(thisSong dispose:)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0)
		(super handleEvent: event)
		(if (event claimed:)
			(return 1)
		)
		(if (and (== (event type:) evSAID) (gCast contains: gMinstrelActor))
			(cond
				((Said 'get/man')
					(Print 516 0) ; "You couldn't get the minstrel."
				)
				((Said 'kiss')
					(Print 516 1) ; "That could get you in more trouble than it's worth!"
				)
				((Said 'give>')
					(cond
						((and ((Inv at: 18) ownedBy: gEgo) (Said '/book')) ; Shakespeare_Book
							(if (>= (gEgo distanceTo: gMinstrelActor) 20)
								(Print 516 2) ; "You're not close enough."
							else
								(gSounds eachElementDo: #dispose)
								(Print 516 3) ; "You hand the Shakespeare book to the minstrel. Curiously, he opens it and begins to read aloud; first hesitantly, then with increased forcefulness as he begins to get into it."
								(Print 516 4) ; "Suddenly, he stops and looks at you. "This is wonderful!" he exclaims. "This gives me a new lease on life! No longer am I a mere minstrel...now I will become a famous ACTOR! `TO BE OR NOT TO BE.' How's that?" He then gives you his lute, bids you farewell, and wanders off to stardom."
								((Inv at: 18) moveTo: 203) ; Shakespeare_Book
								(= global182 1)
								((Inv at: 9) moveTo: gEgo) ; Lute
								(gGame changeScore: 3)
								(minstrelActions changeState: 10)
							)
						)
						(
							(and
								(= temp0 (gInventory saidMe:))
								(gEgo has: (gInventory indexOf: temp0))
							)
							(Print 516 5) ; "The minstrel looks at your offering with mild interest, but politely declines."
						)
						(else
							(event claimed: 0)
						)
					)
				)
				((Said 'rob/lute')
					(Print 516 6) ; "You are not a thief, Rosella!"
				)
				((Said 'look/man')
					(if ((Inv at: 18) ownedBy: 203) ; Shakespeare_Book
						(if (gCast contains: gMinstrelActor)
							(Print 516 7) ; "Well, it looks like our minstrel has turned into a Thespian. He seems much happier now."
						else
							(Print 516 8) ; "I don't see him here."
						)
					else
						(Print 516 9) ; "You see a rather jaunty-looking fellow who appears to be a wandering minstrel. He seems to be a lute player."
					)
				)
				((Said 'talk[/man]')
					(cond
						(((Inv at: 9) ownedBy: 203) ; Lute
							(++ global184)
							(gSounds eachElementDo: #dispose)
							(if (> global184 4)
								(= local1 (Random 2 4))
							else
								(= local1 global184)
							)
							(switch local1
								(1
									(Print 516 10) ; "You say hello to the minstrel who looks at you in surprise. "Well, well. Who do we have here?" he asks. You introduce yourself as Rosella. "Hello, Rosella," the minstrel says. "Let me play for you one of my favorite tunes," and he begins to play an old ballad."
									(Print 516 11) ; "Unfortunately, it appears that his musical skills are quite limited, as he plunks and pings his way through an otherwise, beautiful song."
									(thisSong number: 17 play: minstrelActions)
								)
								(2
									(Print 516 12) ; "You unthinkingly speak to the minstrel again, who immediately begins playing another bad rendition of a favorite "oldie, but goodie.""
									(thisSong number: 16 play: minstrelActions)
								)
								(3
									(Print 516 13) ; "The minstrel seems quite pleased that you appreciate his music so much. He obviously loves the attention as he goes into an out-of-tune version of "Greensleeves.""
									(thisSong number: 15 play: minstrelActions)
								)
								(4
									(Print 516 14) ; "You can't get enough, can you, Rosella? This guy obviously loves an audience as he takes you through another "popular ballad.""
									(thisSong number: 18 play: minstrelActions)
								)
							)
							(minstrelActions changeState: 1)
						)
						((gCast contains: gMinstrelActor)
							(Print 516 15) ; "You say good-bye to the ex-minstrel, but he doesn't respond as he's too engrossed in his Shakespearean soliloquy."
						)
						(else
							(event claimed: 0)
						)
					)
				)
				((Said 'get/lute')
					(if ((Inv at: 9) ownedBy: 203) ; Lute
						(Print 516 16) ; "The minstrel is not going to give you his sole means of livelihood!"
					else
						(Print 516 17) ; "You already have it."
					)
				)
				((Said 'hum/')
					(Print 516 18) ; "Your lilting voice contrasts terribly with the bad lute playing of the minstrel."
				)
			)
		)
	)
)

(instance minstrelActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(notes show: setPri: (gMinstrelActor priority:))
				(gMinstrelActor cycleSpeed: 1 setCycle: Fwd)
			)
			(2
				(gMinstrelActor setCycle: 0 cel: 0)
				(notes hide:)
			)
			(10
				(notes hide:)
				(gMinstrelActor view: 173 cel: 0 loop: 0 cycleSpeed: 2 setCycle: Fwd)
				(= gMinstrelRoom -1)
				((ScriptID 0 6) setReal: self 4) ; timer3
			)
			(11
				(gMinstrelActor
					view: 171
					cel: 0
					loop: 2
					xStep: 2
					cycleSpeed: 0
					yStep: 1
					setAvoider: Avoid
					setCycle: Walk
				)
				(switch gCurRoomNum
					(13
						(gMinstrelActor setMotion: MoveTo 329 125 self)
					)
					(14
						(gMinstrelActor setMotion: MoveTo 329 136 self)
					)
					(19
						(gMinstrelActor setMotion: MoveTo 329 125 self)
					)
				)
			)
			(12
				(gMinstrelActor setScript: 0)
				(gMinstrelActor dispose:)
			)
		)
	)
)

