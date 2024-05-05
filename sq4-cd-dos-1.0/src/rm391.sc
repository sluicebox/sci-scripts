;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 391)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use Sq4Dialog)
(use Sq4Narrator)
(use Sq4Feature)
(use Osc)
(use RandCycle)
(use LoadMany)
(use Window)
(use Sound)
(use Motion)
(use System)

(public
	rm391 0
)

(local
	local0
	local1
	local2
	[local3 500]
)

(procedure (localproc_0 param1)
	(gCurRoom drawPic: 393)
	(Display param1 dsCOLOR global130 dsCOORD 2 12 dsWIDTH 316 dsFONT 0 dsALIGN alCENTER)
	(Display &rest dsWIDTH 270 dsCOORD 25 32 dsFONT 0)
)

(instance rm391 of SQRoom
	(properties
		picture 391
		style 10
		lookStr 3 ; "The rest of the store seems to be pretty empty. But everything is available through the friendly salesbot."
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
		(robotEarSnd vol: 65)
		(robotEarSnd init: play:)
		(self setScript: welcomeSir)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; ???
				(gCurRoom newRoom: 390)
			)
			(6 ; Smell
				(gNarrator say: 4) ; "This whole place smells musty and dusty, just like an old escape pod you used to own... (er, well... borrowed)."
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
				(BlueWindow color: global141 back: global149)
				(DrawStatus {___} global129 0)
				(gCast eachElementDo: #hide)
				(if (== (gCurRoom style:) 13)
					(gCurRoom style: 14)
				)
				(gCurRoom drawPic: 392)
				(robotEarSnd init: fade:)
				(gLongSong2 number: 396 loop: -1 vol: 127 playBed:)
				(= seconds 1)
			)
			(1
				(if
					(not
						(= register
							(proc816_3
								{__}
								78
								{Instructions}
								doInstructions
								{__}
								78
								{Specials}
								doSpecials
								{__}
								78
								{Catalog}
								doCatalog
								{__}
								78
								{Exit}
								backToRob
								{ }
								64
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

	(method (changeState newState)
		(switch (= state newState)
			(0
				(BlueWindow color: global141)
				(Message msgGET gCurRoomNum 2 0 1 1 @local3)
				(localproc_0 {INSTRUCTIONS} @local3 102 global135)
				(= seconds 2)
			)
			(1
				(if (!= gMessageMode 1)
					(newRob say: 1)
				)
				(if
					(proc816_3
						{__}
						78
						{Continue}
						0
						{__}
						78
						{Return to Top Menu}
						1
						{__}
						64
						56
						153
					)
					(gLongSong number: (Random 392 395) play:)
					(client setScript: startTerminal)
				else
					(gLongSong number: (Random 392 395) play:)
					(Message msgGET gCurRoomNum 2 0 2 1 @local3)
					(localproc_0 {INSTRUCTIONS} @local3 102 global135)
					(= seconds 2)
				)
			)
			(2
				(if (!= gMessageMode 1)
					(newRob say: 2)
				)
				(if
					(proc816_3
						{ }
						78
						{Return to Top Menu}
						0
						{__}
						78
						{Limited Time Specials}
						1
						{ }
						64
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

(instance doSpecials of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(BlueWindow color: (proc0_18 global161 global156))
				(Message msgGET gCurRoomNum 2 0 3 1 @local3)
				(localproc_0
					{SPECIALS}
					@local3
					102
					(proc0_18 global133 global132)
				)
				(= seconds 2)
			)
			(1
				(if (!= gMessageMode 1)
					(newRob say: 3)
				)
				(if
					(proc816_3
						{ }
						78
						{Continue}
						0
						{ }
						78
						{Return to Top Menu}
						1
						{ }
						64
						60
						122
					)
					(gLongSong number: (Random 392 395) play:)
					(client setScript: startTerminal)
				else
					(gLongSong number: (Random 392 395) play:)
					(Message msgGET gCurRoomNum 2 0 4 1 @local3)
					(localproc_0
						{SPECIALS}
						@local3
						102
						(proc0_18 global133 global132)
					)
					(= seconds 2)
				)
			)
			(2
				(if (!= gMessageMode 1)
					(newRob say: 4)
				)
				(switch
					(proc816_3
						78
						{Order}
						0
						{ }
						78
						{To Top Menu}
						1
						{ }
						78
						{Automated Catalog}
						2
						64
						20
						135
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(proc816_3
							{Sorry - dealers only!__}
							78
							{Continue}
							1
							64
							60
							140
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
				(Message msgGET gCurRoomNum 2 0 3 1 @local3)
				(localproc_0
					{- Automated Catalog -}
					{\n\n\nWelcome to our Automated Catalog!__Please select from the following departments: }
					@local3
					102
					(proc0_18 global138 global137)
				)
				(= seconds 2)
			)
			(1
				1
				(self
					changeState:
						(proc816_3
							{ }
							78
							{Electronic Gadgets}
							2
							{__}
							78
							{The Electronic Mommy}
							13
							{ }
							109
							{ }
							109
							{ }
							78
							{TechnoTots Toy Dept.}
							21
							{__}
							78
							{Return to Top Menu}
							29
							{ }
							64
							22
							102
						)
						(gLongSong number: (Random 392 395) play:)
				)
			)
			(2
				2
				(Message msgGET gCurRoomNum 2 0 7 1 @local3)
				(localproc_0
					{- Electronic Gadgets -}
					@local3
					102
					(proc0_18 global138 global137)
				)
				(= seconds 2)
			)
			(3
				3
				(if (!= gMessageMode 1)
					(newRob say: 7)
				)
				(switch
					(proc816_3
						{ }
						78
						{Order}
						0
						{ }
						78
						{Continue}
						1
						{ }
						78
						{Return to Top Menu}
						2
						{ }
						64
						35
						142
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(proc816_3
							{Back-ordered; none currently available.}
							109
							78
							{Continue}
							1
							64
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
			(4
				4
				(Message msgGET gCurRoomNum 2 0 8 1 @local3)
				(localproc_0
					{- Electronic Gadgets -}
					@local3
					102
					(proc0_18 global138 global137)
				)
				(= seconds 2)
			)
			(5
				5
				(if (!= gMessageMode 1)
					(newRob say: 8)
				)
				(switch
					(proc816_3
						{ }
						78
						{Order}
						0
						{ }
						78
						{Continue}
						1
						{ }
						78
						{Return to Top Menu}
						2
						{ }
						64
						40
						152
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(proc816_3
							{Sorry - Discontinued.__}
							78
							{Continue}
							1
							64
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
			(6
				6
				(Message msgGET gCurRoomNum 2 0 9 1 @local3)
				(localproc_0
					{- Electronic Gadgets -}
					@local3
					102
					(proc0_18 global138 global137)
				)
				(= seconds 2)
			)
			(7
				7
				(if (!= gMessageMode 1)
					(newRob say: 9)
				)
				(switch
					(proc816_3
						{ }
						78
						{Order}
						0
						{ }
						78
						{Continue}
						1
						{ }
						78
						{Return to Top Menu}
						2
						{ }
						64
						35
						142
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(proc816_3
							{Sorry - Estimated delivery:\nSummer 2735.}
							109
							78
							{Continue}
							1
							64
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
			(8
				8
				(Message msgGET gCurRoomNum 2 0 10 1 @local3)
				(localproc_0
					{- Electronic Gadgets -}
					@local3
					102
					(proc0_18 global138 global137)
				)
				(= seconds 2)
			)
			(9
				9
				(if (!= gMessageMode 1)
					(newRob say: 10)
				)
				(switch
					(proc816_3
						{ }
						78
						{Order}
						0
						{ }
						78
						{Continue}
						1
						{ }
						78
						{Return to Top Menu}
						2
						{ }
						64
						35
						144
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(proc816_3
							{You do not possess the necessary number of Buckazoids.}
							64
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
			(10
				10
				(Message msgGET gCurRoomNum 2 0 11 1 @local3)
				(localproc_0
					{- Electronic Gadgets -}
					@local3
					102
					(proc0_18 global138 global137)
				)
				(= seconds 2)
			)
			(11
				11
				(if (!= gMessageMode 1)
					(newRob say: 11)
				)
				(switch
					(proc816_3
						{ }
						78
						(if (or (gEgo has: 11) (IsFlag 71)) ; plug
							{Exchange}
						else
							{Order}
						)
						0
						{ }
						78
						{Catalog Menu}
						1
						{ }
						78
						{Return to Top Menu}
						2
						{ }
						64
						35
						132
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(cond
							((or (gEgo has: 11) (IsFlag 71)) ; plug
								(proc816_3
									{With many a grind, moan and "Well, I dunno...", the salesbot finally allows you to exchange the plug. }
									64
									60
									132
								)
								(self setScript: choosePlug self)
							)
							((>= gBuckazoidCount 1999)
								(proc816_3
									{With great patience, you insert each and every one of the 1999 buckazoids into the salesbot's coin receptor. }
									64
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
								(proc816_3
									{You do not possess the necessary number of Buckazoids.}
									64
									60
									132
								)
								(= cycles 1)
							)
						)
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
			(12
				12
				(self changeState: 0)
			)
			(13
				13
				(Message msgGET gCurRoomNum 2 0 13 1 @local3)
				(localproc_0
					{- Electronic Mommy -}
					@local3
					102
					(proc0_18 global138 global137)
				)
				(= seconds 2)
			)
			(14
				14
				(if (!= gMessageMode 1)
					(newRob say: 13)
				)
				(switch
					(proc816_3
						{ }
						78
						{Order}
						0
						{ }
						78
						{Continue}
						1
						{ }
						78
						{Return to Top Menu}
						2
						{ }
						64
						35
						136
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(proc816_3
							{Sorry - Recalled by manufacturer.__}
							78
							{Continue}
							1
							64
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
			(15
				15
				(Message msgGET gCurRoomNum 2 0 14 1 @local3)
				(localproc_0
					{- Electronic Mommy -}
					@local3
					102
					(proc0_18 global138 global137)
				)
				(= seconds 2)
			)
			(16
				16
				(if (!= gMessageMode 1)
					(newRob say: 14)
				)
				(switch
					(proc816_3
						{ }
						78
						{Order}
						0
						{ }
						78
						{Continue}
						1
						{ }
						78
						{Return to Top Menu}
						2
						{ }
						64
						35
						125
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(proc816_3
							{Sorry - Not available in the Spiral Arm.__}
							109
							78
							{Continue}
							1
							64
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
			(17
				17
				(Message msgGET gCurRoomNum 2 0 15 1 @local3)
				(localproc_0
					{- Electronic Mommy -}
					@local3
					102
					(proc0_18 global138 global137)
				)
				(= seconds 2)
			)
			(18
				18
				(if (!= gMessageMode 1)
					(newRob say: 15)
				)
				(switch
					(proc816_3
						{ }
						78
						{Order}
						0
						{ }
						78
						{Continue}
						1
						{ }
						78
						{Return to top menu}
						2
						{ }
						64
						35
						163
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(proc816_3
							{Sorry - Estimated date of uplink: November 2803.}
							109
							78
							{Continue}
							1
							64
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
			(19
				19
				(Message msgGET gCurRoomNum 2 0 16 1 @local3)
				(localproc_0
					{- Electronic Mommy -}
					@local3
					102
					(proc0_18 global138 global137)
				)
				(= seconds 2)
			)
			(20
				20
				(if (!= gMessageMode 1)
					(newRob say: 16)
				)
				(switch
					(proc816_3
						78
						{Order}
						0
						{ }
						78
						{Return to Catalog Menu}
						1
						{ }
						78
						{Top Menu}
						2
						64
						20
						155
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(proc816_3
							{Sorry - Currently under UCC investigation.}
							109
							78
							{Continue}
							1
							64
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
			(21
				21
				(Message msgGET gCurRoomNum 2 0 17 1 @local3)
				(localproc_0
					{TechnoTots Toys}
					@local3
					102
					(proc0_18 global138 global137)
				)
				(= seconds 2)
			)
			(22
				22
				(if (!= gMessageMode 1)
					(newRob say: 17)
				)
				(switch
					(proc816_3
						{ }
						78
						{Order}
						0
						{ }
						78
						{Continue}
						1
						{ }
						78
						{Return to Top Menu}
						2
						{ }
						64
						40
						135
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(proc816_3
							{Sorry - Sold out.__}
							78
							{Continue}
							1
							64
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
			(23
				23
				(Message msgGET gCurRoomNum 2 0 18 1 @local3)
				(localproc_0
					{TechnoTots Toys}
					@local3
					102
					(proc0_18 global138 global137)
				)
				(= seconds 2)
			)
			(24
				24
				(if (!= gMessageMode 1)
					(newRob say: 18)
				)
				(switch
					(proc816_3
						{ }
						78
						{Order}
						0
						{ }
						78
						{Continue}
						1
						{ }
						78
						{Return to Top Menu}
						2
						{ }
						64
						35
						135
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(proc816_3
							{Sorry - Discontinued.__}
							78
							{Continue}
							1
							64
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
			(25
				25
				(Message msgGET gCurRoomNum 2 0 19 1 @local3)
				(localproc_0
					{TechnoTots Toys}
					@local3
					102
					(proc0_18 global138 global137)
				)
				(= seconds 2)
			)
			(26
				26
				(if (!= gMessageMode 1)
					(newRob say: 19)
				)
				(switch
					(proc816_3
						{ }
						78
						{Order}
						0
						{ }
						78
						{Continue}
						1
						{ }
						78
						{Return to Top Menu}
						2
						{ }
						64
						35
						140
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(proc816_3
							{Sorry - Due to delay in manufacturing, this item\nis not yet available.}
							109
							78
							{Continue}
							1
							64
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
			(27
				27
				(Message msgGET gCurRoomNum 2 0 20 1 @local3)
				(localproc_0
					{TechnoTots Toys}
					@local3
					102
					(proc0_18 global138 global137)
				)
				(= seconds 2)
			)
			(28
				28
				(switch
					(proc816_3
						{ }
						78
						{Order}
						0
						{ }
						78
						{Return to Top Menu}
						1
						{ }
						64
						60
						132
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(proc816_3
							{Sorry - Sold out.__}
							78
							{Continue}
							1
							64
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
			(29
				29
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
				(gLongSong2 number: 396 loop: -1 vol: 127 playBed:)
				(robotEarSnd vol: 65)
				(robotEarSnd init: play:)
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
						{ THANK YOU\nFOR SHOPPING\nHz SO GOOD!}
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
					{Select the plug you\n_wish to purchase.}
					@local3
					100
					97
					163
					102
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

(instance theEyes of Sq4Prop
	(properties
		x 162
		y 25
		view 391
		loop 4
		lookStr 5 ; "The salesbot's eyes seem to be having a hard time focusing on you."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gNarrator say: 6) ; "Be reasonable. What would you do with robot eyes, anyway?"
			)
			(6 ; Smell
				(gNarrator say: 1) ; "The robot has your typical mechanical aromas."
			)
			(7 ; Taste
				(gNarrator say: 2) ; "Your sense of appropriate public behavior leaves a lot to be desired."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lEar of Sq4Prop
	(properties
		x 79
		y 26
		view 391
		loop 1
		lookStr 7 ; "The salesbot's ear just spins around and around."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Taste
				(gNarrator say: 8) ; "I know you're lonely, but licking a robot's ear?"
			)
			(6 ; Smell
				(gNarrator say: 1) ; "The robot has your typical mechanical aromas."
			)
			(7 ; Taste
				(gNarrator say: 2) ; "Your sense of appropriate public behavior leaves a lot to be desired."
			)
			(4 ; Do
				(gNarrator say: 9) ; "Don't touch the robot's ear. You don't know where it's been."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rEar of Sq4Prop
	(properties
		x 245
		y 26
		view 391
		loop 2
		lookStr 7 ; "The salesbot's ear just spins around and around."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Taste
				(gNarrator say: 8) ; "I know you're lonely, but licking a robot's ear?"
			)
			(6 ; Smell
				(gNarrator say: 1) ; "The robot has your typical mechanical aromas."
			)
			(7 ; Taste
				(gNarrator say: 2) ; "Your sense of appropriate public behavior leaves a lot to be desired."
			)
			(4 ; Do
				(gNarrator say: 9) ; "Don't touch the robot's ear. You don't know where it's been."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theMouth of Sq4Prop
	(properties
		x 162
		y 60
		view 391
		loop 3
		lookStr 10 ; "The salesbot flashes you a grin."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Taste
				(gNarrator say: 11) ; "Everyone knows that licking a salesbot on the mouth is like plugging your tongue into a wall socket."
			)
			(6 ; Smell
				(gNarrator say: 12) ; "Ozone oozes from his frantically flashing lips."
			)
			(4 ; Do
				(gNarrator say: 13) ; "You should stay out of the mouths of others."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance roboHead of Sq4Prop
	(properties
		x 160
		y 9
		view 391
		lookStr 14 ; "There's probably not much in this robot's head."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Taste
				(gNarrator say: 2) ; "Your sense of appropriate public behavior leaves a lot to be desired."
			)
			(6 ; Smell
				(gNarrator say: 15) ; "Smells like he put too much "Lube-Ina-Tube" on this morning."
			)
			(4 ; Do
				(gNarrator say: 16) ; "Hey! Leave the head alone!"
			)
			(2 ; Talk
				(gNarrator say: 17) ; "This model is programmed to interact with the customers through his touch-screen chest monitor."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance chest of Sq4View
	(properties
		x 161
		y 189
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
			(7 ; Taste
				(gNarrator say: 18) ; "The friendly salesbot smiles at you and thanks you for licking his chest monitor clean."
			)
			(6 ; Smell
				(gNarrator say: 19) ; "It smells dusty - like old electronics."
			)
			(else
				(gCurRoom setScript: startTerminal)
			)
		)
	)
)

(instance connector of Sq4View
	(properties
		view 391
		loop 5
		priority 15
		signal 16
		lookStr 21 ; "One of several varieties of PocketPal(tm) connector plug."
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

(instance newRob of Sq4Narrator
	(properties
		noun 23
		modNum 391
		talkerNum 23
		nMsgType 2
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

