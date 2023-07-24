;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 425)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use PuzzleIcon)
(use Interface)
(use rm420)
(use listArray)
(use Feature)
(use LoadMany)
(use Window)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	proc425_0 0
	proc425_1 1
	proc425_2 2
)

(local
	[local0 274] = [216 2 304 2 7 3 57 3 94 3 253 3 308 3 71 4 233 4 273 4 76 6 210 6 22 8 293 8 240 9 28 10 222 11 72 12 32 13 246 13 250 13 283 14 253 15 294 15 85 16 194 17 256 18 104 19 56 20 229 20 255 21 82 22 95 23 27 25 77 25 214 25 279 25 59 26 249 26 64 27 69 27 240 27 284 29 74 30 70 32 216 33 54 34 291 34 189 35 67 36 215 36 36 37 100 37 121 37 225 37 248 37 252 37 134 38 230 38 260 38 284 38 105 39 173 39 179 39 246 39 87 40 199 40 244 41 40 42 49 42 104 43 80 44 188 44 250 44 78 45 90 45 178 45 207 45 67 47 210 47 138 48 275 49 153 50 129 51 249 52 89 53 181 53 72 54 146 55 169 55 211 55 132 57 116 58 152 58 224 58 274 58 51 62 66 62 139 62 151 63 120 64 187 64 232 64 103 65 94 66 199 68 109 70 195 71 64 72 125 72 202 72 71 74 233 74 198 75 217 75 137 76 242 78 73 80 121 80 134 80 156 82 195 84 136 88 163 88 184 90 124 91 138 93 97 94 115 94 164 95 186 95 196 97 117 98 152 103 156 103 -100 -100 83 70]
	[local274 9] = [69 46 39 40 34 31 43 44 49]
	[local283 16] = [69 46 46 39 39 40 40 43 40 44 40 34 44 49 34 31]
	[local299 9]
	[local308 15] = [136 104 103 92 100 106 118 115 119 98 93 99 83 91 80]
	[local323 32] = [136 104 104 103 103 106 103 92 106 118 106 100 92 100 92 83 83 91 80 91 100 98 98 93 98 99 83 80 118 115 118 119]
	[local355 15]
	[local370 7] = [101 107 105 110 113 121 114]
	[local377 14] = [101 107 107 105 107 113 105 110 113 110 113 121 110 114]
	[local391 7]
	[local398 18] = [45 50 54 58 84 59 41 38 30 26 22 20 19 67 64 55 56 73]
	[local416 40] = [45 50 45 54 50 54 58 41 58 84 84 59 41 38 38 30 30 26 26 22 22 20 20 19 54 58 41 59 67 64 64 55 55 56 56 59 55 73 73 84]
	[local456 18]
	local474
	local475
	local476
	local477
	local478
	local479
	local480
	local481
	[local482 4] = [51 53 50 52]
	local486
)

(procedure (localproc_0 &tmp temp0 temp1)
	(for ((= temp0 0)) (<= temp0 136) ((++ temp0))
		(= temp1 (s new:))
		(temp1 number: temp0)
		(starSet add: temp1)
	)
)

(procedure (localproc_1 &tmp temp0)
	(for ((= temp0 0)) (< temp0 (consSet size:)) ((++ temp0))
		(if (== ((consSet at: temp0) done:) 0)
			(return 0)
		)
	)
	(return 1)
)

(procedure (localproc_2 param1 param2 param3 &tmp temp0)
	(for ((= temp0 param1)) (< temp0 param2) ((++ temp0))
		((starSet at: temp0) size: [param3 (- temp0 param1)])
	)
)

(procedure (localproc_3 &tmp temp0 temp1 temp2 temp3)
	(= temp3 (GetPort))
	(SetPort 0)
	(= temp2 (consSet at: global171))
	(for ((= temp0 0)) (<= temp0 136) ((++ temp0))
		(= temp1 (starSet at: temp0))
		(if (temp1 status:)
			(if (temp2 onMe: temp1)
				(temp2 upDate: temp1)
			)
			(temp1 status: 0)
			(proc5_15 starOff temp1)
		)
	)
	(temp2 refreshStars:)
	(SetPort temp3)
	(temp2 starCnt: 0)
)

(procedure (localproc_4 &tmp temp0 temp1 temp2 temp3 [temp4 100])
	(Format @temp4 425 5 ((consSet at: global171) name:)) ; "Please find %s."
	(= temp0 (GetPort))
	(SetPort 0)
	(localproc_5)
	(= temp1 112)
	(= temp2 125)
	(= temp3 0)
	(proc5_19 0 300 0 @temp4)
	(= local475 (- temp1 5))
	(= local476 (+ temp1 5 global177))
	(= local477 (- temp2 5))
	(= local478 (+ temp2 3 global178))
	(= local474 (Graph grSAVE_BOX local477 local475 local478 local476 1))
	(Graph grFILL_BOX local477 local475 local478 local476 1 0 -1 -1)
	(Graph grUPDATE_BOX local477 local475 local478 local476 1)
	(Display
		@temp4
		dsCOORD
		temp1
		temp2
		dsWIDTH
		temp3
		dsFONT
		300
		dsCOLOR
		(proc0_1 29 14 global135)
	)
	(SetPort temp0)
)

(procedure (proc425_0 &tmp temp0)
	(gFeatures addToFront: eventFeature)
	(eventFeature init:)
	(Starselected posn: -1 -1 init:)
	(Perseus init:)
	(Ursa_Major init:)
	(Cancer init:)
	(Orion init:)
	(consSet add: Perseus Ursa_Major Cancer Orion)
	(localproc_0)
	(localproc_2
		0
		121
		1
		0
		0
		0
		0
		0
		0
		0
		0
		0
		1
		1
		2
		2
		0
		0
		0
		0
		2
		1
		1
		0
		1
		0
		0
		2
		1
		2
		0
		0
		1
		1
		0
		2
		1
		1
		0
		0
		1
		1
		1
		1
		0
		1
		1
		1
		1
		0
		0
		1
		1
		0
		0
		2
		1
		1
		1
		0
		1
		1
		0
		1
		0
		0
		1
		0
		0
		1
		0
		1
		0
		1
		0
		1
		0
		1
		0
		0
		0
		0
		1
		2
		0
		1
		1
		0
		0
		0
		0
		2
		0
		1
		1
		1
		0
		0
		1
		0
		1
		1
		1
		1
		0
		1
		1
		1
		1
		1
		0
		0
		1
		0
		2
		1
		1
		1
		2
		0
		1
		1
		2
	)
	(localproc_2 121 137 1 0 0 1 0 0 1 1 0 1 0 1 1 1 1 1)
	(proc425_1)
)

(procedure (proc425_1 &tmp temp0)
	(if (not (currentCon isActive:))
		(consSet eachElementDo: #getStarLim)
		(if (IsFlag 27)
			(for ((= temp0 0)) (< temp0 global171) ((++ temp0))
				((consSet at: temp0) done: 1)
			)
		)
		(if (!= global171 4)
			(proc5_9 425 2) ; "Find the stars on the sky dome which make up each of four constellations. Click on just those stars which form each constellation. If you think you have an incorrect star, click on it again to turn it off."
			(currentCon init:)
		)
	)
)

(procedure (proc425_2)
	(if (IsObject Starselected)
		(Starselected dispose:)
	)
	(if (IsObject curConsView)
		(curConsView dispose:)
	)
	(if (IsObject curConsViewSkel)
		(curConsViewSkel dispose:)
	)
	(if (IsObject currentCon)
		(currentCon dispose:)
	)
	(if (IsObject starSet)
		(starSet dispose:)
	)
	(if (IsObject consSet)
		(consSet dispose:)
	)
	(if (IsObject clickOnStarSound)
		(clickOnStarSound dispose:)
	)
	(if (IsObject wrongSound)
		(wrongSound dispose:)
	)
	(if (IsObject rewardSound)
		(rewardSound dispose:)
	)
)

(procedure (localproc_5 &tmp temp0)
	(if local474
		(= temp0 (GetPort))
		(SetPort 0)
		(Graph grRESTORE_BOX local474)
		(Graph grUPDATE_BOX local477 local475 local478 local476 1)
		(SetPort temp0)
		(= local474 0)
	)
)

(class s of Obj
	(properties
		number 0
		size 0
		status 0
	)

	(method (onMe param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(= temp0 (param1 x:))
		(= temp1 (param1 y:))
		(= temp6 [local0 (= temp8 (* number 2))])
		(= temp7 [local0 (+ temp8 1)])
		(= temp2 (- temp6 1))
		(= temp4 (- temp7 1))
		(= temp3 (+ temp6 1))
		(= temp5 (+ temp7 1))
		(return (and (<= temp2 temp0 temp3) (<= temp4 temp1 temp5)))
	)

	(method (handleEvent event &tmp [temp0 2])
		(if (self onMe: event)
			(clickOnStarSound play:)
			(if (== status 0)
				(self update: 1)
			else
				(self update: 0)
			)
			(event claimed: 1)
			(return 1)
		)
	)

	(method (update param1 &tmp temp0 temp1 temp2)
		(= temp2 (GetPort))
		(SetPort 0)
		(switch param1
			(1
				(proc5_15 starOn self)
				(= temp0 1)
				(= status 1)
			)
			(0
				(proc5_15 starOff self)
				(= temp0 -1)
				(= status 0)
			)
		)
		(= temp1 (consSet at: global171))
		(if (and (temp1 tallyStar: temp0 self) (temp1 onMe: self))
			(temp1 upDate: self)
		)
		(SetPort temp2)
	)

	(method (getX)
		(return [local0 (* 2 number)])
	)

	(method (getY)
		(return [local0 (+ (* 2 number) 1)])
	)
)

(instance clickOnStarSound of Sound
	(properties
		flags 1
		number 950
	)
)

(instance wrongSound of Sound
	(properties
		flags 1
		number 55
	)
)

(instance rewardSound of Sound
	(properties
		flags 1
		number 51
	)
)

(instance conWindow of SysWindow
	(properties
		top 105
		left 5
		bottom 190
		right 105
	)

	(method (open &tmp [temp0 101])
		(super open:)
		(curConsView
			setPri: 15
			setLoop: (+ 2 global171)
			cel: 1
			posn: 55 155
			init:
		)
		(if (or (== global114 0) (== global114 1))
			(curConsViewSkel
				setPri: 15
				setLoop: (+ 2 global171)
				cel: 0
				posn: 55 155
				init:
			)
		)
		(Animate (gCast elements:) 0)
		(localproc_4)
	)
)

(class constellation of Obj
	(properties
		starArray 0
		linkArray 0
		nodeStatusArray 0
		done 0
		starLimit 0
		starCnt 0
	)

	(method (init)
		(super init: &rest)
		(self getStarLim:)
	)

	(method (dispose)
		(starArray dispose:)
		(linkArray dispose:)
		(nodeStatusArray dispose:)
		(super dispose: &rest)
	)

	(method (getStarLim)
		(= starLimit
			(+
				(starArray size:)
				(switch global114
					(0 7)
					(1 4)
					(2 2)
				)
			)
		)
	)

	(method (onMe param1 &tmp temp0 temp1)
		(= temp1 (starArray size:))
		(for ((= temp0 0)) (< temp0 temp1) ((++ temp0))
			(if (== (param1 number:) (starArray query: temp0))
				(return 1)
			)
		)
		(return 0)
	)

	(method (getPos param1 &tmp temp0)
		(for ((= temp0 0)) (< temp0 (starArray size:)) ((++ temp0))
			(if (== param1 (starArray query: temp0))
				(return temp0)
			)
		)
		(return -1)
	)

	(method (resetNonMembers &tmp temp0 temp1 temp2)
		(for ((= temp2 0)) (<= temp2 136) ((++ temp2))
			(= temp1 (starSet at: temp2))
			(if (and (temp1 status:) (not (self onMe: temp1)))
				(temp1 update: 0)
			)
		)
	)

	(method (upDate param1 &tmp [temp0 100] temp100 temp101 temp102 temp103 temp104 temp105 temp106 temp107 temp108 temp109 temp110 temp111 temp112)
		(= temp107 0)
		(= temp110 (param1 number:))
		(= temp111 0)
		(= temp104 (self getPos: temp110))
		(= temp106 (- 1 (nodeStatusArray query: temp104)))
		(= temp100 (GetPort))
		(SetPort 0)
		(for ((= temp103 0)) (< temp103 (linkArray size:)) ((+= temp103 2))
			(cond
				((== temp110 (linkArray query: temp103))
					(= temp108 temp110)
					(= temp109 (linkArray query: (+ temp103 1)))
				)
				((== temp110 (linkArray query: (+ temp103 1)))
					(= temp108 temp110)
					(= temp109 (linkArray query: temp103))
				)
				(else
					(= temp108 0)
					(= temp109 0)
				)
			)
			(if temp108
				(= temp105 (self getPos: temp109))
				(nodeStatusArray assign: temp104 temp106)
				(cond
					((!= global114 2)
						(= temp101 (starSet at: temp108))
						(= temp102 (starSet at: temp109))
						(switch temp106
							(1
								(= temp111 1)
								(if (nodeStatusArray query: temp105)
									(proc5_16
										(temp101 getX:)
										(temp101 getY:)
										(temp102 getX:)
										(temp102 getY:)
										(proc0_1 9 4 global131)
									)
								)
							)
							(0
								(if (nodeStatusArray query: temp105)
									(proc5_17
										(temp101 getX:)
										(temp101 getY:)
										(temp102 getX:)
										(temp102 getY:)
									)
								)
							)
						)
					)
					((== temp106 1)
						(= temp111 1)
					)
				)
			)
		)
		(self refreshStars:)
		(if (and (== temp111 1) (self checkForDone:) (not local479))
			(for ((= temp103 0)) (< temp103 (starArray size:)) ((++ temp103))
				(= temp112 (starSet at: (starArray query: temp103)))
				(proc5_15 starOff temp112)
			)
			(localproc_3)
			(proc5_15 consAppear self)
			(self markDone:)
			(if (localproc_1)
				(= local486 1)
				(localproc_5)
				(rewardSound number: 51 play:)
				(proc5_9 425 0) ; "Out of this world! You have located all of the constellations in the star map!"
				(gTheIconBar disable:)
				(currentCon solvePuzzle: goAway:)
				(eventFeature dispose:)
				(gTheIconBar enable:)
				(gCurRoom setScript: (ScriptID 420 2)) ; consFinished
				(= temp107 1)
			else
				(curConsView
					setPri: 15
					setLoop: (+ global171 2)
					cel: 1
					posn: 55 155
					init:
				)
				(if (or (== global114 0) (== global114 1))
					(curConsViewSkel
						setPri: 15
						setLoop: (+ 2 global171)
						cel: 0
						posn: 55 155
						init:
					)
				)
				(Animate (gCast elements:) 0)
				(localproc_4)
			)
		)
		(SetPort temp100)
	)

	(method (refreshStars &tmp temp0 temp1 temp2)
		(for ((= temp0 0)) (< temp0 (starArray size:)) ((++ temp0))
			(= temp1 (starSet at: (starArray query: temp0)))
			(if (temp1 status:)
				(DrawCel 425 7 3 (- (temp1 getX:) 2) (- (temp1 getY:) 2) 15)
			else
				(switch (temp1 size:)
					(0
						(= temp2 0)
					)
					(1
						(= temp2 1)
					)
					(2
						(= temp2 2)
					)
				)
				(DrawCel 425 7 temp2 (- (temp1 getX:) 2) (- (temp1 getY:) 2) 15)
			)
		)
	)

	(method (markDone)
		(= done 1)
		(++ global171)
		(switch (consSet indexOf: self)
			(0
				(SetFlag 27)
			)
			(1
				(SetFlag 28)
			)
			(2
				(SetFlag 29)
			)
			(3
				(SetFlag 30)
			)
		)
	)

	(method (checkForDone &tmp temp0)
		(for ((= temp0 0)) (< temp0 (nodeStatusArray size:)) ((++ temp0))
			(if (not (nodeStatusArray query: temp0))
				(return 0)
			)
		)
		(return 1)
	)

	(method (tallyStar param1 param2)
		(+= starCnt param1)
		(if (< starCnt starLimit)
			(return 1)
		else
			(= local479 1)
			(wrongSound play:)
			(Print 425 1) ; "Sorry, you have run out of stars. Please try again."
			(if (self onMe: param2)
				(self upDate: param2)
			)
			(localproc_3)
			(= local479 (= starCnt 0))
		)
	)
)

(instance perseusStars of listArray
	(properties
		size 9
	)

	(method (query param1)
		(return [local274 param1])
	)

	(method (assign param1 param2)
		(= [local274 param1] param2)
	)
)

(instance perseusLinks of listArray
	(properties
		size 16
	)

	(method (query param1)
		(return [local283 param1])
	)

	(method (assign param1 param2)
		(= [local283 param1] param2)
	)
)

(instance perNodeStatus of listArray
	(properties
		size 9
	)

	(method (query param1)
		(return [local299 param1])
	)

	(method (assign param1 param2)
		(= [local299 param1] param2)
	)
)

(instance ursaMajorStars of listArray
	(properties
		size 15
	)

	(method (query param1)
		(return [local308 param1])
	)

	(method (assign param1 param2)
		(= [local308 param1] param2)
	)
)

(instance ursaMajorLinks of listArray
	(properties
		size 32
	)

	(method (query param1)
		(return [local323 param1])
	)

	(method (assign param1 param2)
		(= [local323 param1] param2)
	)
)

(instance ursaNodeStatus of listArray
	(properties
		size 15
	)

	(method (query param1)
		(return [local355 param1])
	)

	(method (assign param1 param2)
		(= [local355 param1] param2)
	)
)

(instance cancerStars of listArray
	(properties
		size 7
	)

	(method (query param1)
		(return [local370 param1])
	)

	(method (assign param1 param2)
		(= [local370 param1] param2)
	)
)

(instance cancerLinks of listArray
	(properties
		size 14
	)

	(method (query param1)
		(return [local377 param1])
	)

	(method (assign param1 param2)
		(= [local377 param1] param2)
	)
)

(instance canNodeStatus of listArray
	(properties
		size 7
	)

	(method (query param1)
		(return [local391 param1])
	)

	(method (assign param1 param2)
		(= [local391 param1] param2)
	)
)

(instance orionStars of listArray
	(properties
		size 18
	)

	(method (query param1)
		(return [local398 param1])
	)

	(method (assign param1 param2)
		(= [local398 param1] param2)
	)
)

(instance orionLinks of listArray
	(properties
		size 40
	)

	(method (query param1)
		(return [local416 param1])
	)

	(method (assign param1 param2)
		(= [local416 param1] param2)
	)
)

(instance orNodeStatus of listArray
	(properties
		size 18
	)

	(method (query param1)
		(return [local456 param1])
	)

	(method (assign param1 param2)
		(= [local456 param1] param2)
	)
)

(instance starSet of Set
	(properties)
)

(instance eventFeature of Feature
	(properties)

	(method (handleEvent event)
		(cond
			((or (not (IsObject currentCon)) (not (currentCon isActive:))) 0)
			((starSet firstTrue: #handleEvent event)
				(event claimed: 1)
			)
		)
	)
)

(instance Starselected of Prop
	(properties
		view 425
	)
)

(instance curConsView of Prop
	(properties
		view 425
		loop 6
	)

	(method (doVerb theVerb invItem)
		(if (or (== theVerb 3) (== theVerb 2))
			(proc420_3 global172 theVerb)
		else
			(super doVerb: theVerb invItem &rest)
		)
	)
)

(instance curConsViewSkel of Prop
	(properties
		view 425
	)
)

(instance consSet of Set
	(properties)
)

(instance Perseus of constellation
	(properties)

	(method (init)
		(= starArray perseusStars)
		(= linkArray perseusLinks)
		(= nodeStatusArray perNodeStatus)
		(super init: &rest)
	)
)

(instance Ursa_Major of constellation
	(properties
		name {Ursa Major}
	)

	(method (init)
		(= starArray ursaMajorStars)
		(= linkArray ursaMajorLinks)
		(= nodeStatusArray ursaNodeStatus)
		(super init: &rest)
	)
)

(instance Cancer of constellation
	(properties)

	(method (init)
		(= starArray cancerStars)
		(= linkArray cancerLinks)
		(= nodeStatusArray canNodeStatus)
		(super init: &rest)
	)
)

(instance Orion of constellation
	(properties)

	(method (init)
		(= starArray orionStars)
		(= linkArray orionLinks)
		(= nodeStatusArray orNodeStatus)
		(super init: &rest)
	)
)

(instance currentCon of PuzzleBar
	(properties
		puzzleHeight 169
		bottomHeight 0
		solvedFlag 31
	)

	(method (init &tmp temp0)
		(= window conWindow)
		(conWindow back: (proc0_1 43 11 global127))
		(LoadMany rsSOUND 950)
		(if (not size)
			(super init: &rest)
		)
		(self show:)
	)

	(method (show &tmp [temp0 5])
		(= global173 1)
		(super show: &rest)
		(= global173 0)
		(curConsView posn: -100 -100)
		(curConsViewSkel posn: -100 -100)
		(localproc_5)
		(Animate (gCast elements:) 0)
		(if (<= global171 3)
			(localproc_3)
		)
	)

	(method (buyClue &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(if (super buyClue:)
			(= temp5 0)
			(= temp1 (consSet at: global171))
			(temp1 resetNonMembers:)
			(= temp3 (temp1 starArray:))
			(= temp4 (temp3 size:))
			(for ((= temp0 0)) (and (< temp0 temp4) (< temp5 5)) ((++ temp0))
				(= temp2 (starSet at: (temp3 query: temp0)))
				(if (and (== (temp2 status:) 0) (not (temp1 done:)))
					(++ temp5)
					(temp2 update: 1)
				)
			)
		)
	)

	(method (showHelp)
		(proc5_9 425 2) ; "Find the stars on the sky dome which make up each of four constellations. Click on just those stars which form each constellation. If you think you have an incorrect star, click on it again to turn it off."
		(proc5_9 425 3) ; "If you get totally stuck, spend a hint coin to have the computer help you with the current constellation."
	)

	(method (animateOnce)
		(Animate (gCast elements:) 1)
		(return 1)
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 [temp8 2] temp10 temp11 temp12)
		(= temp0 (event type:))
		(= temp3 (event x:))
		(= temp4 (event y:))
		(= temp2 (event message:))
		(= gLastEvent event)
		(if (not local480)
			(= temp7 (self firstTrue: #onMe event))
		)
		(if local480
			(= temp5 (+ 5 temp3))
			(= temp6 (+ 105 temp4))
			(if
				(and
					(not (& (OnControl CONTROL temp5 temp6) $0800))
					(not (& (OnControl CONTROL temp5 temp6) $4000))
					(not (< temp6 10))
				)
				(= local480 0)
			else
				(= gGameTime (+ gTickOffset (GetTime)))
				(self animateOnce:)
				(gTheDoits doit:)
				(gPMouse handleEvent: event)
			)
		)
		(if (& temp0 $0040) ; direction
			(switch (event message:)
				(JOY_UP
					(if (not local480)
						(= local480 1)
						(gGame setCursor: gTheCursor 1 155 -43)
					)
				)
			)
		)
		(if (and (& temp0 evKEYBOARD) (== temp2 KEY_RETURN) local480)
			(= temp0 evMOUSEBUTTON)
		)
		(if (== temp0 evMOUSEBUTTON)
			(= temp11 temp0)
			(= temp12 (event message:))
			(= temp10 (GetPort))
			(event globalize:)
			(SetPort 0)
			(event localize:)
			(if (IsObject (= temp1 (gTheIconBar curIcon:)))
				(event type: (temp1 type:) message: (temp1 message:))
			)
			(gCast handleEvent: event)
			(gFeatures handleEvent: event)
			(event type: temp11 message: temp12)
			(event globalize:)
			(SetPort temp10)
			(event localize:)
		)
		(event claimed: 0)
		(if (not local480)
			(if (super dispatchEvent: event)
				(return 1)
			else
				(return 0)
			)
		else
			(event dispose:)
			(return 0)
		)
	)

	(method (dispose)
		(starSet dispose:)
		(consSet dispose:)
		(super dispose: &rest)
	)
)

(instance starOn of HandsOffScript
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(Starselected
					posn: (register getX:) (register getY:)
					cel: 0
					setCycle: End self
				)
			)
			(1
				(= ticks 1)
			)
			(2
				(Starselected posn: -1 -1)
				(= cycles 1)
			)
			(3
				(DrawCel
					425
					7
					3
					(- (register getX:) 2)
					(- (register getY:) 2)
					15
				)
				(= client 0)
				(= cycles 1)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance starOff of HandsOffScript
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(register status: 0)
				(switch (register size:)
					(0
						(= temp0 0)
					)
					(1
						(= temp0 1)
					)
					(2
						(= temp0 2)
					)
				)
				(DrawCel
					425
					7
					temp0
					(- (register getX:) 2)
					(- (register getY:) 2)
					15
				)
				(= cycles 1)
			)
			(1
				(Starselected
					posn: (register getX:) (register getY:)
					cel: 2
					setCycle: Beg self
				)
			)
			(2
				(Starselected posn: -1 -1)
				(= client 0)
				(= cycles 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance consAppear of HandsOffScript
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(rewardSound number: [local482 local481] play:)
				(++ local481)
				(proc5_14 425 4 (register name:)) ; "Congratulations! You have located %s."
				(= cycles 1)
			)
			(2
				(proc420_1 0)
				(= ticks 3)
			)
			(3
				(self dispose:)
			)
		)
	)
)

