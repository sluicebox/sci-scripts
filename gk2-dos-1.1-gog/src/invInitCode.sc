;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20)
(include sci.sh)
(use Main)
(use GK2Ego)
(use n011)
(use ScrollPrint)
(use DIcon)
(use PanelPlane)
(use Feature)
(use Cursor)
(use Inventory)
(use System)

(public
	invInitCode 0
)

(local
	local0
	local1
)

(class GKInventory of Inv
	(properties
		normalHeading 9
		empty 27
		button 0
	)
)

(instance invInitCode of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		((= gInventory GKInventory)
			add:
				invGabeCards
				invGraceLetter1
				invUbergrauLetter
				invRitterDagger
				invGabeWallet
				invTalisman
				invTapeRecorder
				invBlankTapes
				invHuberKeys
				invGabeEnvelope1
				invFarmHair
				invPawPrintCast
				invZooHair
				invKlingmannReceipt
				invRitterPapers
				invSpliceTape
				invEvidenceReport
				invBarclayCard
				invNotebookPen
				invGraceWallet
				invGabeLetter1
				invScrewdriver
				invLibraryKey
				invWerewolfBook
				invVictorJournal
				invChristianJournal
				invLudwigLetter
				invGracePackage1
				invMayorNote
				invChurchFile
				invVonGlowerCard
				invGabeEnvelope2
				invCuckooClock
				invXaverKeys
				invGrosPhoneNumber
				invMagazine
				invGraceLetter2
				invGabeLetter2
				invFourRoses
				invTourTapeDeck
				invLudwigBio
				invDallmeierNote
				invChaphillNote
				invGraceEnvelope3
				invDiaryTranslation
				invLily
				invDornMoney
				invGraceLetter3
				invLedgerPage
				invWurst
				invLantern
				invMatches
				invGrossbergLetter
				invShears
				invRope
				invWolfTags
				invChandelierDiagram
				invVonGlowerLetter
				invOperaAct3
				invOperaAct2
				invOperaAct1
				invPillowcase
				invBottleOfWater
				invSilverHeart
				invPriestCard
				invOperaProgram
				invSeatingChart
				invTheaterKeys
				invBanner
				invTheaterRope
				invOperaGlasses
				invToDoList
				invCarKeys
				invPitcher
				invCastleTicket
				invRoll
				invMagWithRecorder
				invDove
				invLitLantern
				invGabeNotebook
				invAddressedPackage
				invGun
				invVonZellTape
				invRollOfTape
				invPowder
				invCostume
				invManuscript
		)
		(= temp0 0)
		(for
			((= temp1 (gInventory first:)))
			temp1
			((= temp1 (gInventory next: temp1)))
			
			((KList 8 temp1) number: temp0) ; NodeValue
			(++ temp0)
		)
	)
)

(class InvPrint of ScrollPrint
	(properties
		width 360
		margin 1
		height 115
		isInvPrint 1
		xOff 50
	)

	(method (init &tmp temp0)
		(gTopMessage save:)
		(if (!= (gEgo invSet:) -1)
			((gEgo invSet:) eachElementDo: #addMe)
		)
		(if selects
			(= yOff ((KList 8 (selects last:)) nsBottom:)) ; NodeValue
			(gUser curVerb: 62)
			((gUser hotCursor:) cage: 60 352 627 475 show: update:)
			(= modeless 1)
			(super init: &rest)
		)
	)

	(method (dispose)
		(= xOff 50)
		((gUser hotCursor:) cage: 0)
		(gTopMessage restore:)
		(super dispose: &rest)
		(= width 360)
	)

	(method (addSelection param1 param2 param3 param4 &tmp temp0)
		(if (not selects)
			(= selects (List new:))
			(= yOff 0)
			(= xOff 50)
			(= classIcon InvIcon)
		)
		(= temp0 (self addIcon: param1 param2 param3 xOff yOff))
		(temp0 value: param4)
		(selects add: temp0)
		(= xOff (+ margin (temp0 nsRight:)))
		(if (> xOff width)
			(= xOff 50)
			(= yOff (+ margin (temp0 nsBottom:)))
		)
		(return temp0)
	)
)

(class InvIcon of DIcon
	(properties
		state 1
	)

	(method (draw)
		(UpdateScreenItem self)
	)

	(method (hilite param1)
		(if (and argc param1)
			(|= loop $0001)
			(gTopMessage newText: 20 0 (value message:))
		else
			(&= loop $fffe)
			(gTopMessage restore:)
		)
		(UpdateScreenItem self)
	)

	(method (onMe param1)
		(return (and (< 2 (param1 y:) 110) (super onMe: param1)))
	)

	(method (handleEvent)
		(if (super handleEvent: &rest)
			(if (value doVerb: (gUser curVerb:))
				(|= state $0002)
			)
			(return 1)
		)
	)
)

(class GK2Inventory of InvI
	(properties
		noun -1
		message 5
		pageNum 0
		pageMax 0
		fullScreen -1
		curItem 0
		number -1
		exitVerb -1
	)

	(method (addMe &tmp temp0 temp1 temp2)
		(if (== owner gEgo)
			(= temp0 995)
			(= temp1 (<< (>> number $0004) $0001))
			(= temp2 (& number $000f))
			(InvPrint addSelection: temp0 temp1 temp2 self)
		else
			(return 0)
		)
	)

	(method (showSelf param1 &tmp temp0 temp1)
		(if (== param1 message)
			((gUser hotCursor:) showWait: isHot: 0)
			(Lock rsVIEW 999)
			(Lock rsVIEW 993)
			(= temp0 number)
			(= pageNum 0)
			(+= temp0 13000)
			(= local0 self)
			(Load rsPIC temp0)
			(invPlane picture: temp0)
			(if (== fullScreen 0)
				(invPlane init: 0 0 639 479)
				((gUser hotCursor:) cage: 0)
				(exitButton posn: 8 440)
			else
				(invPlane init: 12 15 627 349)
				((gUser hotCursor:) cage: 12 15 627 349)
				(exitButton posn: 8 292)
			)
			(UpdateScreenItem exitButton)
			(self adjustFeatures:)
			(= global135 0)
			(while ((= temp1 (Event new: 3)) type:)
				(temp1 dispose:)
			)
			(gUser curVerb: 62)
			((gUser hotCursor:) update: isHot: 1)
			(return 1)
		else
			(return 0)
		)
	)

	(method (pageUp)
		(if (>= (++ pageNum) pageMax)
			(= pageNum pageMax)
		)
		(invPlane picture: (+ 13000 pageNum 999 (* number 10)))
		(if (and (!= fullScreen -1) (<= fullScreen pageNum))
			(invPlane setRect: 0 0 639 479)
			(exitButton
				posn: 8 440
				nsLeft: 8
				nsTop: 440
				nsRight: 53
				nsBottom: 468
			)
			(UpdateScreenItem exitButton)
			((gUser hotCursor:) cage: 0)
		)
		(UpdatePlane invPlane)
		(self adjustFeatures:)
	)

	(method (pageDown)
		(if (<= (-- pageNum) 0)
			(= pageNum 0)
		)
		(invPlane
			picture:
				(+
					13000
					pageNum
					(if pageNum
						(+ 999 (* number 10))
					else
						number
					)
				)
		)
		(if (and (!= fullScreen -1) (> fullScreen pageNum))
			(invPlane setRect: 12 15 627 348)
			(exitButton posn: 8 292)
			(UpdateScreenItem exitButton)
			((gUser hotCursor:) cage: 12 15 627 349)
		)
		(UpdatePlane invPlane)
		(self adjustFeatures:)
	)

	(method (select param1)
		(if (and argc (not param1))
			(= curItem 0)
			((gInventory button:) select:)
		else
			(= curItem 1)
			((gInventory button:) select: number)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(self select:)
				(return 0)
			)
			(exitVerb
				(return 1)
			)
			(else
				((gUser hotCursor:) flashBad:)
				(return 0)
			)
		)
	)

	(method (adjustFeatures)
		(return 0)
	)

	(method (handleEvent &tmp temp0 temp1)
		(= temp1 (if (!= modNum -1) modNum else 20))
		(if (!= noun -1)
			(= temp0 (if pageMax pageNum else 0))
			(gMessager say: noun 62 0 temp0 0 temp1)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance invGabeCards of GK2Inventory
	(properties
		noun 87
		view 9940
		message 48
	)

	(method (adjustFeatures)
		(itemFeature init: 173 89 441 89 441 243 173 243)
	)
)

(instance invGraceLetter1 of GK2Inventory
	(properties
		noun 228
		view 9940
		loop 1
		message 49
		pageMax 2
		fullScreen 1
	)

	(method (adjustFeatures)
		(switch pageNum
			(0
				(upFeature init: 42 51 571 281)
			)
			(1
				(gGame changeScore: 826)
				(itemFeature init: 120 8 120 445 514 453 515 8)
				(upFeature init: 510 26 535 470)
				(downFeature dispose:)
			)
			(2
				(itemFeature init: 139 7 139 451 534 460 535 6)
				(downFeature init: 0 0 102 224)
				(upFeature dispose:)
			)
		)
	)
)

(instance invUbergrauLetter of GK2Inventory
	(properties
		noun 229
		view 9940
		loop 2
		message 7
		pageMax 1
		fullScreen 1
	)

	(method (adjustFeatures)
		(if pageNum
			(SetFlag 606)
			(gGame changeScore: 850)
			(itemFeature init: 121 14 516 14 516 459 122 454)
			(upFeature dispose:)
		else
			(upFeature init: 42 51 573 280)
			(downFeature dispose:)
		)
	)
)

(instance invRitterDagger of GK2Inventory
	(properties
		noun 88
		view 9940
		loop 3
		message 23
	)

	(method (adjustFeatures)
		(itemFeature
			init:
				262
				126
				521
				210
				567
				246
				515
				249
				245
				179
				237
				212
				221
				208
				212
				155
				63
				118
				57
				97
				66
				83
				218
				127
				254
				94
				272
				98
		)
	)
)

(instance invGabeWallet of GK2Inventory
	(properties
		noun 246
		view 9940
		loop 4
		message 17
	)

	(method (adjustFeatures)
		(itemFeature init: 209 38 204 280 238 290 400 282 397 37)
	)
)

(instance invTalisman of GK2Inventory
	(properties
		noun 89
		view 9940
		loop 5
		message 8
	)

	(method (addMe)
		(if (== gChapter 6)
			(= noun 203)
		)
		(super addMe: &rest)
	)

	(method (adjustFeatures)
		(itemFeature
			init:
				96
				190
				146
				217
				191
				262
				217
				312
				246
				312
				266
				263
				315
				214
				364
				189
				364
				163
				308
				137
				262
				91
				238
				44
				215
				44
				185
				99
				143
				141
				96
				165
		)
	)
)

(instance invTapeRecorder of GK2Inventory
	(properties
		noun 252
		view 9940
		loop 6
		message 40
		exitVerb 75
	)

	(method (adjustFeatures)
		(itemFeature init: 45 83 598 334)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 75) ; invMagazine
				(gGame changeScore: 976)
				(Load rsVIEW 9943)
				(gMessager say: 113 62 0 1 0 20) ; "(CLICK TAPE RECORDER ON MAGAZINE, SLY)Hmmm. That's a thought."
				(gEgo put: 6 put: 35 get: 76) ; invTapeRecorder, invMagazine, invMagWithRecorder
				(invMagWithRecorder select:)
			)
			((== theVerb 117) ; invVonZellTape
				(if (IsFlag 678)
					(gMessager say: 186 62 0 1 0 20) ; "\9abergrau told me what the tape says."
				else
					(gMessager say: 185 62 0 1 0 20) ; "I'm sure whatever they said is in German. I need a translator."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance invBlankTapes of GK2Inventory
	(properties
		noun 90
		view 9940
		loop 7
		message 115
	)

	(method (adjustFeatures)
		(itemFeature init: 79 79 562 80 562 335 79 336)
	)
)

(instance invHuberKeys of GK2Inventory
	(properties
		noun 247
		view 9940
		loop 8
		message 52
	)

	(method (adjustFeatures)
		(itemFeature
			init:
				314
				166
				276
				228
				348
				304
				365
				295
				328
				238
				334
				226
				449
				239
				452
				219
				384
				199
				351
				160
		)
	)
)

(instance invGabeEnvelope1 of GK2Inventory
	(properties
		noun 230
		view 9940
		loop 9
		message 53
	)

	(method (adjustFeatures)
		(itemFeature init: 43 48 572 48 572 283 43 283)
	)
)

(instance invFarmHair of GK2Inventory
	(properties
		noun 91
		view 9940
		loop 10
		message 56
	)

	(method (adjustFeatures)
		(itemFeature init: 299 114 289 181 316 196 345 180 387 107)
	)
)

(instance invPawPrintCast of GK2Inventory
	(properties
		noun 93
		view 9940
		loop 11
		message 58
	)

	(method (adjustFeatures)
		(itemFeature
			init: 258 14 187 100 191 254 243 322 369 322 423 256 423 91 350 14
		)
	)
)

(instance invZooHair of GK2Inventory
	(properties
		noun 94
		view 9940
		loop 12
		message 57
	)

	(method (adjustFeatures)
		(itemFeature
			init: 311 196 370 163 364 143 327 151 302 108 261 145 273 175
		)
	)
)

(instance invKlingmannReceipt of GK2Inventory
	(properties
		view 9940
		loop 13
		message 59
		pageMax 1
		fullScreen 0
	)

	(method (adjustFeatures)
		(SetFlag 434) ; enable "Jagdschein" in rm4220
		(if pageNum
			(gGame changeScore: 854)
			(upFeature dispose:)
			(downFeature init: 96 258 560 375)
			(if (IsFlag 412)
				(= noun 98)
			else
				(= noun 97)
			)
		else
			(upFeature init: 96 258 560 425)
			(downFeature dispose:)
			(SetFlag 439)
			(if (IsFlag 114) ; "Jagdschein" in rm4220
				(= noun 96)
			else
				(= noun 95)
			)
		)
		(itemFeature init: 154 15 154 441 485 443 485 15)
	)
)

(instance invRitterPapers of GK2Inventory
	(properties
		noun 99
		view 9940
		loop 14
		message 60
	)

	(method (adjustFeatures)
		(itemFeature
			init: 125 34 243 34 250 19 363 19 372 34 487 34 487 312 125 312
		)
	)
)

(instance invSpliceTape of GK2Inventory
	(properties
		noun 100
		view 9940
		loop 15
		message 61
	)

	(method (adjustFeatures)
		(itemFeature init: 79 77 560 77 560 334 79 335)
	)
)

(instance invEvidenceReport of GK2Inventory
	(properties
		noun 92
		view 994
		message 41
		pageMax 1
		fullScreen 1
	)

	(method (adjustFeatures)
		(if pageNum
			(itemFeature init: 129 -3 129 444 511 458 511 -5)
			(upFeature dispose:)
			(downFeature init: 0 0 102 224)
		else
			(upFeature init: 130 65 510 58 513 262 123 255)
			(downFeature dispose:)
		)
	)

	(method (handleEvent)
		(gMessager say: noun 62 0 0 0 20) ; "(LOOK AT EVIDENCE ANALYSIS REPORT FROM MICHAEL)So much for the old zoo wolves theory. Unfortunately, the report doesn't exactly reek of another solution."
		(return 1)
	)
)

(instance invBarclayCard of GK2Inventory
	(properties
		noun 106
		view 994
		loop 1
		message 6
	)

	(method (adjustFeatures)
		(itemFeature init: 175 90 441 90 441 242 175 242)
	)
)

(instance invNotebookPen of GK2Inventory
	(properties
		noun 141
		view 994
		loop 2
		message 106
	)

	(method (adjustFeatures)
		(itemFeature init: 160 19 480 342)
	)
)

(instance invGraceWallet of GK2Inventory
	(properties
		noun 137
		view 994
		loop 3
		message 10
	)

	(method (adjustFeatures)
		(if (IsFlag 740)
			(= noun 163)
		)
		(itemFeature init: 121 56 493 53 497 270 121 270)
	)
)

(instance invGabeLetter1 of GK2Inventory
	(properties
		noun 239
		view 994
		loop 4
		message 63
		fullScreen 0
	)

	(method (adjustFeatures)
		(itemFeature init: 121 6 519 6 521 453 121 453)
	)
)

(instance invScrewdriver of GK2Inventory
	(properties
		noun 136
		view 994
		loop 5
		message 65
	)

	(method (adjustFeatures)
		(itemFeature
			init:
				102
				57
				100
				80
				234
				157
				251
				150
				493
				297
				507
				279
				259
				131
				255
				119
				122
				41
		)
	)
)

(instance invLibraryKey of GK2Inventory
	(properties
		noun 139
		view 994
		loop 6
		message 66
	)

	(method (adjustFeatures)
		(itemFeature
			init:
				432
				226
				283
				122
				262
				68
				215
				62
				185
				86
				185
				124
				202
				149
				234
				158
				270
				144
				344
				196
				320
				222
				391
				272
		)
	)
)

(instance invWerewolfBook of GK2Inventory
	(properties
		noun 236
		view 994
		loop 7
		message 67
		pageMax 5
		fullScreen 0
	)

	(method (adjustFeatures)
		(= noun (if (== gEgo GabeEgo) 128 else 127))
		(switch pageNum
			(0
				(doublePage dispose:)
				(upFeature init: 180 20 490 428)
			)
			(1
				(doublePage dispose:)
				(doublePage init: 347 45 566 45 567 421 347 421)
				(upFeature init: 565 41 627 41 627 421 570 421)
				(downFeature dispose:)
			)
			(2
				(gGame changeScore: 880)
				(doublePage dispose:)
				(doublePage init: 68 50 572 50 572 421 69 421)
				(upFeature init: 578 42 625 42 626 445 580 449)
				(downFeature init: -4 42 68 42 68 421 -12 421)
			)
			(4
				(upFeature init: 578 42 625 42 626 421 580 421)
			)
			(5
				(upFeature dispose:)
			)
		)
	)

	(method (handleEvent event)
		(switch pageNum
			(1
				(gMessager say: noun 62 0 1 0 20) ; MISSING MESSAGE
			)
			(2
				(gMessager sayRange: noun 62 0 2 4 0 20) ; MISSING MESSAGE
			)
			(3
				(if (not event)
					(gMessager sayRange: noun 62 0 5 6 0 20) ; MISSING MESSAGE
				else
					(gMessager sayRange: noun 62 0 7 8 0 20) ; MISSING MESSAGE
				)
			)
			(4
				(if (not event)
					(gMessager sayRange: noun 62 0 9 10 0 20) ; MISSING MESSAGE
				else
					(gMessager sayRange: noun 62 0 11 12 0 20) ; MISSING MESSAGE
				)
			)
			(5
				(cond
					((not event)
						(gMessager sayRange: noun 62 0 13 14 0 20) ; MISSING MESSAGE
					)
					((and (== gEgo GraceEgo) (not (IsFlag 452)))
						(SetFlag 452)
						(gMessager sayRange: noun 62 0 15 16 0 20) ; MISSING MESSAGE
					)
					(else
						(gMessager say: noun 62 0 15 0 20) ; MISSING MESSAGE
					)
				)
			)
		)
	)
)

(instance invVictorJournal of GK2Inventory
	(properties
		noun 232
		view 994
		loop 8
		message 68
		pageMax 2
		fullScreen 1
	)

	(method (adjustFeatures)
		(SetFlag 471)
		(switch pageNum
			(0
				(upFeature init: 204 17 401 9 415 316 211 316)
				(downFeature dispose:)
				(doublePage dispose:)
			)
			(1
				(gGame changeScore: 882)
				(doublePage init: 45 5 590 400)
				(downFeature init: 0 5 45 400)
				(upFeature dispose:)
				(upFeature init: 590 5 640 400)
			)
			(2
				(upFeature dispose:)
			)
		)
	)

	(method (handleEvent event)
		(if (== gEgo GabeEgo)
			(gMessager say: 158 62 0 0 0 20) ; "(PLAYER TRIES TO READ HISTORICAL JOURNALS SENT BY GRACIE)I don't have time to worry about this historical stuff at the moment. I don't think it's got much to do with what's goin' on here in Munich."
			(return 1)
		)
		(switch pageNum
			(1
				(if event
					(gMessager say: noun 62 0 3 0 20) ; "(VICTOR RITTER'S JOURNAL CONT'D)It was a newling lamb we loosed in the thicket as a lure. We awaited down-wind. For two night, the lamb bleated to no purpose and once we had to fend off a hungry fox. But, at last, the beast himself took the bait. I might have missed him -- the night was so dark and the wolf himself was black, but my assistant saw the light of his eyes, and I heard the lamb's cries turn fearful. He had the poor dumb lamb by the throat when we sprang."
				else
					(gMessager sayRange: noun 62 0 1 2 0 20) ; "(READING VICTOR RITTER'S JOURNAL)Numerous deaths at the hands of a marauding wolf being recorded in a neighboring county, I set out to see if I could determine the cause. There had been rumors of a werewolf, and the dark signs did indeed seem to be present."
				)
			)
			(2
				(if event
					(gMessager sayRange: noun 62 0 6 7 0 20) ; "(VICTOR RITTER'S JOURNAL CONT'D)God be praised for aiding his servant. From his hand came the strength and wisdom to end the killing."
				else
					(gMessager sayRange: noun 62 0 4 5 0 20) ; "(VICTOR RITTER'S JOURNAL CONT'D)He was swift and might have escaped, but his fatal mistake was to attack rather than run. My dagger struck through his chest and into his right lung."
				)
			)
		)
	)
)

(instance invChristianJournal of GK2Inventory
	(properties
		noun 235
		view 994
		loop 9
		message 69
		pageMax 1
		fullScreen 1
	)

	(method (adjustFeatures)
		(SetFlag 458)
		(if pageNum
			(gGame changeScore: 883)
			(upFeature dispose:)
			(downFeature init: 0 0 120 450)
			(doublePage init: 3 50 611 51 612 451 5 454)
		else
			(doublePage dispose:)
			(downFeature dispose:)
			(upFeature init: 304 48 614 333)
		)
	)

	(method (handleEvent event)
		(if (== gEgo GabeEgo)
			(gMessager say: 158 62 0 0 0 20) ; "(PLAYER TRIES TO READ HISTORICAL JOURNALS SENT BY GRACIE)I don't have time to worry about this historical stuff at the moment. I don't think it's got much to do with what's goin' on here in Munich."
			(return 1)
		)
		(switch pageNum
			(1
				(if event
					(gMessager say: noun 62 0 2 0 20) ; "(CHRISTIAN RITTER'S JOURNAL CONT'D)March 3, 1864. I have had a break at last. The key was in front of me all the time. The Black Wolf, he so daringly calls himself, for all to hear and none to truly see. It is worse than I could ever have suspected. He is not just a beast, but a monster! His jaws are already around some of the best throats in Europe. I return to Rittersberg tonight. I must warn those in danger and get someone to assist me. I am in over my head."
				else
					(gMessager say: noun 62 0 1 0 20) ; "(READING CHRISTIAN RITTER'S JOURNAL)3 January, 1864. I am now in Prussia. The beast that brought me here has so far bested me. He is secretive and skillful. He has much self-control, unlike what I'd been led to expect. He seems to know almost before I do where and when I will be stalking him. He turns up his nose at my lures. Three more disappearances have occurred and I'm no closer to learning his identity nor finding his lair. I can't even prove HE took them. Not a single corpse has been found."
				)
			)
		)
	)
)

(instance invLudwigLetter of GK2Inventory
	(properties
		noun 234
		view 994
		loop 10
		message 70
		pageMax 2
		fullScreen 1
	)

	(method (adjustFeatures)
		(SetFlag 466) ; enable "Ludwig II" in rm711c2d2
		(switch pageNum
			(0
				(upFeature init: 104 28 509 28 509 304 104 304)
				(downFeature dispose:)
				(itemFeature dispose:)
			)
			(1
				(itemFeature init: 121 4 512 4 512 441 121 441)
				(upFeature dispose:)
				(upFeature init: 512 4 560 440)
				(downFeature dispose:)
			)
			(2
				(upFeature dispose:)
				(downFeature init: 0 -3 98 228)
			)
		)
	)

	(method (handleEvent)
		(if (== gEgo GabeEgo)
			(gMessager say: 158 62 0 0 0 20) ; "(PLAYER TRIES TO READ HISTORICAL JOURNALS SENT BY GRACIE)I don't have time to worry about this historical stuff at the moment. I don't think it's got much to do with what's goin' on here in Munich."
			(return 1)
		)
		(switch pageNum
			(1
				(gMessager sayRange: noun 62 0 1 2 0 20) ; "(READING LETTER TO LUDWIG FROM CHRISTIAN RITTER)4, Marz. 1864 To King Ludwig II, most gracious ruler of all Bavaria:  I beg your forgiveness for my forthrightness in this letter, but I fear terribly for your Majesty's safety and thus have no time for subtlety."
			)
			(2
				(if (IsFlag 881)
					(gMessager sayRange: noun 62 0 3 4 0 20) ; "(LETTER TO LUDWIG CONT'D)I BEG your Highness only this--please do not see this man alone nor even with your servants only to guard you. I promise you, all will be made clear very shortly when my investigation is complete. For now, only keep yourself safe."
				else
					(gGame changeScore: 881)
					(if (IsFlag 897)
						(SetFlag 36)
						(gMessager sayRange: noun 62 0 3 5 0 20) ; "(LETTER TO LUDWIG CONT'D)I BEG your Highness only this--please do not see this man alone nor even with your servants only to guard you. I promise you, all will be made clear very shortly when my investigation is complete. For now, only keep yourself safe."
					else
						(gMessager sayRange: noun 62 0 3 4 0 20) ; "(LETTER TO LUDWIG CONT'D)I BEG your Highness only this--please do not see this man alone nor even with your servants only to guard you. I promise you, all will be made clear very shortly when my investigation is complete. For now, only keep yourself safe."
					)
				)
			)
		)
	)
)

(instance invGracePackage1 of GK2Inventory
	(properties
		noun 254
		view 994
		loop 11
		message 9
	)

	(method (adjustFeatures)
		(itemFeature init: 58 44 581 44 579 435 58 437)
	)
)

(instance invMayorNote of GK2Inventory
	(properties
		noun 253
		view 994
		loop 12
		message 108
	)

	(method (adjustFeatures)
		(itemFeature init: 92 31 522 31 522 301 92 301)
	)
)

(instance invChurchFile of GK2Inventory
	(properties
		noun 107
		view 994
		loop 13
		message 72
	)

	(method (adjustFeatures)
		(itemFeature init: 138 25 477 25 478 303 135 303)
	)
)

(instance invVonGlowerCard of GK2Inventory
	(properties
		noun 140
		view 994
		loop 14
		message 73
	)

	(method (showSelf)
		(if (super showSelf: &rest)
			(SetFlag 29)
		else
			(return 0)
		)
	)

	(method (adjustFeatures)
		(gGame changeScore: 926)
		(itemFeature init: 173 90 440 90 440 243 173 242)
	)

	(method (handleEvent)
		(= noun
			(if (IsFlag 499)
				140
			else
				(SetFlag 499)
				174
			)
		)
		(super handleEvent: &rest)
	)
)

(instance invGabeEnvelope2 of GK2Inventory
	(properties
		noun 230
		view 994
		loop 15
		message 54
	)

	(method (adjustFeatures)
		(itemFeature init: 42 50 573 50 573 282 42 282)
	)
)

(instance invCuckooClock of GK2Inventory
	(properties
		noun 109
		view 9941
		message 74
	)

	(method (adjustFeatures)
		(itemFeature
			init:
				307
				19
				422
				79
				398
				109
				398
				127
				424
				127
				416
				249
				397
				295
				226
				295
				208
				244
				205
				129
				227
				127
				227
				113
				202
				84
		)
	)
)

(instance invXaverKeys of GK2Inventory
	(properties
		noun 110
		view 9941
		loop 1
		message 39
	)

	(method (adjustFeatures)
		(itemFeature
			init:
				352
				64
				285
				127
				168
				193
				183
				215
				252
				195
				200
				259
				218
				273
				294
				218
				294
				277
				319
				284
				336
				229
				350
				253
				380
				244
				358
				193
				427
				148
				436
				92
				395
				58
		)
	)
)

(instance invGrosPhoneNumber of GK2Inventory
	(properties
		noun 111
		view 9941
		loop 2
		message 47
	)

	(method (adjustFeatures)
		(itemFeature init: 155 98 462 98 462 234 155 234)
	)
)

(instance invMagazine of GK2Inventory
	(properties
		noun 112
		view 9941
		loop 3
		message 75
		fullScreen 0
		exitVerb 40
	)

	(method (doVerb theVerb)
		(if (== theVerb 40) ; invTapeRecorder
			(= state 3)
			(gGame changeScore: 976)
			(Load rsVIEW 9943)
			(gMessager say: 113 62 0 1 0 20) ; "(CLICK TAPE RECORDER ON MAGAZINE, SLY)Hmmm. That's a thought."
			(gEgo put: 6 put: 35 get: 76) ; invTapeRecorder, invMagazine, invMagWithRecorder
			(invMagWithRecorder select:)
		)
		(super doVerb: theVerb)
	)

	(method (adjustFeatures)
		(itemFeature init: 182 56 457 58 449 421 182 418)
	)
)

(instance invGraceLetter2 of GK2Inventory
	(properties
		noun 237
		view 9941
		loop 4
		message 50
		fullScreen 0
	)

	(method (adjustFeatures)
		(SetFlag 514) ; enable "The Black Wolf" in rm3210, enable "Ludwig II" in rm4220b, enable "The Black Wolf" in rm4220b, enable "The Black Wolf" in rm4420, enable "The Black Wolf" in rm4421
		(itemFeature init: 120 -3 500 438)
	)

	(method (handleEvent)
		(if (or (IsFlag 550) (== gEgo GraceEgo))
			(gMessager sayRange: noun 62 0 1 5 0 20) ; "March 18, 1994  Gabriel: You might as well know, I'm in Rittersberg. I wasn't about to sit in New Orleans and let you have all the fun. Besides, if it goes anything like last time, you're going to need my help."
		else
			(SetFlag 550)
			(gMessager sayRange: noun 62 0 1 7 0 20) ; "March 18, 1994  Gabriel: You might as well know, I'm in Rittersberg. I wasn't about to sit in New Orleans and let you have all the fun. Besides, if it goes anything like last time, you're going to need my help."
		)
	)
)

(instance invGabeLetter2 of GK2Inventory
	(properties
		noun 116
		view 9941
		loop 5
		message 64
		pageMax 2
		fullScreen 1
	)

	(method (adjustFeatures)
		(switch pageNum
			(0
				(upFeature init: 42 50 571 282)
				(downFeature dispose:)
			)
			(1
				(gGame changeScore: 981)
				(itemFeature init: 112 3 508 3 510 436 111 446)
				(upFeature init: 509 25 557 470)
				(downFeature dispose:)
				(SetFlag 19)
				(SetFlag 18)
			)
			(2
				(itemFeature init: 136 14 536 14 535 447 136 451)
				(downFeature init: 0 0 102 224)
				(upFeature dispose:)
			)
		)
	)

	(method (handleEvent)
		(if (and (== pageNum 2) (== gChapter 4))
			(gMessager sayRange: noun 62 0 2 3 0 20) ; "Don't worry. Things are going very smoothly this time around. I've tracked a suspect to a hunt club run by a man named von Glower. He seems okay, but I'm sure there's something going on with at least one of the others. Don't worry, though. I met a police detective named Leber, so I have back-up. I'll be finished soon. Sit tight and enjoy your visit til I get there. Gabriel"
		else
			(super handleEvent: &rest)
		)
	)
)

(instance invFourRoses of GK2Inventory
	(properties
		noun 144
		view 9941
		loop 6
		message 76
	)

	(method (adjustFeatures)
		(itemFeature
			init:
				359
				4
				429
				44
				413
				98
				427
				134
				388
				171
				358
				174
				343
				232
				268
				242
				254
				224
				160
				310
				136
				296
				124
				252
				214
				197
				179
				111
				202
				87
				231
				106
				250
				92
				254
				48
				275
				39
				301
				84
				324
				78
				339
				20
		)
	)
)

(instance invTourTapeDeck of GK2Inventory
	(properties
		noun 145
		view 9941
		loop 7
		message 78
	)

	(method (adjustFeatures)
		(itemFeature init: 182 46 357 10 411 158 423 212 406 287 237 323)
	)
)

(instance invLudwigBio of GK2Inventory
	(properties
		noun 118
		view 9941
		loop 8
		message 80
		pageMax 5
		fullScreen 0
	)

	(method (adjustFeatures)
		(switch pageNum
			(0
				(upFeature init: 150 10 480 375)
				(downFeature dispose:)
				(itemFeature dispose:)
			)
			(1
				(itemFeature dispose:)
				(if (not (IsFlag 465))
					(itemFeature init: 320 14 572 433)
				)
				(upFeature dispose:)
				(upFeature init: 580 0 640 433)
				(downFeature init: 0 0 60 433)
			)
			(2
				(gGame changeScore: 1006)
				(itemFeature init: 310 0 580 433)
			)
			(3
				(itemFeature init: 310 0 580 433)
				(doublePage dispose:)
			)
			(4
				(upFeature init: 580 0 640 433)
				(itemFeature dispose:)
				(doublePage init: 60 0 580 433)
			)
			(5
				(doublePage dispose:)
				(itemFeature init: 60 0 320 433)
				(upFeature dispose:)
			)
		)
	)

	(method (handleEvent event &tmp temp0)
		(switch pageNum
			(1
				(= temp0 (if (IsFlag 281) 159 else 117)) ; "Ludwig's Diary" in rm8412Topic
				(gMessager say: temp0 62 0 0 0 20)
			)
			(2
				(gMessager sayRange: 118 62 0 1 3 0 20) ; "(READING BIOGRAPHY)Ludwig remained throughout his life both very bright and very naive. He was an introvert who seemed to be constantly out-of-sync with traditional views of rulership, money, and human relationships. The world ever failed to match his ideals. Perhaps this was the fault of his sheltered upbringing as future king. He never was introduced to the real world, and the real world failed to interest him as an adult."
			)
			(3
				(gMessager sayRange: 119 62 0 1 2 0 20) ; "(READING BIO)Other than his long-standing friendship with the Empress Elizabeth of Austria and with his mother, the relationships Ludwig attempted with others were nearly always a disappointment for him and a bewilderment for his partners. He would become obsessed with someone -- a singer, an artist, a nobleman, or a peasant, and would bombard them with gifts, praise and favors."
			)
			(4
				(if event
					(if (and (IsFlag 288) (not (IsFlag 575))) ; "The Black Wolf" in rm8412Topic
						(SetFlag 575)
						(gMessager sayRange: 120 62 0 4 5 cueScript 20) ; "(READING BIO)His Majesty has been in the thick of it ever since and, while I welcome his good temper, I grow tired of fetching letters back and forth to 'Louis' (so called by His Majesty -- that should tell you who the young man looks like) at all hours of the night!""
					else
						(gMessager say: 120 62 0 4 cueScript 20) ; "(READING BIO)His Majesty has been in the thick of it ever since and, while I welcome his good temper, I grow tired of fetching letters back and forth to 'Louis' (so called by His Majesty -- that should tell you who the young man looks like) at all hours of the night!""
					)
				else
					(gMessager sayRange: 120 62 0 1 3 0 20) ; "(READING BIO)A good example of the king's obsessive behavior in relationships is the following letter from the K\94niglich Bayerische Archives, which this author was priviledged to access. It is dated 1864 and it was written by Ludwig's manservant, Paul, to a friend."
				)
			)
			(5
				(gMessager sayRange: 122 62 0 1 2 0 20) ; "(READING BIO)The king, especially later in life, felt a great deal of guilt about his sensual nature. His diaries are full of repentant entries begging God for forgiveness and swearing to remain pure."
			)
		)
	)
)

(instance cueScript of Script
	(properties)

	(method (cue)
		(gMessager say: 121 62 0 0 0 20) ; "(READING BIO)This author has not been able to learn much about 'Louis,' but he was known to have been a seemingly high-bred foreigner and he was involved with Ludwig as late as 1880, when he fell into disfavor."
	)
)

(instance invDallmeierNote of GK2Inventory
	(properties
		noun 123
		view 9941
		loop 9
		message 81
	)

	(method (adjustFeatures)
		(itemFeature init: 123 44 494 44 494 255 123 255)
	)
)

(instance invChaphillNote of GK2Inventory
	(properties
		noun 124
		view 9941
		loop 10
		message 82
	)

	(method (adjustFeatures)
		(itemFeature init: 123 61 493 61 493 269 123 269)
	)
)

(instance invGraceEnvelope3 of GK2Inventory
	(properties
		noun 125
		view 9941
		loop 11
		message 83
	)

	(method (adjustFeatures)
		(itemFeature init: 42 47 571 47 571 285 42 285)
	)
)

(instance invDiaryTranslation of GK2Inventory
	(properties
		noun 126
		view 9941
		loop 12
		message 15
		pageMax 10
		fullScreen 0
	)

	(method (adjustFeatures)
		(switch pageNum
			(0
				(upFeature init: 224 6 116 67 118 451 534 463 620 452 620 6)
				(downFeature dispose:)
				(itemFeature dispose:)
			)
			(1
				(gGame changeScore: 1023)
				(upFeature dispose:)
				(itemFeature init: 120 6 490 441)
				(upFeature init: 490 9 634 440)
				(downFeature init: 0 -3 98 228)
			)
			(2
				(itemFeature init: 132 6 500 441)
				(upFeature init: 500 9 634 440)
			)
			(3
				(itemFeature init: 145 6 510 441)
				(upFeature init: 510 9 634 440)
			)
			(4
				(itemFeature init: 155 6 522 441)
				(upFeature init: 522 9 634 440)
			)
			(5
				(itemFeature init: 170 6 534 441)
				(upFeature init: 534 9 634 440)
			)
			(6
				(itemFeature init: 180 6 548 441)
				(upFeature init: 548 9 634 440)
			)
			(7
				(itemFeature init: 200 6 560 441)
				(upFeature init: 560 9 634 440)
			)
			(8
				(itemFeature init: 210 6 572 441)
				(upFeature init: 572 9 634 440)
			)
			(9
				(itemFeature init: 222 6 585 441)
				(upFeature init: 585 9 634 440)
			)
			(10
				(upFeature dispose:)
			)
		)
	)
)

(instance invLily of GK2Inventory
	(properties
		noun 146
		view 9941
		loop 13
		message 46
	)

	(method (adjustFeatures)
		(itemFeature
			init:
				147
				119
				217
				92
				231
				26
				253
				70
				309
				25
				316
				41
				296
				136
				342
				103
				394
				140
				397
				159
				349
				200
				474
				302
				454
				311
				339
				216
				240
				254
				180
				243
				196
				178
				222
				160
		)
	)
)

(instance invDornMoney of GK2Inventory
	(properties
		noun 190
		view 9941
		loop 14
		message 114
	)

	(method (adjustFeatures)
		(itemFeature init: 88 264 89 66 113 52 538 51 565 74 566 252 551 268)
	)
)

(instance invGraceLetter3 of GK2Inventory
	(properties
		noun 182
		view 9941
		loop 15
		message 51
		pageMax 1
		fullScreen 1
	)

	(method (adjustFeatures)
		(if pageNum
			(upFeature dispose:)
			(itemFeature init: 120 -3 500 438)
		else
			(upFeature init: 42 50 573 283)
			(itemFeature dispose:)
		)
	)

	(method (handleEvent)
		(if (IsFlag 683)
			(gMessager sayRange: noun 62 0 1 3 0 20) ; "Gabriel: I've been busy on this case and it's starting to pay off. Thought I'd fill you in. There's DEFINITELY something going on with Ludwig II. I'm pretty sure he was involved with a werewolf. In fact, he was probably turned into one himself. Anyway, something happened to him on this hunting trip and afterwards he fits the profile in the lore book to a 'T'. It's really fascinating."
		else
			(gGame changeScore: 1057)
			(SetFlag 683)
			(gMessager sayRange: noun 62 0 1 4 0 20) ; "Gabriel: I've been busy on this case and it's starting to pay off. Thought I'd fill you in. There's DEFINITELY something going on with Ludwig II. I'm pretty sure he was involved with a werewolf. In fact, he was probably turned into one himself. Anyway, something happened to him on this hunting trip and afterwards he fits the profile in the lore book to a 'T'. It's really fascinating."
		)
	)
)

(instance invLedgerPage of GK2Inventory
	(properties
		noun 189
		view 9942
		message 86
		pageMax 1
	)

	(method (adjustFeatures)
		(SetFlag 688)
		(itemFeature init: 116 11 504 11 505 376 111 380)
		(if (IsFlag 687)
			(= noun 175)
		)
	)
)

(instance invWurst of GK2Inventory
	(properties
		noun 188
		view 9942
		loop 1
		message 87
	)

	(method (adjustFeatures)
		(itemFeature
			init: 393 22 316 81 168 250 250 313 421 179 443 110 426 91 422 37
		)
	)
)

(instance invLantern of GK2Inventory
	(properties
		noun 147
		view 9942
		loop 2
		message 24
	)

	(method (doVerb theVerb)
		(cond
			((and (== theVerb 21) (== gCurRoomNum 670)) ; invMatches, cavePitRm
				(SetFlag 658)
				(gEgo put: 50 put: 51) ; invLantern, invMatches
				(gUser curVerb: 62)
				(GKHotCursor update:)
				(gCurRoom setScript: litLanternScript)
				(return 1)
			)
			((== theVerb 21) ; invMatches
				(gMessager say: 192 62 0 1 0 20) ; "(TRY TO LIGHT LANTERN SOMEWHERE EXCEPT CAVE)I don't need the light here."
				(return 0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (adjustFeatures)
		(itemFeature
			init:
				262
				41
				295
				36
				321
				36
				353
				42
				338
				94
				351
				141
				343
				190
				369
				228
				369
				245
				341
				293
				271
				293
				247
				248
				247
				225
				273
				195
				264
				149
				275
				91
		)
	)
)

(instance invMatches of GK2Inventory
	(properties
		noun 148
		view 9942
		loop 3
		message 21
	)

	(method (adjustFeatures)
		(itemFeature init: 188 165 366 67 424 162 246 266)
	)

	(method (doVerb theVerb)
		(cond
			((and (== theVerb 24) (== gCurRoomNum 670)) ; invLantern, cavePitRm
				(SetFlag 658)
				(gEgo put: 50 put: 51) ; invLantern, invMatches
				(gUser curVerb: 62)
				(GKHotCursor update:)
				(gCurRoom setScript: litLanternScript)
				(return 1)
			)
			((== theVerb 24) ; invLantern
				(gMessager say: 192 62 0 1 0 20) ; "(TRY TO LIGHT LANTERN SOMEWHERE EXCEPT CAVE)I don't need the light here."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance litLanternScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 1)
			)
			(1
				(gGk2Music stop:)
				(PlayScene 705 self 640) ; lairExtRm
			)
		)
	)
)

(instance invGrossbergLetter of GK2Inventory
	(properties
		noun 238
		view 9942
		loop 4
		message 88
		pageMax 1
		fullScreen 1
	)

	(method (adjustFeatures)
		(gGame changeScore: 1068)
		(if (not pageNum)
			(upFeature init: 121 50 600 284)
		else
			(upFeature dispose:)
			(itemFeature init: 162 10 557 450)
		)
	)
)

(instance invShears of GK2Inventory
	(properties
		noun 149
		view 9942
		loop 5
		message 89
	)

	(method (adjustFeatures)
		(itemFeature
			init:
				35
				49
				103
				104
				245
				144
				290
				210
				545
				315
				560
				280
				306
				174
				327
				133
				568
				181
				575
				144
				331
				103
				260
				113
				136
				36
				55
				9
				117
				68
		)
	)
)

(instance invRope of GK2Inventory
	(properties
		noun 150
		view 9942
		loop 6
		message 22
	)

	(method (adjustFeatures)
		(itemFeature
			init:
				127
				139
				308
				31
				391
				28
				435
				39
				506
				97
				504
				116
				468
				123
				455
				171
				328
				290
				247
				311
				166
				257
		)
	)
)

(instance invWolfTags of GK2Inventory
	(properties
		noun 191
		view 9942
		loop 7
		message 90
	)

	(method (adjustFeatures)
		(itemFeature
			init:
				251
				63
				400
				44
				432
				64
				464
				178
				463
				248
				429
				272
				296
				263
				264
				227
				231
				115
		)
	)
)

(instance invChandelierDiagram of GK2Inventory
	(properties
		noun 213
		view 9942
		loop 8
		message 92
		fullScreen 0
	)

	(method (adjustFeatures)
		(centerFeature init: 316 150 316 208 355 208 355 150)
		(itemFeature init: 55 48 583 48 583 422 55 422)
	)

	(method (handleEvent)
		(if argc
			(= noun
				(if (IsFlag 741)
					214
				else
					(gGame changeScore: 1123)
					(SetFlag 801)
					(SetFlag 765)
					156
				)
			)
		else
			(= noun (if (IsFlag 749) 213 else 155))
		)
		(super handleEvent:)
	)
)

(instance invVonGlowerLetter of GK2Inventory
	(properties
		noun 204
		view 9942
		loop 9
		message 96
		pageMax 6
		fullScreen 1
	)

	(method (adjustFeatures)
		(SetFlag 705) ; enable "Von Glower's Letter" in smithTopicCh6
		(switch pageNum
			(0
				(upFeature init: 87 24 527 25 527 309 86 309)
				(itemFeature dispose:)
			)
			(1
				(if (not (gEgo has: 5)) ; invTalisman
					(gEgo get: 5) ; invTalisman
					(gMessager say: 161 62 0 1 0 20) ; "(PICKUP, OPENS VON GLOWER'S LETTER TO GABE CH 6 AND DISCOVERS TALISMAN, NERVOUS, ANXIOUS)It's a letter from von Glower! And he sent the Ritter talisman back, too!"
					(gGame changeScore: 1140)
				)
				(itemFeature init: 122 0 517 450)
				(upFeature dispose:)
				(upFeature init: 518 0 594 450)
				(downFeature dispose:)
			)
			(2
				(downFeature init: 0 0 100 280)
			)
			(6
				(upFeature dispose:)
			)
		)
	)

	(method (handleEvent)
		(switch pageNum
			(1
				(gMessager sayRange: noun 62 0 1 3 0 20) ; "(LETTER TO GABE, CH 6)Gabriel. I know you are very ill right now. The change is always painful. I went through it myself when I was only twelve, and I did not even know what was happening to me."
			)
			(2
				(gMessager sayRange: noun 62 0 4 5 0 20) ; "You will need me then and, I think, you will WANT me then. It is for hope of this that I did not have you destroyed the night you were bitten by von Zell. I could have done. You were passed out for hours at the lodge."
			)
			(3
				(gMessager sayRange: noun 62 0 6 8 0 20) ; "I have even, very rarely, taken the risk and Changed others. But the Blood was always too much for the brain, and my Chosen One ended up dead. Or mad."
			)
			(4
				(gMessager sayRange: noun 62 0 9 10 0 20) ; "But you are different. You're a Ritter. Your blood is ALREADY supernatural. Yes, I know of your family. I have studied much over these long years. When we met, I felt somehow that you would not be destroyed by the Gift. You have an enormous streak of the beast in you, and you are innately strong in the Occult."
			)
			(5
				(gMessager sayRange: noun 62 0 11 12 0 20) ; "He had to be taken care of and you obligingly showed up. What was I to do? I am too old not to have learned at least this much about the light -- you cannot shut it out. Better to let it in and let it simply dim to adjust to the relative brightness INSIDE."
			)
			(6
				(if (IsFlag 705)
					(gMessager sayRange: noun 62 0 13 14 0 20) ; "You can feel the night wind on your face, taste the heartbeat of the kill beneath your jaws. It is glorious -- much more so than the priestly life the Schattenjager offers."
				else
					(SetFlag 705) ; enable "Von Glower's Letter" in smithTopicCh6
					(gMessager sayRange: noun 62 0 13 15 0 20) ; "You can feel the night wind on your face, taste the heartbeat of the kill beneath your jaws. It is glorious -- much more so than the priestly life the Schattenjager offers."
				)
			)
		)
	)
)

(instance invOperaAct1 of GK2Inventory
	(properties
		noun 207
		view 9942
		loop 12
		message 97
		fullScreen 0
	)

	(method (adjustFeatures)
		(itemFeature init: 298 18 378 23 355 459 271 453)
	)
)

(instance invOperaAct2 of GK2Inventory
	(properties
		noun 206
		view 9942
		loop 11
		message 98
		fullScreen 0
	)

	(method (adjustFeatures)
		(itemFeature
			init: 213 15 384 20 412 447 328 460 308 134 292 136 267 454 175 447
		)
	)
)

(instance invOperaAct3 of GK2Inventory
	(properties
		noun 205
		view 9942
		loop 10
		message 99
		fullScreen 0
	)

	(method (adjustFeatures)
		(itemFeature
			init:
				165
				10
				143
				433
				226
				452
				247
				280
				273
				276
				313
				462
				469
				455
				483
				8
				392
				9
				390
				292
				376
				292
				318
				14
		)
	)
)

(instance invPillowcase of GK2Inventory
	(properties
		noun 151
		view 9942
		loop 13
		message 30
	)

	(method (adjustFeatures)
		(itemFeature init: 250 27 157 203 341 309 462 153 297 23 282 43)
	)
)

(instance invBottleOfWater of GK2Inventory
	(properties
		noun 202
		view 9942
		loop 14
		message 100
	)

	(method (adjustFeatures)
		(itemFeature init: 277 26 330 26 349 147 349 300 263 300 263 136)
	)
)

(instance invSilverHeart of GK2Inventory
	(properties
		noun 208
		view 9942
		loop 15
		message 101
	)

	(method (adjustFeatures)
		(itemFeature
			init:
				228
				33
				172
				95
				172
				191
				283
				308
				334
				308
				429
				202
				445
				109
				406
				39
				355
				27
				303
				42
		)
	)
)

(instance invPriestCard of GK2Inventory
	(properties
		noun 209
		view 9943
		message 102
	)

	(method (adjustFeatures)
		(itemFeature init: 173 72 441 72 441 261 173 261)
	)
)

(instance invOperaProgram of GK2Inventory
	(properties
		view 9943
		loop 1
		message 103
		pageMax 5
		fullScreen 0
	)

	(method (adjustFeatures)
		(switch pageNum
			(0
				(upFeature init: 175 13 466 440)
				(downFeature dispose:)
				(doublePage dispose:)
			)
			(1
				(upFeature dispose:)
				(upFeature init: 576 34 630 440)
				(downFeature init: 10 34 63 440)
				(doublePage init: 63 34 576 440)
			)
			(4
				(upFeature init: 576 34 630 440)
				(doublePage init: 63 34 576 440)
				(itemFeature dispose:)
			)
			(5
				(upFeature dispose:)
				(doublePage dispose:)
				(itemFeature init: 64 33 317 440)
			)
		)
	)

	(method (handleEvent event)
		(switch pageNum
			(1
				(if (not event)
					(gMessager sayRange: 164 62 0 1 4 0 20) ; "(PICKUP, READING OPERA PROGRAM IN INVENTORY)The Curse of Englehart by Richard Wagner. Act I."
				else
					(gMessager sayRange: 165 62 0 1 4 0 20) ; "(PICKUP, OPERA PROGRAM CONT'D)The other villagers, assuming that the blacksmith's behavior toward Engelhart must be deserved, followed suit. Now in the same town there lived a rich Baron. The Baron maintained a patronly and righteous face with the villagers, but it was rumored that he was actually unspeakably cruel and wicked."
				)
			)
			(2
				(if (not event)
					(gMessager sayRange: 166 62 0 1 3 0 20) ; "(PICKUP, OPERA PROGRAM CONT'D)Hildegunde -- overcome by her fear and anger at the betrothal -- casts the jewelry box into the fire. She is immediately remorseful and pulls it out, but it is too late. The delicate silver has been badly marred."
				else
					(gMessager sayRange: 167 62 0 1 3 0 20) ; "(PICKUP, OPERA PROGRAM CONT'D)Act 2. The Baron learns of Hildegunde and Engelhart's disappearance. He is so furious that he hires hunters to track the pair down. Hildegunde and Engelhart are found and arrested. In a public trial, Hildegunde pleads their case in a stirring aria."
				)
			)
			(3
				(if (not event)
					(gMessager sayRange: 168 62 0 1 5 0 20) ; "(PICKUP, OPERA PROGRAM CONT'D)By the rights of the injured, the Baron announces, he is empowered to set a curse. The Baron curses Engelhart with a terrible and ancient malady -- that whenever the moon shines in the night, Engelhart will become a marauding wolf."
				else
					(gMessager sayRange: 169 62 0 1 3 0 20) ; "(PICKUP, OPERA PROGRAM CONT'D)In fact, he even does some good for the villagers. He scares away bandits and he keeps the renegade wolf at bay. No more children are lost to the fangs of the night. Engelhart's kindness shines through even the dire nature of his curse."
				)
			)
			(4
				(if (not event)
					(gMessager sayRange: 170 62 0 1 4 0 20) ; "(PICKUP, OPERA PROGRAM CONT'D)Act 3. The final act begins with the wedding feast for Hildegunde and the Baron. Hildegunde has "cooperated," due to her fear for her parent's lives, but now that the service is over, she is horrified to find herself that Baron's wife, and is mourning her final separation from Engelhart."
				else
					(gMessager sayRange: 171 62 0 1 4 0 20) ; "(PICKUP, OPERA PROGRAM CONT'D)The Baron protests, preferring the comedy, but he's reassured by Hildegunde's father. The minstrels gather in a circle around the frowning minstrel. They whirl around him, and he slowly sinks form sight. The music grows more frantic."
				)
			)
			(5
				(gMessager sayRange: 172 62 0 1 4 0 20) ; "(PICKUP, OPERA PROGRAM CONT'D)The villagers rally in a cry of horror and fury. One of the men grabs an axe from the wall and entreats the others to follow. They will stalk and kill the murderous wolf! The villagers storm through the archway. Hildegunde follows."
			)
		)
	)
)

(instance invSeatingChart of GK2Inventory
	(properties
		noun 211
		view 9943
		loop 2
		message 104
		pageMax 1
		fullScreen 0
	)

	(method (showSelf)
		(if (and (super showSelf: &rest) (IsFlag 741))
			(self pageUp:)
		)
	)

	(method (adjustFeatures)
		(centerFeature init: 298 162 295 229 314 234 338 230 338 163 319 159)
		(itemFeature init: 53 60 53 409 589 417 589 60)
	)

	(method (handleEvent)
		(if argc
			(gGame changeScore: 1124)
			(= noun
				(cond
					((IsFlag 741) 212)
					((IsFlag 801)
						(SetFlag 802)
						217
					)
					(else 157)
				)
			)
		else
			(= noun 211)
		)
		(gMessager say: noun 62 0 0 0 20) ; "(LOOK AT SEATING CHART)It's a seating chart for the theater."
	)
)

(instance invTheaterKeys of GK2Inventory
	(properties
		noun 154
		view 9943
		loop 3
		message 37
	)

	(method (adjustFeatures)
		(itemFeature
			init:
				162
				84
				288
				34
				386
				57
				405
				140
				477
				204
				460
				223
				375
				177
				364
				198
				388
				278
				369
				294
				330
				219
				308
				303
				283
				297
				284
				265
				269
				277
				252
				260
				267
				205
				257
				176
				237
				165
				205
				175
				163
				168
				143
				122
		)
	)
)

(instance invBanner of GK2Inventory
	(properties
		noun 220
		view 9943
		loop 4
		message 33
	)

	(method (adjustFeatures)
		(itemFeature init: 89 124 89 306 524 306 524 124)
	)
)

(instance invTheaterRope of GK2Inventory
	(properties
		noun 153
		view 9943
		loop 5
		message 105
	)

	(method (adjustFeatures)
		(itemFeature
			init:
				191
				67
				273
				17
				336
				21
				397
				52
				432
				112
				453
				204
				430
				217
				413
				265
				362
				306
				303
				319
				233
				285
				171
				210
				157
				142
		)
	)
)

(instance invOperaGlasses of GK2Inventory
	(properties
		noun 152
		view 9943
		loop 6
		message 34
	)

	(method (adjustFeatures)
		(itemFeature
			init:
				203
				84
				181
				153
				183
				189
				419
				266
				434
				225
				231
				179
				243
				161
				279
				168
				351
				169
				390
				112
				380
				81
				354
				68
				322
				73
				306
				108
				274
				110
				264
				93
				237
				76
		)
	)
)

(instance invToDoList of GK2Inventory
	(properties
		noun 244
		view 9943
		loop 7
		message 131
	)

	(method (adjustFeatures)
		(itemFeature init: 108 7 108 442 508 445 508 7)
	)
)

(instance invCarKeys of GK2Inventory
	(properties
		noun 143
		view 9943
		loop 8
		message 113
	)

	(method (adjustFeatures)
		(= noun
			(cond
				((IsFlag 740) 162)
				((== gChapter 6)
					(= modNum 100)
					6
				)
				(else 143)
			)
		)
		(itemFeature
			init:
				266
				49
				229
				142
				249
				157
				215
				275
				231
				282
				283
				169
				322
				180
				385
				292
				404
				280
				353
				164
				365
				133
				317
				49
		)
	)
)

(instance invPitcher of GK2Inventory
	(properties
		view 9943
		loop 9
		message 111
		fullScreen 0
	)

	(method (adjustFeatures)
		(itemFeature init: 158 151 243 135 397 141 475 155 444 406 194 418)
	)
)

(instance invCastleTicket of GK2Inventory
	(properties
		noun 142
		view 9943
		loop 10
		message 77
	)

	(method (adjustFeatures)
		(itemFeature init: 189 109 425 109 425 224 189 224)
	)
)

(instance invRoll of GK2Inventory
	(properties
		noun 223
		view 9943
		loop 11
		message 132
	)

	(method (adjustFeatures)
		(itemFeature
			init:
				213
				83
				274
				59
				316
				75
				357
				125
				370
				191
				361
				224
				293
				255
				248
				239
				223
				203
				199
				138
		)
	)
)

(instance invMagWithRecorder of GK2Inventory
	(properties
		noun 114
		view 9943
		loop 12
		message 116
		fullScreen 0
	)

	(method (adjustFeatures)
		(itemFeature init: 184 55 454 53 447 430 184 437)
	)
)

(instance invDove of GK2Inventory
	(properties
		noun 201
		view 9943
		loop 13
		message 31
	)

	(method (adjustFeatures)
		(itemFeature
			init:
				251
				41
				215
				139
				144
				223
				276
				306
				330
				222
				423
				120
				417
				58
				348
				7
				309
				42
				282
				26
				273
				46
		)
	)
)

(instance invLitLantern of GK2Inventory
	(properties
		noun 226
		view 9943
		loop 14
		message 134
	)

	(method (adjustFeatures)
		(itemFeature
			init:
				263
				39
				296
				34
				328
				35
				355
				41
				339
				90
				350
				143
				343
				199
				370
				224
				370
				251
				347
				287
				324
				294
				283
				294
				246
				251
				246
				221
				274
				198
				274
				185
				263
				155
				277
				91
		)
	)
)

(instance invGabeNotebook of GK2Inventory
	(properties
		noun 249
		view 9943
		loop 15
		message 133
	)

	(method (adjustFeatures)
		(itemFeature init: 78 44 560 44 560 406 78 406)
	)
)

(instance invAddressedPackage of GK2Inventory
	(properties
		noun 138
		view 9944
		message 44
	)

	(method (adjustFeatures)
		(itemFeature init: 58 44 581 44 579 435 58 437)
	)

	(method (handleEvent)
		(if (== gEgo GraceEgo)
			(super handleEvent: &rest)
		else
			(gEgo get: 23 get: 24 get: 25 get: 36 put: 80) ; invWerewolfBook, invVictorJournal, invChristianJournal, invGraceLetter2, invAddressedPackage
			(invPlane scratch: 1)
			(invPlane doit:)
			(gGame changeScore: 928)
			(invGraceLetter2 showSelf: 50)
		)
	)
)

(instance invGun of GK2Inventory
	(properties
		noun 233
		view 9944
		loop 1
		message 135
	)
)

(instance invVonZellTape of GK2Inventory
	(properties
		view 9944
		loop 2
		message 117
	)

	(method (adjustFeatures)
		(itemFeature init: 140 100 480 380)
		(if (IsFlag 678)
			(= noun 184)
		else
			(= noun 183)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 40) ; invTapeRecorder
			(if (IsFlag 678)
				(gMessager say: 186 62 0 1 0 20) ; "\9abergrau told me what the tape says."
			else
				(gMessager say: 185 62 0 1 0 20) ; "I'm sure whatever they said is in German. I need a translator."
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance invRollOfTape of GK2Inventory
	(properties
		noun 248
		view 9944
		loop 3
		message 35
	)

	(method (adjustFeatures)
		(itemFeature
			init:
				279
				50
				230
				88
				204
				159
				140
				206
				191
				263
				222
				274
				280
				267
				356
				279
				425
				237
				450
				176
				433
				98
				372
				46
				317
				38
		)
	)
)

(instance invPowder of GK2Inventory
	(properties
		noun 250
		view 9944
		loop 4
		message 36
	)

	(method (adjustFeatures)
		(itemFeature
			init:
				195
				42
				162
				89
				160
				125
				199
				174
				201
				231
				232
				284
				301
				307
				377
				261
				396
				192
				364
				130
				325
				107
				339
				76
				321
				36
				260
				24
		)
	)
)

(instance invCostume of GK2Inventory
	(properties
		noun 251
		view 9944
		loop 5
		message 128
	)

	(method (adjustFeatures)
		(itemFeature init: 70 20 560 430)
	)
)

(instance invManuscript of GK2Inventory
	(properties
		noun 173
		view 9944
		loop 6
		message 84
		fullScreen 0
	)

	(method (adjustFeatures)
		(itemFeature
			init:
				182
				23
				150
				61
				172
				170
				149
				184
				153
				199
				180
				210
				175
				254
				216
				325
				311
				305
				361
				325
				421
				323
				459
				265
				457
				178
				424
				144
				387
				136
				367
				69
				322
				51
				290
				60
				237
				2
		)
	)
)

(instance invPlane of PanelPlane
	(properties)

	(method (drawPic)
		(gThePlane drawPic: -1)
		(UpdatePlane self)
		(super drawPic: &rest)
	)

	(method (init)
		(= scratch 0)
		((gUser hotCursor:) showWait:)
		(= local1 ((gUser hotCursor:) hotObjList:))
		((gUser hotCursor:) hotObjList: (List new:))
		(super init: &rest)
		(exitButton init: self 1 1)
		((gUser hotCursor:) update: isHot: 0)
		(= priority (+ (GetHighPlanePri) 1))
		(UpdatePlane self)
	)

	(method (handleEvent event)
		(super handleEvent: event &rest)
		(if (event type:)
			(event claimed: 1)
		)
		(event claimed:)
	)

	(method (doit)
		(if scratch
			(self dispose:)
		)
	)

	(method (dispose)
		(((gUser hotCursor:) hotObjList:) release: dispose:)
		((gUser hotCursor:) hotObjList: local1)
		((gUser hotCursor:) isHot: 1)
		(= scratch 0)
		((gUser hotCursor:) cage: 0)
		(= global135 1)
		(super dispose: &rest)
		(if global249
			(Palette 1 global249) ; PalLoad
		)
	)
)

(instance exitButton of PanelButton
	(properties
		x 8
		y 292
		view 140
		loop 11
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(return 1)
		)
	)

	(method (doVerb)
		(plane scratch: 1)
		(return 1)
	)
)

(class InvFeature of ExitFeature
	(properties)

	(method (init param1)
		(if (== argc 4)
			(= nsLeft [param1 0])
			(= nsTop [param1 1])
			(= nsRight [param1 2])
			(= nsBottom [param1 3])
		else
			(self createPoly: param1 &rest)
		)
		(if (not plane)
			(= plane invPlane)
			((invPlane eventList:) add: self)
			((gUser hotCursor:) add: self)
		)
	)

	(method (dispose)
		(self setPolygon: 0)
		((invPlane eventList:) delete: self)
		(((gUser hotCursor:) hotObjList:) delete: self)
		(= plane (= nsLeft (= nsTop (= nsBottom (= nsRight 0)))))
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (& (event type:) evMOUSEBUTTON))
			(self doVerb: 62)
			(event claimed: 1)
			(return)
		else
			(return 0)
		)
	)
)

(instance upFeature of InvFeature
	(properties)

	(method (setCursor param1)
		(param1 view: 993)
		(param1 loop: 1)
		(param1 cel: 0)
	)

	(method (doVerb)
		(local0 pageUp:)
	)
)

(instance downFeature of InvFeature
	(properties)

	(method (setCursor param1)
		(param1 view: 993)
		(param1 loop: 0)
		(param1 cel: 0)
	)

	(method (doVerb)
		(local0 pageDown:)
	)
)

(instance itemFeature of InvFeature
	(properties)

	(method (setCursor param1)
		(param1 view: 999)
		(param1 loop: 1)
		(param1 cel: 0)
	)

	(method (doVerb &tmp temp0)
		(local0 handleEvent:)
	)
)

(instance doublePage of InvFeature
	(properties)

	(method (setCursor param1)
		(param1 view: 999)
		(param1 loop: 1)
		(param1 cel: 0)
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (& (event type:) evMOUSEBUTTON))
			(= scratch (if (> (event x:) 320) 1 else 0))
			(self doVerb: 62)
			(event claimed: 1)
			(return)
		else
			(return 0)
		)
	)

	(method (doVerb &tmp temp0)
		(local0 handleEvent: scratch)
	)
)

(instance centerFeature of InvFeature
	(properties)

	(method (setCursor param1)
		(param1 view: 999)
		(param1 loop: 1)
		(param1 cel: 0)
	)

	(method (doVerb &tmp temp0)
		(local0 handleEvent: 1)
	)
)

