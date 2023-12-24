;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 430)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use Talker)
(use Stage)
(use Full)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Timer)
(use Grooper)
(use Motion)
(use Actor)

(public
	rm430 0
)

(local
	canSee
	wait4Visa
	yesNo
	begging
	waitCounter
	servantCounter
	[tempStr 50]
	[pts1 24] = [42 109 90 109 92 115 56 135 59 139 74 138 134 110 200 114 226 134 251 133 204 98 50 97]
	[pts2 34] = [55 62 65 70 82 48 97 66 111 35 131 19 150 51 165 20 189 42 195 67 205 47 213 49 222 58 226 73 236 59 234 13 51 8]
	[pts3 18] = [199 71 203 86 209 90 215 88 224 75 225 102 215 114 206 114 198 98]
	[pts4 8] = [65 75 65 131 69 131 69 75]
	[pts5 8] = [95 70 95 110 99 110 99 70]
	[pts6 8] = [194 71 194 109 198 109 198 71]
	[pts7 8] = [225 77 225 132 229 132 228 76]
	[pts8 8] = [111 118 183 118 216 151 78 151]
	[zayishahGenList 38] = [12 13 14 11 11 11 11 11 11 15 16 17 18 11 19 20 21 11 22 11 11 23 24 25 26 11 11 11 11 11 27 11 28 11 11 11 11 11]
	[zayishahSpecList 24] = [0 '//khaveen' 1 '//marry' 2 '//puppet' 3 '//clothes' 4 '//woman,mayzun' 5 '//zayisha' 6 '//ad<ad' 7 '//power' 8 '//control' 9 '//eunuch' 10 '//harem' 0 0]
	[servantGenList 38] = [8 9 10 7 7 7 7 7 7 11 7 12 13 7 14 15 16 7 7 7 7 7 17 18 19 7 7 7 7 7 20 7 21 7 7 7 7 7]
	[servantSpecList 16] = [0 '//ad<ad' 1 '//zayisha,girl' 2 '//marry,khaveen' 3 '//eunuch' 4 '//harem' 5 '//resistance,revolt,revolution,underground' 6 '//forbidden' 0 0]
)

(instance rm430 of Stage
	(properties
		picture 430
		east 429
		rightFromX 280
		rightFromY 140
		rightExit 3
		rightToX 200
		rightToY 140
	)

	(method (init)
		(LoadMany rsVIEW 0 4 47 382 383 432 435 436 437 438 440)
		(LoadMany rsTEXT 435 432)
		(LoadMany rsSOUND 430 431)
		(SetFlag 138) ; fVisitedHaremGirl
		(ClearFlag 142) ; fFollowingSlave
		(= gNow (+ (* gDay 100) gTimeODay))
		(= entranceScript enterS)
		(gEgo init:)
		(NormalEgo)
		(super init:)
		(InitFeatures pillar ceiling rightVeil rug)
		(InitAddToPics vase)
		(poly1 points: @pts1 size: 12)
		(poly2 points: @pts2 size: 17)
		(poly3 points: @pts3 size: 9)
		(poly4 points: @pts4 size: 4)
		(poly5 points: @pts5 size: 4)
		(poly6 points: @pts6 size: 4)
		(poly7 points: @pts7 size: 4)
		(poly8 points: @pts8 size: 4)
		(self addObstacle: poly1)
		(gCSound number: 430 loop: -1 priority: 0 playBed:)
		(zayishah init:)
		(servant init:)
		(veil setCel: (IsFlag 125) init:) ; fWearingXRay
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((and (& (gEgo onControl: 1) $0200) (== inOut 3))
				(gCurRoom setScript: byeS)
			)
			((IsFlag 125) ; fWearingXRay
				(if (< 45 (gEgo heading:) 135)
					(veil setCel: 0)
				else
					(veil setCel: 1)
				)
			)
		)
	)

	(method (dispose)
		(gTimers eachElementDo: #dispose eachElementDo: #delete)
		(gCSound fade:)
		(FixTime 16)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'search,look,look[<at,around][/room,area][/!*]')
				(HighPrint 430 0) ; "The room is lavishly appointed in the manner of an Emir's palace."
			)
			((Said 'kiss/girl')
				(if yesNo
					(Say zayishah 430 1) ; "You, sir, are a cad. Get lost!"
				else
					(HighPrint 430 2) ; "The Slave Woman glares at you."
					(Say zayishah 430 3) ; "You wouldn't want to take advantage of me, would you?"
					(= yesNo 1)
				)
			)
			((Said 'yes')
				(if yesNo
					(Say zayishah 430 4) ; "Well, you can't. So there."
					(= yesNo 0)
				else
					(event claimed: 0)
				)
			)
			((Said 'no')
				(cond
					(yesNo
						(Say zayishah 430 5) ; "Good. I would have had to refuse."
						(= yesNo 0)
					)
					(begging
						(Say zayishah 430 6) ; "Please, Hero. You must help me."
					)
					(else
						(event claimed: 0)
					)
				)
			)
			((Said 'use,wear,(put<on)/glasses[<ray]')
				(= yesNo 0)
				(cond
					((not (gEgo has: 54)) ; Glasses
						(DontHave)
					)
					((IsFlag 125) ; fWearingXRay
						(HighPrint 430 7) ; "You're already wearing them."
					)
					(else
						(if (gCast contains: zayishah)
							(HighPrint 430 8) ; "They obviously improve your looks. Zayishah just giggles at you."
						else
							(HighPrint 430 9) ; "You put on the Ali Fakir Genuine X-Ray Glasses."
						)
						(SetFlag 125) ; fWearingXRay
						(if canSee
							(veil setCel: 1)
						)
					)
				)
			)
			((Said '(get<off),get/glasses[<ray]')
				(= yesNo 0)
				(cond
					((not (gEgo has: 54)) ; Glasses
						(DontHave)
					)
					((IsFlag 125) ; fWearingXRay
						(HighPrint 430 10) ; "You take them off and put them away."
						(ClearFlag 125) ; fWearingXRay
						(veil setCel: 0)
					)
					(else
						(HighPrint 430 11) ; "You're not wearing them."
					)
				)
			)
			((Said 'kill,attack,throw,cast')
				(= yesNo 0)
				(HighPrint 430 12) ; "As you start, you see fear in the Slave Woman's eyes."
				(Say servant 430 13) ; "Guards! Guards! Come quickly! My mistress is in danger."
				(EgoDead 1 430 14 #title {Discretion is the Better Part of Safety}) ; "Guards quickly burst into the room. They drag you off to prison and Khaveen personally oversees your stay. It is not long."
			)
			(
				(or
					(Said 'give,barter,(get<off),get/clothes')
					(Said 'strip,change,yes')
				)
				(cond
					(script
						(Say zayishah 430 15) ; "I have all the clothes I need, thank you."
					)
					((gEgo has: 49) ; SpareClothes
						(SolvePuzzle 628 5)
						(gEgo use: 49) ; SpareClothes
						(= yesNo 0)
						(waitTimer dispose:)
						(self setScript: stripTeaseS)
					)
					(else
						(EgoDead 1 430 16 #title {Sheep in Sheik's clothing}) ; "You exchange clothes with Zayishah since you no longer have any spare ones. You don't look very Sheik in her veil, but it's a nice fit. Suddenly the guards break in and drag you off to the Harem. In two weeks, you are married to Khaveen, and you both live happily ever after."
					)
				)
			)
			((Said 'give/visa')
				(Say zayishah 430 17) ; "The clothes first, please."
			)
		)
	)
)

(instance enterS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= canSee 1)
				(servant
					setLoop: 2
					setCycle: Walk
					setMotion: MoveTo 110 116 self
				)
				(zayishah
					view: 437
					setLoop: 4
					setCycle: Walk
					setMotion: MoveTo (- (gEgo x:) 25) (gEgo y:) self
				)
			)
			(1
				(servant setLoop: 0 setCel: 1)
			)
			(2
				(zayishah view: 435 setLoop: 2 setCel: 0)
				(Say zayishah self 430 18 430 19) ; "Please, you must help me. Take off your clothes."
			)
			(3
				(zayishah setCycle: CT 4 1 self)
			)
			(4
				(Say zayishah self 430 20) ; "I wish to disguise myself as you and leave with your Visa, so please, let me exchange clothes with you."
				(StartTimer waitTimer 120)
			)
			(5
				(zayishah setCycle: CT 0 -1 self)
			)
			(6
				(zayishah setCycle: Walk)
				(= begging 1)
				(self dispose:)
			)
		)
	)
)

(instance stripTeaseS of HandsOffScript
	(properties)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			(wait4Visa
				(if (or (Said 'yes') (Said 'give/visa'))
					(if (gEgo has: 41) ; Visa
						(visaTimer dispose:)
						(self cue:)
					else
						(EgoDead ; "You Discover you have no Visa, so you offer her your Master's Card. She Sears you with her gaze, then beats you to a pulp with a Macy and takes your money. You are unable to Ward off the blows and are soon J. C. Penniless."
							1
							430
							21
							#title
							{Giving Credit where Credit's Due:}
						)
					)
				else
					(event claimed: 1)
					(Say zayishah 430 22) ; "Please, Hero, your Visa. There isn't much time."
				)
			)
			(
				(or
					(Said 'use,wear,(put<on)/glasses[<ray]')
					(Said '(get<off),get/glasses[<ray]')
				)
				(event claimed: 0)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= begging 0)
				(HighPrint 430 23) ; "You start to take off your vest, and then you realize that Shema packed you a change of clothes. You hand her your spare outfit."
				(Say zayishah self 430 24) ; "Thank you so very much."
			)
			(1
				(DontTalk 0)
				(gEgo setHeading: 135 self)
				(zayishah view: 437 setLoop: -1 setMotion: PolyPath 75 120 self)
			)
			(2
				(gEgo view: 438 setLoop: 0 setCel: 0)
				(= canSee 0)
				(veil setCel: 0)
			)
			(3
				(gMiscSound number: 431 loop: 0 priority: 5 vol: 100 play:)
				(servant setCel: 0)
				(clothes init:)
				(zayishah
					view: 435
					setLoop: 0
					setCel: 0
					cycleSpeed: 1
					setCycle: End self
				)
				(gEgo setCycle: End self)
				(= canSee 1)
			)
			(4
				(veil setCel: (IsFlag 125)) ; fWearingXRay
			)
			(5
				(zayishah
					setLoop: 1
					setCel: 0
					setCycle: End self
					lookStr:
						{Whoo!  You haven't seen a figure like that since you visited your accountant!}
				)
			)
			(6
				(servant setCel: 1)
				(= cycles 16)
			)
			(7
				(servant setCel: 0)
				(= cycles 8)
			)
			(8
				(servant setLoop: 1 setCycle: Full 5 self)
			)
			(9
				(gEgo setCycle: Beg self)
				(= canSee 0)
			)
			(10
				(veil setCel: 0)
				(= cycles 10)
			)
			(11
				(clothes dispose:)
				(zayishah
					x: (+ (zayishah x:) 7)
					view: 436
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
			)
			(12
				(zayishah view: 436 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(13
				(zayishah
					view: 436
					setLoop: 2
					setCel: 0
					setCycle: End self
					lookStr: {Is it you or is it Memorex?}
				)
			)
			(14
				(zayishah
					view: 0
					setLoop: -1
					setLoop: Grooper
					cycleSpeed: 0
					setCycle: StopWalk 4
					setMotion: PolyPath (- (gEgo x:) 40) (gEgo y:) self
				)
				(NormalEgo)
				(veil setCel: (IsFlag 125)) ; fWearingXRay
				(= canSee 1)
				(= cycles 1)
			)
			(15
				(gEgo setHeading: 180 self)
			)
			(16
				(gEgo setHeading: 270)
			)
			(17
				(Say zayishah self 430 25) ; "How do I look? Do you think this will fool anybody? It's so nice not to have to wear a stupid veil."
			)
			(18
				(zayishah setHeading: 335 self)
			)
			(19
				(zayishah setHeading: 180 self)
			)
			(20
				(zayishah setHeading: 90 self)
			)
			(21
				(Say zayishah 430 26) ; "Please, in order to leave the city I need one more thing, although it will be dangerous for you. I must have your Visa."
				(= wait4Visa 1)
				(StartTimer visaTimer 60)
			)
			(22
				(zayishah
					setMotion: MoveTo (- (gEgo x:) 5) (+ (gEgo y:) 5) self
				)
			)
			(23
				(zayishah setHeading: 0 self)
			)
			(24
				(Say zayishah self 430 27 430 28 430 29) ; "Thank you ever so much. In return for your favors, I can only give you a token."
				(gEgo get: 46) ; Mirror
				(gEgo use: 41) ; Visa
			)
			(25
				(zayishah setPri: 10 setMotion: MoveTo 300 (zayishah y:) self)
			)
			(26
				(zayishah dispose:)
				(Say servant self 430 30) ; "Wait until she clears the alleyway before you leave, Effendi."
				(SolvePuzzle 629 5)
				(SkillUsed 14 50) ; honor
				(StartTimer servantTimer 120)
			)
			(27
				(self dispose:)
			)
		)
	)
)

(instance guardS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(guard init: setCycle: Walk setMotion: MoveTo 220 140 self)
			)
			(1
				(guard view: 383 setLoop: 3 setCel: 0 setCycle: End self)
			)
			(2
				(Say guard self 430 31) ; "What goes on here?"
			)
			(3
				(Say guard self 430 32) ; "Guards! To me!"
			)
			(4
				(if register
					(HighPrint 430 33) ; "You are dragged away to the dungeons of Raseir."
					(gCurRoom newRoom: 440)
				else
					(EgoDead 1 430 33 #title {Not a Vacation}) ; "You are dragged away to the dungeons of Raseir."
				)
			)
		)
	)
)

(instance byeS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gEgo has: 46) ; Mirror
					(Face gEgo servant)
					(Say servant self 430 34 430 35) ; "If you need a place of safety in the Palace sometime, the Harem will welcome you for the aid you gave my mistress. I shall tie a veil from the battlements at night to guide you."
				else
					(EgoDead 1 430 36) ; "You are met outside by several guards, who cheerfully drag you away to the dungeons of Raseir."
				)
			)
			(1
				(gEgo setMotion: MoveTo 320 (gEgo y:))
				(= cycles 10)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance zayishah of Talker
	(properties
		x 69
		y 158
		description {Zayishah}
		lookStr {Yup, she's a girl alright.}
		view 435
		illegalBits 0
		tLoop -1
		talkSpeed 1
		myName '//girl,zayisha,woman'
		title {Zayishah:}
		back 11
		msgFile 435
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (Said 'tell/self,hero') (Said 'tell//self,hero'))
				(= yesNo 0)
				(Say self 430 37) ; "I hope with all my heart that you can restore Raseir."
			)
			((or (Said 'tell/saurii,arus,emir') (Said 'tell//saurii,arus,emir'))
				(= yesNo 0)
				(Say self 430 38) ; "Oh, it is so good to know my uncle is still alive. He is such a kind and friendly man."
				(SkillUsed 14 25) ; honor
			)
			((Said 'tell')
				(= yesNo 0)
				(Say self 430 39) ; "That is most interesting, but I must hurry."
			)
		)
	)

	(method (respond event)
		(cond
			(wait4Visa
				(event claimed: 1)
				(Say zayishah 430 40) ; "I must hurry before the Eunuchs discover I am gone. Khaveen will have the city searched. Please, may I have your Visa?"
			)
			((gCurRoom script:)
				(event claimed: 1)
				(HighPrint 430 41) ; "She looks pretty busy right now."
			)
			(else
				(super respond: event &rest)
			)
		)
	)

	(method (atSpec which)
		(return [zayishahSpecList which])
	)

	(method (atGen which)
		(return [zayishahGenList which])
	)
)

(instance servant of Talker
	(properties
		x 200
		y 130
		description {Mayzun}
		lookStr {Mayzun is Zayishah's servant.}
		view 432
		illegalBits 0
		tLoop 3
		talkSpeed 1
		myName '//servant,mayzun,woman'
		title {Mayzun:}
		back 13
		msgFile 432
	)

	(method (respond event)
		(if (gCurRoom script:)
			(event claimed: 1)
			(HighPrint 430 42) ; "Zayishah's servant pays no attention to you."
		else
			(super respond: event &rest)
		)
	)

	(method (atSpec which)
		(return [servantSpecList which])
	)

	(method (atGen which)
		(return [servantGenList which])
	)
)

(instance guard of Talker
	(properties
		x 280
		y 140
		view 382
		tLoop -1
		talkSpeed 1
		myName '//guard,man'
		title {Guard:}
	)
)

(instance waitTimer of Timer
	(properties)

	(method (cue)
		(switch (++ waitCounter)
			(1
				(Say zayishah 430 43) ; "Please, hero, we must hurry. The guards will be searching for me soon. I need your clothes."
				(StartTimer self 60)
			)
			(2
				(Say zayishah 430 44) ; "The guards will be here any minute."
				(StartTimer self 60)
			)
			(3
				(EgoDead 1 430 45 #title {Unwanted Visitors}) ; "Suddenly, the guards walk in and grab all of you, just as Zayishah had warned. Zayishah is returned to the Harem.  You are taken to the dungeon where Khaveen is waiting for you."
			)
		)
	)
)

(instance visaTimer of Timer
	(properties)

	(method (cue)
		(gCurRoom setScript: guardS 0 0)
	)
)

(instance servantTimer of Timer
	(properties)

	(method (cue)
		(switch (++ servantCounter)
			(1
				(Say servant 430 46) ; "The guards will be coming soon in search of Zayishah. You must not be seen talking with me, Effendi. It is forbidden."
				(StartTimer self 60)
			)
			(2
				(gCurRoom setScript: guardS 0 1)
			)
		)
	)
)

(instance veil of View
	(properties
		x 82
		y 122
		noun '/screen,veil,curtain'
		description {the veil}
		lookStr {The veil is made of light gauze, just opaque enough to prevent any would-be peepers from seeing anything fun.}
		view 430
		priority 9
		signal 16400
	)
)

(instance clothes of View
	(properties
		x 84
		y 122
		view 440
		cel 1
		signal 16384
	)
)

(instance vase of PicView
	(properties
		x 148
		y 114
		noun '/vase,bouquet,pan,plant'
		description {the vase}
		lookStr {A very ornate vase with beautiful flowers.  Certainly an un-Raseirish sight.}
		view 430
		loop 1
	)
)

(instance pillar of Feature
	(properties
		noun '/column'
		description {the pillars}
		lookStr {The pillars are made of white marble.}
	)

	(method (onMe theObj)
		(return
			(or
				(AvoidPath (theObj x:) (theObj y:) poly4)
				(AvoidPath (theObj x:) (theObj y:) poly5)
				(AvoidPath (theObj x:) (theObj y:) poly6)
				(AvoidPath (theObj x:) (theObj y:) poly7)
			)
		)
	)
)

(instance ceiling of Feature
	(properties
		noun '/ceiling,roof'
		description {the ceiling}
		lookStr {The ceiling is inlaid with many colorful woods.}
	)

	(method (onMe theObj)
		(return (AvoidPath (theObj x:) (theObj y:) poly2))
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look,look<up')
				(self doVerb: 1)
			)
		)
	)
)

(instance rightVeil of Feature
	(properties
		noun '/veil'
		description {the veil}
		lookStr {This veil is much like the other.}
	)

	(method (onMe theObj)
		(return (AvoidPath (theObj x:) (theObj y:) poly3))
	)
)

(instance rug of Feature
	(properties
		noun '/carpet,carpet,floor'
		description {the rug}
		lookStr {A beautiful hand-woven rug decorates the center of the floor.}
	)

	(method (onMe theObj)
		(return (AvoidPath (theObj x:) (theObj y:) poly8))
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look,look<down')
				(self doVerb: 1)
			)
		)
	)
)

(instance poly1 of Polygon
	(properties
		type PTotalAccess
	)
)

(instance poly2 of Polygon
	(properties
		type PTotalAccess
	)
)

(instance poly3 of Polygon
	(properties
		type PTotalAccess
	)
)

(instance poly4 of Polygon
	(properties
		type PTotalAccess
	)
)

(instance poly5 of Polygon
	(properties
		type PTotalAccess
	)
)

(instance poly6 of Polygon
	(properties
		type PTotalAccess
	)
)

(instance poly7 of Polygon
	(properties
		type PTotalAccess
	)
)

(instance poly8 of Polygon
	(properties
		type PTotalAccess
	)
)

