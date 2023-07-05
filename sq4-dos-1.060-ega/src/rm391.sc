;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 391)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use Osc)
(use n940)
(use RandCycle)
(use LoadMany)
(use Window)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm391 0
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0 param1)
	(gCurRoom drawPic: 393)
	(Display param1 dsCOLOR global130 dsCOORD 2 12 dsWIDTH 316 dsFONT 0 dsALIGN alCENTER)
	(Display &rest dsWIDTH 270 dsCOORD 25 32 dsFONT 0)
)

(instance rm391 of SQRoom
	(properties
		lookStr {The rest of the store seems to be pretty empty. But everything is available through the friendly salesbot.}
		picture 391
		style 30
	)

	(method (init)
		(LoadMany rsPIC 392 393 803)
		(LoadMany rsSOUND 875 392 393 394 395)
		(Load rsFONT 0)
		(= local1 gSystemWindow)
		(= local2 gUserFont)
		(lEar init: setCycle: Fwd)
		(rEar init: setCycle: Fwd)
		(mouth init: setCycle: RandCycle)
		(eyes init: setCycle: Osc)
		(chest init: hide: stopUpd:)
		(gLongSong number: 0 loop: 1 vol: 127 stop:)
		(super init:)
		(gAddToPics add: roboHead eachElementDo: #init doit:)
		(gLongSong2 number: 396 loop: -1 vol: 127 playBed:)
		(robotEarSnd init: vol: 65 play:)
		(self setScript: welcomeSir)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(0
				(gCurRoom newRoom: 390)
			)
			(11 ; Smell
				(Print 391 0) ; "This whole place smells musty and dusty, just like an old escape pod you used to own... (er, well... borrowed)."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(gLongSong fade:)
		(super dispose:)
	)
)

(instance roboTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0
					(Display
						register
						dsWIDTH
						315
						dsCOORD
						118
						154
						dsALIGN
						alLEFT
						dsFONT
						300
						dsCOLOR
						global135
						dsSAVEPIXELS
					)
				)
				(= seconds 3)
			)
			(1
				(Display 391 1 dsRESTOREPIXELS local0)
				(self dispose:)
			)
		)
	)
)

(instance welcomeSir of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(chest show: forceUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance startTerminal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gNarrator disable:)
				(gNarrator curIcon: (gNarrator at: 2))
				(gGame setCursor: ((gNarrator curIcon:) cursor:))
				(= gSystemWindow BlueWindow)
				(= gUserFont 0)
				(BlueWindow color: global141 back: global149)
				(DrawStatus {   } global129 0)
				(gCast eachElementDo: #hide)
				(if (== (gCurRoom style:) 42)
					(gCurRoom style: 43)
				)
				(gCurRoom drawPic: 392)
				(= seconds 1)
			)
			(1
				(= register
					(PrintD
						{  }
						81
						{Instructions}
						doInstructions
						{  }
						81
						{Specials}
						doSpecials
						{  }
						81
						{Catalog}
						doCatalog
						{  }
						81
						{Exit}
						backToRob
						{ }
						67
						-1
						130
					)
				)
				(gCurRoom style: 42)
				(= cycles 2)
			)
			(2
				(gLongSong number: (Random 392 395) play:)
				(client setScript: register)
			)
		)
	)
)

(instance doInstructions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(BlueWindow color: global141)
				(localproc_0
					{INSTRUCTIONS}
					{Welcome to the Radio Shock Automated Catalog! Let us be your gateway to what's new and exciting in the world of 24th Century Electronics. \n\nThrough the pages of our Automated Catalog, you will find gifts for the whole family.  For Dad, look in Electronic Gadgets for our selection of Realrustic Stereo Components.  For Mom, peek into The Electronic Mommy for a variety of labor-\nsaving devices and marital aids!  For Sis and Little Brother, browse our TechnoTots(R) Toy department for the latest in electronic playborgs! }
					102
					global135
				)
				(if
					(PrintD
						{  }
						81
						{Continue}
						0
						{  }
						81
						{Return to Top Menu}
						1
						{  }
						67
						56
						153
					)
					(gLongSong number: (Random 392 395) play:)
					(client setScript: startTerminal)
				else
					(gLongSong number: (Random 392 395) play:)
					(localproc_0
						{INSTRUCTIONS}
						{Shopping our Automated Catalog is as easy as snapping your digital appendages. Using your mouse or Tab key, simply point to the menu item of your choice and press <Enter> or click the left mouse button.  Should you get confused, simply return to the Top Menu and begin anew. \n\nThank you for choosing Radio Shock for all your electronic needs! We know you'll find just what you're looking for, and if you don't, we're wrong and you should look somewhere else. \n\n  --Your Radio Shock Manager }
						102
						global135
					)
					(if
						(PrintD
							{ }
							81
							{Return to Top Menu}
							0
							{  }
							81
							{Limited Time Specials}
							1
							{ }
							67
							31
							157
						)
						(gLongSong number: (Random 392 395) play:)
						(client setScript: doSpecials)
					else
						(gLongSong number: (Random 392 395) play:)
						(client setScript: startTerminal)
					)
				)
			)
		)
	)
)

(instance doSpecials of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(BlueWindow color: (proc0_18 global161 global156))
				(localproc_0
					{SPECIALS}
					{\nThese Special Sale Items are available for a limited time only. Availability is limited to items in stock, as-is only, no returns. Some items may be demo models, scratched, dented, or just not in very good shape. No warranties, expressed or implied, apply to these items. No refund or exchange. }
					102
					(proc0_18 global133 global132)
				)
				(if
					(PrintD
						{ }
						81
						{Continue}
						0
						{ }
						81
						{Return to Top Menu}
						1
						{ }
						67
						60
						122
					)
					(gLongSong number: (Random 392 395) play:)
					(client setScript: startTerminal)
				else
					(gLongSong number: (Random 392 395) play:)
					(localproc_0
						{SPECIALS}
						{\nReShrinkwrap 2000 \n\nWork for a large retail software chain? Like to take the products home and diddle with them? The ReShrinkwrap 2000 reshrinkwraps any size software box. Is that game new or used? Only you'll know for sure! Keeps the customers guessing. DEALERS ONLY, please. 1033 Buckazoids. }
						102
						(proc0_18 global133 global132)
					)
					(switch
						(PrintD
							{ }
							81
							{Order}
							0
							{ }
							81
							{Continue}
							1
							{ }
							81
							{Return to Top Menu}
							2
							{ }
							67
							30
							132
						)
						(0
							(gLongSong number: (Random 392 395) play:)
							(PrintD
								{Sorry - dealers only!  }
								81
								{Continue}
								1
								67
								60
								140
							)
							(gLongSong number: (Random 392 395) play:)
							(= cycles 1)
						)
						(1
							(gLongSong number: (Random 392 395) play:)
							(= cycles 1)
						)
						(2
							(gLongSong number: (Random 392 395) play:)
							(client setScript: startTerminal)
						)
					)
				)
			)
			(1
				(localproc_0
					{SPECIALS}
					{DuaPhunki Answering Machine \n\nThe ultimate in hi-tech answering machines. Not a phone device. Carry it around with you. If somebody asks you a question, the DuaPhunki will give the correct answer. If it doesn't know the answer, it'll make a good guess. Won't discuss politics or religion. 117 Buckazoids. Sold out. }
					102
					(proc0_18 global133 global132)
				)
				(switch
					(PrintD
						{ }
						81
						{Order}
						0
						{ }
						81
						{Continue}
						1
						{ }
						81
						{Return to Top Menu}
						2
						{ }
						67
						30
						122
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(PrintD
							{Sorry - sold out.  }
							81
							{Continue}
							1
							67
							70
							135
						)
						(gLongSong number: (Random 392 395) play:)
						(= cycles 1)
					)
					(1
						(gLongSong number: (Random 392 395) play:)
						(= cycles 1)
					)
					(2
						(gLongSong number: (Random 392 395) play:)
						(client setScript: startTerminal)
					)
				)
			)
			(2
				(localproc_0
					{SPECIALS}
					{Cheese Wiz II \n\nPreprogrammed with over 350 varieties of cheese, Cheese Wiz II will tell you the precise temperature at which to serve that beautiful round of aged Cheddar or that oozing slice of soft- ripened Brie. A must for all cheese lovers. Will not work with aerosol cheese food products. 25 Buckazoids. Not available as such. }
					102
					(proc0_18 global133 global132)
				)
				(switch
					(PrintD
						81
						{Order}
						0
						{ }
						81
						{Return to Top Menu}
						1
						{ }
						81
						{Automated Catalog}
						2
						67
						20
						135
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(PrintD
							{Sorry - Not available as such.  }
							101
							81
							{Return to Top Menu}
							1
							67
							70
							134
						)
						(gLongSong number: (Random 392 395) play:)
						(client setScript: startTerminal)
					)
					(1
						(gLongSong number: (Random 392 395) play:)
						(client setScript: startTerminal)
					)
					(2
						(gLongSong number: (Random 392 395) play:)
						(client setScript: doCatalog)
					)
				)
			)
		)
	)
)

(instance doCatalog of Script
	(properties)

	(method (changeState newState &tmp [temp0 200])
		(switch (= state newState)
			(0
				0
				(BlueWindow color: (proc0_18 global138 global137))
				(localproc_0
					{- Automated Catalog -}
					{\n\n\nWelcome to our Automated Catalog!  Please select from the following departments: }
					102
					(proc0_18 global138 global137)
				)
				(self
					changeState:
						(PrintD
							{ }
							81
							{Electronic Gadgets}
							1
							{  }
							81
							{The Electronic Mommy}
							7
							{ }
							101
							{ }
							101
							{ }
							81
							{TechnoTots Toy Dept.}
							11
							{  }
							81
							{Return to Top Menu}
							15
							{ }
							67
							22
							102
						)
						(gLongSong number: (Random 392 395) play:)
				)
			)
			(1
				1
				(localproc_0
					{- Electronic Gadgets -}
					{Realrustic(TM) Faux-Component(R) Swiss Army MicroEntertainment Center \n\nStyled to look like a real set of miniature components, this is a complete home entertainment center in one 4"x 6" box! Includes CD-ROM unit, turntable, dual cassette with Hyperwow and MegaFlutter, unfolding 84" digital color projection multiscreen TV, corkscrew and toothpick. 2275 Buckazoids. Back-ordered; none currently available. }
					102
					(proc0_18 global138 global137)
				)
				(switch
					(PrintD
						{ }
						81
						{Order}
						0
						{ }
						81
						{Continue}
						1
						{ }
						81
						{Return to Top Menu}
						2
						{ }
						67
						35
						142
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(PrintD
							{Back-ordered; none currently available.}
							101
							81
							{Continue}
							1
							67
							73
							142
						)
						(= cycles 1)
					)
					(1
						(gLongSong number: (Random 392 395) play:)
						(= cycles 1)
					)
					(2
						(gLongSong number: (Random 392 395) play:)
						(client setScript: startTerminal)
					)
				)
			)
			(2
				2
				(localproc_0
					{- Electronic Gadgets -}
					{Realrustic (TM) Dodecaphonic AroundSound Processor. \n\nEver notice how flat and unexciting normal Stereophonic, Quintophonic and Octophonic recordings are? With the Realrustic(TM) Dodecaphonic AroundSound Processor, your music will seem to come from 12 directions: in front of you, behind you, either side of you, four midpoints in between, above you, below you, from inside of you and from the upstairs neighbors. 877 Buckazoids. Discontinued. }
					102
					(proc0_18 global138 global137)
				)
				(switch
					(PrintD
						{ }
						81
						{Order}
						0
						{ }
						81
						{Continue}
						1
						{ }
						81
						{Return to Top Menu}
						2
						{ }
						67
						40
						152
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(PrintD
							{Sorry - Discontinued.  }
							81
							{Continue}
							1
							67
							60
							152
						)
						(gLongSong number: (Random 392 395) play:)
						(= cycles 1)
					)
					(1
						(gLongSong number: (Random 392 395) play:)
						(= cycles 1)
					)
					(2
						(gLongSong number: (Random 392 395) play:)
						(client setScript: startTerminal)
					)
				)
			)
			(3
				3
				(localproc_0
					{- Electronic Gadgets -}
					{CDGIROMTV \n\nMove over, CD-ROM, CD-G, CD-I, and CDTV! \nThe Realrustic(TM) CDGIROMTV does everything the others do and MORE! Besides accepting the formats listed above, CDGIROMTV also plays high-quality Laserdisc movies, sure to become popular any century now. 842 Buckazoids. Estimated delivery: Summer 2735. }
					102
					(proc0_18 global138 global137)
				)
				(switch
					(PrintD
						{ }
						81
						{Order}
						0
						{ }
						81
						{Continue}
						1
						{ }
						81
						{Return to Top Menu}
						2
						{ }
						67
						35
						142
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(PrintD
							{Sorry - Estimated delivery:\nSummer 2735.}
							101
							81
							{Continue}
							1
							67
							80
							132
						)
						(gLongSong number: (Random 392 395) play:)
						(= cycles 1)
					)
					(1
						(gLongSong number: (Random 392 395) play:)
						(= cycles 1)
					)
					(2
						(gLongSong number: (Random 392 395) play:)
						(client setScript: startTerminal)
					)
				)
			)
			(4
				(localproc_0
					{- Electronic Gadgets -}
					(Format
						@temp0
						{PocketPal Portable Terminal \n\n"Say, is that a complete workstation in your pocket, or are you just glad to see me?" Now you can carry the power of a dumb terminal around with you without even creasing your jumpsuit. Includes RIGA-compatible monitor (Really Incredible Graphics Adapter), chiclet-style keyboard and Dentyne-style mouse.  %u Buckazoids. }
						(Max (+ gBuckazoidCount 1) 2001)
					)
					102
					(proc0_18 global138 global137)
				)
				(switch
					(PrintD
						{ }
						81
						{Order}
						0
						{ }
						81
						{Continue}
						1
						{ }
						81
						{Return to Top Menu}
						2
						{ }
						67
						35
						144
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(PrintD
							{You do not possess the necessary number of Buckazoids.}
							67
							60
							144
						)
						(= cycles 1)
					)
					(1
						(gLongSong number: (Random 392 395) play:)
						(= cycles 1)
					)
					(2
						(gLongSong number: (Random 392 395) play:)
						(client setScript: startTerminal)
					)
				)
			)
			(5
				5
				(localproc_0
					{- Electronic Gadgets -}
					{PocketPal Connector \n\nIf you are a proud owner of our ever-popular PocketPal Portable Terminal, you have no doubt noticed that, without the proper connector, it is virtually useless.   Fortunately, at this moment, our exclusive PocketPal Connector is on sale for just 1999 Buckazoids!  Get yours now, before the price goes up even further. }
					102
					(proc0_18 global138 global137)
				)
				(switch
					(PrintD
						{ }
						81
						(if (or (gEgo has: 11) (IsFlag 71)) ; plug
							{Exchange}
						else
							{Order}
						)
						0
						{ }
						81
						{Continue}
						1
						{ }
						81
						{Return to Top Menu}
						2
						{ }
						67
						35
						132
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(cond
							((or (gEgo has: 11) (IsFlag 71)) ; plug
								(PrintD
									{With many a grind, moan and "Well, I dunno...", the salesbot finally allows you to exchange the plug. }
									67
									60
									132
								)
								(self setScript: choosePlug self)
							)
							((>= gBuckazoidCount 1999)
								(PrintD
									{With great patience, you insert each and every one of the 1999 buckazoids into the salesbot's coin receptor. }
									67
									60
									132
								)
								(if (< (-= gBuckazoidCount 1999) 1)
									(gEgo put: 0) ; buckazoid
								)
								(SetScore 84 15)
								(gEgo get: 11) ; plug
								(self setScript: choosePlug self)
							)
							(else
								(PrintD
									{You do not possess the necessary number of Buckazoids.}
									67
									60
									132
								)
								(= cycles 1)
							)
						)
					)
					(1
						(gLongSong number: (Random 392 395) play:)
						(= cycles 1)
					)
					(2
						(gLongSong number: (Random 392 395) play:)
						(client setScript: startTerminal)
					)
				)
			)
			(6
				6
				(localproc_0
					{- Electronic Gadgets -}
					{The Acronymizer \n\nIn today's hi-tech workaday world, there are just too many acronyms to remember...resulting in CHAOS (Collective Hi-tech Acronym Overexposure Syndrome). With this handy-dandy pocket translator, you merely punch in the acronym ASAP and see what they're REALLY saying PDQ! 212 Buckazoids. Not available in Galaxy Galleria, Alpha Centauri or Peoria stores. }
					102
					(proc0_18 global138 global137)
				)
				(switch
					(PrintD
						{ }
						81
						{Order}
						0
						{ }
						81
						{Catalog Menu}
						1
						{ }
						81
						{Top Menu}
						2
						{ }
						67
						35
						142
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(PrintD
							{Sorry - Not available in Galaxy Galleria, Alpha Centauri or Peoria stores.}
							101
							81
							{Return to Catalog Menu}
							1
							67
							65
							132
						)
						(gLongSong number: (Random 392 395) play:)
						(self changeState: 0)
					)
					(1
						(gLongSong number: (Random 392 395) play:)
						(self changeState: 0)
					)
					(2
						(gLongSong number: (Random 392 395) play:)
						(client setScript: startTerminal)
					)
				)
			)
			(7
				7
				(localproc_0
					{- Electronic Mommy -}
					{Iceman(TM) Pocket Ice Machine \n\nThis miracle of modern engineering fits in purse or pocketbook and freezes 15 pounds of ice cubes per hour. Choose from ice slices, cubes, rounds or crushed. Requires mini hydrogen and oxygen cannisters, sold separately. Breaks the ice at parties. 300 Buckazoids. Recalled by manufacturer. }
					102
					(proc0_18 global138 global137)
				)
				(switch
					(PrintD
						{ }
						81
						{Order}
						0
						{ }
						81
						{Continue}
						1
						{ }
						81
						{Return to Top Menu}
						2
						{ }
						67
						35
						136
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(PrintD
							{Sorry - Recalled by manufacturer.  }
							81
							{Continue}
							1
							67
							35
							146
						)
						(gLongSong number: (Random 392 395) play:)
						(= cycles 1)
					)
					(1
						(gLongSong number: (Random 392 395) play:)
						(= cycles 1)
					)
					(2
						(gLongSong number: (Random 392 395) play:)
						(client setScript: startTerminal)
					)
				)
			)
			(8
				8
				(localproc_0
					{- Electronic Mommy -}
					{EpiChia \n\nNow you can remove unsightly chia growth from upper lip, legs, "bikini area" and small clay figurines. Painless and electronic. Almost tickles once you get used to it. Instantly cauterizes major blood vessels. Battery-operated; 32v dry cell not included. 32 Buckazoids. Not available in the Spiral Arm. }
					102
					(proc0_18 global138 global137)
				)
				(switch
					(PrintD
						{ }
						81
						{Order}
						0
						{ }
						81
						{Continue}
						1
						{ }
						81
						{Return to Top Menu}
						2
						{ }
						67
						35
						125
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(PrintD
							{Sorry - Not available in the Spiral Arm.  }
							101
							81
							{Continue}
							1
							67
							70
							120
						)
						(gLongSong number: (Random 392 395) play:)
						(= cycles 1)
					)
					(1
						(gLongSong number: (Random 392 395) play:)
						(= cycles 1)
					)
					(2
						(gLongSong number: (Random 392 395) play:)
						(client setScript: startTerminal)
					)
				)
			)
			(9
				9
				(localproc_0
					{- Electronic Mommy -}
					{Dandy Recipe Beamer \n\nImagine the situation. The Ambassador from Kerona is coming for dinner, and all you have handy is a can of condensed Cream of Orat Soup and a box of Nano Wafers. You punch the appropriate buttons on your Recipe Beamer and instantly, from our Recipe Satellite, we beam the perfect recipe back to you. Over 18 *trillion* recipes collected from all over the universe, just to make meal planning easier. 455 Buckazoids. Estimated date of uplink: November 2803. }
					102
					(proc0_18 global138 global137)
				)
				(switch
					(PrintD
						{ }
						81
						{Order}
						0
						{ }
						81
						{Continue}
						1
						{ }
						81
						{Return to top menu}
						2
						{ }
						67
						35
						153
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(PrintD
							{Sorry - Estimated date of uplink: November 2803.}
							101
							81
							{Continue}
							1
							67
							65
							145
						)
						(gLongSong number: (Random 392 395) play:)
						(= cycles 1)
					)
					(1
						(gLongSong number: (Random 392 395) play:)
						(= cycles 1)
					)
					(2
						(gLongSong number: (Random 392 395) play:)
						(client setScript: startTerminal)
					)
				)
			)
			(10
				10
				(localproc_0
					{- Electronic Mommy -}
					{Cyber-Depunker \n\nIf your offspring is turning out to be "just another rotten Cyberpunk," you need the Dandy Cyber-Depunker. Works while your child sleeps to replace those black market implants with healthy tissue, removes antiproductive attitudes and leaves a clean, fresh outlook. May cause some motor impairment and memory loss, but isn't that a small price to pay? Battery operated. 580 Buckazoids. Currently under UCC investigation. }
					102
					(proc0_18 global138 global137)
				)
				(switch
					(PrintD
						81
						{Order}
						0
						{ }
						81
						{Return to Catalog Menu}
						1
						{ }
						81
						{Top Menu}
						2
						67
						20
						155
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(PrintD
							{Sorry - Currently under UCC investigation.}
							101
							81
							{Continue}
							1
							67
							68
							140
						)
						(gLongSong number: (Random 392 395) play:)
						(self changeState: 0)
					)
					(1
						(gLongSong number: (Random 392 395) play:)
						(self changeState: 0)
					)
					(2
						(gLongSong number: (Random 392 395) play:)
						(client setScript: startTerminal)
					)
				)
			)
			(11
				11
				(localproc_0
					{TechnoTots Toys}
					{Armatroid 2500 \n\nA remote-control toy for all ages, the Armatroid 2500 is a mobile robotic arm that can swivel, turn, pick up light objects, tear wings off of flies, disembowel small mammals, and perform elective surgery. Teaches hand-eye coordination, elementary physics and self-control. 35 Buckazoids. Sold out. }
					102
					(proc0_18 global138 global137)
				)
				(switch
					(PrintD
						{ }
						81
						{Order}
						0
						{ }
						81
						{Continue}
						1
						{ }
						81
						{Return to Top Menu}
						2
						{ }
						67
						40
						135
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(PrintD
							{Sorry - Sold out.  }
							81
							{Continue}
							1
							67
							60
							135
						)
						(gLongSong number: (Random 392 395) play:)
						(= cycles 1)
					)
					(1
						(gLongSong number: (Random 392 395) play:)
						(= cycles 1)
					)
					(2
						(gLongSong number: (Random 392 395) play:)
						(client setScript: startTerminal)
					)
				)
			)
			(12
				12
				(localproc_0
					{TechnoTots Toys}
					{YoBot, the Ramboid Robot \n\nHaving YoBot in the house is like having an extra playmate around, armed to the teeth with bazookas, laser pistols, and an authentic live nuclear warhead! Light-activated sensors keep YoBot from bumping into walls or falling off tables, and a darn good thing, too. Responds to voice commands with an authoritative, "Yo!" 69 Buckazoids. Discontinued. }
					102
					(proc0_18 global138 global137)
				)
				(switch
					(PrintD
						{ }
						81
						{Order}
						0
						{ }
						81
						{Continue}
						1
						{ }
						81
						{Return to Top Menu}
						2
						{ }
						67
						35
						135
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(PrintD
							{Sorry - Discontinued.  }
							81
							{Continue}
							1
							67
							50
							142
						)
						(gLongSong number: (Random 392 395) play:)
						(= cycles 1)
					)
					(1
						(gLongSong number: (Random 392 395) play:)
						(= cycles 1)
					)
					(2
						(gLongSong number: (Random 392 395) play:)
						(client setScript: startTerminal)
					)
				)
			)
			(13
				13
				(localproc_0
					{TechnoTots Toys}
					{Realrustic(TM) Whether Radio \n\nHours of fun! Looks like a cube with an antenna. Press the bar and get a burst of static. If you can figure out whether or not it's a radio, you're smarter than we are. Requires one 9v battery. Ability to pull in stations and reproduce sounds not included. 20 Buckazoids. Due to delay in manufacturing, this item is not yet available. }
					102
					(proc0_18 global138 global137)
				)
				(switch
					(PrintD
						{ }
						81
						{Order}
						0
						{ }
						81
						{Continue}
						1
						{ }
						81
						{Return to Top Menu}
						2
						{ }
						67
						35
						140
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(PrintD
							{Sorry - Due to delay in manufacturing, this item\nis not yet available.}
							101
							81
							{Continue}
							1
							67
							87
							125
						)
						(gLongSong number: (Random 392 395) play:)
						(= cycles 1)
					)
					(1
						(gLongSong number: (Random 392 395) play:)
						(= cycles 1)
					)
					(2
						(gLongSong number: (Random 392 395) play:)
						(client setScript: startTerminal)
					)
				)
			)
			(14
				14
				(localproc_0
					{TechnoTots Toys}
					{Realrustic(TM) Universal Remote Control \n\nControl the entire universe with one remote control! Open garage doors on other planets, turn off crucial life support systems on passing spaceships, terrify primitive cultures. 1000 light year range, slightly less indoors. Requires one AAA battery, not included. 1050 Buckazoids. Sold out. }
					102
					(proc0_18 global138 global137)
				)
				(switch
					(PrintD
						{ }
						81
						{Order}
						0
						{ }
						81
						{Return to Top Menu}
						1
						{ }
						67
						60
						132
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(PrintD
							{Sorry - Sold out.  }
							81
							{Continue}
							1
							67
							80
							132
						)
						(gLongSong number: (Random 392 395) play:)
						(client setScript: startTerminal)
					)
					(1
						(gLongSong number: (Random 392 395) play:)
						(client setScript: startTerminal)
					)
				)
			)
			(15
				15
				(client setScript: startTerminal)
			)
		)
	)
)

(instance backToRob of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_14 10)
				(= gSystemWindow local1)
				(= gUserFont local2)
				(gCurRoom style: 30 drawPic: 391)
				(gCast eachElementDo: #show)
				(gAddToPics add: roboHead eachElementDo: #init doit:)
				(gEgo hide:)
				(= seconds 3)
			)
			(1
				(chest dispose:)
				(= cycles 2)
			)
			(2
				(self
					setScript:
						roboTalk
						self
						{ THANK YOU\nFOR SHOPPING\nRADIO SHOCK!}
				)
				(= cycles 5)
			)
			(3
				(HandsOn)
				(gCurRoom newRoom: 390)
			)
		)
	)
)

(instance choosePlug of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 803 100)
				(= register (List new:))
				(for ((= temp0 0)) (< temp0 10) ((++ temp0))
					(= temp2 (+ 120 (* 50 (/ temp0 5))))
					(= temp3 (+ 30 (* 30 (mod temp0 5))))
					((= temp1 (connector new:))
						setCel: temp0
						x: temp2
						y: temp3
						init:
					)
					(register addToFront: temp1)
				)
				(Display
					{Select the plug you\n wish to purchase.}
					dsCOORD
					97
					163
					dsCOLOR
					global135
				)
			)
			(1
				(register eachElementDo: #dispose)
				(= cycles 2)
			)
			(2
				(register dispose:)
				(self dispose:)
			)
		)
	)
)

(instance eyes of Prop
	(properties
		x 162
		y 25
		description {salesbot's eyes}
		lookStr { The salesbot's eyes seem to be having a hard time focusing on you.}
		view 391
		loop 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Do
				(Print 391 2) ; "Be reasonable. What would you do with robot eyes, anyway?"
			)
			(11 ; Smell
				(Print {The robot has your typical mechanical aromas.})
			)
			(10 ; Taste
				(Print
					{Your sense of appropriate public behavior leaves a lot to be desired.}
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lEar of Prop
	(properties
		x 79
		y 26
		description {salesbot's ear}
		lookStr {The salesbot's ear just spins around and around. Probably one of those "sensor-round" models.}
		view 391
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Taste
				(Print 391 3) ; "I know you're lonely, but licking a robot's ear?"
			)
			(11 ; Smell
				(Print {The robot has your typical mechanical aromas.})
			)
			(10 ; Taste
				(Print
					{Your sense of appropriate public behavior leaves a lot to be desired.}
				)
			)
			(2 ; Do
				(Print 391 4) ; "Don't touch the robot's ear. You don't know where it's been."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rEar of Prop
	(properties
		x 245
		y 26
		description {salesbot's ear}
		lookStr {The salesbot's ear just spins around and around. Probably one of those "sensor-round" models.}
		view 391
		loop 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Taste
				(Print 391 3) ; "I know you're lonely, but licking a robot's ear?"
			)
			(11 ; Smell
				(Print {The robot has your typical mechanical aromas.})
			)
			(10 ; Taste
				(Print
					{Your sense of appropriate public behavior leaves a lot to be desired.}
				)
			)
			(2 ; Do
				(Print 391 4) ; "Don't touch the robot's ear. You don't know where it's been."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mouth of Prop
	(properties
		x 162
		y 60
		description {salesbot's mouth}
		lookStr {The salesbot flashes you a grin.}
		view 391
		loop 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Taste
				(Print 391 5) ; "Everyone knows that licking a salesbot on the mouth is like plugging your tongue into a wall socket."
			)
			(11 ; Smell
				(Print 391 6) ; "Ozone oozes from his frantically flashing lips."
			)
			(2 ; Do
				(Print 391 7) ; "You should stay out of the mouths of others."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance roboHead of Prop
	(properties
		x 160
		y 9
		description {salesbot's head}
		lookStr {There's probably not much in this robot's head.}
		view 391
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Taste
				(Print
					{Your sense of appropriate public behavior leaves a lot to be desired.}
				)
			)
			(11 ; Smell
				(Print 391 8) ; "Smells like he put too much "Lube-Ina-Tube" on this morning."
			)
			(2 ; Do
				(Print 391 9) ; "Hey! Leave the head alone!"
			)
			(4 ; Talk
				(Print 391 10) ; "This model is not programmed to talk with the customers. You must interact with him through his touch-screen chest monitor."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance chest of View
	(properties
		x 161
		y 189
		description {the friendly salesbot's touch-screen chest monitor}
		view 393
	)

	(method (onMe param1)
		(return
			(and
				(<= nsLeft (param1 x:) nsRight)
				(<= nsTop (param1 y:) nsBottom)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Taste
				(Print 391 11) ; "The friendly salesbot smiles at you and thanks you for licking his chest monitor clean."
			)
			(11 ; Smell
				(Print 391 12) ; "It smells dusty - like old electronics."
			)
			(else
				(gCurRoom setScript: startTerminal)
			)
		)
	)
)

(instance connector of View
	(properties
		description {PocketPal(tm) connector plug}
		lookStr {One of several varieties of PocketPal(tm) connector plug.}
		view 391
		loop 5
		priority 15
		signal 16
	)

	(method (init)
		(super init:)
		(gWalkHandler addToFront: self)
		(gPrints addToFront: self)
	)

	(method (delete)
		(super delete:)
		(gWalkHandler delete: self)
		(gPrints delete: self)
	)

	(method (handleEvent event)
		(if
			(or
				(MousedOn self event)
				(and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
			)
			(event claimed: 1)
			((gInventory at: 11) state: cel) ; plug
			(choosePlug cue:)
		)
	)
)

(instance BlueWindow of SysWindow
	(properties)
)

(instance robotEarSnd of Sound
	(properties
		number 875
		vol 65
		loop -1
	)
)

