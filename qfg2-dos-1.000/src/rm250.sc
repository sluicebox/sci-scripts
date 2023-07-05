;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 250)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use n003)
(use HandsOffScript)
(use TopWindow)
(use Talker)
(use Stage)
(use n251)
(use Polygon)
(use Feature)
(use LoadMany)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	rm250 0
)

(local
	[pts1 16] = [61 0 142 12 152 22 153 38 188 57 250 74 250 8 303 0]
	[pts2 8] = [173 130 127 146 140 174 208 155]
	seenBack
	dontLaugh
	floatMask
	saidFoolers
	[tempStr 100]
	item2Buy
	itemCost
	theSpell
	[priceList 8] = [0 10 15 20 25 30 125 15]
	[keaponGenList 38] = [83 84 85 86 87 88 89 90 91 92 93 95 96 97 98 82 99 82 100 82 101 102 103 104 105 106 107 108 109 110 111 112 113 82 82 82 82 82]
	[keaponSpecList 72] = [56 '//detect,(spell,magic<detect),(spell<magic<detect)' 57 '//trigger,(spell<trigger)' 55 '//force,bolt,(spell<force,bolt)' 58 '//levitate,fly,(spell<levitate,fly)' 59 '//dazzle,(spell<dazzle)' 70 '//invisibility' 115 '//flame,fire,dart,fireball,(spell<flame,fire,dart,fireball)' 116 '//fetch,(spell<fetch)' 117 '//open,open,(spell<open,open)' 118 '//zap,(spell<zap)' 119 '//reversal,reflection,mirror,(spell<reversal,reflection,mirror)' 73 '//rope' 77 '//glasses,disguise,disguise' 49 '//caws' 50 '//shop' 51 '//wonder' 52 '//owner' 53 '//yorick' 76 '//cost,cost<rope' 54 '//spell,cost,cost,merchandise' 60 '//bedouin' 61 '//hero' 63 '//hoodoo' 72 '//dirt,earth<fooler' 64 '//dirt,earth' 65 '//whirl' 66 '//gnome' 67 '//erasmus' 68 '//scroll' 69 '//beast,saurii' 71 '//wizard' 78 '//carp,carp,dolphin,aquarium,oasis,sea' 81 '//air,wind' 114 '//iblis' 115 '//flame,fire,dart,fireball,(spell<flame,fire,dart,fireball)' 0 0]
	[bookMsg 11] = [{"Ghost Writers in the Sky."} {"To Air is Human."} {"Fear of Flying."} {"The Wind in the Bellows."} {"Gnome with the Wind."} {"The Pizza Elemental: Fact or Fiction?.'} {"Air Conditioning and Grooming.} {"H-I-J-K-Elemental-P."} {"We're Here to Pump You Up."} {"The Air Apparent."} {"Three's a Cloud."}]
	msgCounter
)

(instance rm250 of Stage
	(properties
		picture 250
		south 310
		bottomFromX 89
		bottomFromY 250
		bottomToX 89
	)

	(method (init)
		(LoadMany rsVIEW 0 47 250 251 255)
		(LoadMany rsTEXT 254)
		(= gNow (+ (* gDay 100) gTimeODay))
		(= entranceScript enterS)
		(NormalEgo)
		(gEgo init:)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(keapon ignoreActors: 1 init:)
		(pinWheels init:)
		(if (not (gEgo has: 54)) ; Glasses
			(xRayGlasses init:)
		)
		(InitFeatures250)
		(cloudPoly points: @pts1 size: 8)
		(sunPoly points: @pts2 size: 4)
		(self addObstacle: cloudPoly sunPoly)
		(InitFeatures booksRight booksLeft ceiling floor)
		(gCSound number: 250 loop: -1 playBed:)
		(SetFlag 129)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((gEgo script:))
			((!= inOut 3))
			((& (gEgo onControl: 1) $0002)
				(gEgo setScript: bumpNose)
			)
			((& (gEgo onControl: 1) $2000)
				(gEgo setScript: sideDoor 0 0)
			)
			((& (gEgo onControl: 1) $1000)
				(gEgo setScript: sideDoor 0 1)
			)
			((& (gEgo onControl: 1) $4000)
				(gCurRoom setScript: byeScript)
			)
		)
	)

	(method (dispose)
		(DisposeScript 251)
		(= gMagicLastHere gNow)
		(gTimers eachElementDo: #dispose eachElementDo: #delete)
		(gCSound fade:)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'search,look,look[<at,around][/room,area][/!*]')
				(HighPrint 250 0) ; "This place lies somewhere between weird and infinity. Much more toward weird."
			)
			((and (== (event type:) evMOUSEBUTTON) (not (event modifiers:)))
				(cond
					(
						(and
							(gEgo inRect: 272 139 308 146)
							(> (event x:) (gEgo x:))
						)
						(event claimed: 1)
						(gEgo setMotion: MoveTo 320 (gEgo y:))
					)
					(
						(and
							(gEgo inRect: 62 121 95 139)
							(< (event x:) (gEgo x:))
						)
						(event claimed: 1)
						(gEgo setMotion: MoveTo 0 (gEgo y:))
					)
				)
			)
			((Said 'throw,cast,attack,kill,attack')
				(HighPrint 250 1) ; "You think about it, and then think better about it. You don't really want to get the guy upset. You'd probably wind up with ants in your pants, egg on your face, and pie in your eye."
			)
			((Said 'sell,give/whirl,beard')
				(Say keapon 250 2) ; "You uncurled me some whirl from Dervish? Oh, frabjous day, hoorah, hooray! Here's the Dinars that I must pay."
				(gEgo get: 2 15) ; Dinar
				(gEgo use: 14) ; Beard
			)
			((Said 'grab')
				(HighPrint 250 3) ; "You don't dare while the shopkeepers watching. He might throw a pie at you."
			)
			((Said 'tell')
				(Say keapon 250 4) ; "You don't say? And I sure won't."
			)
			((Said 'buy>')
				(cond
					(
						(Said
							'/detect,(spell,scroll,magic<detect),(spell,scroll<magic<detect)'
						)
						(= item2Buy 1)
					)
					((Said '/trigger,(spell,scroll<trigger)')
						(= item2Buy 2)
					)
					((Said '/dazzle,(spell,scroll<dazzle)')
						(= item2Buy 4)
					)
					((Said '/levitate,fly,(spell,scroll<levitate,fly)')
						(= item2Buy 5)
					)
					((Said '/force,bolt,(spell,scroll<force,bolt)')
						(= item2Buy 3)
					)
					((Said '/rope')
						(= item2Buy 6)
					)
					((Said '/spell,scroll,merchandise')
						(= item2Buy 0)
						(keapon showText: 54)
					)
					((Said '/glasses')
						(if (gEgo has: 54) ; Glasses
							(= item2Buy 0)
							(Say keapon 250 5) ; "You have my last pair there, Claire, and I haven't got a spare."
						else
							(= item2Buy 7)
						)
					)
					((Said '/dirt,earth<fooler')
						(= item2Buy 0)
						(keapon showText: 72)
					)
					((Said '/dirt,earth')
						(= item2Buy 0)
						(keapon showText: 64)
					)
					(else
						(= item2Buy 0)
						(event claimed: 1)
						(Say keapon 250 6 250 7) ; "What do I look like, a department store?"
					)
				)
				(if item2Buy
					(self setScript: buyItemS 0 0)
				)
			)
			((Said 'bargain>')
				(cond
					(
						(or
							(Said
								'/detect,(spell,scroll,magic<detect),(spell,scroll<magic<detect)'
							)
							(Said
								'//detect,(spell,scroll,magic<detect),(spell,scroll<magic<detect)'
							)
						)
						(= item2Buy 1)
					)
					(
						(or
							(Said '/trigger,(spell,scroll<trigger)')
							(Said '//trigger,(spell,scroll<trigger)')
						)
						(= item2Buy 2)
					)
					(
						(or
							(Said '/dazzle,(spell,scroll<dazzle)')
							(Said '//dazzle,(spell,scroll<dazzle)')
						)
						(= item2Buy 4)
					)
					(
						(or
							(Said '/levitate,fly,(spell,scroll<levitate,fly)')
							(Said '//levitate,fly,(spell,scroll<levitate,fly)')
						)
						(= item2Buy 5)
					)
					(
						(or
							(Said '/force,bolt,(spell,scroll<force,bolt)')
							(Said '//force,bolt,(spell,scroll<force,bolt)')
						)
						(= item2Buy 3)
					)
					((or (Said '/rope') (Said '//rope'))
						(= item2Buy 6)
					)
					((or (Said '/glasses') (Said '//glasses'))
						(if (gEgo has: 54) ; Glasses
							(= item2Buy 0)
							(Say keapon 250 8) ; "Well, we can bargain all you like, Mike, but that won't change the fact that you already bought the only pair I had."
						else
							(= item2Buy 7)
						)
					)
					(
						(or
							(Said '/dirt,earth<fooler')
							(Said '//dirt,earth<fooler')
						)
						(= item2Buy 0)
						(keapon showText: 72)
					)
					((or (Said '/dirt,earth') (Said '//dirt,earth'))
						(= item2Buy 0)
						(keapon showText: 64)
					)
					(
						(or
							(Said '/spell,scroll,merchandise')
							(Said '//spell,scroll,merchandise')
						)
						(= item2Buy 0)
						(keapon showText: 54)
					)
					(else
						(= item2Buy 0)
						(event claimed: 1)
						(Say keapon 250 6 250 7) ; "What do I look like, a department store?"
					)
				)
				(if item2Buy
					(self setScript: buyItemS 0 1)
				)
			)
			((Said 'use,wear,(put<on)/glasses[<ray]')
				(event claimed: 0)
				(keapon setScript: laughS 0 1)
			)
			((or (Said 'look,look<up') (Said 'look,look/cloud,ceiling,sky'))
				(if (shadow onMe: gEgo)
					(HighPrint 250 9) ; "By golly, it is! There's a silver lining on the underside of Keapon's cloud."
				else
					(HighPrint 250 10) ; "The fact that the clouds on the ceiling don't move leads you to the conclusion that they were not painted on with an air brush."
				)
			)
			((or (Said 'look,look<down') (Said 'look,look/floor,sun'))
				(HighPrint 250 11) ; "Talk about topsy-turvy. The sun shines up from the floor onto the clouds above."
			)
			((Said 'thank')
				(SayThanks keapon 250 12)
			)
		)
	)
)

(instance enterS of HandsOffScript
	(properties)

	(method (changeState newState &tmp theMsg)
		(switch (= state newState)
			(0
				(= dontLaugh 1)
				(keapon caller: self)
				(cond
					((not gMagicLastHere)
						(keapon showMany: 13 16)
					)
					((and (== gElementalState 1) (< gMagicLastHere 400))
						(keapon showMany: 21 24)
					)
					((and (== gElementalState 3) (< gMagicLastHere 800))
						(keapon showMany: 27 29)
					)
					((and (== gElementalState 5) (< gMagicLastHere 1200))
						(keapon showMany: 32 34)
					)
					((and (== gElementalState 7) (< gMagicLastHere 1400))
						(keapon showMany: 36 39)
					)
					(else
						(= theMsg (ChooseFromCycle gMagicTrips 0 5))
						(Say keapon self (keapon msgFile:) (+ 0 theMsg))
					)
				)
				(++ gMagicTrips)
			)
			(1
				(cond
					(
						(and
							(or (>= gDay 7) (not gMagicLastHere))
							(not (gEgo has: 16)) ; Rope
							[gEgoStats 11] ; climb
						)
						(Say keapon self 250 13 250 14) ; "It's sad, Dad, but if you need to climb to the sublime, you need a rope, Dope."
					)
					((and [gEgoStats 12] (not (IsFlag 180))) ; magic use
						(SetFlag 180)
						(Say keapon self 250 15) ; "I see by your outfit that you know some magic. You see by my outfit that I know some, too. We can see by our outfits that we both know magic. I guess that we two must eschew the Hoodoo."
					)
					(else
						(= cycles 1)
					)
				)
			)
			(2
				(if (and [gEgoStats 12] (== gMagicTrips 1)) ; magic use
					(Say keapon self 250 16 250 17 250 18 250 19) ; "Hello sailor, new in town? So how ya doin, Bruin?"
				else
					(self cue:)
				)
			)
			(3
				(= dontLaugh 0)
				(keapon setScript: laughS 0 0)
				(self dispose:)
			)
		)
	)
)

(instance byeScript of HandsOffScript
	(properties)

	(method (changeState newState &tmp theMsg)
		(switch (= state newState)
			(0
				(cond
					((keapon script:)
						((keapon script:) caller: self)
					)
					((keapon cycler:)
						(= dontLaugh 1)
						(keapon caller: self)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(1
				(gEgo setMotion: MoveTo 94 200)
				(keapon caller: self)
				(cond
					((not gMagicLastHere)
						(keapon showMany: 17 20)
					)
					((and (== gElementalState 1) (< gMagicLastHere 400))
						(keapon showMany: 25 26)
					)
					((and (== gElementalState 3) (< gMagicLastHere 800))
						(keapon showMany: 30 31)
					)
					((and (== gElementalState 5) (< gMagicLastHere 1200))
						(keapon showMany: 35 35)
					)
					((and (== gElementalState 7) (< gMagicLastHere 1400))
						(keapon showMany: 40 42)
						(keapon showMany: 43 45)
					)
					(else
						(= theMsg (ChooseFromCycle gMagicTrips 0 5))
						(Say keapon self (keapon msgFile:) (+ 6 theMsg))
					)
				)
				(++ gMagicTrips)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance laughS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(keapon
					setLoop: (+ register 1)
					cycleSpeed: register
					setCycle: Fwd
				)
				(= cycles (+ 16 (* 8 register)))
			)
			(1
				(keapon setLoop: 0 setCel: 0 setCycle: 0)
				(self dispose:)
			)
		)
	)
)

(instance bumpNose of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					posn: (gEgo x:) (- (gEgo y:) 3)
					view: 255
					setLoop: 8
					setCel: 0
					cycleSpeed: 1
					setCycle: CT 3 1
				)
				(= cycles 8)
			)
			(1
				(keapon setScript: laughS 0 1)
				(= cycles 12)
			)
			(2
				(gEgo setCycle: End)
				(= cycles 6)
			)
			(3
				(gEgo setCycle: CT 4 -1 self)
			)
			(4
				(gEgo setCycle: End)
				(= cycles 9)
			)
			(5
				(gEgo setCycle: CT 3 -1 self)
			)
			(6
				(= cycles 8)
			)
			(7
				(NormalEgo)
				(gEgo
					posn: (gEgo x:) (+ (gEgo y:) 3)
					setHeading: 180 self
				)
			)
			(8
				(gEgo setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 5) self)
			)
			(9
				(if (not seenBack)
					(HighPrint 250 20) ; "It sure LOOKED real!"
					(= seenBack 1)
				)
				(self dispose:)
			)
		)
	)
)

(instance sideDoor of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= dontLaugh 1)
				(if register
					(gEgo posn: 61 134 setMotion: MoveTo 86 134 self)
				else
					(gEgo posn: 308 143 setMotion: MoveTo 274 143 self)
				)
			)
			(1
				(Say keapon self 250 21 250 22) ; "You looks awfully familiar and familiarly awful."
			)
			(2
				(= cycles 1)
			)
			(3
				(= dontLaugh 0)
				(keapon setScript: laughS 0 1)
				(self dispose:)
			)
		)
	)
)

(instance buyItemS of HandsOffScript
	(properties)

	(method (changeState newState &tmp theCel theBreak)
		(switch (= state newState)
			(0
				(cond
					((and (< item2Buy 6) (not [gEgoStats 12])) ; magic use
						(Say keapon 250 23) ; "You still don't have the skill, Phil, so I'll spare you the bill."
						(self dispose:)
					)
					((and (== item2Buy 6) (gEgo has: 16)) ; Rope
						(Say keapon 250 24) ; "Say Jay, what the hey? The rope you've got is one and the same."
						(self dispose:)
					)
					(else
						(self cue:)
					)
				)
			)
			(1
				(= itemCost [priceList item2Buy])
				(if register
					(cond
						((== item2Buy 7)
							(Say keapon self 250 25 250 26) ; "Well, the tag says 15 dinars, but I guess I can take 14 for 'em..."
						)
						((TrySkill 13 60) ; communication
							(= theBreak (if (== item2Buy 1) 5 else 10))
							(Say ; "Whew! Smooth talking, Dude. Ya got the gift for gab, Tab."
								keapon
								self
								250
								27
								(Format @tempStr 250 28 theBreak) ; "Tell ya what I'm going ta do. Seein' as you beein' a Heero and all, I'll reduce the price by %d whole simoleons."
								250
								29
							)
							(-= itemCost theBreak)
						)
						(else
							(Say keapon 250 30 250 31 250 32) ; "If you want to do some dealing, then pick a better deck."
							(self changeState: 9)
						)
					)
				else
					(self cue:)
				)
			)
			(2
				(= dontLaugh 1)
				(if (or (not (IsFlag 120)) (== (Random 1 10) 1))
					(self setScript: zoomS self)
				else
					(switch (ChooseFromCycle (+ gMagicTrips 2) 0 2)
						(0
							(Say keapon self 250 33 250 34) ; "Ah, I have that here, Dear."
						)
						(1
							(Say keapon self 250 35 250 36) ; "Nothing up my sleeve..."
						)
						(2
							(Say keapon self 250 37) ; "Eins, Zwei, Drei, Vier, Make it snappy und bring it here!"
						)
					)
				)
			)
			(3
				(keapon setLoop: 3 setCel: 0 cycleSpeed: 1 setCycle: End self)
			)
			(4
				(keapon setLoop: 0 setCel: 0 cycleSpeed: 0)
				(smallCloud setLoop: 0 setCel: 0 posn: 170 145 60 init:)
				(= cycles 8)
			)
			(5
				(switch item2Buy
					(6
						(= theCel 1)
						(magicThing
							noun: '/rope'
							lookStr: {It is a magic rope.}
							description: {the rope}
						)
					)
					(7
						(= theCel 2)
						(magicThing
							noun: '/glasses'
							lookStr: {Ali Fakir Genuine X-Ray Glasses.}
							description: {the x-ray glasses}
						)
						(xRayGlasses hide:)
					)
					(else
						(= theCel 0)
						(magicThing
							noun: '/scroll,spell'
							lookStr: {It is a scroll containing a spell.}
							description: {the scroll}
						)
					)
				)
				(magicThing setLoop: 1 setCel: theCel init:)
				(= cycles 4)
			)
			(6
				(gEgo setMotion: MoveTo 155 150 self)
			)
			(7
				(gEgo setHeading: 45 self)
			)
			(8
				(switch (CheckFunds (* itemCost 100))
					(0
						(Say keapon self 250 38 250 39) ; "Need more money, Honey. Your moolah's too low, Moe."
					)
					(1
						(Say keapon self 250 40 250 41) ; "So solly, Chollie. This money's funny."
					)
					(2
						(Say keapon self 250 42) ; "Here you go, Joe. Hope you're happy, Pappy."
						(GiveMoney (* itemCost 100))
						(if (== item2Buy 6)
							(SolvePuzzle 700 5 2)
							(self changeState: 10)
						else
							(= state 11)
						)
					)
				)
			)
			(9
				(magicThing dispose:)
				(if (== item2Buy 7)
					(xRayGlasses show:)
				)
				(smallCloud setCycle: Beg)
				(self changeState: 17)
			)
			(10)
			(11
				(Say keapon self (keapon msgFile:) 73)
			)
			(12
				(smallCloud z: 59)
			)
			(13
				(gEgo
					view: 47
					setLoop: 6
					setCel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(14
				(magicThing dispose:)
				(= theSpell 0)
				(switch item2Buy
					(1
						(= theSpell 20)
					)
					(2
						(= theSpell 21)
					)
					(4
						(= theSpell 22)
					)
					(5
						(= theSpell 28)
					)
					(3
						(= theSpell 27)
					)
					(6
						(gEgo get: 16) ; Rope
					)
					(7
						(gEgo get: 54) ; Glasses
					)
				)
				(gEgo setCycle: Beg self)
			)
			(15
				(if (and theSpell (not (gEgo learn: theSpell 10)))
					(HighPrint 250 43) ; "The spell looks and feels very familiar. In fact, you realize that you already knew it! What a waste of money!"
				)
				(= cycles 4)
			)
			(16
				(smallCloud setCycle: Beg self)
			)
			(17
				(NormalEgo)
				(= dontLaugh 0)
				(smallCloud dispose:)
				(StartTimer boredTimer 45)
				(self dispose:)
			)
		)
	)
)

(instance zoomS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 120)
				(boredTimer dispose:)
				(Say keapon self 250 44) ; "Now let me see where I last saw it. I'll have to look for it in the back room. I'll be back in a flash with the stash, Nash!"
			)
			(1
				(= cycles 2)
			)
			(2
				(floatTimer1 dispose:)
				(keapon setLoop: 4 setCel: 0 cycleSpeed: 1 setCycle: End self)
				(if (gEgo inRect: 67 117 150 150)
					(gEgo setMotion: MoveTo 140 160)
				)
			)
			(3
				(cloud init: setLoop: 6 setCycle: Fwd doit:)
				(keapon
					setLoop: 9
					setCel: 0
					setStep: 7 4
					setMotion: zMover 120 135 self
				)
				(pinWheels setCycle: Fwd)
				(StartTimer whizTimer 3)
			)
			(4
				(keapon setPri: 10 setMotion: MoveTo -50 (keapon y:) self)
			)
			(5
				(= seconds 5)
			)
			(6
				(keapon setLoop: 10 setMotion: MoveTo 120 135 self)
				(cloud setLoop: 7)
				(shadow setLoop: 12)
			)
			(7
				(keapon setPri: -1 setMotion: zMover 190 145 self)
			)
			(8
				(pinWheels setCycle: Fwd)
				(StartTimer whizTimer 3)
				(cloud setCycle: Beg self)
			)
			(9
				(cloud dispose:)
				(keapon setLoop: 5 setCel: 255 setCycle: Beg self)
				(floatTimer1 setCycle: floatTimer1 (Random 7 13))
			)
			(10
				(keapon setLoop: 0 cycleSpeed: 0)
				(shadow setLoop: 11 setCel: 0 doit:)
				(= cycles 4)
			)
			(11
				(Say keapon self 250 45 250 46) ; "Silly me. I had it here the whole time."
			)
			(12
				(= cycles 2)
			)
			(13
				(self dispose:)
			)
		)
	)
)

(instance keapon of Talker
	(properties
		x 191
		y 145
		z 60
		description {Keapon Laffin}
		lookStr {Be it ever so humble, there's no face like Gnome's.}
		view 255
		illegalBits 0
		talkSpeed 1
		myName '//keapon,keapon,man,gnome,owner'
		title {Keapon Laffin:}
		color 15
		back 1
		msgFile 254
	)

	(method (init)
		(super init: &rest)
		(= tWindow BotWindow)
		(StartTimer boredTimer 45)
		(shadow ignoreActors: 1 setPri: 0 init:)
		(floatTimer1 setCycle: floatTimer1 (Random 7 13))
	)

	(method (handleEvent)
		(StartTimer boredTimer 45)
		(super handleEvent: &rest)
	)

	(method (respond event question)
		(if (== question 10)
			(event claimed: 0)
			(if (Said '//spell')
				(self showText: 54)
				(return)
			else
				(event claimed: 1)
			)
		)
		(super respond: event question &rest)
	)

	(method (atSpec which)
		(return [keaponSpecList which])
	)

	(method (atGen which)
		(return [keaponGenList which])
	)

	(method (showText what)
		(cond
			((== what 72)
				(if (> gClumpsLeft 9)
					(Say self msgFile 72 250 47)
				else
					(gEgo get: 32) ; PotOfDirt
					(+= gClumpsLeft 60)
					(= saidFoolers 1)
					(super showText: what &rest)
				)
			)
			((== what 78)
				(self showMany: what 80)
			)
			((== what 73)
				(self showMany: what 76)
			)
			(else
				(if (== what 89)
					(SolvePuzzle 617 5)
				)
				(super showText: what &rest)
			)
		)
	)

	(method (messages)
		(floatTimer2 setCycle: floatTimer2 (Random 4 10))
		(super messages: &rest)
	)

	(method (endTalk)
		(super endTalk:)
		(if (not dontLaugh)
			(self setScript: laughS 0 0)
		else
			(self setLoop: 0 cel: 0)
		)
		(floatTimer2 dispose:)
		(if saidFoolers
			(HighPrint 250 48) ; "You put the pot of dirt away."
			(= saidFoolers 0)
		)
	)
)

(instance zMover of MoveTo
	(properties)

	(method (doit &tmp theZ)
		(super doit:)
		(= theZ (client z:))
		(switch x
			(120
				(client z: (- theZ 4))
			)
			(190
				(client z: (+ theZ 4))
			)
		)
	)
)

(instance shadow of View
	(properties
		x 191
		y 145
		noun '/shadow'
		description {Keapon's shadow}
		shiftClick 0
		lookStr {SOME people cast shadows.}
		view 255
		loop 11
		signal 2048
	)

	(method (doit)
		(super doit:)
		(= x (keapon x:))
		(= y (keapon y:))
		(if (gCast contains: cloud)
			(= cel (cloud cel:))
		)
	)
)

(instance cloud of Prop
	(properties
		noun '/cloud'
		description {the cloud}
		lookStr {It's the new and improved Maxi-Cloud HyperTurbo V8 LE No-door Sports Coupe, the pinnacle of cloudal mediocrity.}
		view 255
		loop 6
		signal 18432
	)

	(method (doit)
		(super doit:)
		(= z (keapon z:))
		(= x (+ (keapon x:) 3))
		(= y (+ (keapon y:) 3))
		(self setPri: (- (keapon priority:) 1))
	)
)

(instance smallCloud of Prop
	(properties
		noun '/cloud'
		description {the cloud}
		lookStr {It's a cloud/table/tray/catch-all/whatchamacallit.}
		view 251
		signal 18432
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(self setCycle: End)
	)

	(method (doit)
		(super doit:)
		(if (and (< 34 z 60) (== (-- z) 34))
			(buyItemS cue:)
		)
	)
)

(instance magicThing of View
	(properties
		x 170
		y 145
		z 60
		view 251
		loop 1
		signal 18432
	)

	(method (doit)
		(super doit:)
		(= x (smallCloud x:))
		(= y (smallCloud y:))
		(= z (smallCloud z:))
	)
)

(instance floatTimer1 of Timer
	(properties)

	(method (cue)
		(if (== (keapon z:) 59)
			(keapon z: 60)
		else
			(keapon z: 59)
		)
		(self setCycle: self (Random 7 13))
	)
)

(instance floatTimer2 of Timer
	(properties)

	(method (cue)
		(keapon x: (- (keapon x:) floatMask))
		(= floatMask (- (Random 0 2) 1))
		(keapon x: (+ (keapon x:) floatMask))
		(self setCycle: self (Random 4 10))
	)
)

(instance boredTimer of Timer
	(properties)

	(method (cue)
		(Say keapon (keapon msgFile:) (+ 46 (Random 0 2)))
		(StartTimer self 45)
	)
)

(instance whizTimer of Timer
	(properties)

	(method (cue &tmp foo)
		(if (< (= foo (pinWheels cycleSpeed:)) 2)
			(pinWheels cycleSpeed: (+ foo 1))
			(StartTimer self 3)
		else
			(pinWheels cycleSpeed: 0 setCycle: 0)
		)
	)
)

(instance pinWheels of Prop
	(properties
		x 130
		y 40
		noun '/pinwheel,(wheel<pin)'
		description {pinwheels}
		lookStr {They're pinwheels.  Just something for Keapon to toy around with.}
		view 250
		loop 3
		cel 1
		signal 16384
	)
)

(instance xRayGlasses of View
	(properties
		x 267
		y 113
		noun '/face,glasses,disguise'
		description {the x-ray glasses}
		lookStr {The tag says "Ali Fakir Genuine X-Ray Glasses - 15 Dinars."  They look incredibly large, but the tag also says "One size fits all."  It must be magic.}
		view 250
		cel 7
		signal 16384
	)
)

(instance booksLeft of Feature
	(properties
		x 140
		y 62
		noun '/book'
		nsTop 56
		nsLeft 133
		nsBottom 69
		nsRight 147
		description {the books}
	)

	(method (doVerb theVerb)
		(if (== theVerb 1)
			(HighPrint (Format @tempStr 250 49 [bookMsg msgCounter])) ; "There seem to be books in many languages, few of which are comprehensible to you, but you do recognize some old favorites, such as %s"
			(if (> (++ msgCounter) 10)
				(= msgCounter 0)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance booksRight of Feature
	(properties
		x 311
		y 35
		noun '/book'
		nsTop 26
		nsLeft 303
		nsBottom 44
		nsRight 319
		description {the books}
	)

	(method (doVerb theVerb)
		(if (== theVerb 1)
			(HighPrint (Format @tempStr 250 49 [bookMsg msgCounter])) ; "There seem to be books in many languages, few of which are comprehensible to you, but you do recognize some old favorites, such as %s"
			(if (> (++ msgCounter) 10)
				(= msgCounter 0)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance cloudPoly of Polygon
	(properties
		type PTotalAccess
	)
)

(instance ceiling of Feature
	(properties
		noun '/ceiling'
		description {the ceiling}
		lookStr {The fact that the clouds on the ceiling don't move leads you to the conclusion that they were not painted on with an air brush.}
	)

	(method (onMe theObj)
		(return (AvoidPath (theObj x:) (theObj y:) cloudPoly))
	)
)

(instance sunPoly of Polygon
	(properties
		type PTotalAccess
	)
)

(instance floor of Feature
	(properties
		noun '/floor'
		description {the floor}
		lookStr {Talk about topsy-turvy.  The sun shines up from the floor onto the clouds above.}
	)

	(method (onMe theObj)
		(return (AvoidPath (theObj x:) (theObj y:) sunPoly))
	)
)

