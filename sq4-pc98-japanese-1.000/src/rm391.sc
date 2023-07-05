;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 391)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use Language)
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
	(Display &rest dsWIDTH 300 dsCOORD 10 32 dsFONT 0)
)

(instance rm391 of SQRoom
	(properties
		picture 391
		style 10
	)

	(method (init)
		(LoadMany rsPIC 392 393 803)
		(LoadMany rsSOUND 875 392 393 394 395)
		(Load rsFONT 0)
		(= local1 gSystemWindow)
		(= local2 gUserFont)
		(lEar init: setCycle: Fwd)
		(rEar init: setCycle: Fwd)
		(theMouth init: setCycle: RandCycle)
		(theEyes init: setCycle: Osc)
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
			(2 ; Look
				(Print 391 0) ; "The rest of the store seems to be pretty empty. But everything is available through the friendly salesbot."
			)
			(1 ; Walk
				(gCurRoom newRoom: 390)
			)
			(11 ; Smell
				(Print 391 1) ; "This whole place smells musty and dusty, just like an old escape pod you used to own... (er, well... borrowed)."
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

(instance roboTalk of Script ; UNUSED
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
						alCENTER
						dsFONT
						300
						dsCOLOR
						global136
						dsSAVEPIXELS
					)
				)
				(= seconds 3)
			)
			(1
				(Display 391 2 dsRESTOREPIXELS local0)
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
				(gTheIconBar disable:)
				(gTheIconBar curIcon: (gTheIconBar at: 2))
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
				(= gSystemWindow BlueWindow)
				(= gUserFont 0)
				(BlueWindow color: global189 back: global149)
				(DrawStatus {   } global129 0)
				(gCast eachElementDo: #hide)
				(if (== (gCurRoom style:) 13)
					(gCurRoom style: 14)
				)
				(gCurRoom drawPic: 392)
				(= seconds 1)
			)
			(1
				(if
					(not
						(= register
							(PrintD
								{  }
								81
								{Instructions#j\9a\de\91\fd\e5\92}
								doInstructions
								{  }
								81
								{Specials#j\bd\cd\df\bc\ac\d9\be\b0\d9}
								doSpecials
								{  }
								81
								{Catalog#j\b5\b0\c4\b6\c0\db\b8\de}
								doCatalog
								{  }
								81
								{Exit#j\f4\f2\f9 }
								backToRob
								{ }
								67
								-1
								130
							)
						)
					)
					(= register backToRob)
				)
				(gCurRoom style: 13)
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

	(method (changeState newState &tmp [temp0 750])
		(switch (= state newState)
			(0
				(BlueWindow color: global189)
				(localproc_0
					{INSTRUCTIONS#j\9a\de\91\fd\e5\92}
					(Format @temp0 391 3) ; "Welcome to the Radio Shock Automated Catalog! Let us be your gateway to what's new and exciting in the world of 24th Century Electronics.  Through the pages of our Automated Catalog, you will find gifts for the whole family. For Dad, look in Electronic Gadgets for our selection of Realrustic Stereo Components. For Mom, peek into The Electronic Mommy for a variety of labor- saving devices and marital aids! For Sis and Little Brother, browse our TechnoTots(R) Toy department for the latest in electronic playborgs! #j\d7\bc\de\b5\a5\bc\ae\af\b8\e9 \b5\b0\c4\b6\c0\db\b8\de\ed \f6\93\9a\9f\ff 24\9e\92\97\e9\e3\de\fd\9c\9a\93\96\de\98\96\de \93\fd\e0\de\a4 \9d\ea\de\f7\9c\92 \9c\8e\93\eb\fd\86 \9a\de\9c\8e\93\96\92\9c\ef\9c\8e\93\a1 \9a\de\96\9f\de\98\ed\e9 \cc\df\da\be\de\dd\c4\ea\a4\9a\e9\b5\b0\c4\b6\c0\db\b8\de\96\f7\a4 \96\fd\e0\fd\e6 \95\94\f7\eb\de \92\e0\e0\de\99\ef\9d\a1 \95\e4\93\9b\ef\e6\ea\a4\d8\b1\d9\d7\bd\c3\a8\af\b8\a5\bd\c3\da\b5\9e\92\eb\fd\86 \b4\da\b8\c4\d8\af\b8\a5\b6\de\bc\de\aa\af\c4 \96\f7\a1 \95\96\91\9b\ef\e6\ea\a4\ee\93\ec\e5\9e\92\96\e2\f6\93\eb\fd\86 \b4\da\b8\c4\db\c6\af\b8\a5\cf\d0\b0 \96\f7\a1 \9a\e4\de\f3\e0\e1\e6\ea\a4\e3\de\fd\9c\cc\df\da\b2\ce\de\b0\b8\de\e5\e4\de\86 \c3\b8\c9\c4\af\c2\a5\c4\b0\b2\96\f7 \95\94\f7\eb\de\98\e0\de\9b\92\a1"
					102
					global136
				)
				(if
					(PrintD
						{  }
						81
						{Continue#j\e2\e2\de\99\f9}
						0
						{  }
						81
						{Return to Top Menu#j\d2\c6\ad\b0\e6\f3\e4\de\f9 }
						1
						{  }
						67
						(LangSwitch 56 70)
						(LangSwitch 153 173)
					)
					(gLongSong number: (Random 392 395) play:)
					(client setScript: startTerminal)
				else
					(gLongSong number: (Random 392 395) play:)
					(localproc_0
						{INSTRUCTIONS#j\9a\de\91\fd\e5\92}
						(Format @temp0 391 4) ; "Shopping our Automated Catalog is as easy as snapping your digital appendages. Using your mouse or Tab key, simply point to the menu item of your choice and press <Enter> or click the mouse button. Should you get confused, simply return to the Top Menu and begin anew.  Thank you for choosing Radio Shock for all your electronic needs! We know you'll find just what you're looking for, and if you don't, we're wrong and you should look somewhere else.   --Your Radio Shock Manager #j\e4\93\e3\fd\e9 \b5\b0\c4\b6\c0\db\b8\de\96\f7\e9 \95\96\92\f3\e9\ea\a4 \91\e5\e0\96\de \f5\eb\de\86\e5\f7\9d\e9\e4 \95\e5\9c\de\98\f7\92\e6\96\fd\e0\fd\e3\de\9d\a1 \d2\c6\ad\b0\e9\e5\96\96\f7 \9c\e5\f3\e9\86 \cf\b3\bd\96 TAB\b7\b0\e3\de\94\f7\fd\e3\de\a4 \cf\b3\bd\e9 \eb\e0\de\f8\ce\de\c0\dd\96 RETURN\b7\b0\86 \95\9c\e3 \98\e0\de\9b\92\a1 \f3\9c\a4 \9a\fd\f7\fd\9c\e0\ea\de\91\92\ea\a4\c4\af\cc\df\d2\c6\ad\b0\e6\f3\e4\de\8f\e3\9b\92\9c\8e \96\f7\9f\93\9b\9c\e3 \98\e0\de\9b\92\a1 \d7\bc\de\b5\a5\bc\ae\af\b8\e6 \9a\de\f7\92\e3\fd \92\e0\e0\de\97\a4\ef\9a\e4\e6\a0 \91\f8\96\de\e4\93\9a\de\9b\de\92\ef\9d\a1 \96\e5\f7\9d\de\a4\a0 \9a\de\97\ee\de\93\e9\9c\8e\93\eb\fd\96\de\f0\e2\96\f9\9a\e4\e4\a0\95\f3\92\ef\9d\a1 \ef\fd\96\de\92\e1\f0\e2\96\f8\ef\9e\fd\e3\de\9c\e0\f7\a4\e4\93\e3\fd\e9 \9e\97\e6\fd\e3\de\9d \e9\e3\de\a4\e4\de\9a\96 \ee\96\e9\f0\9e\e3\de\a0 \95\9b\96\de\9c\98\e0\de\9b\92\a1  --------------\d7\bc\de\b5\a5\bc\ae\af\b8\a0 \cf\c8\b0\bc\de\ac\b0"
						102
						global136
					)
					(if
						(PrintD
							{ }
							81
							{Return to Top Menu#j\d2\c6\ad\b0\e6\f3\e4\de\f9 }
							0
							{  }
							81
							{Limited Time Specials#j\bd\cd\df\bc\ac\d9\be\b0\d9}
							1
							{ }
							67
							(LangSwitch 31 65)
							(LangSwitch 157 177)
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
				(BlueWindow color: global130)
				(localproc_0 ; "These Special Sale Items are available for a limited time only. Availability is limited to items in stock, as-is only, no returns. Some items may be demo models, scratched, dented, or just not in very good shape. No warranties, expressed or implied, apply to these items. No refund or exchange. #j \bd\cd\df\bc\ac\d9\be\b0\d9\9c\8e\93\eb\fd\ea\a4\96\97\de\f7\fa\e0\97\96\fd\e1\8d\93\e0\de\99\e9\ea\fd\ea\de\92\e3\de\9d\a1 \9b\de\92\9a\9c\8e\ec\de\fd\e3\de\9d\e9\e3\de\a4 \ed\fd\eb\df\fd\ea \95\9a\e4\fc\f8\92\e0\9c\ef\9d\a1 \e5\96\e6\ea\a4 \9c\fd\9a\eb\fd\f4\a4\9d\9a\9c\b7\bd\de\96\de\e2\92\e3\e0\f8\a4\91\ef\f8 \92\92\9c\de\8e\93\e0\92\e3\de \e5\92\f3\e9\f3\91\f8\ef\9d\a1 \9a\fa\f7\e9\9c\8e\93\eb\fd\e6\ea\a4\ee\9c\8e\93\ea \ef\8f\e0\98\91\f8\ef\9e\fd\a1 \9c\e0\96\de\8f\e3\a4\e0\de\92\97\fd\e9 \ed\fd\97\8c\98\f3\9c\8e\93\eb\fd\9a\93\96\fd\f3 \95\9a\e4\fc\f8\92\e0\9c\e3 \95\f8\ef\9d\a1"
					{SPECIALS#j\bd\cd\df\bc\ac\d9\be\b0\d9}
					391
					5
					102
					(proc0_18 global133 global132)
				)
				(if
					(PrintD
						{ }
						81
						{Continue#j\e2\e2\de\99\f9}
						0
						{ }
						81
						{Return to Top Menu#j\d2\c6\ad\b0\e6\f3\e4\de\f9 }
						1
						{ }
						67
						(LangSwitch 60 80)
						122
					)
					(gLongSong number: (Random 392 395) play:)
					(client setScript: startTerminal)
				else
					(gLongSong number: (Random 392 395) play:)
					(localproc_0 ; "ReShrinkwrap 2000 Work for a large retail software chain? Like to take the products home and diddle with them? The ReShrinkwrap 2000 reshrinkwraps any size software box. Is that game new or used? Only you'll know for sure! Keeps the customers guessing. DEALERS ONLY, please. 1033 Buckazoids. #j\d8\a5\bc\ad\d8\dd\b8\a5\d7\af\cc\df 2000 \ba\dd\cb\df\ad\b0\c0\bf\cc\c4\e9\95\f0\9e\e6 \9b\92\e3\97\fe \93\f8\f3\e9\86 \92\94\e6\f3\8f\e3\96\94\8f\e3\9a\de\ef\96\9d\fe \9a\fa\e3\de\a4 \e4\de\fd\e5\bb\b2\bd\de\e9\ce\de\af\b8\bd\e3\de\f3 \9b\92\ee\93\9f\93\9d\f9\9a\e4\96\de\e3\de\97\ef\9d\a1 \9f\e9\b9\de\b0\d1\ea\a4\91\e0\f7\9c\92\f3\e9\96\a4 \9f\fa\e4\f3\ec\f9\92\f3\e9\96\fe \91\e5\e0\e0\de\99\96\de\a0 \9f\fa\86\9c\8f\e3\92\f9\a1 \95\97\8c\98\9b\fd\e6\ea\a4 \fc\96\f8\ef\9e\fd\a1 \ea\fd\ea\de\92\e3\fd\e9\96\e0\e0\de\99\e6\95\93\f8\9c\ef\9d\a1 \e8\e0\de\fd\ea\a4\e0\8f\e0\e91033\ca\de\af\b6\bf\de\b2\c4\de\ff\ff"
						{SPECIALS#j\bd\cd\df\bc\ac\d9\be\b0\d9}
						391
						6
						102
						(proc0_18 global133 global132)
					)
					(switch
						(PrintD
							{ }
							81
							{Order#j\e1\8d\93\f3\fd\9d\f9}
							0
							{ }
							81
							{Continue#j\e2\e2\de\99\f9}
							1
							{ }
							81
							{Return to Top Menu#j\d2\c6\ad\b0\e6\f3\e4\de\f9 }
							2
							{ }
							67
							(LangSwitch 30 45)
							132
						)
						(0
							(gLongSong number: (Random 392 395) play:)
							(PrintD
								{Sorry - dealers only!  }
								106
								81
								{Continue#j\e2\e2\de\99\f9}
								1
								67
								100
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
				(localproc_0 ; "DuaPhunki Answering Machine The ultimate in hi-tech answering machines. Not a phone device. Carry it around with you. If somebody asks you a question, the DuaPhunki will give the correct answer. If it doesn't know the answer, it'll make a good guess. Won't discuss politics or religion. 117 Buckazoids. Sold out. #j\c3\de\ad\b1\cc\a7\dd\b7\b0\a5\b1\dd\bb\d8\dd\b8\de\cf\bc\b0\dd \ca\b2\c3\b8\a5\b1\dd\bb\d8\dd\b8\de\cf\bc\b0\dd\e9 \99\8f\e3\92\ea\de\fd\ff \e3\de\fd\fc\f6\93\e3\de\ea\a4\91\f8\ef\9e\fd\ff \e4\de\9a\ed\92\98\e4\97\e3\de\f3\a4\ce\df\b9\af\c4\f4\ca\de\af\b8\de\e9\e5\96\e6\92\fa\e3\92\8f\e3\98\e0\de\9b\92\a1 \f3\9c\a4\e0\de\fa\96\96\de\9c\e2\f3\fd\86\9d\f9\e4\a4\9a\e9\cf\bc\b0\dd\96\de\a0 \e0\e0\de\9c\92\9a\e0\94\86\9a\e0\94\e3 \98\fa\ef\9d\a1 \9a\e0\94\96\de\fc\96\f7\e5\92\ea\de\91\92\ea\a4\9e\92\96\92\e6 \e1\96\92\9a\e0\94\86\9d\92\9f\98\9c\ef\9d\a1 \9e\92\9c\de\f4\a4\9c\8d\93\97\8e\93\96\fd\99\92\e9\9c\e2\f3\fd\e6\ea\a4\9a\e0\94\ef\9e\fd\a1 117\ca\de\af\b6\bf\de\b2\c4\de\e3\de\9d\a1             (\95\96\99\de\9b\ef\e3\de\a4\93\f8\97\fa\e3\de\9d)"
					{SPECIALS#j\bd\cd\df\bc\ac\d9\be\b0\d9}
					391
					7
					102
					(proc0_18 global133 global132)
				)
				(switch
					(PrintD
						{ }
						81
						{Order#j\e1\8d\93\f3\fd\9d\f9}
						0
						{ }
						81
						{Continue#j\e2\e2\de\99\f9}
						1
						{ }
						81
						{Return to Top Menu#j\d2\c6\ad\b0\e6\f3\e4\de\f9 }
						2
						{ }
						67
						(LangSwitch 30 45)
						(LangSwitch 122 150)
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(PrintD
							{Sorry - sold out.  }
							81
							{Continue#j\e2\e2\de\99\f9}
							1
							67
							100
							(LangSwitch 135 150)
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
				(localproc_0 ; "Cheese Wiz II Preprogrammed with over 350 varieties of cheese, Cheese Wiz II will tell you the precise temperature at which to serve that beautiful round of aged Cheddar or that oozing slice of soft- ripened Brie. A must for all cheese lovers. Will not work with aerosol cheese food products. 25 Buckazoids. Not available as such. #j\c1\b0\bd\de\a5\b3\a8\bd\de II 350\9c\8d\f9\92\f3\e9\c1\b0\bd\de\96\de\cc\df\db\b8\de\d7\d1\9b\fa\e3\92\f9 \c1\b0\bd\de\a5\b3\a8\bd\de II\ea\a4 \c1\b0\bd\de\86 \95\92\9c\98\ee\9f\de\fd\9d\f9\e0\f2\e9 \9e\92\96\98\e5\95\fd\e4\de\86 \95\9c\94\e3\98\fa\ef\9d\a1 \c1\b0\bd\de\91\92\9a\93\96\e6\ea\a4\eb\e2\9c\de\8d\eb\fd\ff \b4\d7\bf\b0\d9\a5\c1\b0\bd\de\9e\92\eb\fd\e6\ea\a4\ea\e0\f7\97\ef\9e\fd\a125\ca\de\af\b6\bf\de\b2\c4\de\e3\de\9d\a1               (\e6\8d\93\9c\8d\a0\ec\96\e9\93)"
					{SPECIALS#j\bd\cd\df\bc\ac\d9\be\b0\d9}
					391
					8
					102
					(proc0_18 global133 global132)
				)
				(switch
					(PrintD
						81
						{Order#j\e1\8d\93\f3\fd\9d\f9}
						0
						{ }
						81
						{Return to Top Menu#j\d2\c6\ad\b0\e6\f3\e4\de\f9 }
						1
						{ }
						81
						{Automated Catalog#j\b5\b0\c4\b6\c0\db\b8\de}
						2
						67
						(LangSwitch 0 40)
						135
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(PrintD
							{Sorry - Not available as such.  }
							81
							{Return to Top Menu#j\d2\c6\ad\b0\e6\f3\e4\de\f9 }
							1
							67
							(LangSwitch 80 100)
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

	(method (changeState newState &tmp [temp0 750])
		(switch (= state newState)
			(0
				0
				(BlueWindow color: (proc0_18 global138 global137))
				(localproc_0 ; "Welcome to our Automated Catalog! Please select from the following departments: #j  \f6\93\9a\9f\a4\b5\b0\c4\b6\c0\db\b8\de\ed\ff\ff \9c\e0\e9\ec\de\f3\fd \96\f7\a4\95\94\f7\eb\de\98\e0\de\9b\92:"
					{- Automated Catalog -#j- \b5\b0\c4\b6\c0\db\b8\de -}
					391
					9
					102
					(proc0_18 global138 global137)
				)
				(self
					changeState:
						(PrintD
							{ }
							81
							{Electronic Gadgets#j\b4\da\b8\c4\d8\af\b8\a5\b6\de\bc\de\aa\af\c4}
							1
							{  #j     }
							81
							{The Electronic Mommy#j\b4\da\b8\c4\db\c6\af\b8\a5\cf\d0\b0}
							7
							{ }
							106
							{ }
							106
							{ }
							81
							{TechnoTots Toy Dept.#j\c3\b8\c9\c4\af\c2\a5\c4\b0\b2}
							11
							{  #j         }
							81
							{Return to Top Menu#j\d2\c6\ad\b0\e6\f3\e4\de\f9 }
							15
							{ }
							67
							(LangSwitch 22 45)
							102
						)
						(gLongSong number: (Random 392 395) play:)
				)
			)
			(1
				1
				(localproc_0 ; "Realrustic(TM) Faux-Component(R) Swiss Army MicroEntertainment Center  Styled to look like a real set of miniature components, this is a complete home entertainment center in one 4"x 6" box! Includes CD-ROM unit, turntable, dual cassette with Hyperwow and MegaFlutter, unfolding 84" digital color projection multiscreen TV, corkscrew and toothpick. 2275 Buckazoids. Back-ordered; none currently available. #j\d8\b1\d9\d7\bd\c3\a8\af\b8(TM) \cc\a7\b0\b8\bd\a5\ba\dd\ce\df(R)          \bd\b2\bd\a5\b1\b0\d0\b0\a5\cf\b2\b8\db\b4\dd\c0\b0\c3\b2\d2\dd\c4\bc\bd\c3\d1 \ee\fd\f3\e9\bf\af\b8\d8\e6 \e2\98\f7\fa\e0\a4\d0\c6\c1\ad\b1\a5\ba\dd\ce\df\be\af\c4\a1 4"x6"\e9\ea\9a\e6\ea\92\8f\e0\a4 \ce\b0\d1\a5\b4\dd\c0\b0\c3\b2\d2\dd\c4\bc\bd\c3\d1\a1 CD-ROM\d5\c6\af\c4\a4\c0\b0\dd\c3\b0\cc\de\d9\a4\ca\b2\ca\df\b0\dc\b3\e4\d2\b6\de\cc\d9\b0\c0\b0\e2\97 \e9\c3\de\ad\b1\d9\a5\b6\be\af\c4\c3\de\af\b7\a1 84"\c3\de\bc\de\c0\d9\b6\d7\b0\cf\d9\c1\bd\b8\d8\b0\ddTV\a4 \ba\d9\b8\9e\fd\91\99\e4\a4\e2\ef\f6\93\9c\de\f3\ea\92\8f\e3\92\ef\9d\a1 \e8\e0\de\fd\ea2275\ca\de\af\b6\bf\de\b2\c4\de\e3\de\9d\a1              (\e2\92\96\e1\8d\93\f3\fd\e1\8d\93)"
					{- Electronic Gadgets -#j- \b4\da\b8\c4\d8\af\b8\a5\b6\de\bc\de\aa\af\c4 -}
					391
					10
					102
					(proc0_18 global138 global137)
				)
				(switch
					(PrintD
						{ }
						81
						{Order#j\e1\8d\93\f3\fd\9d\f9}
						0
						{ }
						81
						{Continue#j\e2\e2\de\99\f9}
						1
						{ }
						81
						{Return to Top Menu#j\d2\c6\ad\b0\e6\f3\e4\de\f9 }
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
							106
							81
							{Continue#j\e2\e2\de\99\f9}
							1
							67
							(LangSwitch 73 110)
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
				(localproc_0 ; "Realrustic (TM) Dodecaphonic AroundSound Processor.  Ever notice how flat and unexciting normal Stereophonic, Quintophonic and Octophonic recordings are? With the Realrustic(TM) Dodecaphonic AroundSound Processor, your music will seem to come from 12 directions: in front of you, behind you, either side of you, four midpoints in between, above you, below you, from inside of you and from the upstairs neighbors. 877 Buckazoids. Discontinued.#j \d8\b1\d9\d7\bd\c3\a8\af\b8(TM) \c4\de\c3\de\b6\cc\ab\c6\af\b8\a5\b1\d7\bb\b3\dd\c4\de\a5\cc\df\db\be\af\bb\b0 \e2\93\9c\de\8e\93\e9 \bd\c3\da\b5\bb\b3\dd\c4\de\96\de\a4 \e2\ef\f7\e5\98\a0\96\fd\9c\de\e0\9a\e4\96\de\91\f8\ef\9d\96\fe 6\ee\93\9a\93\9c\96\97\9a\94\e5\92\a4\e5\fd\e9 \ed\fd\e3\e2\f3\e5\92\a4\e2\93\9c\de\8e\93\e9 \bd\c3\da\b5\e6 \91\97\91\97\9c\e0\9a\e4\ea\a4\91\f8\ef\9e\fd\96\fe \9f\fd\e5\e4\97\ea\a4 \c4\de\c3\de\b6\cc\ab\c6\af\b8\a5\b1\d7\bb\b3\dd\c4\de\a5\cc\df\db\be\af\bb\b0\86\e2\96\94\ea\de\a4 \95\e4\96\de\a0 2\ea\de\92\e912\ee\93\9a\93\e6\a0\eb\fb\96\de\f8\ef\9d\a1 \ef\94\a4\93\9c\fb\a4\f0\97\de\a4\eb\e0\de\f8\ea\f3\e1\fb\fd\ff \ef\94\e6 \92\8f\e04\ee\93\9a\93\e9\e1\8d\93\96\fd\ff \93\94\a4\9c\e0\a4\9c\de\ec\de\fd\e9\93\e1\96\de\fc\a4\95\e4\e5\f8\9b\fd\96\f7\f3\a5\a5\a5\a5\a1 \e8\e0\de\fd\ea877\ca\de\af\b6\bf\de\b2\c4\de\a1         (\9e\92\9f\de\93\e1\8d\93\9c\e6\e2\97\a4\e6\8d\93\9c\8d \ec\96\e9\93)"
					{- Electronic Gadgets -#j- \b4\da\b8\c4\d8\af\b8\a5\b6\de\bc\de\aa\af\c4 -}
					391
					11
					102
					(proc0_18 global138 global137)
				)
				(switch
					(PrintD
						{ }
						81
						{Order#j\e1\8d\93\f3\fd\9d\f9}
						0
						{ }
						81
						{Continue#j\e2\e2\de\99\f9}
						1
						{ }
						81
						{Return to Top Menu#j\d2\c6\ad\b0\e6\f3\e4\de\f9 }
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
							{Continue#j\e2\e2\de\99\f9}
							1
							67
							(LangSwitch 60 75)
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
				(localproc_0 ; "CDGIROMTV Move over, CD-ROM, CD-G, CD-I, and CDTV! The Realrustic(TM) CDGIROMTV does everything the others do and MORE! Besides accepting the formats listed above, CDGIROMTV also plays high-quality Laserdisc movies, sure to become popular any century now. 842 Buckazoids. Estimated delivery: Summer 2735. #jCDGIROMTV CD-ROM\a4CD-G\a4CD-I\a4CDTV\ea\f3\93\92\f7\e5\92\ff\ff\ff CDGIROMTV\ea\a4\ec\e2\93\e9\c3\da\cb\de\e3\de\ea\91\f8\ef\9e\fd\a1 \ec\e2\93\e9\c3\da\cb\de\e9 \97\e9\93\ea\f3\e1\fb\fd\a1 \cf\d9\c1\d2\c3\de\a8\b1\e6 \e0\92\95\93\9c\e3\92\e3\a4\9c\de\8d\93\f7\92\e9 \9d\ed\de\e3\e9\d2\c3\de\a8\b1\e4 \9c\8e\93\f7\92\e9\d2\c3\de\a8\b1\e6 \e0\92\95\93\9c\e3\95\f8\ef\9d\a1 \e8\e0\de\fd\ea\a4842\ca\de\af\b6\bf\de\b2\c4\de\a1            (\e6\8d\93\96\f6\e3\92 : 2735\e8\fd\a4\e5\e2)"
					{- Electronic Gadgets -#j- \b4\da\b8\c4\d8\af\b8\a5\b6\de\bc\de\aa\af\c4 -}
					391
					12
					102
					(proc0_18 global138 global137)
				)
				(switch
					(PrintD
						{ }
						81
						{Order#j\e1\8d\93\f3\fd\9d\f9}
						0
						{ }
						81
						{Continue#j\e2\e2\de\99\f9}
						1
						{ }
						81
						{Return to Top Menu#j\d2\c6\ad\b0\e6\f3\e4\de\f9 }
						2
						{ }
						67
						35
						142
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(PrintD
							{Sorry - Estimated delivery: Summer 2735.}
							106
							81
							{Continue#j\e2\e2\de\99\f9}
							1
							67
							(LangSwitch 120 110)
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
					{- Electronic Gadgets -#j- \b4\da\b8\c4\d8\af\b8\a5\b6\de\bc\de\aa\af\c4 -}
					(Format ; "PocketPal Portable Terminal "Say, is that a complete workstation in your pocket, or are you just glad to see me?" Now you can carry the power of a dumb terminal around with you without even creasing your jumpsuit. Includes RIGA-compatible monitor (Really Incredible Graphics Adapter), chiclet-style keyboard and Dentyne-style mouse. %u Buckazoids. #j\ce\df\b9\af\c4\ca\df\d9\a5\ce\df\b0\c0\cc\de\d9\a5\c0\b0\d0\c5\d9 \97\e3\92\f9\bd\b0\c2\e6\bc\dc\86\f6\9e\9d\de\e6\a4\f3\e1\ea\9a\eb\de\9d\f9\9a\e4\96\de\96\e9\93\e3\de\9d\a1 \95\97\8c\98\9b\fd\86\9e\8f\e0\92\9c\e3\92\f9\e4\97\f3\a4\bc\de\ac\cf\e6\e5\f8\ef\9e\fd\a1 RIGA\ba\dd\ca\df\c1\cc\de\d9\a4\c1\b8\da\af\c4\bd\c0\b2\d9\e9\b7\b0\ce\de\b0\c4\de\a4\c3\de\dd\c3\a8\b0\dd\bd\c0\b2\d9 \e9\cf\b3\bd\96\de\ec\98\ef\fa\e3\92\ef\9d\a1 \e8\e0\de\fd\ea\a4%u\ca\de\af\b6\bf\de\b2\c4\de\e3\de\9d\a1"
						@temp0
						391
						13
						(Max (+ gBuckazoidCount 1) 2001)
						(Max (+ gBuckazoidCount 1) 2001)
					)
					102
					(proc0_18 global138 global137)
				)
				(switch
					(PrintD
						{ }
						81
						{Order#j\e1\8d\93\f3\fd\9d\f9}
						0
						{ }
						81
						{Continue#j\e2\e2\de\99\f9}
						1
						{ }
						81
						{Return to Top Menu#j\d2\c6\ad\b0\e6\f3\e4\de\f9 }
						2
						{ }
						67
						(LangSwitch 35 40)
						144
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(PrintD
							{You do not possess the necessary number of Buckazoids.}
							67
							(LangSwitch 60 125)
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
				(localproc_0 ; "PocketPal Connector If you are a proud owner of our ever-popular PocketPal Portable Terminal, you have no doubt noticed that, without the proper connector, it is virtually useless.  Fortunately, at this moment, our exclusive PocketPal Connector is on sale for just 1999 Buckazoids! Get yours now, before the price goes up even further.#j\ce\df\b9\af\c4\ca\df\d9\a5\ba\c8\b8\c0\b0 \92\ef\a4 \f3\8f\e4\f3\ce\df\cb\df\ad\d7\b0\e5 \ce\df\b9\af\c4\ca\df\d9\e9\ce\df\b0\c0\cc\de\d9\a5\c0\b0\d0\c5\d9\ea \e3\97\9e\e2\e5\ba\c8\b8\c0\b0\e5\9c\e3\de\ea\a0\f4\98\e6\e0\e1\ef\9e\fd\a1 \9c\96\9c\a4\9b\92\fc\92\e5\9a\e4\e6 \e0\e0\de\92\ef\a4 \e4\93\e3\fd\96\f7\e0\de\99\a4\ba\c8\b8\c0\b0\86\ea\e2\ea\de\92\e1\8d\93\ff\ff \9f\fa\f3\a4\e0\8f\e0\e91999\ca\de\af\b6\bf\de\b2\c4\de\ff\ff \9b\91\a4\e8\91\96\de\f8\9d\f9\ef\94\e6\ea\f4\f2\e9\a0 \95\96\92\91\99\de\86\ff\ff\ff\ff"
					{- Electronic Gadgets -#j- \b4\da\b8\c4\d8\af\b8\a5\b6\de\bc\de\aa\af\c4 -}
					391
					14
					102
					(proc0_18 global138 global137)
				)
				(switch
					(PrintD
						{ }
						81
						(if (or (gEgo has: 11) (IsFlag 71)) ; plug
							{Exchange#j\9a\93\96\fd\9d\f9}
						else
							{Order#j\e1\8d\93\f3\fd\9d\f9}
						)
						0
						{ }
						81
						{Continue#j\e2\e2\de\99\f9}
						1
						{ }
						81
						{Return to Top Menu#j\d2\c6\ad\b0\e6\f3\e4\de\f9 }
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
									{With many a grind, moan and "Well, I dunno...", the salesbot finally allows you to exchange the plug.}
									67
									60
									132
								)
								(self setScript: choosePlug self)
							)
							((>= gBuckazoidCount 1999)
								(PrintD
									{With great patience, you insert each and every one of the 1999 buckazoids into the salesbot's coin receptor.}
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
									(LangSwitch 60 125)
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
				(localproc_0 ; "The Acronymizer In today's hi-tech workaday world, there are just too many acronyms to remember...resulting in CHAOS (Collective Hi-tech Acronym Overexposure Syndrome). With this handy-dandy pocket translator, you merely punch in the acronym ASAP and see what they're REALLY saying PDQ! 212 Buckazoids. Not available in Galaxy Galleria, Alpha Centauri or Peoria stores. #j\b1\b8\db\c6\cf\b2\bb\de\b0 \99\de\fd\9b\de\92\e9\ca\b2\c3\b8\9b\fd\97\de\8e\93\e3\de\ea\a4\95\ee\de\94\e3\92\e5\99\fa\ea\de\e5\f7\e5\92\b6\bc\d7\f3\9c\de \96\de\95\95\9d\97\de\ef\9d\a1 \9f\e9\9e\92\e3\de\a4CHAOS (Collective Hi-tech Acronym Overxposure Syndrome) \96\de\95\9a\8f\e3\9c\ef\93\e9\e3\de\9d\a1 \c0\de\dd\c3\de\a8\a5\ce\df\b9\af\c4\a5\c4\d7\dd\bd\da\b0\c0\b0\e4\a0\92\8f\9c\8e\e6\e2\96\93\9a\e4\e6\f6\f8\a4\b6\bc\d7\f3\9c\de\86 \e6\8d\93\f8\8e\98\9c\e0\e0\de\99\e3\de\a4 \9f\fa\96\de\e4\de\93\92\93 \92\f0\e5\e9\96 \9d\98\de\e6 \ea\fd\f2\92\ff \e8\e0\de\fd\ea\a0212\ca\de\af\b6\bf\de\b2\c4\de\e3\de\9d\a1 \b7\de\ac\d7\b8\bc\b0\b7\de\ac\d7\d8\b1\e3\fd\e4\a0\cd\df\b5\d8\b1\e3\fd\a4\b1\d9\cc\a7\b9\dd\c0\b3\d9\e3\fd\e3\de\ea \91\e2\96\8f\e3\95\f8\ef\9e\fd\a1"
					{- Electronic Gadgets -#j- \b4\da\b8\c4\d8\af\b8\a5\b6\de\bc\de\aa\af\c4 -}
					391
					15
					102
					(proc0_18 global138 global137)
				)
				(switch
					(PrintD
						{ }
						81
						{Order#j\e1\8d\93\f3\fd\9d\f9}
						0
						{ }
						81
						{Catalog Menu#j\b6\c0\db\b8\de\d2\c6\ad\b0\ed }
						1
						{ }
						81
						{Top Menu#j\d2\c6\ad\b0\e6\f3\e4\de\f9 }
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
							106
							81
							{Return to Catalog Menu#j\b6\c0\db\b8\de\d2\c6\ad\b0\e6\f3\e4\de\f9 }
							1
							67
							65
							(LangSwitch 132 142)
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
				(localproc_0 ; "Iceman(TM) Pocket Ice Machine This miracle of modern engineering fits in purse or pocketbook and freezes 15 pounds of ice cubes per hour. Choose from ice slices, cubes, rounds or crushed. Requires mini hydrogen and oxygen canisters, sold separately. Breaks the ice at parties. 300 Buckazoids. Recalled by manufacturer. #j\b1\b2\bd\cf\dd(TM) \ce\df\b9\af\c4\a5\b1\b2\bd\cf\bc\b0\dd \9a\e9\9c\8e\93\eb\fd\ea\a4\ca\dd\c4\de\ca\de\af\b8\de\f4\bb\b2\cc\e9\e5\96\e6\ea\92\f8\a4\92\e1\9c\de\96\fd\e6 15\ce\df\dd\c4\de\e9\9a\95\f8\86\a0\9a\95\f7\9e\ef\9d\a1 \bd\d7\b2\bd\a4\b7\ad\b0\cc\de\a4\ef\f9\a4\98\e0\de\97\9c\de\8e\93\e0\92\e9 4\c0\b2\cc\df\e9\96\e0\e1\86\a0\95\94\f7\eb\de \98\e0\de\9b\92\a1 \d0\c6\9d\92\9f\e4\a0 \bb\dd\bf\e9\b6\dd\96\de\eb\e2\f6\93\e3\de\9d\a1 \ca\df\b0\c3\a8\e3\de\9b\92\9c\8e\e6 \9a\95\f8\86\e0\de\9d\9a\e4\96\de\e3\de\97\f9\e9\ea\91\e5\e0\e3\de\9c\8e\93\ff \e8\e0\de\fd\ea\a4\a0 300\ca\de\af\b6\bf\de\b2\c4\de\e3\de\9d\a1        (\d2\b0\b6\b0\96\92\9c\8d\93\e1\8d\93\e6\e2\97\a4\e6\8d\93\9c\8d \ec\96\e9\93)"
					{- Electronic Mommy -#j\b4\da\b8\c4\db\c6\af\b8\a5\cf\d0\b0}
					391
					16
					102
					(proc0_18 global138 global137)
				)
				(switch
					(PrintD
						{ }
						81
						{Order#j\e1\8d\93\f3\fd\9d\f9}
						0
						{ }
						81
						{Continue#j\e2\e2\de\99\f9}
						1
						{ }
						81
						{Return to Top Menu#j\d2\c6\ad\b0\e6\f3\e4\de\f9 }
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
							{Continue#j\e2\e2\de\99\f9}
							1
							67
							(LangSwitch 35 60)
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
				(localproc_0 ; "EpiChia Now you can remove unsightly chia growth from upper lip, legs, "bikini area" and small clay figurines. Painless and electronic. Almost tickles once you get used to it. Instantly cauterizes major blood vessels. Battery-operated; 32v dry cell not included. 32 Buckazoids. Not available in the Spiral Arm. #j\b4\cb\df\c1\b1 \b1\c1\ba\c1\96\f7\ed\e3\98\f9\a4 \f0\96\99\e9\f6\98\e5\92\a0 \d1\c0\de\b9\de\86\a0\9f\f9\9a\e4\96\de\e3\de\97\ef\9d\a1 \92\e0\f0\f3\96\fd\9c\de\9d\de\e6\a0\91\fd\9e\de\fd\e6\a0\9c\8e\f8\e3\de\97\f9\a4\e3\de\fd\9c\9e\92\eb\fd\e3\de\9d\a1 \9c\f6\93\9d\f9\e0\f2\e6\ea\a4\a0 32V\e9\96\fd\e3\de\fd\e1\86\9a\93\e6\8d\93\9c\e3\98\e0\de\9b\92\a1 \e8\e0\de\fd\ea\a432\ca\de\af\b6\bf\de\b2\c4\de\e3\de\9d\a1 \d7\be\dd\9c\de\8e\93\e9\a0\93\e3\de\e9\96\e0\ea\a0 \9c\f6\93\9c\e5\92\e3\de\98\e0\de\9b\92\a1"
					{- Electronic Mommy -#j\b4\da\b8\c4\db\c6\af\b8\a5\cf\d0\b0}
					391
					17
					102
					(proc0_18 global138 global137)
				)
				(switch
					(PrintD
						{ }
						81
						{Order#j\e1\8d\93\f3\fd\9d\f9}
						0
						{ }
						81
						{Continue#j\e2\e2\de\99\f9}
						1
						{ }
						81
						{Return to Top Menu#j\d2\c6\ad\b0\e6\f3\e4\de\f9 }
						2
						{ }
						67
						35
						125
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(PrintD
							{Sorry - Not available in the Spiral Arm.}
							106
							81
							{Continue#j\e2\e2\de\99\f9}
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
					{- Electronic Mommy -#j\b4\da\b8\c4\db\c6\af\b8\a5\cf\d0\b0}
					(Format @temp0 391 18) ; "Dandy Recipe Beamer Imagine the situation. The Ambassador from Kerona is coming for dinner, and all you have handy is a can of condensed Cream of Orat Soup and a box of Nano Wafers. You punch the appropriate buttons on your Recipe Beamer and instantly, from our Recipe Satellite, we beam the perfect recipe back to you. Over 18 *trillion* recipes collected from all over the universe, just to make meal planning easier. 455 Buckazoids. Estimated date of uplink: November 2803. #j\c0\de\dd\c3\de\a8\b0\9a\fd\e0\de\e3\cb\de\b0\cf\b0 \e4\e2\9e\de\fd\a4\e0\de\92\9c\de\e5 \95\97\8c\98\9b\ef\96\de\91\e5\e0\e9\f5\93\9c\8e\98\e6\9c\8e\93\e0\92 \9b\fa\ef\9c\e0\96\de\a4 \91\e5\e0\e9\e3\f3\e4\e6\91\f9\e9\ea\a4\bd\b0\cc\df\e4\bd\c5\af\b8\e0\de\99\e3\de\9c\e0\a1 \9f\fd\e5\e4\97\a4\9a\e9\9a\fd\e0\de\e3\cb\de\b0\cf\b0\96\de\92\f8\8e\98\86\ea\8f\97\9c\ef\9d\a1 \9a\ef\8f\e0\e4\97\e6\a4\9a\fd\e0\de\e3\cb\de\b0\cf\b0\e9\ce\de\c0\dd\86\ce\df\dd\ff\ff \9a\fd\e0\de\e3\bb\c3\d7\b2\c4\96\f7\91\e5\e0\e9\f3\e4\e6\a4\cb\de\b0\d1\e3\de\f8\8e\93\f8\86\95\e4\e4\de\99\9c\ef\9d\a1 \e8\e0\de\fd\ea\a4455\ca\de\af\b6\bf\de\b2\c4\de\a1         (\bb\b0\cb\de\bd\96\92\9c\f6\e3\92:\a0 2803\e8\fd11\96\de\e2 )"
					102
					(proc0_18 global138 global137)
				)
				(switch
					(PrintD
						{ }
						81
						{Order#j\e1\8d\93\f3\fd\9d\f9}
						0
						{ }
						81
						{Continue#j\e2\e2\de\99\f9}
						1
						{ }
						81
						{Return to top menu#j\d2\c6\ad\b0\e6\f3\e4\de\f9 }
						2
						{ }
						67
						35
						163
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(PrintD
							{Sorry - Estimated date of uplink: November 2803.}
							106
							81
							{Continue#j\e2\e2\de\99\f9}
							1
							67
							(LangSwitch 65 70)
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
				(localproc_0 ; "Cyber-Depunker If your offspring is turning out to be "just another rotten Cyberpunk," you need the Dandy Cyber-Depunker. Works while your child sleeps to replace those black market implants with healthy tissue, removes antiproductive attitudes and leaves a clean, fresh outlook. May cause some motor impairment and memory loss, but isn't that a small price to pay? Battery operated. 580 Buckazoids. Currently under UCC investigation. #j\bb\b2\ca\de\b0\c3\de\a8\ca\df\dd\b6\b0 \f3\9c\a4\91\e5\e0\e9\9a\e4\de\f3\96\de \a2\f1\e9\93\e5\bb\b2\ca\de\b0\ca\df\dd\b8\a3\e6\e5\8f\e3\9c\ef\8f\e0\e4\97\a4 \9a\e9\bb\b2\ca\de\b0\c3\de\a8\ca\df\dd\b6\b0\96\de\eb\e2\f6\93\e3\de\9d\a1 \9a\e4\de\f3\96\de\e8\f1\8f\e3\92\f9 \91\92\e0\de\e6 \97\99\fd\e5\a0\ea\fd\9e\92\9b\fd\e3\97\e3\de\ec\99\e2\e5\9e\92\9c\fd\86\a0\e4\f8\e9\9f\de\97\a4 \9e\92\99\e2\e3\de\99\fd\9a\93\e3\97\e5 \9e\92\9c\fd\e6\9c\ef\9d\a1 \93\fd\e4\de\93\9c\fd\99\92\e6\a0\9c\8e\93\96\de\92\f4\a4\97\95\98\9f\93\9c\e2\e5\e4\de\96\de\95\9a\8f\e0\f8\9d\f9 \ea\de\91\92\96\de\91\f8\ef\9d\96\de\a4 \9f\fa\ea\ee\fd\e9 \9d\9a\9c\e9\97\de\9e\92\e0\de\e4\95\f3\92\ef\9e\fd\96\fe \e3\de\fd\e1\e3\de \ea\e0\f7\97\ef\9d\a1 \e8\e0\de\fd\ea\a0580\ca\de\af\b6\bf\de\b2\c4\de\e3\de\9d\a1        (UCC\e6\f6\f8\e4\f8\9c\f7\ed\de\e1\8d\93\e6\e2\97\a4\9c\f6\93\97\fd\9c)"
					{- Electronic Mommy -#j\b4\da\b8\c4\db\c6\af\b8\a5\cf\d0\b0}
					391
					19
					102
					(proc0_18 global138 global137)
				)
				(switch
					(PrintD
						81
						{Order#j\e1\8d\93\f3\fd\9d\f9}
						0
						{ }
						81
						{Return to Catalog Menu#j\b6\c0\db\b8\de\d2\c6\ad\b0\e6\f3\e4\de\f9 }
						1
						{ }
						81
						{Top Menu#j\d2\c6\ad\b0\e6\f3\e4\de\f9 }
						2
						67
						20
						155
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(PrintD
							{Sorry - Currently under UCC investigation.}
							106
							81
							{Return to Catalog Menu#j\b6\c0\db\b8\de\d2\c6\ad\b0\e6\f3\e4\de\f9 }
							1
							67
							(LangSwitch 68 75)
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
				(localproc_0 ; "Armatroid 2500 A remote-control toy for all ages, the Armatroid 2500 is a mobile robotic arm that can swivel, turn, pick up light objects, tear wings off of flies, disembowel small mammals, and perform elective surgery. Teaches hand-eye coordination, elementary physics and self-control. 35 Buckazoids. Sold out. #j\b1\b0\cf\c9\b2\c4\de 2500 \95\9a\9b\ef\96\f7\95\e4\9c\f6\f8\ef\e3\de\a4 \f0\e5\9b\ef\e3\de\95\e0\e9\9c\f0\92\e0\e0\de\99\f9\d8\d3\b0\c4\a5\ba\dd\c4\db \b0\d9\e9\95\f3\e1\8c\e3\de\9d\a1 \b1\b0\cf\c9\b2\c4\de\a0 2500\ea\a4\e4\fd\e0\de\f8\a4\ea\e8\e0\f8\a4 \96\f9\92 \f3\e9\86 \f3\e1\91\99\de\e0\f8\a4 \ca\b4\96\f7\ea\e8\86 \eb\97\e1\97\de\8f\e0\f8\a4\ce\e6\8d\93\f9\92\e9\ea\f7\fc\e0 \86 \e7\97\e0\de\9c\e0\f8\9d\f9\9a\e4\96\de\e3\de\97\f9\a4 \d3\b0\cb\de\d9\db\ce\de\af\c4\e9\93\e3\de\e5\e9\e3\de\9d\a1 \ef\e0\a4\ca\dd\c4\de\b1\b2\e4 \e4\de\93\9c\de\e4\de\93\9b\e3\de\96\fd\e0\fd\e5 \ec\de\e2\f8\e4 \9c\de\9a\f6\98\9e\92\86 \95\9c\94\e3\98\fa\ef\9d\a1 35\ca\de\af\b6\bf\de\b2\c4\de\e3\de\9d\a1            (\e0\e0\de\92\ef\a4\93\f8\97\fa\e1\8d\93\e3\de\9d)"
					{TechnoTots Toys#j\c3\b8\c9\c4\af\c2\a5\c4\b0\b2}
					391
					20
					102
					(proc0_18 global138 global137)
				)
				(switch
					(PrintD
						{ }
						81
						{Order#j\e1\8d\93\f3\fd\9d\f9}
						0
						{ }
						81
						{Continue#j\e2\e2\de\99\f9}
						1
						{ }
						81
						{Return to Top Menu#j\d2\c6\ad\b0\e6\f3\e4\de\f9 }
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
							{Continue#j\e2\e2\de\99\f9}
							1
							67
							100
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
				(localproc_0 ; "YoBot, the Ramboid Robot Having YoBot in the house is like having an extra playmate around, armed to the teeth with bazookas, laser pistols, and an authentic live nuclear warhead! Light-activated sensors keep YoBot from bumping into walls or falling off tables, and a darn good thing, too. Responds to voice commands with an authoritative, "Yo!" 69 Buckazoids. Discontinued. #j\d6\b0\ce\de\af\c4\a4\d7\dd\ce\de\b2\c4\de\a5\db\ce\de\af\c4 \92\94\e9\e5\96\e6\d6\b0\ce\de\af\c4\86\f3\8f\e3\92\f9\e9\ea\a4 \ca\de\bd\de\b0\b6\f4\da\b0\bb\de\b0\cb\df\bd\c4\d9\a4 \96\98\ed\92\97\e3\de\ec\de\9f\93\9c\e0\e4\98\ed\de\e2\e5\91\9f\eb\de\91\92\e3\96\de\a4\a0 \e4\e5\f8\e6\92\f9\e9\e4 \95\e5\9c\de\9a\e4\e3\de\9d\a1 \eb\96\f8\e6\ea\fd\e9\93\9d\f9\be\dd\bb\b0\ea\a4\d6\b0\ce\de\af\c4\96\de\a0 \96\ed\de\e6 \ec\de\e1\91\e0\8f\e0\f8\a4\e0\96\92\e4\9a\fb\96\f7\a0 \95\e1\f9\e9\86\ec\9e\97\de\ef\9d\a1 \b2\b9\de\dd\86\f3\8f\e0 \a2\d6\b0\ff\a3 \e4\92\93\a4\9a\94\e9\f2\92\fa\92\e6\ea\fd\e9\93\9c\ef\9d\a1 69\ca\de\af\b6\bf\de\b2\c4\de\e3\de\9d\a1         (\9e\92\9f\de\93\e1\8d\93\9c\e6\e2\97\a4\e6\8d\93\9c\8d\a0\ec\96\e9\93)"
					{TechnoTots Toys#j\c3\b8\c9\c4\af\c2\a5\c4\b0\b2}
					391
					21
					102
					(proc0_18 global138 global137)
				)
				(switch
					(PrintD
						{ }
						81
						{Order#j\e1\8d\93\f3\fd\9d\f9}
						0
						{ }
						81
						{Continue#j\e2\e2\de\99\f9}
						1
						{ }
						81
						{Return to Top Menu#j\d2\c6\ad\b0\e6\f3\e4\de\f9 }
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
							{Continue#j\e2\e2\de\99\f9}
							1
							67
							(LangSwitch 50 70)
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
				(localproc_0 ; "Realrustic(TM) Whether Radio Hours of fun! Looks like a cube with an antenna. Press the bar and get a burst of static. If you can figure out whether or not it's a radio, you're smarter than we are. Requires one 9v battery. Ability to pull in stations and reproduce sounds not included. 20 Buckazoids. Due to delay in manufacturing, this item is not yet available. #j\d8\b1\d9\d7\bd\c3\a8\af\b8(TM) \b5\c3\dd\b7\a5\d7\bc\de\b5 \e1\8e\93\9c\de\96\fd\a4\95\e0\e9\9c\f0\92\e0\e0\de\99\ef\9d\a1 \b1\dd\c3\c5\e9\e2\92\e0\e4\93\ec\e9\f6\93\e6 \f0\94\ef\9d\a1 \ca\de\b0\86\95\9c\e3\a4\e4\eb\de\e0\de\9d\a0\9e\92\e3\de\fd\97\e6\a0 \9b\fc\8f\e3\f0\f6\93\ff \9f\fa\96\de\a4\d7\bc\de\b5\96\e4\de\93\96\fc\96\8f\e0\f7\a4\a0 \91\e5\e0\ea\a0 \fc\e0\9c\e0\e1\f6\f8\f3\96\9c\9a\92\ff 9V\e9\e3\de\fd\e1\96\de\eb\e2\f6\93\e3\de\9d\a1 \d7\bc\de\b5\e4\9c\e3\e9\97\e9\93\ea\92\8f\9b\92\91\f8\ef\9e\fd\a1 \e8\e0\de\fd\ea\a420\ca\de\af\b6\bf\de\b2\c4\de\e3\de\9d\a1       (\9e\92\9f\de\93\96\de\95\98\fa\e3\92\f9\e0\f2\a4\e6\8d\93\9c\8d\a0\ec\96\e9\93)"
					{TechnoTots Toys#j\c3\b8\c9\c4\af\c2\a5\c4\b0\b2}
					391
					22
					102
					(proc0_18 global138 global137)
				)
				(switch
					(PrintD
						{ }
						81
						{Order#j\e1\8d\93\f3\fd\9d\f9}
						0
						{ }
						81
						{Continue#j\e2\e2\de\99\f9}
						1
						{ }
						81
						{Return to Top Menu#j\d2\c6\ad\b0\e6\f3\e4\de\f9 }
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
							106
							81
							{Continue#j\e2\e2\de\99\f9}
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
				(localproc_0 ; "Realrustic(TM) Universal Remote Control Control the entire universe with one remote control! Open garage doors on other planets, turn off crucial life support systems on passing spaceships, terrify primitive cultures. 1000 light year range, slightly less indoors. Requires one AAA battery, not included. 1050 Buckazoids. Sold out. #j\d8\b1\d9\d7\bd\c3\a8\af\b8(TM) \d5\c6\ca\de\b0\bb\d9\a5\d8\d3\b0\c4\ba\dd\c4\db\b0\d9 \9e\de\fd\93\e1\8d\93\86 \9c\de\f5\93\e6\a0\ba\dd\c4\db\b0\d9\9c\e3\f0\e5\92\96\fe \ee\96\e9\ee\9c\e9\b6\de\da\b0\bc\de\e9\c4\de\b1\86 \91\99\e0\f8\a4 \e1\96\98\86\e2\93\96\e1\8d\93\e9 \93\e1\8d\93\9e\fd \e9\a0\d7\b2\cc\a5\bb\ce\df\b0\c4\a5\bc\bd\c3\d1\86\9a\fc\9c\e0\f8\9c\e3\a4 \99\de\fd\9c\e3\97\e5\ec\de\fd\96\86 \95\e4\de\fb\96\9c\e3\f4\fb\93\ff \9a\93\96\ea\a4 \95\98\96\de\92\e3\de 1000\9a\93\e8\fd\e3\de\9d\a1 \e0\fd3\e3\de\fd\e1\96\de\eb\e2\f6\93\e3\de\9d\a1 \e8\e0\de\fd\ea\a41050\ca\de\af\b6\bf\de\b2\c4\de\a1            (\e0\e0\de\92\ef\a4\93\f8\97\fa\e1\8d\93\e3\de\9d)"
					{TechnoTots Toys#j\c3\b8\c9\c4\af\c2\a5\c4\b0\b2}
					391
					23
					102
					(proc0_18 global138 global137)
				)
				(switch
					(PrintD
						{ }
						81
						{Order#j\e1\8d\93\f3\fd\9d\f9}
						0
						{ }
						81
						{Return to Top Menu#j\d2\c6\ad\b0\e6\f3\e4\de\f9 }
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
							{Return to Top Menu#j\d2\c6\ad\b0\e6\f3\e4\de\f9 }
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
				(gCurRoom style: 10 drawPic: 391)
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
				(= local0
					(Display ; "THANK YOU FOR SHOPPING RADIO SHOCK! #j\91\f8\96\de\e4\93\9a\de\9b\de\92\ef\9c\e0\a1   \ef\e0\e9\9a\de\f7\92\e3\fd\86\a5\a5\a5\a5"
						391
						24
						dsWIDTH
						315
						dsCOORD
						118
						(proc0_19 149 154 154 154 154)
						dsALIGN
						alCENTER
						dsFONT
						300
						dsCOLOR
						global135
						dsSAVEPIXELS
					)
				)
				(= seconds 3)
			)
			(3
				(Display 391 2 dsRESTOREPIXELS local0)
				(= cycles 5)
			)
			(4
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
				(Display 391 25 dsCOORD 97 163 dsCOLOR global136) ; "Select the plug you wish to purchase.#j\95\96\92\91\99\de\e6\e5\f8\e0\92  \cc\df\d7\b8\de\86\94\f7\fd\e3\de\98\e0\de\9b\92\a1"
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

(instance theEyes of Prop
	(properties
		x 162
		y 25
		description {salesbot's eyes}
		view 391
		loop 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 391 26) ; "The salesbot's eyes seem to be having a hard time focusing on you."
			)
			(3 ; Do
				(Print 391 27) ; "Be reasonable. What would you do with robot eyes, anyway?"
			)
			(11 ; Smell
				(Print 391 28) ; "The robot has your typical mechanical aromas."
			)
			(10 ; Taste
				(Print 391 29) ; "Your sense of appropriate public behavior leaves a lot to be desired."
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
		view 391
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 391 30) ; "The salesbot's ear just spins around and around. Probably one of those "sensor-round" models."
			)
			(10 ; Taste
				(Print 391 31) ; "I know you're lonely, but licking a robot's ear?"
			)
			(11 ; Smell
				(Print 391 28) ; "The robot has your typical mechanical aromas."
			)
			(10 ; Taste
				(Print 391 29) ; "Your sense of appropriate public behavior leaves a lot to be desired."
			)
			(3 ; Do
				(Print 391 32) ; "Don't touch the robot's ear. You don't know where it's been."
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
		view 391
		loop 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 391 30) ; "The salesbot's ear just spins around and around. Probably one of those "sensor-round" models."
			)
			(10 ; Taste
				(Print 391 31) ; "I know you're lonely, but licking a robot's ear?"
			)
			(11 ; Smell
				(Print 391 28) ; "The robot has your typical mechanical aromas."
			)
			(10 ; Taste
				(Print 391 29) ; "Your sense of appropriate public behavior leaves a lot to be desired."
			)
			(3 ; Do
				(Print 391 32) ; "Don't touch the robot's ear. You don't know where it's been."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theMouth of Prop
	(properties
		x 162
		y 60
		description {salesbot's mouth}
		view 391
		loop 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 391 33) ; "The salesbot flashes you a grin."
			)
			(10 ; Taste
				(Print 391 34) ; "Everyone knows that licking a salesbot on the mouth is like plugging your tongue into a wall socket."
			)
			(11 ; Smell
				(Print 391 35) ; "Ozone oozes from his frantically flashing lips."
			)
			(3 ; Do
				(Print 391 36) ; "You should stay out of the mouths of others."
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
		view 391
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 391 37) ; "There's probably not much in this robot's head."
			)
			(10 ; Taste
				(Print 391 29) ; "Your sense of appropriate public behavior leaves a lot to be desired."
			)
			(11 ; Smell
				(Print 391 38) ; "Smells like he put too much "Lube-Ina-Tube" on this morning."
			)
			(3 ; Do
				(Print 391 39) ; "Hey! Leave the head alone!"
			)
			(5 ; Talk
				(Print 391 40) ; "This model is not programmed to talk with the customers. You must interact with him through his touch-screen chest monitor."
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
				(Print 391 41) ; "The friendly salesbot smiles at you and thanks you for licking his chest monitor clean."
			)
			(11 ; Smell
				(Print 391 42) ; "It smells dusty - like old electronics."
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
		view 391
		loop 5
		priority 15
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 391 43) ; "One of several varieties of PocketPal(tm) connector plug."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (delete)
		(super delete:)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
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

