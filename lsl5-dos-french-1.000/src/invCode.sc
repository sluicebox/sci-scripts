;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19)
(include sci.sh)
(use Main)
(use Language)
(use BorderWindow)
(use IconBar)
(use Motion)
(use Inventory)
(use System)

(public
	invCode 0
	invWin 1
)

(local
	[local0 26] = [19 0 19 1 19 2 19 3 19 4 19 5 19 6 19 7 19 8 19 9 19 10 19 11 19 12]
)

(procedure (localproc_0 param1 param2 &tmp temp0)
	(TPrint (+ param2 (if gEgoIsLarry 50 else 80)) param1)
)

(class LLIconItem of IconI
	(properties
		helpModule 25
	)

	(method (ownedBy)
		(return 0)
	)
)

(instance invCode of Code
	(properties)

	(method (init)
		(Inv
			init:
			add: ok
			window: invWin
			helpIconItem: invHelp
			selectIcon: invSelect
			okButton: ok
		)
	)

	(method (doit param1)
		(switch param1
			(23
				(Inv
					add:
						Camcorder
						Battery_Charger
						A_Blank_Videotape_a
						A_Blank_Videotape_b
						A_Blank_Videotape_c
						Michelle_Milken_s_Resume
						Hard_Disk_Cafe_Napkin
						AeroDork_Gold_Card
						Boarding_Pass
						AeroDork_s_In_Flight_Magazine
						Some_Change
						DayTrotter_
						Money
						Credit_Cards
						Membership_Tape
						Lana_Luscious__Resume
						Tramp_Casino_Matchbook
						Silver_Dollar
						Roller_skates
						Chi_Chi_Lambada_s_Resume
						Doc_Pulliam_s_Card
						Green_Card
						Doily
						invLook
						invHand
						invSelect
						invHelp
						ok
					eachElementDo: #highlightColor gColLBlue
					eachElementDo: #lowlightColor gColDBlue
					eachElementDo: #init
					state: 2048
				)
			)
			(24
				(Inv
					add:
						DataMan
						Reverse_Biaz_DataPak
						P__C__Hammer_DataPak
						Reverse_Biaz_Fax
						Champagne
						Gold_Record
						Cassette_Tape
						P__C__Hammer_Fax
						Letter_Opener
						Desk_Key
						Folder_Of_Evidence
						Photocopied_Evidence
						Reel_To_Reel_Tape
						Hooter_Shooter
						invLook
						invHand
						invSelect
						invHelp
						ok
					eachElementDo: #highlightColor gColLBlue
					eachElementDo: #lowlightColor gColDBlue
					eachElementDo: #init
					state: 2048
				)
			)
		)
	)
)

(instance invWin of InsetWindow
	(properties
		priority -1
		topBordHgt 28
		botBordHgt 5
	)

	(method (open)
		(invLook nsLeft: (- (/ (- (self right:) (self left:)) 2) 68))
		(super open:)
	)
)

(instance ok of LLIconItem
	(properties
		view 991
		loop 3
		cel 0
		cursor 999
		signal 67
		helpStr 1
	)

	(method (init)
		(= highlightColor 0)
		(= lowlightColor gColYellow)
		(super init:)
	)
)

(instance invLook of LLIconItem
	(properties
		view 991
		loop 2
		cel 0
		cursor 1
		message 2
		signal 129
		helpStr 2
	)

	(method (init)
		(= highlightColor 0)
		(= lowlightColor gColCyan)
		(super init:)
	)
)

(instance invHand of LLIconItem
	(properties
		view 991
		loop 0
		cel 0
		cursor 2
		message 3
		helpStr 3
	)

	(method (init)
		(= highlightColor 0)
		(= lowlightColor gColLGreen)
		(super init:)
	)
)

(instance invHelp of LLIconItem
	(properties
		view 991
		loop 1
		cel 0
		cursor 9
		message 6
		helpStr 4
	)

	(method (init)
		(= highlightColor 0)
		(= lowlightColor gColLRed)
		(super init:)
	)
)

(instance invSelect of LLIconItem
	(properties
		view 991
		loop 4
		cel 0
		cursor 999
		helpStr 5
	)

	(method (init)
		(= highlightColor 0)
		(= lowlightColor gColLMagenta)
		(super init:)
	)
)

(instance Camcorder of InvI
	(properties
		view 931
		cursor 931
		signal 2
		description {the camcorder}
	)

	(method (doVerb theVerb invItem &tmp [temp0 60] temp60 temp61)
		(= temp60 (mod state 100))
		(switch theVerb
			(2 ; Look
				(TPrint 19 13 70 250 80 name) ; "Auto-focus, auto-level, auto-color balance, auto-zoom, auto-pan, .5-lux, Complete-Video- Studio-in-a-Pocket-Protector. 'The Rob Lowe Model'"
				(Format ; "Power: %s Charge: %d min %d sec"
					@temp0
					19
					14
					(if (>= state 100) {On} else {Off})
					(/ (gChargeTimer seconds:) 60)
					(mod (gChargeTimer seconds:) 60)
					(if (>= state 100) {Ouvert} else {Ferm\82})
					(/ (gChargeTimer seconds:) 60)
					(mod (gChargeTimer seconds:) 60)
				)
				(TPrint @temp0 70 123 30 1 80 name)
			)
			(3 ; Do
				(cond
					((>= state 100)
						(-= state 100)
						(TPrint 19 15) ; "Delicately exchanging your blue ballpoint with your yellow highlighter, you switch the camcorder off."
						(Format ; "Charge: %d min %d sec"
							@temp0
							19
							16
							(/ (gChargeTimer seconds:) 60)
							(mod (gChargeTimer seconds:) 60)
							(/ (gChargeTimer seconds:) 60)
							(mod (gChargeTimer seconds:) 60)
						)
						(TPrint @temp0)
					)
					((and temp60 (gChargeTimer seconds:))
						(+= state 100)
						(Points 4 72)
						(TPrint 19 17) ; "Slipping your green felt-tip between the .5-mm lead mechanical pencil and the blue ink rolling ball pen, you switch the camcorder on."
						(Format ; "Charge: %d min %d sec"
							@temp0
							19
							16
							(/ (gChargeTimer seconds:) 60)
							(mod (gChargeTimer seconds:) 60)
							(/ (gChargeTimer seconds:) 60)
							(mod (gChargeTimer seconds:) 60)
						)
						(TPrint @temp0)
					)
					(temp60
						(TPrint 19 18) ; "Your camcorder's batteries are exhausted."
					)
					(else
						(TPrint 19 19) ; "The camcorder will not operate without a videotape inside."
					)
				)
			)
			(4 ; Inventory
				(if (OneOf invItem 2 3 4) ; A_Blank_Videotape_a, A_Blank_Videotape_b, A_Blank_Videotape_c
					(if temp60
						(TPrint 19 20) ; "Before installing another videotape, you first remove the tape in the camcorder."
						((Inv at: temp60) owner: 23)
					)
					(if (!= ((Inv at: invItem) state:) 1)
						(TPrint 19 21) ; "Because of its tiny size, your camcorder has no erase heads. It requires tapes that have been previously degaussed."
						(TPrint 19 22 67 -1 185) ; "(You DID degauss them, didn't you, Larry?)"
						(= state 0)
					else
						(Points 4 73)
						(TPrint 19 23) ; "You insert the tape into "The Rob Lowe.""
						(= state invItem)
						((Inv at: invItem) owner: Camcorder)
						(gTheIconBar curInvIcon: 0)
						(Inv curIcon: 0 hide:)
						(gEgo showInv:)
					)
				else
					(localproc_0 (Inv indexOf: self) invItem)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Battery_Charger of InvI
	(properties
		name {Battery Charger}
		view 932
		cursor 932
		signal 2
		description {the battery charger}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 19 24 80 name) ; "Insert into any 110-volt, 20-amp GFI-protected circuit. Recharges most batteries in one minute!"
			)
			(3 ; Do
				(TPrint 19 25) ; "You open the battery charger and discover there's no battery inside!"
			)
			(4 ; Inventory
				(switch invItem
					(0 ; Camcorder
						(TPrint 19 26) ; "The battery recharger must be plugged into a wall socket before the camcorder may be installed in it."
					)
					(else
						(localproc_0 (Inv indexOf: self) invItem)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance A_Blank_Videotape_a of InvI
	(properties
		name {A Blank Videotape}
		view 934
		cursor 934
		signal 2
		description {the videotape}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(switch state
					(0
						(TPrint 19 27 80 name 30 1) ; "Genuine pretty-good quality Highly biased Degauss before using Floss before brushing T-10"
					)
					(1
						(TPrint 19 28 80 name) ; "The videotape is already degaussed."
					)
					(2
						(TPrint 19 29 80 name) ; "You had no idea financial concepts could be so "physically" rewarding!"
					)
					(3
						(TPrint 19 30 80 name) ; "You had no idea mud wrestling could be so spiritually rewarding!"
					)
					(4
						(TPrint 19 31 80 name) ; "You had no idea dental pain could be so rewarding!"
					)
				)
			)
			(3 ; Do
				(TPrint 19 32) ; "You wiggle the tiny door on the videotape just to make sure it still works. It does."
			)
			(4 ; Inventory
				(localproc_0 (Inv indexOf: self) invItem)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance A_Blank_Videotape_b of InvI
	(properties
		name {A Blank Videotape}
		view 934
		cursor 934
		signal 2
		description {the videotape}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(switch state
					(0
						(TPrint 19 27 80 name 30 1) ; "Genuine pretty-good quality Highly biased Degauss before using Floss before brushing T-10"
					)
					(1
						(TPrint 19 28 80 name) ; "The videotape is already degaussed."
					)
					(2
						(TPrint 19 29 80 name) ; "You had no idea financial concepts could be so "physically" rewarding!"
					)
					(3
						(TPrint 19 30 80 name) ; "You had no idea mud wrestling could be so spiritually rewarding!"
					)
					(4
						(TPrint 19 31 80 name) ; "You had no idea dental pain could be so rewarding!"
					)
				)
			)
			(3 ; Do
				(TPrint 19 33) ; "You shake the videotape violently, seeking to prevent premature shell stickage."
			)
			(4 ; Inventory
				(localproc_0 (Inv indexOf: self) invItem)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance A_Blank_Videotape_c of InvI
	(properties
		name {A Blank Videotape}
		view 934
		cursor 934
		signal 2
		description {the videotape}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(switch state
					(0
						(TPrint 19 27 80 name 30 1) ; "Genuine pretty-good quality Highly biased Degauss before using Floss before brushing T-10"
					)
					(1
						(TPrint 19 28 80 name) ; "The videotape is already degaussed."
					)
					(2
						(TPrint 19 29 80 name) ; "You had no idea financial concepts could be so "physically" rewarding!"
					)
					(3
						(TPrint 19 30 80 name) ; "You had no idea mud wrestling could be so spiritually rewarding!"
					)
					(4
						(TPrint 19 31 80 name) ; "You had no idea dental pain could be so rewarding!"
					)
				)
			)
			(3 ; Do
				(TPrint 19 34) ; "You smooth down the label on the videotape with your hand."
			)
			(4 ; Inventory
				(localproc_0 (Inv indexOf: self) invItem)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Michelle_Milken_s_Resume of InvI
	(properties
		name {Michelle Milken's Resume}
		view 937
		cursor 937
		signal 2
		description {Michelle's resume}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 19 35 33 gMonoFont 82 937 2 1 80 name) ; "NAME    Michelle Milken AGE     28 HAIR    Black EYES    Brown HEIGHT   6' 1" WEIGHT   131"
				(TPrint 19 36 33 gMonoFont 70 222 80 name) ; "OCCUPATION junk bond sales HANGOUTS  Wall Street,       computer stores TURNONS   anything covered       with whipped cream TURNOFFS  strong moral fiber"
				(if (not (OneOf (Hard_Disk_Cafe_Napkin owner:) 23 510))
					(Points 1 69)
					(TPrint 19 37) ; "Inside her folder, you find a napkin."
					(gEgo get: 6) ; Hard_Disk_Cafe_Napkin
					(gTheIconBar curInvIcon: 0)
					(Inv curIcon: 0 hide:)
					(gEgo showInv:)
				)
			)
			(3 ; Do
				(TPrint 19 38) ; "You open Michelle Milken's resume and look inside."
				(self doVerb: 2)
			)
			(4 ; Inventory
				(localproc_0 (Inv indexOf: self) invItem)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Hard_Disk_Cafe_Napkin of InvI
	(properties
		name {Hard Disk Cafe Napkin}
		view 938
		cursor 938
		signal 2
		description {the Hard Disk Cafe napkin}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 19 39 80 name 70 222 30 1) ; "If computers are your life, grab a quick byte in our cafe! In the Heart of the Fabulous Times Square Wine Country 920 W. 42nd Street New York City"
			)
			(3 ; Do
				(TPrint 19 40) ; "Exploring for a secret message from someone in New York City, you unfold the Hard Disk Cafe napkin. Alas, you find nothing written on the napkin."
			)
			(4 ; Inventory
				(localproc_0 (Inv indexOf: self) invItem)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance AeroDork_Gold_Card of InvI
	(properties
		name {AeroDork Gold Card}
		view 939
		cursor 939
		signal 2
		description {the AeroDork Gold Card}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 19 41 80 name) ; "Whether in the U.S.A. or the South Pacific, it's Nontoonyt for you on AeroDork!"
			)
			(3 ; Do
				(TPrint 19 42) ; "You scratch the AeroDork Gold Card and find it isn't made of solid gold."
			)
			(4 ; Inventory
				(localproc_0 (Inv indexOf: self) invItem)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Boarding_Pass of InvI
	(properties
		name {Boarding Pass}
		view 940
		cursor 940
		signal 2
		description {the boarding pass}
	)

	(method (doVerb theVerb invItem &tmp [temp0 200] [temp200 20] temp220 temp221 temp222 temp223)
		(switch theVerb
			(2 ; Look
				(= temp222 (& (= temp220 (GetTime 3)) $001f)) ; SysDate
				(= temp221 (& (>> temp220 $0005) $000f))
				(= temp223 (+ (>> temp220 $0009) 1980))
				(GetFarText 19 temp221 @temp200)
				(if 1
					(= global200 (Memory memALLOC_CRIT (StrLen @temp200)))
					(= global203 (Memory memALLOC_CRIT (StrLen @temp200)))
					(StrSplitInTwo global200 global203 @temp200)
					(Format ; "This boarding pass good for one First Class Seat on AeroDork Flight #1, %s to %s, seat %d%c, %s %d, %d only."
						@temp0
						19
						43
						(switch gLarryLoc
							(0 {L.A.})
							(1 {New York})
							(2 {Atlantic City})
							(3 {Miami})
						)
						(switch state
							(0 {L.A.})
							(1 {New York})
							(2 {Atlantic City})
							(3 {Miami})
						)
						(/ gAirplaneSeat 100)
						(mod gAirplaneSeat 100)
						global200
						temp222
						temp223
						(switch gLarryLoc
							(0 {L.A.})
							(1 {New York})
							(2 {Atlantic City})
							(3 {Miami})
						)
						(switch state
							(0 {L.A.})
							(1 {New York})
							(2 {Atlantic City})
							(3 {Miami})
						)
						(/ gAirplaneSeat 100)
						(mod gAirplaneSeat 100)
						global203
						temp222
						temp223
					)
					(Memory memFREE global200)
					(Memory memFREE global203)
				)
				(TPrint @temp0 80 name)
			)
			(3 ; Do
				(TPrint 19 44) ; "You open the boarding pass and discover it looks like it would just fit inside the AeroDork Boarding Pass Folder that came in the box with your copy of this game!"
			)
			(4 ; Inventory
				(localproc_0 (Inv indexOf: self) invItem)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance AeroDork_s_In_Flight_Magazine of InvI
	(properties
		name {AeroDork's In-Flight Magazine}
		view 941
		cursor 941
		signal 2
		description {the magazine}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 19 45 80 name) ; "Good idea; save this in case the restroom runs out of paper!"
			)
			(3 ; Do
				(TPrint 19 46) ; "Opening the magazine, you discover an interesting article. It says computer punch cards are descendants of a long line of mechanical products dating all the way back to the music box."
				(Points 5 68)
				(TPrint 19 47) ; "You promise to remember this information, in case you ever run across a music box in a computer store."
			)
			(4 ; Inventory
				(localproc_0 (Inv indexOf: self) invItem)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Some_Change of InvI
	(properties
		name {Some Change}
		view 942
		cursor 942
		signal 2
		description {the quarter}
	)

	(method (doVerb theVerb invItem &tmp [temp0 55])
		(switch theVerb
			(2 ; Look
				(Format @temp0 19 48 (* gQuarters 2)) ; "You always were a %d-bit game player!"
				(TPrint @temp0 80 name)
			)
			(3 ; Do
				(Format ; "You flip the quarter in the air. It comes up %s."
					@temp0
					19
					49
					(if (Random 0 1) {heads} else {tails})
					(if (Random 0 1) {pile} else {face})
				)
				(TPrint @temp0)
			)
			(4 ; Inventory
				(localproc_0 (Inv indexOf: self) invItem)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance DayTrotter_ of InvI
	(properties
		name {DayTrotter\05}
		view 943
		cursor 943
		signal 2
		description {the DayTrotter\05}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if state
					(TPrint 19 50 80 name) ; "You always wanted to have one of these, but you never had anything to schedule!"
				else
					(Points 11 74)
					(TPrint 19 51 80 name) ; "Inside you find: some folding money with more than two digits in the corners, many credit cards, some mutual fund account access codes, and a Swiss bank account number."
					(gTheIconBar curInvIcon: 0)
					(Inv curIcon: 0 hide:)
					(= state 1)
					(gEgo get: 12 13 showInv:) ; Money
				)
			)
			(3 ; Do
				(if state
					(TPrint 19 52 80 name) ; "You thumb through the pages looking for anything that might help you, but find nothing except some alphabetical page dividers, which you rip out of the binder in disgust and throw away!"
				else
					(self doVerb: 2)
				)
			)
			(4 ; Inventory
				(localproc_0 (Inv indexOf: self) invItem)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Money of InvI
	(properties
		view 944
		cursor 944
		signal 2
		description {the money}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 19 53 80 name) ; "This is even better than having your own savings and loan (as you think you may have had in "LSL4: The Missing Floppies!")"
			)
			(3 ; Do
				(TPrint 19 54) ; "You really enjoy running your money through your fingers. However, counting that high is beyond your limited mathematical skills."
			)
			(4 ; Inventory
				(localproc_0 (Inv indexOf: self) invItem)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Credit_Cards of InvI
	(properties
		name {Credit Cards}
		view 945
		cursor 945
		signal 2
		description {the credit cards}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 19 55 80 name) ; "Whoever this Pat Patterson guy was, he was sure loaded!"
			)
			(3 ; Do
				(TPrint 19 56) ; "You carefully count the credit cards. There are more than you ever imagined having."
			)
			(4 ; Inventory
				(localproc_0 (Inv indexOf: self) invItem)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Membership_Tape of InvI
	(properties
		name {Membership Tape}
		view 946
		cursor 946
		signal 2
		description {the membership tape}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(switch state
					(1
						(TPrint 19 57 80 name) ; "What an interesting way to make a club membership card! No one uses this antique, 9-track, paper tape any more!"
					)
					(2
						(TPrint 19 58 80 name) ; "Whoever said you're not a man of credit?"
					)
					(3
						(TPrint 19 59 80 name) ; "How clever you are! A few extra holes and you're a new man!"
					)
				)
			)
			(3 ; Do
				(TPrint 19 60) ; "You briefly consider folding, spindling or mutilating this tape, but remembering your early training, decide not to do it--at least, not here."
			)
			(4 ; Inventory
				(localproc_0 (Inv indexOf: self) invItem)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance DataMan of InvI
	(properties
		view 948
		cursor 948
		signal 2
		description {the DataMan}
		owner 445
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(switch state
					(0
						(TPrint 19 61 80 name) ; "You are amazed the Japanese didn't come up with this product first!"
					)
					(1
						(TPrint 19 62 80 name 30 1) ; "Reverse Biaz des Rever Records Suite 900 Shill Building 1000 Upson Downs Lane Baltimore, MD"
						(SetFlag 17) ; fSeenRBOffice
					)
					(2
						(Points 1 78)
						(TPrint 19 63 80 name 30 1) ; "P. C. Hammer K-RAP Radio 1709 Hillview Vista Philadelphia, PA Access code: 45954 often in Control Room B Access code: n/a"
					)
				)
			)
			(3 ; Do
				(switch state
					(0
						(TPrint 19 64) ; "The DataMan has no on/off switch as it is always on. However, right now it is empty."
					)
					(1
						(= state 0)
						(TPrint 19 65) ; "You remove Reverse Biaz's DataPak from your DataMan."
						(Reverse_Biaz_DataPak owner: 24)
						(gTheIconBar curInvIcon: 0)
						(Inv curIcon: 0 hide:)
						(gEgo showInv:)
					)
					(2
						(= state 0)
						(TPrint 19 66) ; "You remove P. C. Hammer's DataPak from your DataMan."
						(P__C__Hammer_DataPak owner: 24)
						(gTheIconBar curInvIcon: 0)
						(Inv curIcon: 0 hide:)
						(gEgo showInv:)
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(1 ; Battery_Charger
						(Points 7 75)
						(if (== (DataMan state:) 0)
							(TPrint 19 67) ; "You insert Reverse Biaz's DataPak into your DataMan."
							(= state 1)
							(Reverse_Biaz_DataPak owner: self)
							(gTheIconBar curInvIcon: 0)
							(Inv curIcon: 0 hide:)
							(gEgo showInv:)
						else
							(TPrint 19 68) ; "The DataMan already contains a DataPak."
						)
					)
					(2 ; A_Blank_Videotape_a
						(Points 7 75)
						(if (== (DataMan state:) 0)
							(TPrint 19 69) ; "You insert P. C. Hammer's DataPak into your DataMan."
							(= state 2)
							(P__C__Hammer_DataPak owner: self)
							(gTheIconBar curInvIcon: 0)
							(Inv curIcon: 0 hide:)
							(gEgo showInv:)
						else
							(TPrint 19 68) ; "The DataMan already contains a DataPak."
						)
					)
					(else
						(localproc_0 (Inv indexOf: self) invItem)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Reverse_Biaz_DataPak of InvI
	(properties
		name {Reverse Biaz DataPak}
		view 949
		cursor 949
		signal 2
		description {the Reverse Biaz DataPak}
		owner 445
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 19 70 80 name 30 1) ; "Reverse Biaz Insert one end first"
			)
			(3 ; Do
				(TPrint 19 71) ; "You check the DataPak carefully for any signs of damage. You find none."
			)
			(4 ; Inventory
				(localproc_0 (Inv indexOf: self) invItem)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance P__C__Hammer_DataPak of InvI
	(properties
		name {P. C. Hammer DataPak}
		view 949
		cursor 949
		signal 2
		description {the P. C. Hammer DataPak}
		owner 445
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 19 72 80 name 30 1) ; "P. C. Hammer Insert one end first"
			)
			(3 ; Do
				(TPrint 19 71) ; "You check the DataPak carefully for any signs of damage. You find none."
			)
			(4 ; Inventory
				(localproc_0 (Inv indexOf: self) invItem)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Lana_Luscious__Resume of InvI
	(properties
		name {Lana Luscious' Resume}
		view 937
		cursor 937
		signal 2
		description {Lana's resume}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 19 73 33 gMonoFont 82 937 2 2 80 name) ; "NAME    Lana Luscious AGE     21 HAIR    Blond EYES    Blue HEIGHT   5' 10" WEIGHT   123"
				(TPrint 19 74 33 gMonoFont 70 277 80 name) ; "OCCUPATION professional mud wrestler,       former "Miss Wet T-Shirt       of Atlantic City" HANGOUTS  Tramp's Boardwalk TURNONS   polyurethane, mud TURNOFFS  high IQ's"
				(if (not (gEgo has: 16)) ; Tramp_Casino_Matchbook
					(Points 1 70)
					(TPrint 19 75) ; "Inside her folder, you find a matchbook."
					(gEgo get: 16) ; Tramp_Casino_Matchbook
					(gTheIconBar curInvIcon: 0)
					(Inv curIcon: 0 hide:)
					(gEgo showInv:)
				)
			)
			(3 ; Do
				(TPrint 19 76) ; "You open Lana Luscious' resume and look inside."
				(self doVerb: 2)
			)
			(4 ; Inventory
				(localproc_0 (Inv indexOf: self) invItem)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Tramp_Casino_Matchbook of InvI
	(properties
		name {Tramp Casino Matchbook}
		view 952
		cursor 952
		signal 2
		description {the Tramp's casino matchbook}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 19 77 80 name 30 1) ; "Visit beautiful Tramp Casino on the beautiful Tramp Boardwalk outside the luxurious Tramp Hotel near the palatial Tramp Overscale Miniature Golf Course right off filthy Tramp Beach! 777 High Roller Drive Atlantic City"
			)
			(3 ; Do
				(TPrint 19 78) ; "Just for fun, you strike a match and hold it between your fingers as long as possible, until it burns down so far that you think you're about to burn yourself. Then you drop it and rub it out with your toe."
				(TPrint 19 79 67 -1 185) ; "(Thus, you amuse yourself greatly!)"
			)
			(4 ; Inventory
				(localproc_0 (Inv indexOf: self) invItem)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Silver_Dollar of InvI
	(properties
		name {Silver Dollar}
		view 953
		cursor 953
		signal 2
		description {the silver dollar}
	)

	(method (doVerb theVerb invItem &tmp [temp0 200])
		(switch theVerb
			(2 ; Look
				(Format ; "You have %d silver dollar%s, but you desire much, much more."
					@temp0
					19
					80
					gSilvDollars
					(if (> gSilvDollars 1) {s} else {})
					gSilvDollars
					(if (> gSilvDollars 1) {s} else {})
				)
				(TPrint @temp0 80 name)
				(TPrint 19 81) ; "Hey, wait a minute! These aren't real silver dollars. Every single one of them has Donald Tramp's picture on it!"
			)
			(3 ; Do
				(TPrint 19 82) ; "You enjoy the clinking sound these silver dollars make."
			)
			(4 ; Inventory
				(localproc_0 (Inv indexOf: self) invItem)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Roller_skates of InvI
	(properties
		name {Roller-skates}
		view 954
		cursor 954
		signal 2
		description {the roller-blades}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 19 83 80 name) ; "With these on your feet you feel as though you could fly... right off the boardwalk."
			)
			(3 ; Do
				(if (== gCurRoomNum 760)
					(Inv hide:)
					((ScriptID 760 1) doVerb: 4 18) ; bench
				else
					(TPrint 19 84) ; "You can't skate here, Larry!"
				)
			)
			(4 ; Inventory
				(localproc_0 (Inv indexOf: self) invItem)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Reverse_Biaz_Fax of InvI
	(properties
		name {Reverse Biaz Fax}
		view 955
		cursor 955
		signal 2
		description {the fax on Reverse Biaz}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 19 62 80 name 30 1) ; "Reverse Biaz des Rever Records Suite 900 Shill Building 1000 Upson Downs Lane Baltimore, MD"
				(SetFlag 17) ; fSeenRBOffice
			)
			(3 ; Do
				(TPrint 19 85) ; "This fax paper sure is flimsy!"
			)
			(4 ; Inventory
				(localproc_0 (Inv indexOf: self) invItem)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Champagne of InvI
	(properties
		view 956
		cursor 956
		signal 2
		description {the champagne}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 19 86 80 name) ; "You do so love a nice wet Brute!"
			)
			(3 ; Do
				(TPrint 19 87) ; "You begin to pop the cork, but decide to wait for a more opportune moment."
			)
			(4 ; Inventory
				(localproc_0 (Inv indexOf: self) invItem)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Gold_Record of InvI
	(properties
		name {Gold Record}
		view 957
		cursor 957
		signal 2
		description {the gold record}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if state
					(TPrint 19 88 80 name) ; "Excellent detective work, Patti!"
				else
					(TPrint 19 89 80 name) ; "For years you've wondered what happened to "The Four Shabangs!""
				)
			)
			(3 ; Do
				(TPrint 19 90) ; "You have your doubts that this record is solid gold."
			)
			(4 ; Inventory
				(localproc_0 (Inv indexOf: self) invItem)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Cassette_Tape of InvI
	(properties
		name {Cassette Tape}
		view 958
		cursor 958
		signal 2
		description {the cassette tape}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 19 91 80 name) ; "A smoking gun of the subtle degradation of our nation's youth by those filth-mongering blasphemers, wouldn't you say, Patti?"
			)
			(3 ; Do
				(TPrint 19 92) ; "You hold the cassette tape up to your ear and listen carefully. You do not hear the ocean roar!"
			)
			(4 ; Inventory
				(localproc_0 (Inv indexOf: self) invItem)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Chi_Chi_Lambada_s_Resume of InvI
	(properties
		name {Chi Chi Lambada's Resume}
		view 937
		cursor 937
		signal 2
		description {Chi Chi's resume}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 19 93 33 gMonoFont 82 937 2 0 80 name) ; "NAME    Chi Chi Lambada AGE     24 HAIR    Raven EYES    Chestnut HEIGHT   5' 8" WEIGHT   101"
				(TPrint 19 94 33 gMonoFont 70 240 80 name) ; "OCCUPATION dental hygienist and       former gymnast HANGOUTS  the gym; the office TURNONS   locker room odor,       dental irrigators TURNOFFS  burning rubber"
				(if (not (gEgo has: 20)) ; Doc_Pulliam_s_Card
					(Points 1 71)
					(TPrint 19 95) ; "Inside her folder, you find a business card."
					(gEgo get: 20) ; Doc_Pulliam_s_Card
					(gTheIconBar curInvIcon: 0)
					(Inv curIcon: 0 hide:)
					(gEgo showInv:)
				)
			)
			(3 ; Do
				(TPrint 19 96) ; "You open Chi Chi Lambada's resume and look inside."
				(self doVerb: 2)
			)
			(4 ; Inventory
				(localproc_0 (Inv indexOf: self) invItem)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Doc_Pulliam_s_Card of InvI
	(properties
		name {Doc Pulliam's Card}
		view 960
		cursor 960
		signal 2
		description {Doc Pulliam's card}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Points 1 77)
				(TPrint 19 97 80 name 70 222 30 1) ; "Can Doc Fixem? Nope, but can 'Doc Pulliam!!'" Doc Pulliam's Dental Hygiene Heaven, 169 Lower Wacker Drive Miami, FL Dial 554-3627 Our Motto: "Beats a doorknob and string!"
			)
			(3 ; Do
				(TPrint 19 98) ; "You turn the business card over expecting to find a secret clue on the back."
				(TPrint 19 99) ; "You don't."
			)
			(4 ; Inventory
				(localproc_0 (Inv indexOf: self) invItem)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Green_Card of InvI
	(properties
		name {Green Card}
		view 961
		cursor 961
		signal 2
		description {the green card}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 19 100 80 name) ; "Official U. S. Government Alien Resident Permit"
			)
			(3 ; Do
				(TPrint 19 101) ; "Whatever possessed you to "purchase" one of these?"
			)
			(4 ; Inventory
				(localproc_0 (Inv indexOf: self) invItem)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Doily of InvI
	(properties
		view 962
		cursor 962
		signal 2
		description {the doily}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 19 102 80 name) ; "Isn't this sweet! It would look great back home in your apartment."
				(TPrint 19 103 67 -1 185 80 name) ; "(If you HAD an apartment!)"
				(TPrint 19 104 67 -1 185 80 name) ; "(If you had a HOME!)"
			)
			(3 ; Do
				(cond
					((!= gCurRoomNum 905)
						(TPrint 19 105) ; "You'd be too embarrassed to wear the doily now!"
					)
					((gEgo sitting:)
						(TPrint 19 106) ; "Stand up first."
					)
					(else
						(if state
							(gEgo
								view: 907
								setLoop: 4
								setCel: 255
								cycleSpeed: 10
								setCycle: Beg gCurRoom
							)
							(TPrint 19 107) ; "Sadly, you remove the doily from your head."
						else
							(gEgo
								view: 907
								setLoop: 4
								setCel: 0
								cycleSpeed: 10
								setCycle: End gCurRoom
							)
							(Points 8 159)
							(TPrint 19 108) ; "Feeling rather silly, you wrap the doily around your head in a classic "3 Stooges-toothache" style."
						)
						(= state (not state))
					)
				)
			)
			(4 ; Inventory
				(localproc_0 (Inv indexOf: self) invItem)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance P__C__Hammer_Fax of InvI
	(properties
		name {P. C. Hammer Fax}
		view 955
		cursor 955
		signal 2
		description {the fax on P. C. Hammer}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 19 109 80 name 70 200 30 1) ; "P. C. Hammer K-RAP Radio 1709 Hillview Vista Philadelphia, PA Access code: 45954 often in Control Room B Access code: n/a"
			)
			(3 ; Do
				(TPrint 19 110) ; "This fax paper sure is flimsy!"
			)
			(4 ; Inventory
				(localproc_0 (Inv indexOf: self) invItem)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Letter_Opener of InvI
	(properties
		name {Letter Opener}
		view 964
		cursor 964
		signal 2
		description {the letter opener}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 19 111 80 name) ; "This is merely a razor-sharp letter opener; don't try anything funny with it like picking locks!"
			)
			(3 ; Do
				(TPrint 19 112) ; "You nearly cut your hand on the needle-like letter opener."
			)
			(4 ; Inventory
				(localproc_0 (Inv indexOf: self) invItem)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Desk_Key of InvI
	(properties
		name {Desk Key}
		view 965
		cursor 965
		signal 2
		description {the desk key}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 19 113 80 name) ; "Did you know that one key will fit the lock of every piece of pressed-cardboard furniture in the world!?"
			)
			(4 ; Inventory
				(localproc_0 (Inv indexOf: self) invItem)
			)
			(3 ; Do
				(TPrint 19 113 80 name) ; "Did you know that one key will fit the lock of every piece of pressed-cardboard furniture in the world!?"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Folder_Of_Evidence of InvI
	(properties
		name {Folder Of Evidence}
		view 966
		cursor 966
		signal 2
		description {the folder of evidence}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Points 4 146)
				(TPrint 19 114 80 name) ; "Examining the papers inside the folder carefully, you find one with some references to gangster activities. It is signed only with a scrawled name you make out to be "Julius.""
				(TPrint 19 115 80 name) ; "These papers provide proof positive of Mob payola at K-RAP Radio! But how will you get them out of here without Krapper finding out?"
			)
			(3 ; Do
				(if (gEgo has: 11) ; DayTrotter
					(TPrint 19 116) ; "There is nothing more to find in this folder. Besides, you already have photocopies of everything inside."
				else
					(TPrint 19 117) ; "Checking through these papers makes you realize you need some way to photocopy them."
				)
			)
			(4 ; Inventory
				(localproc_0 (Inv indexOf: self) invItem)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Photocopied_Evidence of InvI
	(properties
		name {Photocopied Evidence}
		view 967
		cursor 967
		signal 2
		description {the photocopies}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 19 118 80 name) ; "These copies provide proof positive of Mob payola at K-RAP Radio!"
			)
			(3 ; Do
				(TPrint 19 119) ; "Good job sneaking these photocopies out of K-RAP, Patti!"
			)
			(4 ; Inventory
				(localproc_0 (Inv indexOf: self) invItem)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Reel_To_Reel_Tape of InvI
	(properties
		name {Reel To Reel Tape}
		view 968
		cursor 968
		signal 2
		description {the reel-to-reel tape}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if state
					(TPrint 19 120 80 name) ; ""D D D" This tape is filled with digitally-recorded incriminating evidence!"
				else
					(TPrint 19 121 80 name) ; "If you could look closely enough, you could see billions of magnetic particles pointing in random directions."
					(TPrint 19 122 67 -1 185) ; "(In other words, this tape is still blank!)"
				)
			)
			(3 ; Do
				(TPrint 19 123) ; "You really need a tape deck to use this, Patti."
			)
			(4 ; Inventory
				(localproc_0 (Inv indexOf: self) invItem)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Hooter_Shooter of InvI
	(properties
		name {Hooter Shooter}
		view 969
		cursor 969
		signal 2
		description {the "Hooter Shooter" bra}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Points 2 76)
				(TPrint 19 124 80 name) ; "Commander Twit's boys may be into explosives, but they know nothing about comfort or adequate support."
			)
			(3 ; Do
				(self doVerb: 2)
			)
			(4 ; Inventory
				(localproc_0 (Inv indexOf: self) invItem)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

