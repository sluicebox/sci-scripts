;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 91)
(include sci.sh)
(use Main)
(use n011)
(use Plane)
(use Array)
(use Print)
(use Inset)
(use Sound)
(use Actor)
(use System)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	[local9 6] = [0 6 12 18 22 28]
	local15 = -999
)

(procedure (localproc_0 param1 param2)
	(if (> (local2 size:) param1)
		(return (== ((local2 at: param1) spliceIndex:) param2))
	)
	(return 0)
)

(class Walkman of Inset
	(properties
		picture 13087
		tapes 0
		messages 0
		curTape 0
		tapeX 32
		tapeY 30
		topicX 74
		topicY 131
		spliceX 65
		spliceY 131
		oldHotList 0
		spliceArray 0
		numSpliceItems 0
		spliceItemX 0
		spliceItemY 0
	)

	(method (addSpliceItem param1 param2 param3 &tmp temp0)
		(if (== numSpliceItems 10)
			(gMessager say: 0 0 11 0 0 91) ; "(TAPE RECORDER CONT'D, OVERRUN SPLICE TAPE AREA)It's gettin' a bit long-winded. I need to keep it short and sweet."
		else
			(if numSpliceItems
				(= spliceItemX
					(+ ((local2 at: (- numSpliceItems 1)) nsRight:) 8)
				)
			else
				(= spliceItemX 60)
			)
			(= temp0
				(spliceItem new: spliceItemX spliceItemY param1 param2 param3)
			)
			(++ numSpliceItems)
			(if (> (temp0 nsRight:) 570)
				(if (!= spliceItemY 380)
					(self deleteSpliceItem:)
					(return)
				else
					(= spliceItemX 60)
					(+= spliceItemY 20)
					(temp0 x: spliceItemX y: spliceItemY)
					(UpdateScreenItem temp0)
					(SetNowSeen temp0)
				)
			)
			(if
				(and
					(== (temp0 spliceIndex:) (- numSpliceItems 1))
					(or
						(== local15 (- numSpliceItems 2))
						(< (- numSpliceItems 2) 0)
					)
				)
				(= local15 (- numSpliceItems 1))
			)
		)
	)

	(method (deleteSpliceItem)
		(if numSpliceItems
			(if (== (- numSpliceItems 1) local15)
				(gMessager say: 0 0 31 2 0 91) ; "(TAPE RECORDER, TRY TO BACK UP OVER GOOD PART OF MSG)I like THAT part. I don't want to erase it."
			else
				((local2 at: (- numSpliceItems 1)) dispose:)
				(-- numSpliceItems)
				(if numSpliceItems
					(= spliceItemX ((local2 at: (- numSpliceItems 1)) x:))
					(= spliceItemY ((local2 at: (- numSpliceItems 1)) y:))
				)
			)
		else
			(gMessager say: 0 0 12 0 0 91) ; "(TAPE RECORDER CONT'D--TRY TO BACK UP SPLICE TAPE WHEN TAPE IS EMPTY)I don't have anythin' loaded YET."
		)
	)

	(method (splice)
		(local0 eachElementDo: #hide)
		(= numSpliceItems 0)
		(= spliceItemX 60)
		(= spliceItemY 380)
		(advanceSpliceText init:)
		(backSpliceText init:)
		(deleteSpliceItems init:)
		(transfer init:)
		(spliceExit init:)
		(hintButton init:)
		(if (not spliceArray)
			(= spliceArray
				(IDArray
					with:
						(IntArray
							with:
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								1
								2
								3
								4
								-1
								1
								2
								-1
								-1
								-1
						)
						(IntArray
							with:
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								7
								-1
						)
						(IntArray
							with:
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								8
								-1
								-1
								-1
								4
								-1
								-1
								-1
								0
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								5
								6
								7
								8
								-1
						)
						(IntArray
							with: -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 8 -1 -1
						)
						(IntArray
							with:
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								7
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								8
								-1
								-1
						)
						(IntArray
							with:
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								-1
								9
						)
				)
			)
		)
		(if (not local3)
			(= local3 (Cast new:))
			(plane addCast: local3)
		)
		(if (not local2)
			(= local2 (Cast new:))
			(plane addCast: local2)
		)
		(= picture 13089)
		(plane drawPic: picture)
		(self showSpliceText: (= local8 0))
	)

	(method (showSpliceText param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(cond
			((>= param1 6)
				(= local8 0)
			)
			((< param1 0)
				(= local8 5)
			)
			(else
				(= local8 param1)
			)
		)
		(local3 eachElementDo: #dispose)
		(= spliceX 65)
		(= spliceY 131)
		(= temp0 (spliceArray at: local8))
		(= temp3 [local9 local8])
		(= temp4 0)
		(for ((= temp2 0)) (< temp2 (temp0 size:)) ((++ temp2))
			(= temp1
				(spliceText new: spliceX spliceY temp3 temp4 (temp0 at: temp2))
			)
			(if (> (++ temp4) (temp1 lastCel:))
				(= spliceX 65)
				(+= spliceY 20)
				(= temp4 0)
				(+= temp3 2)
			else
				(= spliceX (+ (temp1 nsRight:) 8))
			)
		)
	)

	(method (init)
		(gGame handsOff:)
		(= plane (Plane new:))
		(plane setRect: 0 0 640 480)
		(= x (- 0 ((gCurRoom plane:) left:)))
		(= y (- 0 ((gCurRoom plane:) top:)))
		(super init: &rest)
		(if (gUser hotCursor:)
			(= oldHotList ((gUser hotCursor:) hotObjList:))
			((gUser hotCursor:) hotObjList: (Set new:))
		)
		(if (not gPanels)
			(= gPanels (List new:))
		)
		(Load rsVIEW 13088)
		(Load rsVIEW 13087)
		(Load rsVIEW 9940)
		(Load rsPIC 13088)
		(Load rsPIC 13087)
		(gPanels addToFront: self)
		(self showTapes:)
	)

	(method (showTapes &tmp temp0 temp1 temp2)
		(cond
			((== picture 13089)
				(if (and local2 (local2 size:))
					(local2 eachElementDo: #dispose)
				)
				(if (and local3 (local3 size:))
					(local3 eachElementDo: #dispose)
				)
				(advanceSpliceText dispose:)
				(backSpliceText dispose:)
				(deleteSpliceItems dispose:)
				(transfer dispose:)
				(spliceExit dispose:)
			)
			((and local1 (local1 size:))
				(local1 eachElementDo: #dispose)
			)
		)
		(= picture 13087)
		(plane drawPic: picture)
		(messageSound stop:)
		(if (not tapes)
			(= tapes
				(IDArray
					with:
						(IntArray
							with:
								(IsFlag 101) ; "Himself" in rm2316
								(IsFlag 102) ; "Himself" in rm2316
								(IsFlag 104) ; "Wolves" in rm2316
								(IsFlag 105) ; "Missing Wolves" in rm2316
								(IsFlag 106) ; "How did the wolves get out?" in rm2316
								(IsFlag 107) ; "What do you think about the wolves killing people?" in rm2316
								(IsFlag 108) ; "What did the wolves look like?" in rm2316
								(IsFlag 103) ; "Doktor Klingmann" in rm2316
						)
						(IntArray
							with:
								(IsFlag 109) ; "Himself" in rm4220
								(IsFlag 110) ; "Munich" in rm4220
								(IsFlag 111) ; "Ritter Estate" in rm4220
								(IsFlag 112) ; "Mutilation Killings" in rm4220
								(IsFlag 113)
								(IsFlag 114) ; "Jagdschein" in rm4220
								(IsFlag 116) ; "Die K\94niglich-Bayrische Hofjagdloge" in rm4220
								(IsFlag 115) ; "Ritter Family Papers" in rm4220
								(IsFlag 241) ; "Ludwig II" in rm4220b
								(IsFlag 242) ; "Ludwig II" in rm4220b
								(IsFlag 243) ; "The Black Wolf" in rm4220b
								(IsFlag 245) ; "Missing Persons" in rm4220b
								(IsFlag 321) ; "Missing Persons" in rm4220b
								(IsFlag 322) ; "Getting Cash" in rm4220b
						)
						(IntArray
							with:
								(IsFlag 117) ; "Himself" in rm2420
								(IsFlag 118) ; "Himself" in rm2420
								(IsFlag 119) ; "Research" in rm2420
								(IsFlag 120) ; "Wolves" in rm2420
								(IsFlag 121) ; "Missing Wolves" in rm2420
								(IsFlag 123) ; "How long have the wolves been missing?" in rm2420
								(IsFlag 124) ; "Do you think the Zoo wolves are responsible for the mutilation killings?" in rm2420
								(IsFlag 125) ; "Why would the wolves kill humans?" in rm2420
								(IsFlag 126) ; "How does a wolf choose its victims?" in rm2420
						)
						(IntArray
							with:
								(or
									(IsFlag 201) ; "Himself" in rm3302
									(IsFlag 204) ; "Where are you from?" in rm3302
									(IsFlag 208) ; "What brought you to Munich?" in rm3302
									(IsFlag 205) ; "Tell me about your family." in rm3302
								)
								(IsFlag 204) ; "Where are you from?" in rm3302
								(IsFlag 208) ; "What brought you to Munich?" in rm3302
								(IsFlag 205) ; "Tell me about your family." in rm3302
								(IsFlag 202) ; "The Club" in rm3302
								(IsFlag 206) ; "Club Members" in rm3302
								(IsFlag 207) ; "Club Members" in rm3302
								(IsFlag 209) ; "Club Basement" in rm3302
								(IsFlag 210) ; "Club Philosophy" in rm3302
								(IsFlag 211) ; "Club Philosophy" in rm3302
								(IsFlag 212) ; "Club Philosophy" in rm3302
								(IsFlag 213) ; "The Black Wolf" in rm3302
						)
						(IntArray
							with:
								(IsFlag 214) ; "Himself" in rm3210
								(or
									(IsFlag 358) ; "Downtown Killing" in rm3210
									(IsFlag 228) ; "Have any theories about why the killer struck downtown this time?" in rm3210
									(IsFlag 25) ; "Tell me about the latest victim." in rm3210
									(IsFlag 215) ; "Other Victims" in rm3210
									(IsFlag 220) ; "How many victims have there been?" in rm3210
									(IsFlag 221) ; "When were the other victims killed?" in rm3210
									(IsFlag 222) ; "Is there a pattern to the locations of the killings?" in rm3210
									(IsFlag 223)
								)
								(IsFlag 228) ; "Have any theories about why the killer struck downtown this time?" in rm3210
								(IsFlag 25) ; "Tell me about the latest victim." in rm3210
								(IsFlag 215) ; "Other Victims" in rm3210
								(IsFlag 220) ; "How many victims have there been?" in rm3210
								(IsFlag 221) ; "When were the other victims killed?" in rm3210
								(IsFlag 222) ; "Is there a pattern to the locations of the killings?" in rm3210
								(IsFlag 223)
								(IsFlag 217) ; "The Killer" in rm3210
								(IsFlag 224) ; "What does forensics say about the killer?" in rm3210
								(IsFlag 225) ; "Have you considered werewolfry?" in rm3210
								(IsFlag 226) ; "The killer isn't one of the Zoo wolves, is it?" in rm3210
								(IsFlag 227) ; "You believe only one animal is responsible?" in rm3210
								(IsFlag 218) ; "The Black Wolf" in rm3210
								(IsFlag 219) ; "Missing Persons Cases" in rm3210
								(IsFlag 354) ; "Case Status" in rm3210
								(IsFlag 355) ; "Case Status" in rm3210
								(IsFlag 356) ; "Grossberg's Account Book" in rm3210
								(IsFlag 357) ; "Grossberg's Account Book" in rm3210
						)
						(IntArray
							with:
								(or
									(IsFlag 234) ; "The Club" in rm4320
									(IsFlag 236) ; "How long has the club been around?" in rm4320
									(IsFlag 237) ; "What happened in 1970?" in rm4320
									(IsFlag 239) ; "How many members are there?" in rm4320
									(IsFlag 238) ; "How often do the club members go hunting?" in rm4320
									(IsFlag 235) ; "Club Members" in rm4320
								)
								(IsFlag 236) ; "How long has the club been around?" in rm4320
								(IsFlag 237) ; "What happened in 1970?" in rm4320
								(IsFlag 239) ; "How many members are there?" in rm4320
								(IsFlag 238) ; "How often do the club members go hunting?" in rm4320
								(IsFlag 235) ; "Club Members" in rm4320
								(IsFlag 240) ; "The Black Wolf" in rm4320
						)
						(IntArray
							with:
								(IsFlag 246) ; "Himself" in rm4420
								(IsFlag 247) ; "Hunting" in rm4420
								(IsFlag 248) ; "Hunting" in rm4420
								(IsFlag 249) ; "Club Members" in rm4420
								(IsFlag 250) ; "The Club" in rm4420
								(IsFlag 251) ; "The Club" in rm4420
								(IsFlag 252) ; "Trophies in basement" in rm4420
								(IsFlag 253) ; "The Black Wolf" in rm4420
						)
						(IntArray
							with:
								(IsFlag 254) ; "Himself" in rm4421
								(IsFlag 255) ; "Himself" in rm4421
								(IsFlag 256) ; "The Club" in rm4421
								(IsFlag 257) ; "Club Members" in rm4421
								(IsFlag 258) ; "Club Members" in rm4421
								(IsFlag 259) ; "Von Zell" in rm4421
								(IsFlag 260) ; "Von Zell" in rm4421
								(IsFlag 261) ; "Von Zell" in rm4421
								(IsFlag 262) ; "The Black Wolf" in rm4421
						)
						(IntArray
							with:
								(IsFlag 329) ; "The Club" in rm5211
								(IsFlag 330) ; "Klingmann" in rm5211
								(IsFlag 331) ; "Preiss" in rm5211
								(IsFlag 332) ; "Preiss" in rm5211
								(IsFlag 333) ; "The Lodge" in rm5211
								(IsFlag 334) ; "The Lodge" in rm5211
								(IsFlag 335) ; "The Black Wolf" in rm5211
						)
						(IntArray
							with:
								(IsFlag 323) ; "What kind of exotics did you get for Grossberg?" in rm2620
								(IsFlag 324) ; "Did Grossberg harvest the furs or did you?" in rm2620
								(IsFlag 325) ; "Did you talk to Grossberg before he died?" in rm2620
								(IsFlag 326) ; "How did the 'export' go?" in rm2620
								(IsFlag 327) ; "Where did the exports end up?" in rm2620
								(IsFlag 328) ; "Can I see where you kept the wolves?" in rm2620
						)
						(IntArray
							with:
								(IsFlag 342) ; "The Club" in hlVonAignerTub
								(IsFlag 344) ; "Grossberg" in hlVonAignerTub
								(IsFlag 346) ; "Were you the Club's main contact with Grossberg?" in hlVonAignerTub
								(IsFlag 347) ; "What does von Zell have to do with Grossberg?" in hlVonAignerTub
								(IsFlag 348) ; "Why did von Zell want Grossberg's name?" in hlVonAignerTub
								(IsFlag 349) ; "Would your cooperation have anything to do with the money you owe von Zell?" in hlVonAignerTub
								(IsFlag 345) ; "The Black Wolf" in hlVonAignerTub
								(IsFlag 350) ; "The Black Wolf" in hlVonAignerTub
						)
				)
			)
			(if 0
				(SetFlag 117) ; enable "Himself" in rm2420
				(SetFlag 118) ; enable "Research" in rm2420
				(SetFlag 119)
				(SetFlag 120)
				(SetFlag 121) ; enable "Missing Wolves" in rm2420
				(SetFlag 123)
				(SetFlag 124)
				(SetFlag 125) ; enable "How does a wolf choose its victims?" in rm2420
				(SetFlag 126)
				(for ((= temp0 0)) (< temp0 (tapes size:)) ((++ temp0))
					(= temp2 (tapes at: temp0))
					(for ((= temp1 0)) (< temp1 (temp2 size:)) ((++ temp1))
						(temp2 at: temp1 1)
					)
				)
			)
		)
		(if (not messages)
			(= messages
				(IDArray
					with:
						(IntArray
							with:
								50340
								50350
								50360
								50370
								50380
								50390
								50400
								50410
						)
						(IntArray
							with:
								50740
								50750
								50760
								50780
								50790
								50800
								50840
								50810
								52460
								52470
								52480
								52490
								55580
								55590
						)
						(IntArray
							with:
								50500
								50510
								50520
								50530
								50540
								50550
								50560
								50570
								50580
						)
						(IntArray
							with:
								-1
								53980
								53990
								54010
								54020
								54040
								54050
								54060
								54070
								54080
								54090
								54100
						)
						(IntArray
							with:
								53500
								-1
								53630
								53640
								53510
								53520
								53530
								53550
								53560
								-1
								53570
								53590
								53600
								53610
								53660
								53670
								55730
								55740
								55750
								55760
						)
						(IntArray
							with: 52640 52650 52660 52670 52680 52690 52700
						)
						(IntArray
							with:
								52800
								52810
								52820
								52830
								52850
								52860
								52870
								52880
						)
						(IntArray
							with:
								52920
								52930
								52950
								52970
								53010
								52980
								52990
								53000
								53040
						)
						(IntArray
							with: 56140 56150 56160 56170 56200 56210 56220
						)
						(IntArray with: 55940 55950 55970 55980 55990 56000)
						(IntArray
							with:
								56560
								56570
								56580
								56590
								56600
								56610
								56640
								56650
						)
				)
			)
		)
		(if (or (not local0) (not (local0 size:)))
			(= tapeX 32)
			(= tapeY 30)
			(if (and local1 (local1 size:))
				(local1 eachElementDo: #dispose)
			)
			(if (not local0)
				(= local0 (Cast new:))
				(plane addCast: local0)
			)
			(for ((= temp0 0)) (< temp0 (tapes size:)) ((++ temp0))
				(= temp2 (tapes at: temp0))
				(for ((= temp1 0)) (< temp1 (temp2 size:)) ((++ temp1))
					(if (temp2 at: temp1)
						(self addTape: temp0)
						(break)
					)
				)
			)
			(for ((= temp0 (local0 size:))) (< temp0 12) ((++ temp0))
				(self addTape: -1)
			)
			(loadA init:)
			(playTape init:)
			(loadB init:)
			(spliceTape init:)
			(tapeExit init:)
			(gGame handsOn:)
		else
			(local0 eachElementDo: #show)
		)
	)

	(method (addTape param1)
		(tapeButton new: param1 tapeX tapeY)
		(+= tapeX 164)
		(if (> tapeX 500)
			(= tapeX 32)
			(+= tapeY 108)
		)
	)

	(method (handleEvent event)
		(event localize: plane)
		(if (not (event type:))
			(if (gUser hotCursor:)
				((gUser hotCursor:) handleEvent: event)
			)
			(if (and (== picture 13089) local3)
				(local3 handleEvent: event)
			)
			(event claimed: 1)
			(return)
		)
		(if (& (event type:) $000a) ; evKEYUP | evMOUSERELEASE
			(event claimed: 1)
			(return)
		)
		(event type: (| (event type:) evVERB))
		(if plane
			(event
				claimed: ((plane casts:) eachElementDo: #handleEvent event)
			)
		)
		(if (not (event claimed:))
			(gFeatures handleEvent: event)
		)
		(if local4
			(messageSound stop:)
			(= local4 0)
			(gCurRoom setInset: 0)
		)
		(event claimed: 1)
	)

	(method (drawInset)
		(if (!= picture -1)
			(plane drawPic: picture)
		)
		(plane posn: x y priority: (+ (GetHighPlanePri) 1))
		(UpdatePlane plane)
	)

	(method (showTopics param1 &tmp temp0 temp1 temp2)
		(local0 eachElementDo: #hide)
		(= picture 13088)
		(plane drawPic: picture)
		(= topicX 74)
		(= topicY 131)
		(if (not local1)
			(= local1 (Cast new:))
			(plane addCast: local1)
		)
		(backup init:)
		(stopPlayback init:)
		(topicExit init:)
		(topicHeader init: param1)
		(= temp1 (tapes at: param1))
		(= temp2 (temp1 size:))
		(for ((= temp0 0)) (< temp0 temp2) ((++ temp0))
			(if (temp1 at: temp0)
				(self addTopic: param1 temp0)
			)
		)
	)

	(method (cue)
		(self showTopics: curTape)
	)

	(method (addTopic param1 param2)
		(topicButton new: param1 param2 topicX topicY)
		(+= topicY 20)
		(if (> topicY 350)
			(= topicY 131)
			(+= topicX 200)
		)
	)

	(method (dispose &tmp temp0)
		(messageSound stop:)
		(if oldHotList
			(((gUser hotCursor:) hotObjList:) release: dispose:)
			((gUser hotCursor:) hotObjList: oldHotList)
			(= oldHotList 0)
		)
		(if tapes
			(for ((= temp0 0)) (< temp0 (tapes size:)) ((++ temp0))
				((tapes at: temp0) dispose:)
			)
			(tapes dispose:)
			(= tapes 0)
		)
		(if spliceArray
			(for ((= temp0 0)) (< temp0 (spliceArray size:)) ((++ temp0))
				((spliceArray at: temp0) dispose:)
			)
			(spliceArray dispose:)
			(= spliceArray 0)
		)
		(if messages
			(for ((= temp0 0)) (< temp0 (messages size:)) ((++ temp0))
				((messages at: temp0) dispose:)
			)
			(messages dispose:)
			(= messages 0)
		)
		(gPanels delete: self)
		(super dispose: &rest)
		(= local4 0)
		(= local5 0)
		(= local6 0)
		(= local7 0)
		(= local3 0)
		(= local2 0)
		(= local1 0)
		(= local0 0)
		(if global249
			(Palette 1 global249) ; PalLoad
		)
	)

	(method (playMessage param1 param2)
		(= curTape param1)
		(messageSound stop:)
		(messageSound
			number: ((messages at: param1) at: param2)
			setLoop: 1
			play:
		)
		(return 1)
	)
)

(instance messageSound of Sound
	(properties)

	(method (play)
		(if (not (ResCheck 140 number)) ; WAVE
			(Prints {DEBUG! That message wave file does not exist!})
			(return)
		)
		(super play: &rest)
	)
)

(class topicButton of View
	(properties
		myTape 0
		myTopic 0
		mySoundNum 0
	)

	(method (new param1 param2 param3 param4 &tmp temp0 temp1)
		(= temp0 (super new:))
		(if (>= param2 (((Walkman messages:) at: param1) size:))
			(= temp1 -1)
		else
			(= temp1 (((Walkman messages:) at: param1) at: param2))
		)
		(temp0
			view: 13087
			loop: param1
			cel: (+ param2 1)
			myTape: param1
			myTopic: param2
			mySoundNum: temp1
			x: param3
			y: param4
			init: local1
			signal: (& (temp0 signal:) $efff)
		)
		(temp0 scaleX: 90 scaleSignal: 1)
		(UpdateScreenItem temp0)
	)

	(method (handleEvent event)
		(if (and (not (event claimed:)) (self onMe: event))
			(super handleEvent: event)
			(event claimed: 1)
			(return)
		else
			(return 0)
		)
	)

	(method (doVerb)
		(Walkman playMessage: myTape myTopic)
	)

	(method (dispose)
		(local1 delete: self)
		(super dispose:)
	)

	(method (onMe)
		(if (!= mySoundNum -1)
			(return (super onMe: &rest))
		else
			(return 0)
		)
	)
)

(class tapeButton of View
	(properties
		tapeID 0
	)

	(method (onMe param1)
		(if
			(and
				(!= local6 self)
				(!= local7 self)
				(self isNotHidden:)
				(<= (param1 x:) (+ x 150))
				(<= (param1 y:) (+ y 100))
				(>= (param1 x:) x)
				(>= (param1 y:) y)
			)
			(return 1)
		else
			(return 0)
		)
	)

	(method (new param1 param2 param3 &tmp temp0)
		(= temp0 (super new:))
		(if (< param1 0)
			(temp0
				view: 13086
				loop: 3
				cel: 0
				tapeID: param1
				x: param2
				y: param3
				init: local0
			)
		else
			(temp0
				view: 13086
				cel: param1
				tapeID: param1
				x: param2
				y: param3
				init: local0
			)
		)
	)

	(method (handleEvent event)
		(if (and (not (event claimed:)) (self onMe: event))
			(super handleEvent: event)
			(event claimed: 1)
			(return)
		else
			(return 0)
		)
	)

	(method (doVerb)
		(= local5 self)
		(tapeHilite init: self)
	)

	(method (dispose)
		(local0 delete: self)
		(super dispose:)
	)
)

(class spliceText of View
	(properties
		spliceIndex -1
		hilighted 0
	)

	(method (handleEvent event)
		(cond
			((event type:)
				(super handleEvent: event &rest)
				(return)
			)
			((self onMe: event)
				(if (not hilighted)
					(= hilighted 1)
					(++ loop)
					(UpdateScreenItem self)
				)
			)
			(hilighted
				(= hilighted 0)
				(-- loop)
				(UpdateScreenItem self)
			)
		)
	)

	(method (doVerb)
		(Walkman addSpliceItem: (& loop $fffe) cel spliceIndex)
	)

	(method (new param1 param2 param3 param4 param5 &tmp temp0)
		(= temp0 (Clone self))
		(temp0
			view: 13088
			loop: param3
			cel: param4
			spliceIndex: param5
			x: param1
			y: param2
			init: local3
			signal: (& (temp0 signal:) $efff)
		)
		(temp0 scaleX: 90 scaleSignal: 1)
		(UpdateScreenItem temp0)
		(return temp0)
	)

	(method (dispose)
		(local3 delete: self)
		(super dispose:)
	)
)

(instance spliceItem of spliceText
	(properties)

	(method (new param1 param2 param3 param4 param5 &tmp temp0)
		(= temp0 (Clone self))
		(temp0
			view: 13088
			loop: param3
			cel: param4
			spliceIndex: param5
			x: param1
			y: param2
			init: local2
		)
		(return temp0)
	)

	(method (onMe)
		(return 0)
	)

	(method (handleEvent)
		(return 0)
	)

	(method (dispose)
		(local2 delete: self)
		(super dispose:)
	)
)

(instance transfer of Prop
	(properties
		x 267
		y 321
		view 13088
		loop 34
		cel 2
	)

	(method (cue)
		(Walkman showTapes:)
	)

	(method (doVerb &tmp temp0 temp1)
		(if (== (local2 size:) 10)
			(= temp1 1)
			(for ((= temp0 0)) (< temp0 10) ((++ temp0))
				(if (!= temp0 ((local2 at: temp0) spliceIndex:))
					(= temp1 0)
				)
			)
			(if temp1
				(hintButton dispose:)
				(gGame changeScore: 864)
				(gEgo get: 15) ; invSpliceTape
				(messageSound number: 50000 setLoop: 1 play: self)
			else
				(gMessager say: 0 0 13 0 0 91) ; "(TAPE RECORDER, TRY TO TRANSFER WRONG MSG, DRY)I DON'T think that's what I need."
			)
		else
			(gMessager say: 0 0 13 0 0 91) ; "(TAPE RECORDER, TRY TO TRANSFER WRONG MSG, DRY)I DON'T think that's what I need."
		)
	)
)

(instance spliceExit of View
	(properties
		x 388
		y 322
		view 13088
		loop 34
		cel 3
	)

	(method (doVerb)
		(hintButton dispose:)
		(Walkman showTapes:)
	)
)

(instance deleteSpliceItems of View
	(properties
		x 169
		y 322
		view 13088
		loop 34
		cel 1
	)

	(method (doVerb)
		(Walkman deleteSpliceItem:)
	)
)

(instance backSpliceText of View
	(properties
		x 67
		y 321
		view 13088
		loop 34
	)

	(method (doVerb)
		(Walkman showSpliceText: (- local8 1))
	)
)

(instance advanceSpliceText of View
	(properties
		x 517
		y 320
		view 13088
		loop 34
		cel 4
	)

	(method (doVerb)
		(Walkman showSpliceText: (+ local8 1))
	)
)

(instance loadA of View
	(properties
		x 561
		y 96
		view 13086
		loop 4
	)

	(method (init)
		(super init: local0)
	)

	(method (dispose)
		(local0 delete: self)
		(super dispose:)
	)

	(method (doVerb)
		(cond
			(local5
				(if (>= (local5 tapeID:) 0)
					(tapeHilite dispose:)
					(local5 loop: 1)
					(UpdateScreenItem local5)
					(if local6
						(local6 loop: 0 cel: (local6 tapeID:))
						(UpdateScreenItem local6)
					)
					(= local6 local5)
					(= local5 0)
				else
					(gMessager say: 0 0 1 0 0 91) ; "(TAPE RECORDER CONT'D)There's no point in listenin' to a blank tape."
				)
			)
			(local6
				(gMessager say: 0 0 2 0 0 91) ; "(TAPE RECORDER INTERFACE THIS AND FOLLOWING)I already have a tape loaded in deck A."
			)
			(else
				(gMessager say: 0 0 3 0 0 91) ; "(TAPE RECORDER CONT'D, HIT LOAD WITH NO TAPE SELECTED)I need to pick a tape first."
			)
		)
	)
)

(instance playTape of View
	(properties
		x 561
		y 168
		view 13086
		loop 4
		cel 1
	)

	(method (init)
		(super init: local0)
	)

	(method (dispose)
		(local0 delete: self)
		(super dispose:)
	)

	(method (doVerb)
		(if local6
			(Walkman showTopics: (local6 tapeID:))
		else
			(gMessager say: 0 0 4 0 0 91) ; "(TAPE RECORDER CONT'D)I have to load a tape first."
		)
	)
)

(instance loadB of View
	(properties
		x 561
		y 238
		view 13086
		loop 4
		cel 2
	)

	(method (init)
		(super init: local0)
	)

	(method (dispose)
		(local0 delete: self)
		(super dispose:)
	)

	(method (doVerb)
		(cond
			(local7
				(gMessager say: 0 0 5 0 0 91) ; "(TAPE RECORDER CONT'D)There's already a blank tape in deck B."
			)
			(local5
				(if (>= (local5 tapeID:) 0)
					(gMessager say: 0 0 6 0 0 91) ; "(TAPE RECORDER CONT'D)I don't want to overwrite what's on that tape."
				else
					(tapeHilite dispose:)
					(= local7 local5)
					(local5 loop: 1)
					(local5 cel: (local5 lastCel:))
					(UpdateScreenItem local5)
					(= local5 0)
				)
			)
			(else
				(gMessager say: 0 0 3 0 0 91) ; "(TAPE RECORDER CONT'D, HIT LOAD WITH NO TAPE SELECTED)I need to pick a tape first."
			)
		)
	)
)

(instance spliceTape of View
	(properties
		x 559
		y 307
		view 13086
		loop 4
		cel 3
	)

	(method (init)
		(= local15 -999)
		(super init: local0)
	)

	(method (dispose)
		(local0 delete: self)
		(super dispose:)
	)

	(method (doVerb)
		(if local6
			(if local7
				(if (== (local6 tapeID:) 2)
					(cond
						((IsFlag 864)
							(gMessager say: 0 0 7 0 0 91) ; "(TAPE RECORDER CONT'D)I've done enough splicin' off Klingmann's tape."
						)
						(
							(and
								(IsFlag 117) ; "Himself" in rm2420
								(IsFlag 118) ; "Himself" in rm2420
								(IsFlag 119) ; "Research" in rm2420
								(IsFlag 120) ; "Wolves" in rm2420
								(IsFlag 121) ; "Missing Wolves" in rm2420
								(IsFlag 123) ; "How long have the wolves been missing?" in rm2420
								(IsFlag 124) ; "Do you think the Zoo wolves are responsible for the mutilation killings?" in rm2420
								(IsFlag 125) ; "Why would the wolves kill humans?" in rm2420
								(IsFlag 126) ; "How does a wolf choose its victims?" in rm2420
							)
							(if
								(not
									(OneOf
										gCurRoomNum
										210 ; farmIntRm
										220 ; farmFldRm
										2103 ; farmIntRm2
										2145 ; farmIntRm3
										2114
										2140
										2142
										2143
										2202
										2211
										2212
										2213
										2241
										2242
										2244
									)
								)
								(gMessager say: 0 0 32 0 0 91) ; "(TAPE RECORDER, TRY TO DO SPLICE ANYWHERE BUT FARM)Not a bad idea, but I should go somewhere more private first."
							else
								(Walkman splice:)
							)
						)
						(else
							(gMessager say: 0 0 14 0 0 91) ; "(TAPE RECORDER CONT'D, TRY TO MAKE KLINGMANN SPLICE BUT DON'T HAVE ALL DIALGOUE YET)There's an idea. But I don't think I have quite enough source material from Klingmann yet."
						)
					)
				else
					(gMessager say: 0 0 8 0 0 91) ; "(TAPE RECORDER CONT'D, TRY TO MAKE SPLICE OFF TAPE OTHER THAN KLINGMANN'S)I can't see any reason to make a splice off THAT tape."
				)
			else
				(gMessager say: 0 0 9 0 0 91) ; "(TAPE RECORDER CONT'D, THOUGHTFUL)If I'm gonna do a splice, I'll need TWO tapes loaded."
			)
		else
			(gMessager say: 0 0 10 0 0 91) ; "(TAPE RECORDER CONT'D, THOUGHTFUL)If I'm gonna do a splice, I'll need a source tape in deck A."
		)
	)
)

(instance tapeExit of View
	(properties
		x 561
		y 377
		view 13086
		loop 4
		cel 4
	)

	(method (init)
		(super init: local0)
	)

	(method (dispose)
		(local0 delete: self)
		(super dispose:)
	)

	(method (doVerb)
		(= local4 1)
	)
)

(instance backup of View
	(properties
		x 559
		y 143
		view 13087
		loop 11
	)

	(method (init)
		(super init: local1)
	)

	(method (dispose)
		(local1 delete: self)
		(super dispose:)
	)

	(method (doVerb)
		(Walkman showTapes:)
	)
)

(instance stopPlayback of View
	(properties
		x 559
		y 215
		view 13087
		loop 11
		cel 1
	)

	(method (init)
		(super init: local1)
	)

	(method (dispose)
		(local1 delete: self)
		(super dispose:)
	)

	(method (doVerb)
		(messageSound stop:)
	)
)

(instance topicExit of View
	(properties
		x 559
		y 279
		view 13087
		loop 11
		cel 2
	)

	(method (init)
		(super init: local1)
	)

	(method (dispose)
		(local1 delete: self)
		(super dispose:)
	)

	(method (doVerb)
		(= local4 1)
	)
)

(instance tapeHilite of View
	(properties
		view 13086
		loop 2
	)

	(method (init param1)
		(self x: (param1 x:) y: (+ (param1 y:) 1))
		(if (local0 contains: self)
			(UpdateScreenItem self)
		else
			(super init: local0)
		)
	)

	(method (onMe)
		(return 0)
	)

	(method (dispose)
		(local0 delete: self)
		(super dispose:)
	)
)

(instance topicHeader of View
	(properties
		x 45
		y 87
		view 13087
	)

	(method (init param1)
		(= loop param1)
		(super init: local1)
	)

	(method (onMe)
		(return 0)
	)
)

(instance hintButton of View
	(properties
		x 258
		y 40
		view 13071
		loop 35
	)

	(method (doVerb)
		(cond
			((not (local2 size:))
				(gMessager say: 0 0 15 0 0 91) ; "(SPLICE TAPE HINTS)First things first--I need to address my audience."
			)
			((< local15 0)
				(cond
					((localproc_0 0 3)
						(gMessager say: 0 0 16 0 0 91) ; "(SPLICE TAPE HINTS)I don't think Klingmann would believe a splice message from himself."
					)
					((localproc_0 0 9)
						(gMessager say: 0 0 17 0 0 91) ; "(SPLICE TAPE HINTS)I'm not sendin' the splice to myself."
					)
					((localproc_0 0 11)
						(gMessager say: 0 0 18 0 0 91) ; "(SPLICE TAPE HINTS)I'm not sure who GREG is. I wouldn't know how to get in touch with him if I did."
					)
					(else
						(gMessager say: 0 0 15 0 0 91) ; "(SPLICE TAPE HINTS)First things first--I need to address my audience."
					)
				)
			)
			((< local15 4)
				(cond
					(
						(and
							(not (localproc_0 1 3))
							(not (localproc_0 2 3))
							(not (localproc_0 3 3))
							(not (localproc_0 4 3))
						)
						(gMessager say: 0 0 19 0 0 91) ; "(SPLICE TAPE HINTS, SLY)I think I'll need to voice some authority here."
					)
					(
						(or
							(localproc_0 1 9)
							(localproc_0 2 9)
							(localproc_0 3 9)
							(localproc_0 4 9)
						)
						(gMessager say: 0 0 20 0 0 91) ; "(SPLICE TAPE HINTS, SLY)*I* have much authority at the zoo. I'll have to try somethin' else."
					)
					(
						(or
							(== local15 3)
							(and
								(localproc_0 2 1)
								(localproc_0 3 2)
								(localproc_0 4 3)
							)
						)
						(gMessager say: 0 0 22 0 0 91) ; "(SPLICE TAPE HINTS, SLY)Close. But I need to work on the syntax."
					)
					(
						(or
							(and (localproc_0 1 2) (localproc_0 2 3))
							(and (localproc_0 2 2) (localproc_0 3 3))
							(and (localproc_0 3 2) (localproc_0 4 3))
							(and
								(localproc_0 1 3)
								(localproc_0 2 3)
								(localproc_0 3 3)
								(localproc_0 4 3)
							)
						)
						(gMessager say: 0 0 21 0 0 91) ; "(SPLICE TAPE HINTS, SLY)It's gettin' there, but the man IS a bit uptight about formal address."
					)
					(else
						(gMessager say: 0 0 19 0 0 91) ; "(SPLICE TAPE HINTS, SLY)I think I'll need to voice some authority here."
					)
				)
			)
			((< local15 7)
				(cond
					(
						(and
							(not (localproc_0 5 7))
							(not (localproc_0 6 7))
							(not (localproc_0 7 7))
						)
						(gMessager say: 0 0 24 0 0 91) ; "(SPLICE TAPE HINTS, SLY)Now it's time to shoot for the grand prize."
					)
					(
						(and
							(or
								(localproc_0 5 7)
								(localproc_0 6 7)
								(localproc_0 7 7)
							)
							(not (localproc_0 5 5))
							(not (localproc_0 6 5))
							(not (localproc_0 7 5))
						)
						(gMessager say: 0 0 25 0 0 91) ; "(SPLICE TAPE HINTS)That's a start, but I need to be more specific about what I want."
					)
					(
						(and
							(or
								(localproc_0 5 7)
								(localproc_0 6 7)
								(localproc_0 7 7)
							)
							(or
								(localproc_0 5 5)
								(localproc_0 6 5)
								(localproc_0 7 5)
							)
						)
						(gMessager say: 0 0 26 0 0 91) ; "(SPLICE TAPE HINTS)That last part is close, but I need to reword it somehow."
					)
					(else
						(gMessager say: 0 0 24 0 0 91) ; "(SPLICE TAPE HINTS, SLY)Now it's time to shoot for the grand prize."
					)
				)
			)
			((< local15 9)
				(cond
					((and (not (localproc_0 8 9)) (not (localproc_0 9 9)))
						(gMessager say: 0 0 27 0 0 91) ; "(SPLICE TAPE HINTS)Okay. The only missin'is the intented recipient of this fine hospitality."
					)
					((or (localproc_0 8 9) (localproc_0 9 9))
						(gMessager say: 0 0 28 0 0 91) ; "(SPLICE TAPE HINTS, SYNTAX OFF IN SPLICE MSG)It's almost there, but the wordin' leave somethin' to be desired."
					)
					(else
						(gMessager say: 0 0 27 0 0 91) ; "(SPLICE TAPE HINTS)Okay. The only missin'is the intented recipient of this fine hospitality."
					)
				)
			)
		)
	)
)

