;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 199)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use TopWindow)
(use TargActor)
(use Interface)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm199 0
)

(local
	honorGain
	morning
	evening
	askCount
	zapCount
	returnCode
	noMore4Now
	[tmpName 20]
	bits = -130
	sponsor
	numSponsors = 7
	sponsorOK
	[sponsorList 8] = [{rakeesh} {omar} {keapon} {laffin} {WIT} {Wizards Institute} {Institute of Technocery} {erasmus}]
)

(procedure (AzizaPrint &tmp aT aR aL)
	(= aR (BotWindow brRight:))
	(= aL (BotWindow brLeft:))
	(BotWindow color: 13 back: 0)
	(Print
		&rest
		#font
		gUserFont
		#title
		{Woman's Voice:}
		#window
		BotWindow
		#width
		(- aR (+ aL 16))
	)
)

(instance rm199 of Rm
	(properties
		picture 700
		style 15
		vanishingY 50
	)

	(method (init &tmp [str 20])
		(LoadMany rsVIEW 0 6 183 702)
		(= morning (< gTimeODay 2))
		(= evening (OneOf gTimeODay 4 5))
		(= gNow (+ (* gDay 100) gTimeODay))
		(super init: &rest)
		(InitAddToPics backWall)
		(gEgo init: illegalBits: bits)
		(door cel: (if (and (== gPrevRoomNum 180) (< gAzizaTemper 3)) 3 else 0) init:)
		(if (and (== gAzizaTemper 3) (== gPrevRoomNum 180))
			(self setScript: zapScript)
		else
			(self setScript: enterS)
		)
		(SetFlag 130) ; f199
		(= gSpellChecker gAllChecker)
	)

	(method (doit)
		(if (and (>= (gEgo y:) 188) (not script))
			(= gRoomExitDir 2)
			(self setScript: exitS)
		)
		(super doit:)
	)

	(method (dispose)
		(= gEnchAlleyLast gNow)
		(= gRoomExitDir 1)
		(super dispose:)
	)

	(method (handleEvent event &tmp spellNum)
		(cond
			((super handleEvent: event))
			((Said 'open,open/door')
				(gCurRoom setScript: openScript)
			)
			((Said 'knock[/door]')
				(gCurRoom setScript: knockScript)
			)
			(
				(or
					(Said 'lockpick[/lock]')
					(Said 'use/(lockpick[<lock]),lockpick')
					(Said 'unlock')
				)
				(if (or (gEgo has: 10) (gEgo has: 11)) ; LockPick, ThiefKit
					(gCurRoom setScript: zapScript)
				else
					(HighPrint 199 0) ; "You don't have the equipment to do that."
				)
			)
		)
	)
)

(instance enterS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== gPrevRoomNum 180)
					(door setCycle: Beg)
					(gEgo posn: 160 90 setMotion: MoveTo 160 110 self)
				else
					(gEgo posn: 158 200 setMotion: MoveTo 160 179 self)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance exitS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 160 220 self)
			)
			(1
				(gCurRoom newRoom: 704) ; alleyRoom
			)
		)
	)
)

(instance doorScript of Script
	(properties)

	(method (doit)
		(if (and (not state) (not (gEgo script:)))
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState &tmp theY)
		(switch (= state newState)
			(1
				(= theY (if (== client zapScript) 105 else 85))
				(if (not (< (gEgo y:) 101))
					(gEgo setMotion: MoveTo 158 theY self)
				else
					(self cue:)
				)
			)
			(2
				(gEgo loop: 3)
				(= cycles 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance openScript of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: doorScript self)
			)
			(1
				(HighPrint 199 1) ; "The door is locked."
				(self dispose:)
			)
		)
	)
)

(instance knockScript of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: doorScript self)
			)
			(1
				(cond
					(
						(or
							noMore4Now
							(and (== gEnchAlleyLast gNow) gAzizaTemper)
							(IsFlag 182) ; fAzizaSaurus
						)
						(HighPrint 199 2) ; "There is no response."
						(self changeState: 2)
					)
					((== gDay 16)
						(SetFlag 182) ; fAzizaSaurus
						(gCurRoom setScript: goInside)
					)
					((and (IsFlag 40) (not (== gAzizaTemper 3))) ; fAzizaOnce
						(AzizaPrint (Format @tmpName 199 3 @gUserName)) ; "Welcome, %s"
						(gCurRoom setScript: goInside)
					)
					(else
						(gCurRoom setScript: azizaTest)
					)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance azizaTest of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= tmpName 0)
				(= askCount 0)
				(if (< 0 gAzizaTemper 3)
					(= returnCode (AzizaPrint 199 4 41 @tmpName 41)) ; "Perhaps you have learned some manners since the last time you came calling. That would be better. Who are you that now seeks entrance to my house?"
					(= gAzizaTemper 0)
				else
					(= returnCode (AzizaPrint 199 5 41 @tmpName 41)) ; "Who is it that seeks to enter?"
				)
				(= cycles 1)
			)
			(1
				(cond
					((StrFind @tmpName @gUserName)
						(TrySkill 13 100) ; communication
						(self changeState: 3)
					)
					((or (== askCount 1) (== returnCode 0))
						(AzizaPrint 199 6) ; "Perhaps you should return when you have learned your name and some manners."
						(= noMore4Now 1)
						(++ gAzizaTemper)
						(self changeState: 5)
					)
					(else
						(= tmpName 0)
						(++ askCount)
						(AzizaPrint 199 7 41 @tmpName 41) ; "You have not answered my question. Who are you that knocks upon my door?"
						(self changeState: 1)
					)
				)
			)
			(3
				(= tmpName 0)
				(AzizaPrint 199 8 41 @tmpName 41) ; "Who is it that sent you here?"
				(for ((= sponsor 0)) (<= sponsor numSponsors) ((++ sponsor))
					(if (StrFind @tmpName [sponsorList sponsor])
						(break)
					)
				)
				(if (== sponsor 3)
					(= sponsor 2)
				)
				(if (OneOf sponsor 5 6)
					(= sponsor 4)
				)
				(= tmpName 0)
				(switch sponsor
					(0
						(AzizaPrint 199 9 41 @tmpName 41) ; "How did the leg of Rakeesh get injured?"
						(= sponsorOK
							(or
								(StrFind @tmpName {demon})
								(StrFind @tmpName {wizard})
							)
						)
					)
					(1
						(AzizaPrint 199 10 41 @tmpName 41) ; "What is Ja'afar's most crucial role for Omar?"
						(= sponsorOK (StrFind @tmpName {friend}))
					)
					(2
						(AzizaPrint 199 11 41 @tmpName 41) ; "What is the Element most appropriate to the owner of the Magic Shop?"
						(= sponsorOK (StrFind @tmpName {air}))
					)
					(4
						(AzizaPrint 199 12 41 @tmpName 41) ; "Which of the elements do the Wizards of WIT command?"
						(= sponsorOK
							(or
								(and
									(StrFind @tmpName {earth})
									(StrFind @tmpName {air})
									(StrFind @tmpName {fire})
									(StrFind @tmpName {water})
								)
								(StrFind @tmpName {all})
							)
						)
					)
					(7
						(AzizaPrint 199 13 41 @tmpName 41) ; "What is the companion of Erasmus?"
						(= sponsorOK
							(or
								(StrFind @tmpName {rat})
								(StrFind @tmpName {fenrus})
								(StrFind @tmpName {mouse})
							)
						)
					)
					(8
						(AzizaPrint 199 14) ; "Perhaps you should learn more about who sent you before you seek me."
						(= noMore4Now 1)
						(self changeState: 5)
					)
				)
				(if (not sponsorOK)
					(AzizaPrint 199 15) ; "I do not see strangers who come unbidden."
					(= noMore4Now 1)
					(self changeState: 5)
				else
					(self cue:)
				)
			)
			(4
				(= tmpName 0)
				(BotWindow brRight: 150)
				(AzizaPrint 199 16 41 @tmpName 15) ; "My first is the first, My second the last, Next comes Myself, Then back to the end, And beginning again. Who am I?"
				(BotWindow brRight: 320)
				(if (not (StrFind @tmpName {aziza}))
					(AzizaPrint 199 17) ; "If you know not whom you seek, you will surely not find that person here."
					(= noMore4Now 1)
					(self cue:)
				else
					(AzizaPrint (Format @tmpName 199 18 @gUserName)) ; "You may enter freely into my home, %s."
					(gCurRoom setScript: goInside)
				)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance goInside of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(door setCycle: End self)
			)
			(1
				(gEgo setMotion: MoveTo 158 80 self)
			)
			(2
				(SetFlag 40) ; fAzizaOnce
				(gCurRoom newRoom: 180)
			)
		)
	)
)

(instance zapScript of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (and (== gAzizaTemper 3) (== gPrevRoomNum 180)))
					(self setScript: doorScript self)
				else
					(self cue:)
				)
			)
			(1
				(if (and (== gAzizaTemper 3) (== gPrevRoomNum 180))
					(gEgo posn: 158 95 loop: 3 init: hide:)
				)
				(if zapCount
					(= cycles 1)
				else
					(sparkle
						init:
						posn: (gEgo x:) (gEgo y:)
						setCycle: CT 3 1 self
					)
				)
			)
			(2
				(if zapCount
					(self cue:)
				else
					(sparkle setCycle: End self)
				)
				(if (and (== gAzizaTemper 3) (== gPrevRoomNum 180))
					(gEgo show:)
				)
			)
			(3
				(if (not zapCount)
					(SkillUsed 14 -200) ; honor
					(if (and (== gAzizaTemper 3) (== gPrevRoomNum 180))
						(AzizaPrint 199 19) ; "I do not welcome those who are rude in my house."
					else
						(HighPrint 199 20) ; "You find that you cannot move."
						(AzizaPrint 199 21) ; "I do not welcome those who try to force their entrance into my house."
					)
					(++ gAzizaTemper)
				)
				(= [gEgoStats 17] 0) ; stamina
				(sparkle
					show:
					posn: (gEgo x:) (gEgo y:)
					setCycle: CT 3 1 self
				)
			)
			(4
				(sparkle setCycle: End)
				(gEgo view: 22 loop: 0 setCycle: End self)
				(if (< (gEgo y:) 85)
					(gEgo setMotion: MoveTo (gEgo x:) 85)
				)
			)
			(5
				(if zapCount
					(self changeState: 9)
				else
					(= cycles 10)
				)
			)
			(6
				(sparkle hide:)
				(gEgo loop: 1 cel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(7
				(NormalEgo)
				(gEgo illegalBits: bits)
				(++ zapCount)
				(= cycles 2)
			)
			(8
				(HighPrint 199 22) ; "That was exhausting. You don't think you'd survive going through that again."
				(if (and (== gAzizaTemper 3) (== gPrevRoomNum 180))
					(HighPrint 199 23) ; "It is best not to anger a powerful Magic User."
				)
				(self changeState: 10)
			)
			(9
				(HighPrint 199 24) ; "Persistence pays off, but this certainly isn't the payoff you had in mind!"
				(EgoDead 0 199 25 #title {It's taps for a zapped sap...} #icon 6 3 0) ; "Next time use your head... or maybe your knuckles!"
			)
			(10
				(self dispose:)
			)
		)
	)
)

(instance backWall of PicView
	(properties
		x 159
		y 79
		view 702
		cel 3
	)
)

(instance door of TargActor
	(properties
		x 173
		y 78
		noun '[/door]'
		description {door}
		lookStr {The door seems to be watching you.}
		view 702
		loop 1
		illegalBits 0
	)

	(method (detectMe)
		(HighPrint 199 26) ; "There is a magical aura around the door."
		(return 1)
	)

	(method (hurtMe)
		(self setScript: zapScript)
		(return 1)
	)

	(method (openMe)
		(self setScript: zapScript)
		(return 1)
	)

	(method (triggerMe)
		(self setScript: zapScript)
		(return 1)
	)
)

(instance sparkle of Prop
	(properties
		z 36
		view 183
		priority 15
		signal 16
	)
)

