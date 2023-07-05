;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24)
(include sci.sh)
(use Main)
(use n013)
(use GKInvItem)

(public
	tile1 0
	tile2 1
	tile3 2
	tile4 3
	tile5 4
	tile6 5
	records 6
	tile8 7
	tile9 8
	tile10 9
	tile11 10
	rod 11
	chamPot 12
	lotsCash 13
	scroll 14
	knife 15
	salt 16
	scissors 17
	bookSnkMnd 18
	bookTribe 19
	wolfKey 20
	talisman 21
	bones 22
	master_card 23
	wallet 24
	lit_flash 25
	fortScale_ 26
	signalDev_ 27
	signalDev2_ 28
	brick 29
	hartNotes 30
	wolfLetter 31
	hair_gel 32
	shirt 33
	disguise 34
	BoarMask 35
	BoarRobe 36
	WolfMask 37
	WolfRobe 38
	BoarGuise 39
	WolfGuise 40
	hounfourKey 41
	collar_ 42
	braceMold_ 43
	braceRep_ 44
	VoodooCode1 45
	sVoodooCode 46
	ritPhoto_ 47
	lostDrawing 48
	luckyDog_ 49
	snakeSkin_ 50
	reconVeve_ 51
)

(instance fortScale_ of GKInvItem
	(properties
		name {fortScale }
		noun 9
		signal 2
		message 22
		mainView 940
		mainLoop 1
		mainCel 15
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4 ; magGlass
				(gEgo getPoints: 197 1)
				(gInventory hide: 1)
				(cond
					((gEgo has: 24) ; lakeScale
						(= temp0 32)
					)
					((gEgo has: 25) ; twoScales
						(= temp0 35)
					)
					(else
						(= temp0 33)
					)
				)
				((ScriptID 23 0) doit: 72 0 0 86 29 10 0 1) ; insetCode
				(gMessager say: 9 4 temp0 0 0 15)
				(return 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance signalDev_ of GKInvItem
	(properties
		name {signalDev }
		noun 46
		signal 2
		message 60
		mainView 940
		mainLoop 2
		mainCel 7
	)
)

(instance signalDev2_ of GKInvItem
	(properties
		name {signalDev2 }
		noun 46
		signal 2
		message 60
		mainView 940
		mainLoop 2
		mainCel 7
	)
)

(instance brick of GKInvItem
	(properties
		noun 47
		signal 2
		message 66
		mainView 940
		mainLoop 2
		mainCel 8
	)
)

(instance hartNotes of GKInvItem
	(properties
		noun 44
		signal 2
		message 19
		mainView 940
		mainLoop 2
		mainCel 4
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 58) ; invRead
			(gInventory hide: 1)
			((ScriptID 23 0) doit: 45 0 0 92 52 80 0 0) ; insetCode
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance wolfLetter of GKInvItem
	(properties
		noun 42
		signal 2
		message 36
		mainView 940
		mainLoop 2
		mainCel 2
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 58) ; invRead
			(gEgo getPoints: 198 1)
		)
		(super doVerb: theVerb &rest)
	)
)

(instance hair_gel of GKInvItem
	(properties
		name {hair gel}
		noun 97
		signal 2
		message 72
		mainView 940
		mainLoop 4
		mainCel 6
	)
)

(instance shirt of GKInvItem
	(properties
		noun 96
		signal 2
		message 74
		mainView 940
		mainLoop 4
		mainCel 4
	)
)

(instance disguise of GKInvItem
	(properties
		noun 95
		signal 2
		message 73
		mainView 940
		mainLoop 4
		mainCel 5
	)
)

(instance tile1 of GKInvItem
	(properties
		noun 52
		signal 2
		message 89
		mainView 940
		mainLoop 2
		mainCel 13
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 7) ; Look
			(gInventory hide: 1)
			((ScriptID 23 0) doit: 61 0 0 98 37 52 0 62) ; insetCode
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance tile2 of GKInvItem
	(properties
		noun 53
		signal 2
		message 90
		mainView 940
		mainLoop 2
		mainCel 14
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 7) ; Look
			(gInventory hide: 1)
			((ScriptID 23 0) doit: 61 0 0 98 37 53 0 63) ; insetCode
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance tile3 of GKInvItem
	(properties
		noun 54
		signal 2
		message 91
		mainView 940
		mainLoop 2
		mainCel 15
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 7) ; Look
			(gInventory hide: 1)
			((ScriptID 23 0) doit: 61 0 0 98 37 54 0 64) ; insetCode
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance tile4 of GKInvItem
	(properties
		noun 55
		signal 2
		message 92
		mainView 940
		mainLoop 3
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 7) ; Look
			(gInventory hide: 1)
			((ScriptID 23 0) doit: 61 0 0 98 37 55 0 65) ; insetCode
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance tile5 of GKInvItem
	(properties
		noun 56
		signal 2
		message 93
		mainView 940
		mainLoop 3
		mainCel 1
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 7) ; Look
			(gInventory hide: 1)
			((ScriptID 23 0) doit: 61 0 0 98 37 56 0 66) ; insetCode
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance tile6 of GKInvItem
	(properties
		noun 57
		signal 2
		message 94
		mainView 940
		mainLoop 3
		mainCel 2
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 7) ; Look
			(gInventory hide: 1)
			((ScriptID 23 0) doit: 61 0 0 98 37 57 0 67) ; insetCode
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance records of GKInvItem
	(properties
		noun 66
		signal 2
		message 130
		mainView 940
		mainLoop 3
		mainCel 11
	)

	(method (doVerb theVerb &tmp temp0)
		(if (or (== theVerb 58) (== theVerb 6)) ; invRead, Open
			(gInventory hide: 1)
			((ScriptID 23 0) doit: 94 0 0 90 40 81 0 0) ; insetCode
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance tile8 of GKInvItem
	(properties
		noun 58
		signal 2
		message 96
		mainView 940
		mainLoop 3
		mainCel 3
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 7) ; Look
			(gInventory hide: 1)
			((ScriptID 23 0) doit: 61 0 0 98 37 58 0 69) ; insetCode
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance tile9 of GKInvItem
	(properties
		noun 59
		signal 2
		message 97
		mainView 940
		mainLoop 3
		mainCel 4
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 7) ; Look
			(gInventory hide: 1)
			((ScriptID 23 0) doit: 61 0 0 98 37 59 0 691) ; insetCode
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance tile10 of GKInvItem
	(properties
		noun 60
		signal 2
		message 98
		mainView 940
		mainLoop 3
		mainCel 5
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 7) ; Look
			(gInventory hide: 1)
			((ScriptID 23 0) doit: 61 0 0 98 37 60 0 692) ; insetCode
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance tile11 of GKInvItem
	(properties
		noun 61
		signal 2
		message 99
		mainView 940
		mainLoop 3
		mainCel 6
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 7) ; Look
			(gInventory hide: 1)
			((ScriptID 23 0) doit: 61 0 0 98 37 61 0 693) ; insetCode
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance rod of GKInvItem
	(properties
		noun 51
		signal 2
		message 76
		mainView 940
		mainLoop 2
		mainCel 12
	)
)

(instance chamPot of GKInvItem
	(properties
		noun 102
		signal 2
		message 104
		mainView 940
		mainLoop 4
		mainCel 1
	)
)

(instance lotsCash of GKInvItem
	(properties
		noun 112
		signal 2
		message 115
		mainView 940
		mainLoop 4
		mainCel 10
	)
)

(instance scroll of GKInvItem
	(properties
		noun 101
		signal 2
		message 105
		mainView 940
		mainLoop 4
		mainCel 2
	)

	(method (doVerb theVerb)
		(if (or (== theVerb 58) (== theVerb 6)) ; invRead, Open
			(gMessager say: 101 58 0 0 0 15) ; "(READING SCROLL. SLIGHTLY DRAMATIC)St. George, patron of the light, who hunts the shadows of the night..."
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance knife of GKInvItem
	(properties
		noun 62
		signal 2
		message 101
		mainView 940
		mainLoop 3
		mainCel 7
	)
)

(instance salt of GKInvItem
	(properties
		noun 103
		signal 2
		message 106
		mainView 940
		mainLoop 3
		mainCel 15
	)
)

(instance scissors of GKInvItem
	(properties
		noun 104
		signal 2
		message 107
		mainView 940
		mainLoop 4
	)
)

(instance bookSnkMnd of GKInvItem
	(properties
		noun 105
		signal 2
		message 84
		mainView 940
		mainLoop 4
		mainCel 3
	)

	(method (doVerb theVerb &tmp temp0)
		(if (or (== theVerb 58) (== theVerb 6)) ; invRead, Open
			(gMessager say: 105 58 0 0 self 15) ; "Gabriel opens "Ancient Digs of Africa.""
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (cue)
		(gInventory hide: 1)
		((ScriptID 23 0) doit: 60 0 0 39 23 106 0 0) ; insetCode
	)
)

(instance bookTribe of GKInvItem
	(properties
		noun 66
		signal 2
		message 130
		mainView 940
		mainLoop 3
		mainCel 11
	)

	(method (doVerb theVerb &tmp temp0)
		(if (or (== theVerb 58) (== theVerb 6)) ; invRead, Open
			(gInventory hide: 1)
			((ScriptID 23 0) doit: 94 0 0 87 48 81 0 0) ; insetCode
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance wolfKey of GKInvItem
	(properties
		noun 110
		signal 2
		message 108
		mainView 940
		mainLoop 4
		mainCel 7
	)
)

(instance talisman of GKInvItem
	(properties
		noun 64
		signal 2
		message 124
		mainView 940
		mainLoop 3
		mainCel 9
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 7) ; Look
			(gInventory hide: 1)
			((ScriptID 23 0) doit: 56 0 0 90 32 64 0 0) ; insetCode
			(gMessager say: 64 7 0 0 0 15) ; "Gabriel has in his possession the Ritter family talisman. He'll never forget that it was regained only through Wolfgang's blood."
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance bones of GKInvItem
	(properties
		noun 63
		signal 2
		message 125
		mainView 940
		mainLoop 3
		mainCel 8
	)
)

(instance master_card of GKInvItem
	(properties
		name {master card}
		noun 109
		signal 2
		message 86
		mainView 940
		mainLoop 3
		mainCel 13
	)
)

(instance wallet of GKInvItem
	(properties
		noun 108
		signal 2
		message 29
		mainView 940
		mainLoop 3
		mainCel 14
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(7 ; Look
				(if (gEgo has: 71) ; master_card
					(gMessager say: 108 7 27 0 0 15) ; "Mosely's wallet has obviously been in his back pocket for a long time. It's shaped just like him."
				else
					(gMessager say: 108 7 28 0 0 15) ; "It's a man's wallet."
				)
				(return 1)
			)
			(6 ; Open
				(if (gEgo has: 71) ; master_card
					(gMessager say: 108 6 29 0 0 15) ; "The other items in Mosely's wallet don't interest Gabriel."
				else
					(gEgo getPoints: -999 1)
					(gMessager say: 108 6 26 0 self 15) ; "Gabriel opens the wallet and finds...."
				)
				(return 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue &tmp temp0)
		(gInventory eraseItems:)
		(gEgo get: 71) ; master_card
		(gInventory eraseItems:)
		(gInventory drawInvItems: (gInventory curPage:))
		(FrameOut)
	)
)

(instance lit_flash of GKInvItem
	(properties
		name {lit flash}
		noun 107
		signal 2
		message 129
		mainView 940
		mainLoop 4
		mainCel 9
	)
)

(instance BoarMask of GKInvItem
	(properties
		noun 68
		signal 2
		message 116
		mainView 940
		mainLoop 3
		mainCel 12
	)
)

(instance BoarRobe of GKInvItem
	(properties
		noun 100
		signal 2
		message 122
		mainView 940
		mainLoop 4
		mainCel 11
	)
)

(instance WolfMask of GKInvItem
	(properties
		noun 67
		signal 2
		message 114
		mainView 940
		mainLoop 4
		mainCel 12
	)
)

(instance WolfRobe of GKInvItem
	(properties
		noun 100
		signal 2
		message 122
		mainView 940
		mainLoop 4
		mainCel 13
	)
)

(instance BoarGuise of GKInvItem
	(properties
		noun 99
		signal 2
		message 121
		mainView 940
		mainLoop 4
		mainCel 14
	)
)

(instance WolfGuise of GKInvItem
	(properties
		noun 98
		signal 2
		message 120
		mainView 940
		mainLoop 4
		mainCel 15
	)
)

(instance hounfourKey of GKInvItem
	(properties
		noun 65
		signal 2
		message 123
		mainView 940
		mainLoop 3
		mainCel 10
	)
)

(instance collar_ of GKInvItem
	(properties
		name {collar }
		noun 36
		signal 2
		message 64
		mainView 940
		mainLoop 1
		mainCel 11
	)
)

(instance braceMold_ of GKInvItem
	(properties
		name {braceMold }
		noun 37
		signal 2
		message 43
		mainView 940
		mainLoop 1
		mainCel 12
	)
)

(instance braceRep_ of GKInvItem
	(properties
		name {braceRep }
		noun 38
		signal 2
		message 42
		mainView 940
		mainLoop 1
		mainCel 13
	)
)

(instance VoodooCode1 of GKInvItem
	(properties
		noun 20
		signal 2
		message 40
		mainView 940
		mainCel 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(58 ; invRead
				(gInventory hide:)
				(if (IsFlag 248)
					((ScriptID 23 0) doit: 3020 0 0 99 22 71 0 0) ; insetCode
				else
					((ScriptID 23 0) doit: 95 0 0 99 22 70 0 0) ; insetCode
				)
				(return 1)
			)
			(7 ; Look
				(if (IsFlag 248)
					(gMessager say: 20 7 8 0 0 15) ; "It's Gabriel's sketch of the series of crosses from the Laveau tomb wall--with Magentia Moonbeam's translation penciled in."
				else
					(gMessager say: 20 7 7 0 0 15) ; "It's Gabriel's sketch of the series of crosses from the Laveau tomb wall."
				)
				(return 1)
			)
			(59 ; sVoodooCode
				(if (IsFlag 249)
					(gMessager say: 21 40 10 0 0 15) ; "Gabriel has already transferred the letters for all of the symbols that match."
				else
					(gEgo getPoints: -999 2)
					(SetFlag 249)
					(gMessager say: 21 40 9 0 0 15) ; "Gabriel checks the two messages for duplicate symbols, and transfers the letters from the matches to the new message."
				)
				(return 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sVoodooCode of GKInvItem
	(properties
		noun 21
		signal 2
		message 59
		mainView 940
		mainCel 11
	)

	(method (doVerb theVerb)
		(switch theVerb
			(58 ; invRead
				(gInventory hide:)
				(if (IsFlag 249)
					((ScriptID 23 0) doit: 3021 0 0 99 22 83 0 0) ; insetCode
				else
					((ScriptID 23 0) doit: 96 0 0 99 22 84 0 0) ; insetCode
				)
				(return 1)
			)
			(7 ; Look
				(if (IsFlag 249)
					(gMessager say: 21 7 10 0 0 15) ; "Gabriel sketched a new series of crosses from the Laveau tomb, and added what letters he could match from Moonbeam's translations."
				else
					(gMessager say: 21 7 9 0 0 15) ; "It's Gabriel's sketch of the new series of crosses from the Laveau tomb wall."
				)
				(return 1)
			)
			(40 ; VoodooCode1
				(if (IsFlag 249)
					(gMessager say: 21 40 10 0 0 15) ; "Gabriel has already transferred the letters for all of the symbols that match."
				else
					(gEgo getPoints: -999 2)
					(SetFlag 249)
					(gMessager say: 21 40 9 0 0 15) ; "Gabriel checks the two messages for duplicate symbols, and transfers the letters from the matches to the new message."
				)
				(return 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ritPhoto_ of GKInvItem
	(properties
		name {ritPhoto }
		noun 25
		signal 2
		message 39
		mainView 940
		mainCel 14
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(if (IsFlag 282)
					(gInventory hide:)
					((ScriptID 23 0) doit: 27 0 0 87 48 25 11 0) ; insetCode
				else
					(gInventory hide:)
					((ScriptID 23 0) doit: 27 0 0 87 48 25 12 0) ; insetCode
				)
				(return 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lostDrawing of GKInvItem
	(properties
		noun 29
		signal 2
		message 34
		mainView 940
		mainLoop 1
		mainCel 2
	)
)

(instance luckyDog_ of GKInvItem
	(properties
		name {luckyDog }
		noun 30
		signal 2
		message 33
		mainView 940
		mainLoop 1
		mainCel 3
	)
)

(instance snakeSkin_ of GKInvItem
	(properties
		name {snakeSkin }
		noun 3
		signal 2
		message 21
		mainView 940
		mainLoop 1
		mainCel 4
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 4) ; magGlass
			(gEgo getPoints: 195 1)
			(gInventory hide:)
			(cond
				((gEgo has: 24) ; lakeScale
					(= temp0 32)
				)
				((gEgo has: 25) ; twoScales
					(= temp0 35)
				)
				(else
					(= temp0 33)
				)
			)
			((ScriptID 23 0) doit: 98 0 0 86 29 3 0 1) ; insetCode
			(gMessager say: 3 4 temp0 0 0 15)
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance reconVeve_ of GKInvItem
	(properties
		name {reconVeve }
		noun 24
		signal 2
		message 16
		mainView 940
		mainLoop 1
		mainCel 10
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 58) ; invRead
			(gInventory hide:)
			((ScriptID 23 0) doit: 93 0 0 87 48 73 0 0) ; insetCode
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

