;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 391)
(include sci.sh)
(use Main)
(use Interface)
(use SQRoom)
(use Osc)
(use n940)
(use RandCycle)
(use Window)
(use Motion)
(use Actor)
(use System)

(public
	rm391 0
)

(local
	local0
	local1
)

(procedure (localproc_0)
	(= gSystemWindow local1)
	(Print &rest)
	(= gSystemWindow BlackWindow)
)

(instance rm391 of SQRoom
	(properties
		picture 391
		style 30
		south 390
	)

	(method (init)
		(self setRegions: 700) ; mall
		(gEgo init: hide:)
		(= local1 gSystemWindow)
		(= gSystemWindow (BlackWindow color: global135 back: global129))
		(roboHead init:)
		(lEar init: setCycle: Fwd)
		(rEar init: setCycle: Fwd)
		(mouth init: setCycle: RandCycle)
		(eyes init: setCycle: Osc)
		(gLongSong number: 0 loop: 1 vol: 127 stop:)
		(super init:)
		(gLongSong2 number: 396 loop: 1 playBed:)
		(self setRegions: 700 setScript: welcomeSir) ; mall
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
				(Display 391 0 dsRESTOREPIXELS local0)
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
				(self setScript: roboTalk self {WELCOME TO\nRADIO SHOCK!})
			)
			(2
				(= cycles 2)
			)
			(3
				(self setScript: roboTalk self {ALLOW ME TO\n__SERVE YOU!})
			)
			(4
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 803)
				(= seconds 2)
			)
			(5
				(client setScript: startTerminal)
			)
		)
	)
)

(instance startTerminal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch
					(PrintD
						{___}
						101
						{ }
						101
						81
						{Instructions}
						0
						101
						{ }
						101
						81
						{Limited-time Specials}
						1
						101
						{ }
						101
						81
						{Shop With Our Automated Catalog}
						2
						101
						{ }
						101
						81
						{Exit to friendly salesbot}
						3
						80
						{- Automated Catalog Terminal -}
						67
						60
						36
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(client setScript: doInstructions)
					)
					(1
						(gLongSong number: (Random 392 395) play:)
						(client setScript: doSpecials)
					)
					(2
						(gLongSong number: (Random 392 395) play:)
						(client setScript: doCatalog)
					)
					(3
						(gLongSong number: (Random 392 395) play:)
						(client setScript: backToRob)
					)
				)
			)
		)
	)
)

(instance doInstructions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(PrintD
						{Welcome to the Radio Shock Automated Catalog! Let us be your gateway to what's new and exciting in the world of 24th Century Electronics. \n\nThrough the pages of our Automated Catalog, you will find gifts for the whole family. For Dad, look in Electronic Gadgets for our selection of Realrustic Stereo Components. For Mom, peek into The Electronic Mommy for a variety of labor-saving devices and marital aids! For Sis and Little Brother, browse our TechnoTots(R) Toy department for the latest in electronic playborgs! }
						101
						81
						{Continue}
						0
						101
						81
						{Return to Top Menu}
						1
						80
						{INSTRUCTIONS}
						67
						60
						32
					)
					(gLongSong number: (Random 392 395) play:)
					(client setScript: startTerminal)
				else
					(gLongSong number: (Random 392 395) play:)
					(if
						(PrintD
							{Shopping our Automated Catalog is as easy as snapping your digital appendages. Using your mouse or cursor, simply point to the menu item of your choice and press <CR> or click the left mouse button. Should you get confused, simply return to the Top Menu and begin anew. \n\nThank you for choosing Radio Shock for all your electronic needs! We know you'll find just what you're looking for, and if you don't, we're wrong and you should look somewhere else. \n\n__--Your Radio Shock Manager }
							101
							81
							{Return to Top Menu}
							0
							101
							81
							{Limited Time Specials}
							1
							80
							{INSTRUCTIONS}
							67
							60
							32
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
				(if
					(PrintD
						{These Special Sale Items are available for a limited time only. Availability is limited to items in stock, as-is only, no returns. Some items may be demo models, scratched, dented, or just not in very good shape. No warranties, express or implied, apply to these items. No refund or exchange. }
						101
						{ }
						101
						81
						{Continue}
						0
						101
						81
						{Return to Top Menu}
						1
						80
						{SPECIALS}
						67
						60
						32
					)
					(gLongSong number: (Random 392 395) play:)
					(client setScript: startTerminal)
				else
					(gLongSong number: (Random 392 395) play:)
					(switch
						(PrintD
							{ReShrinkwrap 2000 \n\nWork for a large retail software chain? Like to take the products home and diddle with them? The ReShrinkwrap 2000 reshrinkwraps any size software box. Is that game new or used? Only you'll know for sure! Keeps the customers guessing. DEALERS ONLY, please. 1033 Buckazoids. }
							101
							{ }
							101
							81
							{Order}
							0
							101
							81
							{Continue}
							1
							101
							81
							{Return to Top Menu}
							2
							67
							60
							32
							80
							{SPECIALS}
						)
						(0
							(gLongSong number: (Random 392 395) play:)
							(PrintD
								{Sorry - dealers only!}
								101
								{ }
								101
								81
								{Continue}
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
				(switch
					(PrintD
						{DuaPhunki Answering Machine \n\nThe ultimate in hi-tech answering machines. Not a phone device. Carry it around with you. If somebody asks you a question, the DuaPhunki will give the correct answer. If it doesn't know the answer, it'll make a good guess. Won't discuss politics or religion. 117 Buckazoids. Sold out. }
						101
						{ }
						101
						81
						{Order}
						0
						101
						81
						{Continue}
						1
						101
						81
						{Return to Top Menu}
						2
						67
						60
						32
						80
						{SPECIALS}
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(PrintD {Sorry - sold out} 101 { } 101 81 {Continue})
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
				(switch
					(PrintD
						{Cheese Wiz II \n\nPreprogrammed with over 350 varieties of cheese, Cheese Wiz II will tell you the precise temperature at which to serve that beautiful round of aged Cheddar or that oozing slice of soft- ripened Brie. A must for all cheese lovers. Will not work with aerosol cheese food products. 25 Buckazoids. Not available as such. }
						101
						{ }
						101
						81
						{Order}
						0
						101
						81
						{Return to Top Menu}
						1
						101
						81
						{Shop With Our Automated Catalog}
						2
						67
						60
						34
						80
						{SPECIALS}
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(PrintD
							{Sorry - Not available as such.}
							101
							{ }
							101
							81
							{Return to Top Menu}
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

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(self
					changeState:
						(PrintD
							{Welcome to our Automated Catalog!__Please select from the following departments: }
							101
							{ }
							101
							81
							{Electronic Gadgets}
							1
							101
							{ }
							101
							81
							{The Electronic Mommy}
							7
							101
							{ }
							101
							81
							{TechnoTots(R) Toy Dept.}
							11
							101
							{ }
							101
							81
							{Return to Top Menu}
							15
							67
							60
							32
							80
							{- Automated Catalog -}
						)
						(gLongSong number: (Random 392 395) play:)
				)
			)
			(1
				1
				(switch
					(PrintD
						{Realrustic(TM) Faux-Component(R) Swiss Army MicroEntertainment Center \nStyled to look like a real set of miniature components, this is a complete home entertainment center in one 4"x 6" box! Includes CD-ROM unit, turntable, dual cassette with Hyperwow and MegaFlutter, unfolding 84" digital color projection multiscreen TV, corkscrew and toothpick. 2275 Buckazoids. Back-ordered; none currently available. }
						101
						{ }
						101
						81
						{Order}
						0
						101
						81
						{Continue}
						1
						101
						81
						{Return to Top Menu}
						2
						67
						60
						32
						80
						{- Electronic Gadgets -}
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(PrintD
							{Back-ordered; none currently available.}
							101
							{ }
							101
							81
							{Continue}
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
				(switch
					(PrintD
						{Realrustic (TM) Dodecaphonic AroundSound Processor. \nEver notice how flat and unexciting normal Stereophonic, Quintophonic and Octophonic recordings are? With the Realrustic(TM) Dodecaphonic AroundSound Processor, your music will seem to come from 12 directions: in front of you, behind you, either side of you, four midpoints inbetween, above you, below you, from inside of you and from the upstairs neighbors. 877 Buckazoids. Discontinued. }
						101
						81
						{Order}
						0
						101
						81
						{Continue}
						1
						101
						81
						{Return to Top Menu}
						2
						67
						60
						32
						80
						{- Electronic Gadgets -}
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(PrintD
							{Sorry - Discontinued.}
							101
							{ }
							101
							81
							{Continue}
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
				(switch
					(PrintD
						{CDGIROMTV \n\nMove over, CD-ROM, CD-G, CD-I, and CDTV! The Realrustic(TM) CDGIROMTV does everything the others do and MORE! Besides accepting the formats listed above, CDGIROMTV also plays high-quality Laserdisc movies, sure to become popular any century now. 842 Buckazoids. Estimated delivery: Summer 2735. }
						101
						{ }
						101
						81
						{Order}
						0
						101
						81
						{Continue}
						1
						101
						81
						{Return to Top Menu}
						2
						67
						60
						32
						80
						{- Electronic Gadgets -}
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(PrintD
							{Sorry - Estimated delivery: Summer 2735.}
							101
							{ }
							101
							81
							{Continue}
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
				4
				(switch
					(PrintD
						{PocketPal Portable Terminal \n\n"Say, is that a complete workstation in your pocket, or are you just glad to see me?" Now you can carry the power of a dumb terminal around with you without even creasing your jumpsuit. Includes RIGA-compatible monitor (Really Incredible Graphics Adapter), chiclet-style keyboard and dentyne-style mouse.__2001 Buckazoids. }
						101
						{ }
						101
						81
						{Order}
						0
						101
						81
						{Continue}
						1
						101
						81
						{Return to Top Menu}
						2
						67
						60
						32
						80
						{- Electronic Gadgets -}
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(localproc_0 391 1) ; "You do not possess the necessary number of Buckazoids."
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
				(switch
					(PrintD
						{PocketPal Connector \n\nIf you are a proud owner of our ever-popular PocketPal Portable Terminal, you have no doubt noticed that, without the proper connector, it is virtually useless.___Fortunately, at this moment, our exclusive PocketPal Connector is on sale for just 1999 Buckazoids!__Get yours now, before the price goes up even further. }
						101
						{ }
						101
						81
						(if (gEgo has: 12) {Exchange} else {Order}) ; plug
						0
						101
						81
						{Continue}
						1
						101
						81
						{Return to Top Menu}
						2
						67
						60
						32
						80
						{- Electronic Gadgets -}
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(cond
							((gEgo has: 12) ; plug
								(localproc_0
									{With many a grind, moan and "Well I dunno", the salesbot finally allows you to exchange the plug. }
								)
								(self setScript: choosePlug self)
							)
							((>= gBuckazoidCount 1999)
								(localproc_0
									{With great patience, you insert each and every one of the 1999 buckazoids into the salesbot's coin receptor. }
								)
								(localproc_0
									{Within seconds, your new PocketPal Portable Terminal Connector is inserted into your pocket by a friendly little robot. }
								)
								(= gBuckazoidCount 1)
								(gEgo get: 12) ; plug
								(self setScript: choosePlug self)
							)
							(else
								(localproc_0 391 1) ; "You do not possess the necessary number of Buckazoids."
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
				(switch
					(PrintD
						{The Acronymizer \n\nIn today's hi-tech workaday world, there are just too many acronyms to remember...resulting in CHAOS (Collective Hi-tech Acronym Overexposure Syndrome). With this handy-dandy pocket translator, you merely punch in the acronym ASAP and see what they're REALLY saying PDQ! 212 Buckazoids. Not available in Galaxy Galleria, Alpha Centauri or Peoria stores. }
						101
						{ }
						101
						81
						{Order}
						0
						101
						81
						{Return to Catalog Menu}
						1
						101
						81
						{Return to Top Menu}
						2
						67
						60
						32
						80
						{- Electronic Gadgets -}
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(PrintD
							{Sorry - Not available in Galaxy Galleria, Alpha Centauri or Peoria stores.}
							101
							{ }
							101
							81
							{Return to Catalog Menu}
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
				(switch
					(PrintD
						{Iceman(TM) Pocket Ice Machine \n\nThis miracle of modern engineering fits in purse or pocketbook and freezes 15 pounds of icecubes per hour. Choose from ice slices, cubes, rounds or crushed. Requires mini hydrogen and oxygen cannisters, sold separately. Breaks the ice at parties. 300 Buckazoids. Recalled by manufacturer. }
						101
						{ }
						101
						81
						{Order}
						0
						101
						81
						{Continue}
						1
						101
						81
						{Return to Top Menu}
						2
						67
						60
						32
						80
						{- Electronic Mommy -}
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(PrintD
							{Sorry - Recalled by manufacturer.}
							101
							{ }
							101
							81
							{Continue}
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
				(switch
					(PrintD
						{EpiChia \n\nNow you can remove unsightly chia growth from upper lip, legs, "bikini area" and small clay figurines. Painless and electronic. Almost tickles once you get used to it. Instantly cauterizes major blood vessels. Battery-operated; 32 V. dry cell not included. 32 Buckazoids. Not available in the Spiral Arm. }
						101
						{ }
						101
						81
						{Order}
						0
						101
						81
						{Continue}
						1
						101
						81
						{Return to Top Menu}
						2
						67
						60
						32
						80
						{- Electronic Mommy -}
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(PrintD
							{Sorry - Not available in the Spiral Arm.}
							101
							{ }
							101
							81
							{Continue}
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
				(switch
					(PrintD
						{Dandy Recipe Beamer \nImagine the situation. The Ambassador from Kerona is coming for dinner, and all you have handy is a can of condensed Cream of Orat Soup and a box of Nano Wafers. You punch the appropriate buttons on your Recipe Beamer and instantly, from our Recipe Satellite, we beam the perfect recipe back to you. Over 18 *trillion* recipes collected from all over the universe, just to make meal planning easier. 455 Buckazoids. Estimated date of uplink: November 2803. }
						101
						81
						{Order}
						0
						101
						81
						{Continue}
						1
						101
						81
						{Return to top menu}
						2
						67
						60
						32
						80
						{- Electronic Mommy -}
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(PrintD
							{Sorry - Estimated date of uplink: November 2803.}
							101
							{ }
							101
							81
							{Continue}
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
				(switch
					(PrintD
						{Cyber-Depunker \nIf your offspring is turning out to be "just another rotten Cyberpunk," you need the Dandy Cyber-Depunker. Works while your child sleeps to replace those black market implants with healthy tissue, removes antiproductive attitudes and leaves a clean, fresh outlook. May cause some motor impairment and memory loss, but isn't that a small price to pay? Battery operated. 580 Buckazoids. Currently under UCC investigation. }
						101
						81
						{Order}
						0
						101
						81
						{Return to Catalog Menu}
						1
						101
						81
						{Return to Top Menu}
						2
						67
						60
						32
						80
						{- Electronic Mommy -}
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(PrintD
							{Sorry - Currently under UCC investigation.}
							101
							{ }
							101
							81
							{Continue}
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
				(switch
					(PrintD
						{Armatroid 2500 \nA remote-control toy for all ages, the Armatroid 2500 is a mobile robotic arm that can swivel, turn, pick up light objects, tear wings off of flies, disembowel small mammals, and perform elective surgery. Teaches hand-eye coordination, elementary physics and self-control. 35 Buckazoids. Sold out. }
						101
						81
						{Order}
						0
						101
						81
						{Continue}
						1
						101
						81
						{Return to Top Menu}
						2
						67
						60
						32
						80
						{TechnoTots Toys}
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(PrintD
							{Sorry - Sold out.}
							101
							{ }
							101
							81
							{Continue}
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
				(switch
					(PrintD
						{YoBot, the Ramboid Robot \nHaving YoBot in the house is like having an extra playmate around, armed to the teeth with bazookas, laser pistols, and an authentic live nuclear warhead! Light-activated sensors keep YoBot from bumping into walls or falling off tables, and a darn good thing, too. Responds to voice commands with an authoritative, "Yo!" 69 Buckazoids. Discontinued. }
						101
						81
						{Order}
						0
						101
						81
						{Continue}
						1
						101
						81
						{Return to Top Menu}
						2
						67
						60
						32
						80
						{TechnoTots Toys}
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(PrintD
							{Sorry - Discontinued.}
							101
							{ }
							101
							81
							{Continue}
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
				(switch
					(PrintD
						{Realrustic(TM) Whether Radio \nHours of fun! Looks like a cube with an antenna. Press the bar and get a burst of static. If you can figure out whether or not it's a radio, you're smarter than we are. Requires 1 9v battery. Ability to pull in stations and reproduce sounds not included. 20 Buckazoids. Due to delay in manufacturing, this item is not yet available. }
						101
						81
						{Order}
						0
						101
						81
						{Continue}
						1
						101
						81
						{Return to Top Menu}
						2
						67
						60
						32
						80
						{TechnoTots Toys}
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(PrintD
							{Sorry - Due to delay in manufacturing, this item is not yet available.}
							101
							{ }
							101
							81
							{Continue}
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
				(switch
					(PrintD
						{Realrustic(TM) Universal Remote Control \n\nControl the entire universe with one remote control! Open garage doors on other planets, turn off crucial life support systems on passing spaceships, terrify primitive cultures. 1000 light year range, slight less indoors. Requires one AAA battery, not included. 1050 Buckazoids. Sold out. }
						101
						{ }
						101
						81
						{Order}
						0
						101
						81
						{Return to Top Menu}
						1
						67
						60
						32
						80
						{TechnoTots Toys}
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(PrintD
							{Sorry - Sold out.}
							101
							{ }
							101
							81
							{Continue}
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
				(DisposeScript 940)
				(= gSystemWindow local1)
				(gCurRoom drawPic: 391)
				(gCast eachElementDo: #show)
				(gEgo hide:)
				(= seconds 3)
			)
			(1
				(self
					setScript:
						roboTalk
						self
						{ THANK YOU\nFOR SHOPPING\nRADIO SHOCK!}
				)
				(= cycles 2)
			)
			(2
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
		view 391
		loop 4
	)
)

(instance lEar of Prop
	(properties
		x 79
		y 26
		view 391
		loop 1
	)
)

(instance rEar of Prop
	(properties
		x 245
		y 26
		view 391
		loop 2
	)
)

(instance mouth of Prop
	(properties
		x 162
		y 60
		view 391
		loop 3
	)
)

(instance roboHead of Prop
	(properties
		x 160
		y 9
		view 391
	)
)

(instance BlackWindow of SysWindow
	(properties)
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
		(gGameControls addToFront: self)
	)

	(method (delete)
		(super delete:)
		(gGameControls delete: self)
	)

	(method (handleEvent event)
		(if (MousedOn self event)
			(event claimed: 1)
			((gInventory at: 12) state: cel) ; plug
			(choosePlug cue:)
		)
	)
)

