;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 710)
(include sci.sh)
(use Main)
(use Piles)
(use SortArray)
(use n726)
(use System)

(public
	proc710_0 0
)

(local
	[local0 13]
	[local13 13]
	[local26 13]
	[local39 5]
	[local44 5]
	[local49 5]
	[local54 5]
	[local59 5]
	[local64 5]
	[local69 5]
	[local74 5]
	[local79 5]
	[local84 5]
	[local89 5]
	[local94 5]
	[local99 5]
	[local104 5]
	[local109 5]
	[local114 5]
	[local119 5]
	[local124 5]
	[local129 5]
	[local134 5]
	[local139 5]
	local144
	local145
	local146
	local147
	local148
	local149
)

(procedure (localproc_0 &tmp temp0 temp1 [temp2 5])
	(for ((= temp0 1)) (<= temp0 4) ((++ temp0))
		(= [temp2 temp0] [local109 temp0])
	)
	(for ((= temp1 1)) (<= temp1 4) ((++ temp1))
		(= [local109 temp1]
			(switch
				(= temp0 (Max [temp2 1] [temp2 2] [temp2 3] [temp2 4]))
				([temp2 1] 1)
				([temp2 2] 2)
				([temp2 3] 3)
				([temp2 4] 4)
			)
		)
		(= [temp2 [local109 temp1]] -1)
	)
)

(procedure (proc710_0 param1 param2 &tmp temp0)
	(switch param1
		(0
			(= temp0 [local39 param2])
		)
		(1
			(= temp0 [local44 param2])
		)
		(2
			(= temp0 [local49 param2])
		)
		(3
			(= temp0 [local54 param2])
		)
		(4
			(= temp0 [local59 param2])
		)
		(5
			(= temp0 [local64 param2])
		)
		(6
			(= temp0 [local69 param2])
		)
		(7
			(= temp0 [local74 param2])
		)
		(8
			(= temp0 [local79 param2])
		)
		(10
			(= temp0 [local84 param2])
		)
		(11
			(= temp0 [local89 param2])
		)
		(12
			(= temp0 [local94 param2])
		)
		(13
			(= temp0 [local99 param2])
		)
		(14
			(= temp0 [local104 param2])
		)
	)
	(return temp0)
)

(class BridgeStrategyPlay of Code
	(properties
		LHOChance 0
		combinedHCP 0
		missingHCP 0
		LHOPoints 0
		RHOPoints 0
		topCl 0
		topDi 0
		topHt 0
		topSp 0
		LHO 0
		RHO 0
		mustLose 0
		finChance 0
		finCard 0
		finTricks 0
		noFinLoserChance 0
		noFinLoserTricks 0
		forceLosers 0
		clLosers 0
		diLosers 0
		htLosers 0
		spLosers 0
		plan 0
		curPlyr 0
		pard 0
		trumps 0
		trickSize 0
		theSuitLead 0
		desperate 0
	)

	(method (setPlan param1)
		(= plan param1)
		(BridgeStrategyPlay plan: plan)
		(return param1)
	)

	(method (init)
		(= [local0 0] 100)
		(= [local0 1] 100)
		(= [local0 2] 52)
		(= [local0 3] 78)
		(= [local0 4] 41)
		(= [local0 5] 68)
		(= [local0 6] 36)
		(= [local0 7] 62)
		(= [local0 8] 33)
		(= [local0 9] 59)
		(= [local0 10] 31)
		(= [local0 11] 57)
		(= [local0 12] 30)
		(= [local13 0] 100)
		(= [local13 1] 100)
		(= [local13 2] 100)
		(= [local13 3] 100)
		(= [local13 4] 90)
		(= [local13 5] 96)
		(= [local13 6] 84)
		(= [local13 7] 93)
		(= [local13 8] 80)
		(= [local13 9] 90)
		(= [local13 10] 77)
		(= [local13 11] 89)
		(= [local13 12] 76)
		(= [local26 0] 100)
		(= [local26 1] 100)
		(= [local26 2] 100)
		(= [local26 3] 100)
		(= [local26 4] 100)
		(= [local26 5] 100)
		(= [local26 6] 99)
		(= [local26 7] 99)
		(= [local26 8] 97)
		(= [local26 9] 99)
		(= [local26 10] 96)
		(= [local26 11] 98)
		(= [local26 12] 95)
	)

	(method (makePlan param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 [temp6 4] temp10 [temp11 14] temp25)
		(if (not [local0 0])
			(self init:)
		)
		(= temp5 (gTrick tricksPlayed:))
		(= local146 (gTrick leader:))
		(= trickSize (gTrick size:))
		(= theSuitLead (gTrick suitLead:))
		(= local145 (- (+ global434 6) global433))
		(= local144 (- (- 7 global434) (- temp5 global433)))
		(= trumps (gTrick trump:))
		(self setCurPlyr:)
		(proc726_0)
		(curPlyr calcScore:)
		(if (!= param1 0)
			(= desperate 1)
		else
			(= desperate 0)
		)
		(= local148 (LHO countSuit: trumps))
		(= local149 (RHO countSuit: trumps))
		(for ((= temp1 1)) (<= temp1 4) ((++ temp1))
			(= [local49 temp1] (global429 countSuit: temp1))
			(= [local54 temp1] (global431 countSuit: temp1))
			(= [local119 temp1] (LHO countSuit: temp1))
			(= [local124 temp1] (RHO countSuit: temp1))
			(= [local129 temp1] (pard countSuit: temp1))
			(= [local114 temp1]
				(if (== curPlyr global429) [local49 temp1] else [local54 temp1])
			)
		)
		(= temp25 (self checkTopTricks:))
		(for ((= temp1 1)) (<= temp1 4) ((++ temp1))
			(= [local74 temp1] 0)
			(= [local79 temp1] 0)
			(= [local44 temp1] 0)
			(= temp3 [local49 temp1])
			(= temp4 [local54 temp1])
			(= [local59 temp1] (self checkLongTricks: temp1))
			(= [local64 temp1] mustLose)
			(= [local69 temp1] LHOChance)
			(if (!= [local39 temp1] (Max temp3 temp4))
				(= [local74 temp1] (self forceWinners: temp1))
				(= [local79 temp1] forceLosers)
			)
			(= [local44 temp1] (self topLosers: temp1))
			(= temp3 [local49 temp1])
			(= temp4 [local54 temp1])
			(self loadFinArray: temp1)
			(if (= temp0 (self finesse: temp3 temp4 temp1 LHO RHO))
				(= [local94 temp1] temp0)
				(= [local89 temp1] mustLose)
				(= [local99 temp1] finChance)
				(= [local104 temp1] finCard)
				(= [local84 temp1] finTricks)
				(if noFinLoserChance
					(= [local139 temp1] noFinLoserChance)
					(= [local134 temp1] noFinLoserTricks)
				)
			else
				(= [local94 temp1] 0)
				(= [local89 temp1] 0)
				(= [local99 temp1] 0)
				(= [local104 temp1] 0)
				(= [local84 temp1] 0)
				(if noFinLoserChance
					(= [local139 temp1] 0)
					(= [local134 temp1] 0)
				)
			)
		)
		(if (!= plan (BridgeStrategyPlay plan:))
			(= plan (BridgeStrategyPlay plan:))
		)
		(if plan
			(switch plan
				(2
					(if (self noForcePlan: 1)
						(= plan 0)
					)
				)
				(3
					(if (self noForcePlan: 2)
						(= plan 0)
					)
				)
				(4
					(if (self noForcePlan: 3)
						(= plan 0)
					)
				)
				(5
					(if (self noForcePlan: 4)
						(= plan 0)
					)
				)
				(6
					(if (not (and [local59 1] [local69 1] [local114 1]))
						(= plan 0)
					)
				)
				(7
					(if (not (and [local59 2] [local69 2] [local114 2]))
						(= plan 0)
					)
				)
				(8
					(if (not (and [local59 3] [local69 3] [local114 3]))
						(= plan 0)
					)
				)
				(9
					(if (not (and [local59 4] [local69 4] [local114 4]))
						(= plan 0)
					)
				)
				(22
					(if
						(or
							(== [local49 trumps] [local54 trumps] 0)
							(and (not local148) (not local149))
							(>=
								[local44 trumps]
								(Max [local49 trumps] [local54 trumps])
							)
							(not [local114 trumps])
							(and
								(not [local39 trumps])
								(or
									(<=
										(Max
											[local49 trumps]
											[local54 trumps]
										)
										(Max local148 local149)
									)
									(and
										[local49 trumps]
										[local54 trumps]
										(== (+ local148 local149) 1)
										(not [local39 trumps])
									)
								)
							)
						)
						(= plan 0)
					)
				)
				(23
					(if (self noRuffPlan: 1 global429)
						(= plan 0)
					)
				)
				(24
					(if (self noRuffPlan: 2 global429)
						(= plan 0)
					)
				)
				(25
					(if (self noRuffPlan: 3 global429)
						(= plan 0)
					)
				)
				(26
					(if (self noRuffPlan: 4 global429)
						(= plan 0)
					)
				)
				(27
					(if (self noRuffPlan: 1 global431)
						(= plan 0)
					)
				)
				(28
					(if (self noRuffPlan: 2 global431)
						(= plan 0)
					)
				)
				(29
					(if (self noRuffPlan: 3 global431)
						(= plan 0)
					)
				)
				(30
					(if (self noRuffPlan: 4 global431)
						(= plan 0)
					)
				)
			)
		)
		(= local147 0)
		(for ((= temp1 1)) (<= temp1 4) ((++ temp1))
			(if
				(and
					(== [local69 temp1] 100)
					(>= [local59 temp1] [local39 temp1])
					(>=
						[local39 temp1]
						(Max [local119 temp1] [local124 temp1])
					)
				)
				(+= local147 [local59 temp1])
				(= [local39 temp1] [local59 temp1])
				(= [local59 temp1] 0)
			else
				(+= local147 [local39 temp1])
			)
		)
		(if (and (>= local147 local145) (not desperate))
			(for ((= temp1 1)) (<= temp1 4) ((++ temp1))
				(= [local104 temp1] 0)
				(= [local99 temp1] 0)
			)
		)
		(if
			(and
				(>= local147 local145)
				(!= trumps 5)
				(not [local114 trumps])
				[local39 trumps]
				(>= [local129 trumps] (+ local148 local149))
				(or local148 local149)
				(< trickSize 2)
				(or
					(and
						(== trumps 1)
						(= temp10 (self gotAnEntry: 1 pard 1))
						(or (== temp10 theSuitLead) (not trickSize))
					)
					(and
						(== trumps 2)
						(= temp10 (self gotAnEntry: 2 pard 1))
						(or (== temp10 theSuitLead) (not trickSize))
					)
					(and
						(== trumps 3)
						(= temp10 (self gotAnEntry: 3 pard 1))
						(or (== temp10 theSuitLead) (not trickSize))
					)
					(and
						(== trumps 4)
						(= temp10 (self gotAnEntry: 4 pard 1))
						(or (== temp10 theSuitLead) (not trickSize))
					)
				)
			)
			(= plan
				(switch temp10
					(1 31)
					(2 32)
					(3 33)
					(4 34)
				)
			)
		)
		(if
			(and
				(not plan)
				(or (>= local147 local145) desperate)
				(or
					(and [local114 1] (self notTheySuitOrTrump: 1) (= plan 2))
					(and [local114 2] (self notTheySuitOrTrump: 2) (= plan 3))
					(and [local114 3] (self notTheySuitOrTrump: 3) (= plan 4))
					(and [local114 4] (self notTheySuitOrTrump: 4) (= plan 5))
				)
			)
			(switch
				(= temp1
					(Max [local39 1] [local39 2] [local39 3] [local39 4])
				)
				([local39 1]
					(if (and [local114 1] (self notTheySuitOrTrump: 1))
						(= plan 2)
					)
				)
				([local39 2]
					(if (and [local114 2] (self notTheySuitOrTrump: 2))
						(= plan 3)
					)
				)
				([local39 3]
					(if (and [local114 3] (self notTheySuitOrTrump: 3))
						(= plan 4)
					)
				)
				([local39 4]
					(if (and [local114 4] (self notTheySuitOrTrump: 4))
						(= plan 5)
					)
				)
			)
		)
		(if plan
			(switch plan
				(10
					(if (self noFinesses: 1)
						(= plan 0)
					)
				)
				(11
					(if (self noFinesses: 2)
						(= plan 0)
					)
				)
				(12
					(if (self noFinesses: 3)
						(= plan 0)
					)
				)
				(13
					(if (self noFinesses: 4)
						(= plan 0)
					)
				)
				(14
					(if (self noFinesses: 1)
						(= plan 0)
					)
				)
				(15
					(if (self noFinesses: 2)
						(= plan 0)
					)
				)
				(16
					(if (self noFinesses: 3)
						(= plan 0)
					)
				)
				(17
					(if (self noFinesses: 4)
						(= plan 0)
					)
				)
			)
		)
		(if
			(and
				(!= trumps 5)
				[local114 trumps]
				(or local148 local149)
				(not [local94 trumps])
				(or (not trickSize) (== theSuitLead trumps))
				(not plan)
				(not (self checkTopRuff:))
				(or
					(not [local49 trumps])
					(not [local54 trumps])
					(> (+ local148 local149) 1)
					[local39 trumps]
				)
			)
			(= plan 22)
		)
		(if
			(or
				(== local147 (- 13 temp5))
				(and
					(not plan)
					(or
						(and (== trumps 5) (>= local147 local145))
						(and
							(!= trumps 5)
							(>= (- local147 [local39 trumps]) local145)
							[local39 trumps]
						)
					)
					(not trickSize)
					(or (== trumps 5) (not (or local148 local149)))
					(or [local44 1] [local44 2] [local44 3] [local44 4])
				)
			)
			(for ((= temp1 1)) (<= temp1 4) ((++ temp1))
				(= [local109 temp1] [local39 temp1])
			)
			(localproc_0)
			(for ((= temp1 1)) (<= temp1 4) ((++ temp1))
				(if
					(and
						[local114 [local109 temp1]]
						(or
							[local39 [local109 temp1]]
							[local74 [local109 temp1]]
						)
					)
					(= plan
						(switch [local109 temp1]
							(1 2)
							(2 3)
							(3 4)
							(4 5)
						)
					)
					(= temp1 4)
				)
			)
		)
		(if (not plan)
			(for ((= temp1 0)) (< temp1 2) ((++ temp1))
				(cond
					((self checkTopForceOne: temp1)
						(if
							(and
								(!= trumps 5)
								[local114 trumps]
								(or local148 local149)
								(not [local94 trumps])
								(or (not trickSize) (== theSuitLead trumps))
								(or
									(not [local49 trumps])
									(not [local54 trumps])
									(> (+ local148 local149) 1)
									[local39 trumps]
								)
							)
							(= plan 22)
						)
					)
					((and (!= trumps 5) (self checkTopRuff: temp1)))
					((self checkTopFin: temp1))
					((self checkTopForceTwo: 3 4 temp1))
					((self checkTopForceTwo: 2 4 temp1))
					((self checkTopForceTwo: 1 4 temp1))
					((self checkTopForceTwo: 3 2 temp1))
					((self checkTopForceTwo: 3 1 temp1))
					((self checkTopForceTwo: 1 2 temp1))
					((self checkForceTopOne: temp1))
					(
						(and
							(or
								(>=
									(+
										[local74 3]
										[local74 1]
										[local74 4]
										[local74 2]
										[local39 3]
										[local39 1]
										[local39 4]
										[local39 2]
									)
									local145
								)
								desperate
							)
							(<=
								(+
									[local79 2]
									[local79 3]
									[local79 1]
									[local79 4]
								)
								local144
							)
						)
						(if trickSize
							(= plan
								(switch theSuitLead
									(1 2)
									(2 3)
									(3 4)
									(4 5)
								)
							)
						else
							(self checkForceFour:)
						)
					)
					((self checkTopLong: temp1))
					((self checkNFLT: temp1))
					(else
						(= plan 0)
					)
				)
				(if plan
					(= temp1 2)
				)
			)
		)
		(self setPlan: plan)
	)

	(method (noFinesses param1 &tmp temp0)
		(if
			(or
				(not [local94 param1])
				(and (not [local114 param1]) (not trickSize))
			)
			(= temp0 1)
		else
			(= temp0 0)
		)
		(return temp0)
	)

	(method (notTheySuitOrTrump param1 &tmp temp0)
		(if
			(and
				(not [local119 param1])
				(not [local124 param1])
				(!= trumps param1)
			)
			(= temp0 1)
		else
			(= temp0 0)
		)
		(return temp0)
	)

	(method (noForcePlan param1 &tmp temp0)
		(if
			(or
				(and
					(not [local74 param1])
					(< trickSize 2)
					(or
						(not [local39 param1])
						(<
							[local39 param1]
							(Max [local119 param1] [local124 param1])
						)
					)
				)
				(and (not [local114 param1]) (not trickSize))
				(and
					(== param1 trumps)
					(not [local119 param1])
					(not [local124 param1])
				)
				(and
					(!= trumps 5)
					(< (+ [local119 param1] [local124 param1]) 2)
					(> (+ local148 local149) 1)
					(>
						(Max [local49 trumps] [local54 trumps])
						(Max local148 local149)
					)
				)
			)
			(= temp0 1)
		else
			(= temp0 0)
		)
		(if
			(and
				(not temp0)
				(>= local147 local145)
				(not trickSize)
				(not [local39 param1])
				(or (== trumps 5) (not (or local148 local149)))
				(or [local44 1] [local44 2] [local44 3] [local44 4])
			)
			(= temp0 1)
		)
		(return temp0)
	)

	(method (noRuffPlan param1 param2 &tmp temp0)
		(if
			(or
				(and (not trickSize) (== curPlyr param2))
				(and
					(== param2 global429)
					(not [local49 trumps])
					(not [local54 param1])
				)
				(and
					(== param2 global431)
					(not [local54 trumps])
					(not [local49 param1])
				)
				(and (not [local119 param1]) [local119 trumps])
				(and (not [local124 param1]) [local124 trumps])
				(and
					(not trickSize)
					(not (self gotAnEntry: param1))
					(or
						(and [local39 1] (not [local129 1]))
						(and [local39 2] (not [local129 2]))
						(and [local39 3] (not [local129 3]))
						(and [local39 4] (not [local129 4]))
					)
				)
			)
			(= temp0 1)
		else
			(= temp0 0)
		)
		(return temp0)
	)

	(method (checkTopRuff &tmp temp0 temp1 [temp2 5])
		(for ((= temp0 1)) (<= temp0 4) ((++ temp0))
			(= [temp2 temp0] 0)
			(if (and (!= temp0 trumps) (!= trumps 5))
				(if (>= [local49 temp0] [local54 temp0])
					(= [temp2 temp0]
						(Min
							(- [local49 temp0] [local54 temp0])
							[local54 trumps]
						)
					)
				else
					(= [temp2 temp0]
						(Min
							(- [local54 temp0] [local49 temp0])
							[local49 trumps]
						)
					)
				)
				(if [local74 temp0]
					(cond
						(
							(and
								(>= [local74 temp0] [temp2 temp0])
								(> [temp2 temp0] [local79 temp0])
							)
							(= [temp2 temp0] [local79 temp0])
						)
						((> [temp2 temp0] [local79 temp0])
							(-=
								[temp2 temp0]
								(Min [local74 temp0] [local79 temp0])
							)
						)
						(
							(and
								(> [temp2 temp0] [local74 temp0])
								(>= [temp2 temp0] [local79 temp0])
							)
							(-= [temp2 temp0] [local74 temp0])
						)
					)
				)
				(if (< [temp2 temp0] 0)
					(= [temp2 temp0] 0)
				)
			)
		)
		(for ((= temp0 1)) (<= temp0 4) ((++ temp0))
			(= [local109 temp0] [local39 temp0])
		)
		(localproc_0)
		(if
			(and
				(== [local39 1] [local39 2] [local39 3] [local39 4] 0)
				(or [local74 1] [local74 2] [local74 3] [local74 4])
			)
			(for ((= temp0 1)) (<= temp0 4) ((++ temp0))
				(= [local109 temp0] [local74 temp0])
			)
			(localproc_0)
		)
		(for ((= temp0 1)) (<= temp0 4) ((++ temp0))
			(if
				(and
					(= temp1 [temp2 [local109 temp0]])
					(or
						(and (not trickSize) [local114 [local109 temp0]])
						(== [local109 temp0] theSuitLead)
					)
					(or (>= (+ local147 temp1) local145) desperate)
					(or [local119 [local109 temp0]] [local124 [local109 temp0]])
					(or
						(not [local94 [local109 temp0]])
						(== [local94 [local109 temp0]] 10)
						(== [local94 [local109 temp0]] 25)
						(and (not trickSize) (not [local129 [local109 temp0]]))
					)
					(!= [local109 temp0] trumps)
				)
				(cond
					(
						(and
							(or
								(>=
									(- [local54 trumps] temp1)
									(/ (+ local148 local149 1) 2)
								)
								(>=
									(- [local49 trumps] temp1)
									(/ (+ local148 local149 1) 2)
								)
							)
							(or local148 local149)
							[local114 trumps]
							(or (not trickSize) (== trumps theSuitLead))
							(or
								(not [local49 trumps])
								(not [local54 trumps])
								(> (+ local148 local149) 1)
								[local39 trumps]
							)
						)
						(= plan 22)
						(= temp0 4)
					)
					(
						(and
							(>
								[local49 [local109 temp0]]
								[local54 [local109 temp0]]
							)
							[local54 trumps]
							(or
								[local114 [local109 temp0]]
								(== [local109 temp0] theSuitLead)
							)
						)
						(= plan
							(switch [local109 temp0]
								(1 27)
								(2 28)
								(3 29)
								(4 30)
							)
						)
						(= temp0 4)
					)
					(
						(and
							(>
								[local54 [local109 temp0]]
								[local49 [local109 temp0]]
							)
							[local49 trumps]
							(or
								[local114 [local109 temp0]]
								(== [local109 temp0] theSuitLead)
							)
						)
						(= plan
							(switch [local109 temp0]
								(1 23)
								(2 24)
								(3 25)
								(4 26)
							)
						)
						(= temp0 4)
					)
				)
			)
		)
		(return plan)
	)

	(method (forceWinners param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(self loadFinArray: param1)
		(= temp0 0)
		(= temp2 0)
		(= temp3 0)
		(while (< temp0 13)
			(cond
				((== [global201 temp0] 1)
					(++ temp2)
				)
				((== [global201 temp0] 2)
					(++ temp3)
				)
				(else
					(== [global201 temp0] 0)
				)
			)
			(++ temp0)
		)
		(= temp5 (Max temp2 temp3))
		(= temp4 0)
		(cond
			((== (proc710_0 [local39 param1]) (Max temp2 temp3))
				(= temp4 0)
			)
			(
				(and
					[global201 0]
					[global201 1]
					[global201 2]
					[global201 4]
					[global201 5]
					(> temp5 4)
				)
				(= temp4 1)
			)
			(
				(and
					[global201 0]
					[global201 1]
					[global201 3]
					[global201 4]
					[global201 5]
				)
				(= forceLosers 1)
				(cond
					((> temp5 4)
						(= temp4 2)
					)
					((== temp5 4)
						(= temp4 1)
					)
					(else
						(= temp4 0)
					)
				)
			)
			(
				(and
					[global201 0]
					[global201 1]
					[global201 3]
					[global201 4]
					(> temp5 3)
				)
				(= temp4 (= forceLosers 1))
			)
			(
				(and
					[global201 0]
					[global201 2]
					[global201 3]
					[global201 4]
					[global201 5]
				)
				(= forceLosers 1)
				(cond
					((> temp5 4)
						(= temp4 3)
					)
					((== temp5 4)
						(= temp4 2)
					)
					((== temp5 3)
						(= temp4 1)
					)
					(else
						(= temp4 0)
					)
				)
			)
			((and [global201 0] [global201 2] [global201 3] [global201 4])
				(= forceLosers 1)
				(cond
					((> temp5 3)
						(= temp4 2)
					)
					((== temp5 3)
						(= temp4 1)
					)
					(else
						(= temp4 0)
					)
				)
			)
			((and [global201 0] [global201 2] [global201 3] (> temp5 2))
				(= temp4 (= forceLosers 1))
			)
			(
				(and
					[global201 1]
					[global201 2]
					[global201 3]
					[global201 4]
					[global201 5]
				)
				(= forceLosers 1)
				(if (< temp5 5)
					(= temp4 (- temp5 1))
				else
					(= temp4 4)
				)
			)
			((and [global201 1] [global201 2] [global201 3] [global201 4])
				(= forceLosers 1)
				(if (< temp5 4)
					(= temp4 (- temp5 1))
				else
					(= temp4 3)
				)
			)
			((and [global201 1] [global201 2] [global201 3])
				(= forceLosers 1)
				(if (< temp5 3)
					(= temp4 (- temp5 1))
				else
					(= temp4 2)
				)
			)
			(
				(and
					[global201 1]
					[global201 2]
					[global201 4]
					[global201 5]
					[global201 6]
					(> temp5 3)
				)
				(= forceLosers 2)
				(if (< temp5 5)
					(= temp4 (- temp5 2))
				else
					(= temp4 3)
				)
			)
			(
				(and
					[global201 1]
					[global201 2]
					[global201 4]
					[global201 5]
					(> temp5 3)
				)
				(= temp4 (= forceLosers 2))
			)
			((and [global201 1] [global201 2] (> temp5 1))
				(= temp4 (= forceLosers 1))
			)
			(
				(and
					[global201 2]
					[global201 3]
					[global201 4]
					[global201 5]
					[global201 6]
				)
				(= forceLosers 2)
				(if (< temp5 5)
					(= temp4 (- temp5 2))
				else
					(= temp4 3)
				)
			)
			((and [global201 2] [global201 3] [global201 4] [global201 5])
				(= forceLosers 2)
				(if (< temp5 4)
					(= temp4 (- temp5 2))
				else
					(= temp4 2)
				)
			)
			((and [global201 2] [global201 3] [global201 4] (> temp5 2))
				(= forceLosers 2)
				(= temp4 1)
			)
			(
				(and
					[global201 2]
					[global201 3]
					[global201 5]
					[global201 6]
					[global201 7]
					(> temp5 3)
				)
				(= temp4 (- temp5 3))
			)
			(else
				(= temp4 0)
			)
		)
		(return temp4)
	)

	(method (checkLongTricks param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
		(= temp0
			(+
				((global117 atLocation: 3) countSuit: param1)
				((global117 atLocation: 2) countSuit: param1)
				((global117 atLocation: 1) countSuit: param1)
				((global117 atLocation: 4) countSuit: param1)
			)
		)
		(= temp1 [local39 param1])
		(= temp2 (LHO countSuit: param1))
		(= temp4 (RHO countSuit: param1))
		(= temp5 (global429 countSuit: param1))
		(= temp6 (global431 countSuit: param1))
		(= temp7 (- temp0 (+ temp6 temp5)))
		(if (not temp1)
			(= temp9 (Max temp2 temp4 [local44 param1]))
		else
			(= temp9 0)
		)
		(= temp3 (- (Max temp6 temp5) temp1))
		(= temp8 temp1)
		(cond
			((>= (- temp1 temp7) 0)
				(= LHOChance 100)
				(= temp8 temp3)
			)
			((>= temp1 (/ (+ 5 temp7) 2))
				(= LHOChance [local26 temp7])
				(= temp8 temp3)
			)
			((>= temp1 (/ (+ 3 temp7) 2))
				(= LHOChance [local13 temp7])
				(= temp8 temp3)
			)
			((>= temp1 (/ (+ 1 temp7) 2))
				(= LHOChance [local0 temp7])
				(= temp8 temp3)
			)
			((>= temp1 (/ (- temp7 1) 2))
				(= LHOChance [local0 temp7])
				(= temp8 (- temp3 1))
				(= temp9 1)
			)
			((>= temp1 (/ (- temp7 3) 2))
				(= LHOChance [local0 temp7])
				(= temp8 (- temp3 2))
				(= temp9 2)
			)
			((>= temp1 (/ (- temp7 5) 2))
				(= LHOChance [local0 temp7])
				(= temp8 (- temp3 3))
				(= temp9 3)
			)
			(else
				(= temp8 (= LHOChance 0))
			)
		)
		(= mustLose temp9)
		(if (< temp8 0)
			(= temp8 0)
		)
		(return temp8)
	)

	(method (duckToSetUp param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
		(switch param1
			(1
				(= temp0
					(+
						((global117 atLocation: 3) countSuit: 1)
						((global117 atLocation: 2) countSuit: 1)
						((global117 atLocation: 1) countSuit: 1)
						((global117 atLocation: 4) countSuit: 1)
					)
				)
				(= temp1 [local39 1])
				(= temp2 (LHO minClubs:))
				(= temp3 (LHO maxClubs:))
				(= temp4 (RHO minClubs:))
				(= temp5 (RHO maxClubs:))
				(= temp7 (global429 clubs:))
				(= temp8 (global431 clubs:))
			)
			(2
				(= temp0
					(+
						((global117 atLocation: 3) countSuit: 2)
						((global117 atLocation: 2) countSuit: 2)
						((global117 atLocation: 1) countSuit: 2)
						((global117 atLocation: 4) countSuit: 2)
					)
				)
				(= temp1 [local39 2])
				(= temp2 (LHO minDiamonds:))
				(= temp3 (LHO maxDiamonds:))
				(= temp4 (RHO minDiamonds:))
				(= temp5 (RHO maxDiamonds:))
				(= temp7 (global429 diamonds:))
				(= temp8 (global431 diamonds:))
			)
			(3
				(= temp0
					(+
						((global117 atLocation: 3) countSuit: 3)
						((global117 atLocation: 2) countSuit: 3)
						((global117 atLocation: 1) countSuit: 3)
						((global117 atLocation: 4) countSuit: 3)
					)
				)
				(= temp1 [local39 3])
				(= temp2 (LHO minHearts:))
				(= temp3 (LHO maxHearts:))
				(= temp4 (RHO minHearts:))
				(= temp5 (RHO maxHearts:))
				(= temp7 (global429 hearts:))
				(= temp8 (global431 hearts:))
			)
			(else
				(= temp0
					(+
						((global117 atLocation: 3) countSuit: 4)
						((global117 atLocation: 2) countSuit: 4)
						((global117 atLocation: 1) countSuit: 4)
						((global117 atLocation: 4) countSuit: 4)
					)
				)
				(= temp1 [local39 4])
				(= temp2 (LHO minSpades:))
				(= temp3 (LHO maxSpades:))
				(= temp4 (RHO minSpades:))
				(= temp5 (RHO maxSpades:))
				(= temp7 (global429 spades:))
				(= temp8 (global431 spades:))
			)
		)
		(= temp9 (- (+ temp8 temp7) temp0))
		(= temp6 (Max temp7 temp8))
		(switch param2
			(1
				(if (> temp6 (/ (+ 5 temp9) 2))
					(= LHOChance [local26 temp9])
					(return (- (/ (+ 1 temp9) 2) (+ temp1 temp6)))
				)
				(if (> temp6 (/ (+ 3 temp9) 2))
					(= LHOChance [local13 temp9])
					(return (- (/ (+ 1 temp9) 2) (+ temp1 temp6)))
				)
				(if (<= 1 (- temp1 (/ (+ 1 temp9) 2)))
					(= LHOChance [local0 temp9])
					(return (- (/ (+ 1 temp9) 2) (+ temp1 temp6)))
				)
			)
			(2
				(if (> temp6 (/ (+ 5 temp9) 2))
					(= LHOChance [local26 temp9])
					(return (- (/ (+ 3 temp9) 2) (+ temp1 temp6)))
				)
				(if (> temp6 (/ (+ 3 temp9) 2))
					(= LHOChance [local13 temp9])
					(return (- (/ (+ 3 temp9) 2) (+ temp1 temp6)))
				)
				(if (<= 1 (- temp1 (/ (+ 1 temp9) 2)))
					(= LHOChance [local0 temp9])
					(return (- (/ (+ 3 temp9) 2) (+ temp1 temp6)))
				)
			)
			(3
				(if (> temp6 (/ (+ 5 temp9) 2))
					(= LHOChance [local26 temp9])
					(return (- (/ (+ 5 temp9) 2) (+ temp1 temp6)))
				)
				(if (> temp6 (/ (+ 5 temp9) 2))
					(= LHOChance [local26 temp9])
					(return (- (/ (+ 5 temp9) 2) (+ temp1 temp6)))
				)
				(if (<= 1 (- temp1 (/ (+ 1 temp9) 2)))
					(= LHOChance [local0 temp9])
					(return (- (/ (+ 5 temp9) 2) (+ temp1 temp6)))
				)
			)
			(else
				(= LHOChance 0)
				(return temp1)
			)
		)
	)

	(method (topLosers param1 &tmp temp0 temp1 temp2)
		(= temp2 0)
		(= temp0 0)
		(while (< temp2 13)
			(if
				(<
					(switch param1
						(1 [global162 temp2])
						(2 [global149 temp2])
						(3 [global136 temp2])
						(4 [global123 temp2])
					)
					3
				)
				(= temp0 temp2)
				(= temp2 13)
			)
			(++ temp2)
		)
		(if
			(and
				trickSize
				(== param1 theSuitLead)
				(or
					(and
						(== trickSize 1)
						(not
							(global431
								hasCard:
									theSuitLead
									(| (gTrick highOfSuitLead:) $0f00)
							)
						)
						(not
							(global429
								hasCard:
									theSuitLead
									(| (gTrick highOfSuitLead:) $0f00)
							)
						)
					)
					(and
						(> trickSize 1)
						(!= ((gTrick highCard:) owner:) global429)
						(!= ((gTrick highCard:) owner:) global431)
						(not
							(curPlyr
								hasCard:
									theSuitLead
									(| (gTrick highOfSuitLead:) $0f00)
							)
						)
					)
				)
			)
			(++ temp0)
		)
		(= temp2 (Max (LHO countSuit: param1) (RHO countSuit: param1)))
		(if (> temp0 temp2)
			(= temp0 temp2)
		)
		(return temp0)
	)

	(method (checkTopTricks &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10)
		(= temp3 (= temp0 (= temp1 (= temp2 0))))
		(= temp4 (= temp5 (= temp6 (= temp7 0))))
		(for ((= temp10 1)) (<= temp10 4) ((++ temp10))
			(for ((= temp9 0)) (< temp9 13) ((++ temp9))
				(switch temp10
					(1
						(if (and (< [global162 temp9] 3) [global162 temp9])
							(++ temp0)
						else
							(= temp9 13)
						)
					)
					(2
						(if (and (< [global149 temp9] 3) [global149 temp9])
							(++ temp1)
						else
							(= temp9 13)
						)
					)
					(3
						(if (and (< [global136 temp9] 3) [global136 temp9])
							(++ temp2)
						else
							(= temp9 13)
						)
					)
					(4
						(if (and (< [global123 temp9] 3) [global123 temp9])
							(++ temp3)
						else
							(= temp9 13)
						)
					)
				)
			)
		)
		(if
			(and
				trickSize
				(or
					(and
						(== trickSize 1)
						(not
							(global431
								hasCard:
									theSuitLead
									(| (gTrick highOfSuitLead:) $0f00)
							)
						)
						(not
							(global429
								hasCard:
									theSuitLead
									(| (gTrick highOfSuitLead:) $0f00)
							)
						)
					)
					(and
						(> trickSize 1)
						(!= ((gTrick highCard:) owner:) global429)
						(!= ((gTrick highCard:) owner:) global431)
						(not
							(curPlyr
								hasCard:
									theSuitLead
									(| (gTrick highOfSuitLead:) $0f00)
							)
						)
					)
				)
			)
			(switch theSuitLead
				(1
					(= temp0 0)
				)
				(2
					(= temp1 0)
				)
				(3
					(= temp2 0)
				)
				(4
					(= temp3 0)
				)
			)
		)
		(if
			(>
				temp0
				(Max (global431 countSuit: 1) (global429 countSuit: 1))
			)
			(= temp0
				(Max (global431 countSuit: 1) (global429 countSuit: 1))
			)
		)
		(if
			(>
				temp1
				(Max (global431 countSuit: 2) (global429 countSuit: 2))
			)
			(= temp1
				(Max (global431 countSuit: 2) (global429 countSuit: 2))
			)
		)
		(if
			(>
				temp2
				(Max (global431 countSuit: 3) (global429 countSuit: 3))
			)
			(= temp2
				(Max (global431 countSuit: 3) (global429 countSuit: 3))
			)
		)
		(if
			(>
				temp3
				(Max (global431 countSuit: 4) (global429 countSuit: 4))
			)
			(= temp3
				(Max (global431 countSuit: 4) (global429 countSuit: 4))
			)
		)
		(= topCl temp0)
		(= topDi temp1)
		(= topHt temp2)
		(= topSp temp3)
		(= [local39 1] temp0)
		(= [local39 2] temp1)
		(= [local39 3] temp2)
		(= [local39 4] temp3)
		(return (+ temp0 temp1 temp2 temp3))
	)

	(method (topCard param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(if (< argc 2)
			(self setCurPlyr:)
			(= temp4 curPlyr)
		else
			(= temp4 param2)
		)
		(= temp1 0)
		(= temp2 14)
		(= temp3 0)
		(while (< temp1 (temp4 size:))
			(= temp5 (temp4 at: temp1))
			(if
				(and
					(< (= temp0 (SortArray isCurrent: temp5)) temp2)
					(== param1 (temp5 suit:))
				)
				(= temp2 temp0)
				(= temp3 temp1)
				(if (== temp0 0)
					(= temp1 (temp4 size:))
				)
			)
			(++ temp1)
		)
		(if (< temp2 7)
			(temp4 at: temp3)
			(return)
		else
			(self bottomCard: param1)
			(return)
		)
	)

	(method (bottomCard param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(self setCurPlyr:)
		(= temp1 0)
		(= temp2 -1)
		(= temp3 -1)
		(while (< temp1 (curPlyr size:))
			(= temp4 (curPlyr at: temp1))
			(if
				(and
					(> (= temp0 (SortArray isCurrent: temp4)) temp2)
					(== (temp4 suit:) param1)
				)
				(= temp3 temp1)
				(= temp2 temp0)
			)
			(++ temp1)
		)
		(curPlyr at: temp3)
	)

	(method (checkTopForceOne param1 &tmp temp0 temp1 temp2)
		(for ((= temp0 1)) (<= temp0 4) ((++ temp0))
			(= [local109 temp0] [local74 temp0])
		)
		(localproc_0)
		(if [local74 [local109 1]]
			(for ((= temp0 1)) (<= temp0 4) ((++ temp0))
				(if
					(or
						(and (not trickSize) [local114 [local109 temp0]])
						(== temp0 theSuitLead)
					)
					(if (not param1)
						(= temp2
							(-
								(+
									[local44 1]
									[local44 2]
									[local44 3]
									[local44 4]
									[local79 [local109 temp0]]
								)
								[local44 [local109 temp0]]
							)
						)
					else
						(= temp2 0)
					)
					(if
						(and
							(or
								(>=
									(+ local147 [local74 [local109 temp0]])
									local145
								)
								desperate
							)
							(<= temp2 local144)
							(or trickSize [local114 [local109 temp0]])
							(or (!= trumps [local109 temp0]) local148 local149)
							(or
								(>
									(+
										[local119 [local109 temp0]]
										[local124 [local109 temp0]]
									)
									1
								)
								(==
									(+ [local119 trumps] [local124 trumps])
									[local44 trumps]
								)
							)
							(or
								[local39 [local109 temp0]]
								[local74 [local109 temp0]]
							)
						)
						(= plan
							(switch [local109 temp0]
								(1 2)
								(2 3)
								(3 4)
								(4 5)
							)
						)
						(= temp0 4)
					)
				)
			)
		)
		(return plan)
	)

	(method (checkTopForceTwo param1 param2 param3 &tmp temp0 temp1)
		(= temp0
			(-
				(+
					[local39 1]
					[local39 2]
					[local39 3]
					[local39 4]
					[local74 param1]
					[local74 param2]
				)
				(+ [local39 param1] [local39 param2])
			)
		)
		(if (not param3)
			(= temp1
				(-
					(+
						[local44 1]
						[local44 2]
						[local44 3]
						[local44 4]
						[local79 param1]
						[local79 param2]
					)
					(+ [local44 param1] [local44 param2])
				)
			)
		else
			(= temp1 0)
		)
		(if (and (or (>= temp0 local145) desperate) (<= temp1 local144))
			(if
				(and
					(>= [local74 param1] [local74 param2])
					(or (curPlyr countSuit: param1) trickSize)
					(or (!= trumps param1) local148 local149)
					(or (not trickSize) (== param1 theSuitLead))
					(or [local74 param1] [local39 param1])
				)
				(= plan
					(switch param1
						(1 2)
						(2 3)
						(3 4)
						(4 5)
					)
				)
			)
			(if
				(and
					(not plan)
					(>= [local74 param2] [local74 param1])
					(or (curPlyr countSuit: param2) trickSize)
					(or (!= trumps param2) local148 local149)
					(or (not trickSize) (== param2 theSuitLead))
					(or [local74 param2] [local39 param2])
				)
				(= plan
					(switch param2
						(1 2)
						(2 3)
						(3 4)
						(4 5)
					)
				)
			)
		)
		(return plan)
	)

	(method (checkForceTopOne param1 &tmp temp0 temp1 [temp2 5] temp7 temp8)
		(for ((= temp7 1)) (<= temp7 4) ((++ temp7))
			(= [local109 temp7] [local74 temp7])
		)
		(localproc_0)
		(for ((= temp7 1)) (<= temp7 4) ((++ temp7))
			(= temp0
				(-
					(+
						[local74 1]
						[local74 2]
						[local74 3]
						[local74 4]
						[local39 [local109 temp7]]
					)
					[local74 [local109 temp7]]
				)
			)
			(if (not param1)
				(= temp1
					(-
						(+
							[local79 1]
							[local79 2]
							[local79 3]
							[local79 4]
							[local44 [local109 temp7]]
						)
						[local79 [local109 temp7]]
					)
				)
			else
				(= temp1 0)
			)
			(if (and (or (>= temp0 local145) desperate) (<= temp1 local144))
				(switch [local109 temp7]
					(1
						(= [temp2 1] 0)
						(= [temp2 2] [local74 2])
						(= [temp2 3] [local74 3])
						(= [temp2 4] [local74 4])
					)
					(2
						(= [temp2 1] [local74 1])
						(= [temp2 2] 0)
						(= [temp2 3] [local74 3])
						(= [temp2 4] [local74 4])
					)
					(3
						(= [temp2 1] [local74 1])
						(= [temp2 2] [local74 2])
						(= [temp2 3] 0)
						(= [temp2 4] [local74 4])
					)
					(4
						(= [temp2 1] [local74 1])
						(= [temp2 2] [local74 2])
						(= [temp2 3] [local74 3])
						(= [temp2 4] 0)
					)
				)
				(cond
					((not trickSize)
						(switch
							(Max [temp2 1] [temp2 2] [temp2 3] [temp2 4])
							([temp2 1]
								(if
									(and
										(or (!= trumps 1) local148 local149)
										(or
											(and
												(== local146 global429)
												[local49 1]
											)
											(and
												(== local146 global431)
												[local54 1]
											)
										)
										(or (not trickSize) (== 1 theSuitLead))
										(or [local74 1] [local39 1])
									)
									(= plan 2)
									(= temp7 4)
								)
							)
							([temp2 2]
								(if
									(and
										(not plan)
										(or (!= trumps 2) local148 local149)
										(or
											(and
												(== local146 global429)
												[local49 2]
											)
											(and
												(== local146 global431)
												[local54 2]
											)
										)
										(or (not trickSize) (== 2 theSuitLead))
										(or [local74 2] [local39 2])
									)
									(= plan 3)
									(= temp7 4)
								)
							)
							([temp2 3]
								(if
									(and
										(not plan)
										(or (!= trumps 3) local148 local149)
										(or
											(and
												(== local146 global429)
												[local49 3]
											)
											(and
												(== local146 global431)
												[local54 3]
											)
										)
										(or (not trickSize) (== 3 theSuitLead))
										(or [local74 3] [local39 3])
									)
									(= temp7 (= plan 4))
								)
							)
							([temp2 4]
								(if
									(and
										(not plan)
										(or (!= trumps 4) local148 local149)
										(or
											(and
												(== local146 global429)
												[local49 4]
											)
											(and
												(== local146 global431)
												[local54 4]
											)
										)
										(or (not trickSize) (== 4 theSuitLead))
										(or [local74 4] [local39 4])
									)
									(= plan 5)
									(= temp7 4)
								)
							)
						)
						(if (not plan)
							(for ((= temp8 1)) (<= temp8 4) ((++ temp8))
								(if
									(and
										[temp2 temp8]
										(switch curPlyr
											(global429 [local49 temp8])
											(else [local54 temp8])
										)
										(or (!= trumps temp8) local148 local149)
										(or
											(not trickSize)
											(== temp7 theSuitLead)
										)
										(or [local74 temp8] [local39 temp8])
									)
									(= plan
										(switch temp8
											(1 2)
											(2 3)
											(3 4)
											(4 5)
										)
									)
								)
							)
						)
					)
					(
						(and
							(not plan)
							(!= theSuitLead [local109 temp7])
							(or (!= trumps [local109 temp7]) local148 local149)
							(or [local74 theSuitLead] [local39 theSuitLead])
						)
						(= plan
							(switch theSuitLead
								(1 2)
								(2 3)
								(3 4)
								(4 5)
							)
						)
						(= temp7 4)
					)
				)
			)
		)
		(return plan)
	)

	(method (checkTopLong param1 &tmp temp0 temp1 temp2)
		(for ((= temp0 1)) (<= temp0 4) ((++ temp0))
			(= [local109 temp0] [local59 temp0])
		)
		(localproc_0)
		(for ((= temp0 1)) (<= temp0 4) ((++ temp0))
			(if (not param1)
				(= temp2
					(-
						(+
							[local44 1]
							[local44 2]
							[local44 3]
							[local44 4]
							[local64 [local109 temp0]]
						)
						[local44 [local109 temp0]]
					)
				)
			else
				(= temp2 0)
			)
			(if
				(and
					(or
						(>= (+ local147 [local59 [local109 temp0]]) local145)
						desperate
					)
					(<= temp2 local144)
					(or trickSize (curPlyr countSuit: [local109 temp0]))
					(or (!= trumps [local109 temp0]) local148 local149)
					(or (not trickSize) (== [local109 temp0] theSuitLead))
				)
				(= plan
					(switch [local109 temp0]
						(1 6)
						(2 7)
						(3 8)
						(4 9)
					)
				)
				(= temp0 4)
			)
		)
		(return plan)
	)

	(method (checkTopFin param1 &tmp temp0 temp1 temp2)
		(for ((= temp0 1)) (<= temp0 4) ((++ temp0))
			(= [local109 temp0] [local99 temp0])
		)
		(localproc_0)
		(for ((= temp0 1)) (<= temp0 4) ((++ temp0))
			(= temp1
				(+
					[local39 1]
					[local39 2]
					[local39 3]
					[local39 4]
					[local84 [local109 temp0]]
				)
			)
			(if (not param1)
				(= temp2
					(+
						[local44 1]
						[local44 2]
						[local44 3]
						[local44 4]
						[local89 [local109 temp0]]
					)
				)
			else
				(= temp2 0)
			)
			(if
				(and
					(or (>= temp1 local145) desperate)
					(<= temp2 local144)
					[local99 [local109 temp0]]
					[local94 [local109 temp0]]
					(or (curPlyr countSuit: [local109 temp0]) trickSize)
					(<
						[local39 [local109 temp0]]
						(Max
							(LHO countSuit: [local109 temp0])
							(RHO countSuit: [local109 temp0])
						)
					)
				)
				(switch [local109 temp0]
					(1
						(cond
							(
								(and
									(not plan)
									(> [local94 [local109 temp0]] 11)
									(or (== curPlyr global429) trickSize)
								)
								(= plan 14)
								(= temp0 4)
							)
							(
								(and
									(< [local94 [local109 temp0]] 15)
									(or (== curPlyr global431) trickSize)
								)
								(= plan 10)
								(= temp0 4)
							)
							(else
								(= plan 0)
							)
						)
					)
					(2
						(cond
							(
								(and
									(> [local94 [local109 temp0]] 11)
									(or (== curPlyr global429) trickSize)
								)
								(= plan 15)
								(= temp0 4)
							)
							(
								(and
									(< [local94 [local109 temp0]] 15)
									(or (== curPlyr global431) trickSize)
								)
								(= plan 11)
								(= temp0 4)
							)
							(else
								(= plan 0)
							)
						)
					)
					(3
						(cond
							(
								(and
									(> [local94 [local109 temp0]] 11)
									(or (== curPlyr global429) trickSize)
								)
								(= plan 16)
								(= temp0 4)
							)
							(
								(and
									(< [local94 [local109 temp0]] 15)
									(or (== curPlyr global431) trickSize)
								)
								(= plan 12)
								(= temp0 4)
							)
							(else
								(= plan 0)
							)
						)
					)
					(4
						(cond
							(
								(and
									(> [local94 [local109 temp0]] 11)
									(or (== curPlyr global429) trickSize)
								)
								(= plan 17)
								(= temp0 4)
							)
							(
								(and
									(< [local94 [local109 temp0]] 15)
									(or (== curPlyr global431) trickSize)
								)
								(= plan 13)
								(= temp0 4)
							)
							(else
								(= plan 0)
							)
						)
					)
				)
			)
		)
		(return plan)
	)

	(method (checkNFLT param1 &tmp temp0 temp1 temp2)
		(for ((= temp0 1)) (<= temp0 4) ((++ temp0))
			(= [local109 temp0] [local139 temp0])
		)
		(localproc_0)
		(for ((= temp0 1)) (<= temp0 4) ((++ temp0))
			(= temp1
				(+
					[local39 1]
					[local39 2]
					[local39 3]
					[local39 4]
					[local134 [local109 temp0]]
				)
			)
			(if (not param1)
				(= temp2 (+ [local44 1] [local44 2] [local44 3] [local44 4]))
			else
				(= temp2 0)
			)
			(if
				(and
					(or (>= temp1 local145) desperate)
					(<= temp2 local144)
					[local139 [local109 temp0]]
					[local94 [local109 temp0]]
					(or (curPlyr countSuit: [local109 temp0]) trickSize)
				)
				(switch [local109 temp0]
					(1
						(cond
							(
								(and
									(> [local94 [local109 temp0]] 11)
									(or (== curPlyr global429) trickSize)
								)
								(= plan 14)
								(= temp0 4)
							)
							(
								(and
									(< [local94 [local109 temp0]] 15)
									(or (== curPlyr global431) trickSize)
								)
								(= plan 10)
								(= temp0 4)
							)
							(else
								(= plan 0)
							)
						)
					)
					(2
						(cond
							(
								(and
									(> [local94 [local109 temp0]] 11)
									(or (== curPlyr global429) trickSize)
								)
								(= plan 15)
								(= temp0 4)
							)
							(
								(and
									(< [local94 [local109 temp0]] 15)
									(or (== curPlyr global431) trickSize)
								)
								(= plan 11)
								(= temp0 4)
							)
							(else
								(= plan 0)
							)
						)
					)
					(3
						(cond
							(
								(and
									(> [local94 [local109 temp0]] 11)
									(or (== curPlyr global429) trickSize)
								)
								(= plan 16)
								(= temp0 4)
							)
							(
								(and
									(< [local94 [local109 temp0]] 15)
									(or (== curPlyr global431) trickSize)
								)
								(= plan 12)
								(= temp0 4)
							)
							(else
								(= plan 0)
							)
						)
					)
					(4
						(cond
							(
								(and
									(> [local94 [local109 temp0]] 11)
									(or (== curPlyr global429) trickSize)
								)
								(= plan 17)
								(= temp0 4)
							)
							(
								(and
									(< [local94 [local109 temp0]] 15)
									(or (== curPlyr global431) trickSize)
								)
								(= plan 13)
								(= temp0 4)
							)
							(else
								(= plan 0)
							)
						)
					)
				)
			)
		)
		(return plan)
	)

	(method (checkForceFour &tmp temp0)
		(for ((= temp0 1)) (<= temp0 4) ((++ temp0))
			(= [local109 temp0] [local74 temp0])
		)
		(localproc_0)
		(for ((= temp0 1)) (<= temp0 4) ((++ temp0))
			(if
				(and
					(curPlyr countSuit: [local109 temp0])
					(or (!= trumps [local109 temp0]) local148 local149)
					(or [local74 [local109 temp0]] [local39 [local109 temp0]])
				)
				(= plan
					(switch [local109 temp0]
						(1 2)
						(2 3)
						(3 4)
						(4 5)
					)
				)
			)
		)
		(return plan)
	)

	(method (setCurPlyr)
		(= curPlyr (Dealer curPlayer:))
		(= pard (curPlyr partner:))
		(= RHO (curPlyr RHO:))
		(= LHO (curPlyr LHO:))
	)

	(method (winCheap param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(= temp0 (gTrick highOfSuitLead:))
		(= temp3 (= temp4 0))
		(= temp7 99)
		(for ((= temp1 0)) (< temp1 (LHO size:)) ((++ temp1))
			(= temp2 (LHO at: temp1))
			(if (and (== (temp2 suit:) param1) (> (temp2 rank:) temp0))
				(= temp4 (temp2 rank:))
			)
		)
		(if (> temp4 temp0)
			(= temp0 temp4)
		)
		(= temp5 (curPlyr hasCard: param1 (| temp0 $0f00)))
		(= temp6 (pard hasCard: param1 (| temp0 $0f00)))
		(for ((= temp1 0)) (< temp1 (curPlyr size:)) ((++ temp1))
			(= temp2 (curPlyr at: temp1))
			(if (and (== (temp2 suit:) param1) (> temp7 (temp2 rank:) temp0))
				(= temp7 (temp2 rank:))
				(= temp3 temp2)
			)
		)
		(cond
			(
				(and
					(!= temp3 0)
					(or
						(and temp6 (== trickSize 1))
						(and (not temp4) (== pard (gTrick highPlayer:)))
					)
					(or
						(not (SortArray isCurrent: temp3))
						(and
							(>= temp5 temp6)
							(>= [local114 param1] [local129 param1])
							(or (== trickSize 2) (> [local129 param1] temp6))
						)
					)
				)
				(= temp3 0)
			)
			(
				(and
					(!= temp3 0)
					(not temp4)
					(not (self gotAnEntry: param1 pard))
					(== temp5 [local114 param1])
					(> [local129 param1] [local114 param1])
					(> [local39 param1] temp5)
				)
				(= temp3 (self topCard: param1))
			)
		)
		(if
			(>=
				[local39 param1]
				(+ (LHO countSuit: param1) (RHO countSuit: param1))
			)
			(= temp3 (self topCard: param1))
		)
		(return temp3)
	)

	(method (checkHoldUp param1 param2 &tmp temp0 temp1 temp2 temp3 [temp4 13])
		(if
			(or
				(>
					(proc710_0 2 param2)
					(Max (LHO countSuit: param2) (RHO countSuit: param2))
				)
				(>
					(proc710_0 3 param2)
					(Max (LHO countSuit: param2) (RHO countSuit: param2))
				)
				(and (!= trumps 5) (or [local49 trumps] [local54 trumps]))
			)
			(return 0)
		)
		(for ((= temp0 0)) (< temp0 13) ((++ temp0))
			(= [temp4 temp0]
				(switch param2
					(1 [global162 temp0])
					(2 [global149 temp0])
					(3 [global136 temp0])
					(4 [global123 temp0])
				)
			)
		)
		(= temp0 0)
		(= temp2 0)
		(= temp3 0)
		(while (< temp0 5)
			(if (<= 1 [temp4 temp0] 2)
				(++ temp2)
			else
				(++ temp3)
			)
			(++ temp0)
		)
		(if
			(or
				(>=
					temp2
					(/ (+ (LHO countSuit: param2) (RHO countSuit: param2) -1) 2)
				)
				(and (> temp3 3) (> [temp4 0] 2) (> [temp4 1] 2))
				(and
					(== temp2 2)
					(> [temp4 0] 2)
					(not (and (> [temp4 1] 2) (> [temp4 2] 2)))
				)
				(and
					(== temp2 3)
					(not (and (> [temp4 0] 2) (> [temp4 1] 2) (> [temp4 5] 2)))
				)
			)
			(return 0)
		else
			(return 1)
		)
	)

	(method (verifiedCard param1 &tmp temp0)
		(= temp0 (gTrick suitLead:))
		(if
			(and
				(IsObject param1)
				(curPlyr countSuit: temp0)
				(!= (param1 suit:) temp0)
			)
			(= param1 (self bottomCard: temp0))
		)
		(if (not (IsObject param1))
			(if (curPlyr countSuit: temp0)
				(= param1 (self bottomCard: temp0))
			else
				(= param1 (curPlyr at: (Random 0 (- (curPlyr size:) 1))))
			)
		)
		(return param1)
	)

	(method (checkFinCard param1 &tmp temp0 temp1)
		(= temp0 0)
		(cond
			(
				(and
					(= temp0 (proc710_0 14 param1))
					(or
						(== (temp0 owner:) curPlyr)
						(== temp0 (gTrick highCard:))
					)
				))
			(
				(and
					(= temp0 (proc710_0 12 param1))
					(or
						(and
							(>= temp0 11)
							(== curPlyr global431)
							(OneOf temp0 17 20 23)
						)
						(and
							(<= temp0 15)
							(== curPlyr global429)
							(OneOf temp0 2 5 8)
						)
					)
				)
				(= temp0 (self topCard: param1))
			)
			(
				(and
					(= temp1 (proc710_0 12 param1))
					(or
						(and (>= temp1 11) (== curPlyr global431))
						(and (<= temp1 15) (== curPlyr global429))
					)
					(= temp0 (self topCard: param1))
					(or
						(<
							(-
								(SortArray isCurrent: (gTrick highCard:))
								(SortArray isCurrent: temp0)
							)
							2
						)
						(and
							(OneOf temp1 3 6 9 18 21 24)
							(<
								(-
									(+
										(SortArray
											isCurrent: (gTrick highCard:)
										)
										1
									)
									(SortArray isCurrent: temp0)
								)
								5
							)
						)
					)
				)
				(= temp0 (self bottomCard: param1))
			)
			(
				(and
					(= temp0 (proc710_0 12 param1))
					(or
						(and (>= temp0 11) (== curPlyr global431))
						(and (<= temp0 15) (== curPlyr global429))
					)
				)
				(= temp0 (self getSecondBest: param1))
			)
			(else
				(= temp0 0)
			)
		)
		(if
			(and
				temp0
				(IsObject temp0)
				(< (temp0 rank:) (gTrick highOfSuitLead:))
				(!= (gTrick highPlayer:) pard)
			)
			(= temp0 0)
		)
		(return temp0)
	)

	(method (getSecondBest param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp0 0)
		(= temp2 13)
		(while (< temp0 (curPlyr size:))
			(if
				(and
					(<
						(= temp1 (SortArray isCurrent: (curPlyr at: temp0)))
						temp2
					)
					(== param1 ((curPlyr at: temp0) suit:))
				)
				(= temp2 temp1)
			)
			(++ temp0)
		)
		(= temp0 0)
		(= temp4 13)
		(= temp3 0)
		(while (< temp0 (curPlyr size:))
			(if
				(and
					(<
						(= temp1 (SortArray isCurrent: (curPlyr at: temp0)))
						temp4
					)
					(!= temp1 temp2)
					(== param1 ((curPlyr at: temp0) suit:))
				)
				(= temp4 temp1)
				(= temp3 temp0)
			)
			(++ temp0)
		)
		(cond
			((> (- 14 temp4) (gTrick highOfSuitLead:))
				(= temp2 (curPlyr at: temp3))
			)
			(
				(and
					(> (- 14 temp2) (gTrick highOfSuitLead:))
					(!= (gTrick highPlayer:) pard)
				)
				(= temp2 (self topCard: param1))
			)
			(else
				(= temp2 (self bottomCard: param1))
			)
		)
		(return temp2)
	)

	(method (checkSplitTops param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12)
		(= temp5 [local114 param1])
		(= temp6 [local129 param1])
		(= temp12 ((self topCard: param1) rank:))
		(= temp11 (gTrick highOfSuitLead:))
		(if
			(and
				temp5
				(or
					(and
						(or (== param1 trumps) (not (gTrick highTrump:)))
						(not
							(curPlyr
								hasCard:
									param1
									(| (gTrick highOfSuitLead:) $0f00)
							)
						)
					)
					(and (!= param1 trumps) (gTrick highTrump:))
					(and
						(not temp6)
						(not trickSize)
						(not (LHO countSuit: param1))
						(not (RHO countSuit: param1))
					)
					(and
						trickSize
						(== (gTrick highPlayer:) pard)
						(==
							(- temp12 temp11)
							(curPlyr
								hasCard:
									param1
									(| (gTrick highOfSuitLead:) $0f00)
							)
						)
						(or
							(< [local39 param1] 4)
							[local129 param1]
							(self gotAnEntry: param1)
						)
					)
				)
			)
			(return (self bottomCard: param1))
		)
		(= temp0 0)
		(= temp2 0)
		(= temp3 0)
		(while (< temp0 13)
			(cond
				(
					(or
						(>
							(= temp1
								(switch param1
									(1 [global162 temp0])
									(2 [global149 temp0])
									(3 [global136 temp0])
									(4 [global123 temp0])
								)
							)
							2
						)
						(not temp1)
					)
					(= temp0 13)
				)
				((== temp1 1)
					(++ temp2)
					(if (== temp0 0)
						(= temp10 global429)
					)
				)
				(else
					(++ temp3)
					(if (== temp0 0)
						(= temp10 global431)
					)
				)
			)
			(++ temp0)
		)
		(= temp4 (+ temp2 temp3))
		(if (!= curPlyr temp10)
			(= temp10 0)
		)
		(if (== curPlyr global429)
			(= temp8 temp2)
			(= temp9 temp3)
		else
			(= temp8 temp3)
			(= temp9 temp2)
		)
		(cond
			(trickSize
				(if
					(or
						(and
							(== trickSize 3)
							(== pard (gTrick highPlayer:))
							(or
								(> temp6 temp9)
								(>= temp6 temp5)
								(self gotAnEntry: param1)
							)
						)
						(and
							(== trickSize 2)
							(not
								((curPlyr LHO:)
									hasCard:
										param1
										(| (gTrick highOfSuitLead:) $0f00)
								)
							)
							(< temp4 (Max temp5 temp6))
							(== pard (gTrick highPlayer:))
							(or (not temp10) (> temp5 2))
							(or
								(> temp6 temp9)
								(>= temp6 temp5)
								(self gotAnEntry: param1)
								(not temp8)
							)
						)
						(and
							(== trickSize 1)
							temp9
							(or
								(> temp6 temp9)
								(>= temp6 temp5)
								(self gotAnEntry: param1)
								(not temp8)
							)
						)
					)
					(= temp7 (self bottomCard: param1))
				else
					(= temp7 (self topCard: param1))
				)
			)
			(
				(or
					(> temp4 2)
					(and
						(>= temp4 (LHO countSuit: param1))
						(>= temp4 (RHO countSuit: param1))
					)
				)
				(if (or (and temp9 (>= temp5 temp6)) (not temp8))
					(= temp7 (self bottomCard: param1))
				else
					(= temp7 (self topCard: param1))
				)
			)
			((and temp8 (not temp9))
				(= temp7 (self topCard: param1))
			)
			((and temp9 (not temp8))
				(= temp7 (self bottomCard: param1))
			)
			((== temp8 temp5)
				(= temp7 (self topCard: param1))
			)
			((== temp9 temp6)
				(= temp7 (self bottomCard: param1))
			)
			((and (>= temp5 temp4) (>= temp6 temp4))
				(if (< temp5 temp6)
					(= temp7 (self topCard: param1))
				else
					(= temp7 (self bottomCard: param1))
				)
			)
			(else
				(= temp7 (self bottomCard: param1))
			)
		)
		(return temp7)
	)

	(method (gotAnEntry param1 param2 param3 &tmp temp0 temp1 temp2 temp3 temp4)
		(if (< argc 2)
			(= param2 curPlyr)
		)
		(if (== param2 global429)
			(= temp3 1)
		else
			(= temp3 2)
		)
		(= temp0 1)
		(= temp4 0)
		(while (<= temp0 4)
			(if (and param3 (gTrick size:))
				(= temp0 theSuitLead)
			)
			(for ((= temp1 0)) (< temp1 13) ((++ temp1))
				(if
					(and
						(!= temp0 param1)
						(==
							temp3
							(switch temp0
								(1 [global162 temp1])
								(2 [global149 temp1])
								(3 [global136 temp1])
								(4 [global123 temp1])
							)
						)
						(= temp2 temp1)
						(= temp1 13)
						(or
							(< temp2 [local129 temp0])
							(>
								[local129 temp0]
								(Max [local119 temp0] [local124 temp0])
							)
						)
					)
					(= temp4 temp0)
					(= temp0 4)
				)
			)
			(if (and param3 (gTrick size:))
				(= temp0 4)
			)
			(++ temp0)
		)
		(return temp4)
	)

	(method (loadFinArray param1 &tmp temp0)
		(for ((= temp0 0)) (< temp0 13) ((++ temp0))
			(= [global201 temp0]
				(switch param1
					(4 [global123 temp0])
					(1 [global162 temp0])
					(2 [global149 temp0])
					(3 [global136 temp0])
				)
			)
			(if (> [global201 temp0] 2)
				(= [global201 temp0] 0)
			)
		)
	)

	(method (setFinCard param1 param2 &tmp temp0 temp1 temp2 temp3)
		(= temp0 0)
		(= temp1 0)
		(while (< temp0 (curPlyr size:))
			(if (== [global201 param1] 1)
				(= temp3 (global429 at: temp0))
			else
				(= temp3 (global431 at: temp0))
			)
			(if (IsObject temp3)
				(if
					(and
						(== (= temp2 (SortArray isCurrent: temp3)) param1)
						(== param2 (temp3 suit:))
					)
					(= temp1 temp0)
					(= temp0 13)
				)
			else
				(= temp0 13)
			)
			(++ temp0)
		)
		(if (== [global201 param1] 1)
			(global429 at: temp1)
			(return)
		else
			(global431 at: temp1)
			(return)
		)
	)

	(method (finesse param1 param2 param3 &tmp [temp0 2] temp2 temp3 temp4 temp5 [temp6 2] temp8 temp9 temp10)
		(= temp2 (= temp3 (= temp4 (= temp5 (= temp8 0)))))
		(= local146 (gTrick leader:))
		(= temp10 (= finCard 0))
		(cond
			([global201 0]
				(= finChance 50)
				(= mustLose 0)
				(cond
					([global201 1]
						(cond
							([global201 2]
								(= temp10 0)
							)
							(
								(and
									[global201 3]
									[global201 4]
									(!= [global201 0] [global201 1])
								)
								(if
									(and
										(or
											[global201 5]
											(== [global201 3] [global201 4])
										)
										(or (> param1 3) (> param2 3))
										(> param1 2)
										(> param2 2)
									)
									(= finTricks 2)
								else
									(= finTricks 1)
								)
								(= temp10 12)
							)
							(
								(and
									[global201 3]
									(or
										[global201 4]
										(== [global201 0] [global201 3])
										(== [global201 1] [global201 3])
									)
								)
								(if [global201 4]
									(cond
										((!= [global201 3] [global201 4])
											(= finCard
												(self setFinCard: 4 param3)
											)
											(if
												(and
													[global201 5]
													(or
														(> param1 3)
														(> param2 3)
													)
													(> param1 2)
													(> param2 2)
												)
												(= finTricks 2)
											else
												(= finTricks 1)
											)
										)
										(
											(and
												(== [global201 4] [global201 0])
												(> param1 1)
												(> param2 1)
											)
											(= finTricks 2)
										)
										(else
											(= finTricks 1)
										)
									)
								else
									(= finTricks 1)
								)
								(if (== [global201 3] 1)
									(= temp10 1)
								else
									(= temp10 16)
								)
							)
							(
								(and
									[global201 4]
									(or
										(==
											[global201 0]
											[global201 1]
											[global201 4]
										)
										(and
											[global201 5]
											(== [global201 0] [global201 1])
											(or
												(== [global201 0] [global201 5])
												[global201 6]
											)
											(or (> param2 3) (> param1 3))
											(> param2 1)
											(> param1 1)
										)
									)
								)
								(= finChance 75)
								(= mustLose (= finTricks 1))
								(= noFinLoserChance 25)
								(= noFinLoserTricks 2)
								(if [global201 6]
									(if
										(and
											(or (> param2 3) (> param1 3))
											(> param2 2)
											(> param1 2)
										)
										(= finTricks 2)
										(= noFinLoserTricks 3)
									else
										(= finTricks 1)
										(= noFinLoserTricks 2)
									)
									(cond
										((!= [global201 0] [global201 4])
											(= finCard
												(self setFinCard: 4 param3)
											)
										)
										((!= [global201 0] [global201 5])
											(= finCard
												(self setFinCard: 5 param3)
											)
										)
										((!= [global201 0] [global201 6])
											(= finCard
												(self setFinCard: 6 param3)
											)
										)
									)
								)
								(if (== [global201 0] 1)
									(= temp10 1)
								else
									(= temp10 16)
								)
							)
						)
					)
					([global201 2]
						(= finTricks 1)
						(cond
							((and [global201 3] [global201 4])
								(cond
									(
										(and
											(==
												[global201 0]
												[global201 2]
												[global201 3]
												[global201 4]
											)
											(> param2 2)
											(> param1 2)
										)
										(= finTricks 3)
									)
									(
										(and
											(or (> param1 2) (> param2 2))
											(> param1 1)
											(> param2 1)
										)
										(= finTricks 2)
									)
									(
										(or
											(and (> param1 0) (> param2 0))
											(and
												(> param2 1)
												(or
													(!= local146 global429)
													trickSize
												)
											)
											(and
												(> param1 1)
												(or
													(== local146 global431)
													trickSize
												)
											)
										)
										(= finTricks 1)
									)
									(else
										(= temp10 (= finTricks 0))
									)
								)
								(cond
									((!= [global201 2] [global201 0])
										(= finCard (self setFinCard: 2 param3))
										(if (== [global201 0] 1)
											(= temp10 3)
										else
											(= temp10 18)
										)
									)
									((!= [global201 3] [global201 0])
										(= finCard (self setFinCard: 3 param3))
										(if (== [global201 0] 1)
											(= temp10 3)
										else
											(= temp10 18)
										)
									)
									((!= [global201 4] [global201 0])
										(= finCard (self setFinCard: 4 param3))
										(if (== [global201 0] 1)
											(= temp10 3)
										else
											(= temp10 18)
										)
									)
									((== [global201 0] 1)
										(= temp10 3)
									)
									(else
										(= temp10 18)
									)
								)
							)
							([global201 3]
								(cond
									(
										(and
											(==
												[global201 2]
												[global201 3]
												[global201 0]
											)
											(> param1 1)
											(> param2 1)
										)
										(= finTricks 2)
										(if (== [global201 0] 1)
											(= temp10 3)
										else
											(= temp10 18)
										)
									)
									(
										(or
											(and param1 param2)
											(and
												(== [global201 0] 1)
												(or
													(!= local146 global429)
													trickSize
												)
											)
											(and
												(== [global201 0] 2)
												(or
													(!= local146 global431)
													trickSize
												)
											)
										)
										(= finTricks 1)
									)
									(else
										(= temp10 (= finTricks 0))
									)
								)
								(if (== [global201 0] 1)
									(= temp10 1)
								else
									(= temp10 16)
								)
							)
							([global201 4]
								(cond
									(
										(==
											[global201 2]
											[global201 4]
											[global201 0]
										)
										(cond
											((== [global201 0] 1)
												(cond
													((> param2 1)
														(= finChance 25)
														(= finTricks 2)
													)
													(
														(or
															(== param2 1)
															(!=
																local146
																global429
															)
															trickSize
														)
														(= finTricks 1)
													)
													(else
														(= temp10
															(= finTricks 0)
														)
													)
												)
											)
											((> param1 1)
												(= finChance 25)
												(= finTricks 2)
											)
											(
												(or
													(== param1 1)
													(!= local146 global431)
													trickSize
												)
												(= finTricks 1)
											)
											(else
												(= temp10 (= finTricks 0))
											)
										)
										(if (== [global201 0] 1)
											(= temp10 3)
										else
											(= temp10 18)
										)
									)
									(
										(and
											[global201 5]
											[global201 6]
											(== [global201 0] [global201 2])
										)
										(cond
											((and (> param2 2) (> param1 2))
												(= finTricks
													(-
														1
														(Max
															param2
															param1
														)
													)
												)
											)
											(
												(and
													(== [global201 0] 1)
													(> param1 2)
													(> param2 1)
												)
												(= finTricks 2)
											)
											(
												(and
													(== [global201 0] 2)
													(> param1 1)
													(> param2 2)
												)
												(= finTricks 2)
											)
											(
												(and
													(== [global201 0] 1)
													(== param1 2)
												)
												(= finTricks 1)
											)
											(
												(and
													(== [global201 0] 2)
													(== param2 2)
												)
												(= finTricks 1)
											)
											(
												(and
													(== [global201 0] 1)
													(== param1 2)
													(or
														(!= local146 global429)
														trickSize
													)
												)
												(= finTricks 1)
											)
											(
												(and
													(== [global201 0] 1)
													(== param2 2)
													(or
														(!= local146 global431)
														trickSize
													)
												)
												(= finTricks 1)
											)
											(else
												(= temp10 (= finTricks 0))
											)
										)
										(if (> finTricks 1)
											(= finChance 25)
										else
											(= finChance 50)
										)
										(cond
											((!= [global201 0] [global201 4])
												(= finCard
													(self setFinCard: 4 param3)
												)
											)
											((!= [global201 0] [global201 5])
												(= finCard
													(self setFinCard: 5 param3)
												)
											)
											((!= [global201 0] [global201 6])
												(= finCard
													(self setFinCard: 6 param3)
												)
											)
										)
										(if (== [global201 0] 1)
											(= temp10 3)
										else
											(= temp10 18)
										)
									)
									(
										(and
											(== [global201 0] [global201 2])
											(== [global201 0] [global201 5])
										)
										(= finChance 25)
										(= finCard (self setFinCard: 4 param3))
										(if (== [global201 0] 1)
											(= temp10 3)
										else
											(= temp10 18)
										)
									)
									(else
										(= finChance 50)
										(cond
											((== [global201 0] [global201 2])
												(if (== [global201 0] 1)
													(= temp10 1)
												else
													(= temp10 16)
												)
											)
											((== [global201 0] 1)
												(= temp10 17)
											)
											(else
												(= temp10 2)
											)
										)
									)
								)
							)
							((== [global201 0] [global201 2])
								(= finChance 50)
								(if (== [global201 0] 1)
									(= temp10 1)
								else
									(= temp10 16)
								)
							)
							(else
								(= finChance 50)
								(= mustLose 1)
								(if (== [global201 0] 1)
									(= temp10 17)
								else
									(= temp10 2)
								)
							)
						)
					)
					([global201 3]
						(= finTricks 1)
						(cond
							((and [global201 4] [global201 5])
								(= finChance 75)
								(= mustLose 1)
								(= finTricks 2)
								(cond
									((!= [global201 0] [global201 3])
										(= finCard (self setFinCard: 3 param3))
									)
									((!= [global201 0] [global201 4])
										(= finCard (self setFinCard: 4 param3))
									)
									((!= [global201 0] [global201 5])
										(= finCard (self setFinCard: 5 param3))
									)
								)
								(if (== [global201 0] 1)
									(= temp10 3)
								else
									(= temp10 18)
								)
							)
							(
								(and
									[global201 4]
									(== [global201 0] [global201 3])
									(== [global201 0] [global201 4])
								)
								(= finChance 75)
								(= mustLose 1)
								(if (== [global201 0] 1)
									(= temp10 3)
								else
									(= temp10 18)
								)
							)
							(
								(and
									[global201 5]
									(== [global201 0] [global201 3])
									(or
										(== [global201 0] [global201 5])
										[global201 6]
									)
								)
								(= finChance 38)
								(= mustLose 1)
								(cond
									((!= [global201 0] [global201 5])
										(= finCard (self setFinCard: 5 param3))
									)
									((!= [global201 0] [global201 6])
										(= finCard (self setFinCard: 6 param3))
									)
								)
								(if (== [global201 0] 1)
									(= temp10 3)
								else
									(= temp10 18)
								)
							)
							((== [global201 0] [global201 3])
								(= finChance 25)
								(= mustLose 1)
								(if (== [global201 0] 1)
									(= temp10 3)
								else
									(= temp10 18)
								)
							)
							(else
								(= temp10 0)
							)
						)
					)
					(
						(==
							[global201 4]
							[global201 5]
							[global201 6]
							[global201 0]
						)
						(= mustLose 2)
						(= finChance 38)
						(if (== [global201 0] 1)
							(= temp10 3)
						else
							(= temp10 18)
						)
					)
					(else
						(= temp10 0)
					)
				)
			)
			([global201 1]
				(= finChance 50)
				(= finTricks (= mustLose 1))
				(cond
					([global201 2]
						(= finTricks 2)
						(cond
							([global201 3]
								(= temp10 0)
							)
							(
								(and
									[global201 4]
									[global201 5]
									(!= [global201 1] [global201 2])
								)
								(if [global201 5]
									(= finCard (self setFinCard: 5 param3))
								)
								(= temp10 13)
							)
							(
								(or
									[global201 5]
									(== [global201 1] [global201 4])
									(== [global201 2] [global201 4])
								)
								(if [global201 5]
									(= finCard (self setFinCard: 5 param3))
								)
								(if (== [global201 1] 1)
									(= temp10 6)
								else
									(= temp10 21)
								)
							)
							(
								(and
									[global201 4]
									(or
										(==
											[global201 1]
											[global201 2]
											[global201 4]
										)
										(and
											[global201 5]
											(== [global201 2] [global201 1])
											(or
												(== [global201 1] [global201 5])
												[global201 6]
											)
										)
									)
								)
								(= finChance 75)
								(if [global201 5]
									(cond
										((!= [global201 1] [global201 4])
											(= finCard
												(self setFinCard: 4 param3)
											)
										)
										((!= [global201 1] [global201 5])
											(= finCard
												(self setFinCard: 5 param3)
											)
										)
										((!= [global201 1] [global201 6])
											(= finCard
												(self setFinCard: 6 param3)
											)
										)
									)
								)
								(if (== [global201 0] 1)
									(= temp10 4)
								else
									(= temp10 19)
								)
							)
						)
					)
					([global201 3]
						(= finTricks 2)
						(cond
							((and [global201 4] [global201 5])
								(= finChance 75)
								(cond
									(
										(!=
											[global201 (= finTricks 3)]
											[global201 1]
										)
										(= finCard (self setFinCard: 3 param3))
										(if (== [global201 1] 1)
											(= temp10 6)
										else
											(= temp10 21)
										)
									)
									((!= [global201 4] [global201 1])
										(= finCard (self setFinCard: 4 param3))
										(if (== [global201 0] 1)
											(= temp10 6)
										else
											(= temp10 21)
										)
									)
									((!= [global201 5] [global201 1])
										(= finCard (self setFinCard: 5 param3))
										(if (== [global201 1] 1)
											(= temp10 6)
										else
											(= temp10 21)
										)
									)
									((== [global201 1] 1)
										(= temp10 6)
									)
									(else
										(= temp10 21)
									)
								)
							)
							([global201 4]
								(cond
									(
										(and
											(== [global201 3] [global201 4])
											(!= [global201 3] [global201 1])
										)
										(= finCard (self setFinCard: 3 param3))
										(if (== [global201 1] 1)
											(= temp10 6)
										else
											(= temp10 21)
										)
									)
									((== [global201 1] 1)
										(= temp10 6)
									)
									(else
										(= temp10 21)
									)
								)
							)
							([global201 5]
								(cond
									(
										(==
											[global201 1]
											[global201 3]
											[global201 5]
										)
										(= finChance 25)
										(if (== [global201 1] 1)
											(= temp10 6)
										else
											(= temp10 21)
										)
									)
									(
										(and
											[global201 6]
											[global201 7]
											(== [global201 1] [global201 3])
										)
										(= finChance 25)
										(cond
											((!= [global201 0] [global201 5])
												(= finCard
													(self setFinCard: 5 param3)
												)
											)
											((!= [global201 0] [global201 6])
												(= finCard
													(self setFinCard: 6 param3)
												)
											)
											((!= [global201 0] [global201 7])
												(= finCard
													(self setFinCard: 7 param3)
												)
											)
										)
										(if (== [global201 1] 1)
											(= temp10 6)
										else
											(= temp10 21)
										)
									)
									(
										(and
											(== [global201 1] [global201 3])
											(== [global201 1] [global201 6])
										)
										(= finChance 25)
										(= finCard (self setFinCard: 5 param3))
										(if (== [global201 0] 1)
											(= temp10 3)
										else
											(= temp10 18)
										)
									)
									(else
										(= finChance 50)
										(cond
											((== [global201 1] [global201 3])
												(if (== [global201 1] 1)
													(= temp10 4)
												else
													(= temp10 19)
												)
											)
											((== [global201 1] 1)
												(= temp10 5)
											)
											(else
												(= temp10 20)
											)
										)
									)
								)
							)
							((== [global201 1] [global201 3])
								(= finChance 50)
								(if (== [global201 1] 1)
									(= temp10 4)
								else
									(= temp10 19)
								)
							)
							(else
								(if (== [global201 1] 1)
									(= temp10 2)
								else
									(= temp10 17)
								)
								(= finTricks 1)
							)
						)
					)
					([global201 4]
						(cond
							((and [global201 5] [global201 6])
								(= finChance 75)
								(= finTricks (= mustLose 2))
								(cond
									((!= [global201 1] [global201 4])
										(= finCard (self setFinCard: 4 param3))
									)
									((!= [global201 1] [global201 5])
										(= finCard (self setFinCard: 5 param3))
									)
									((!= [global201 1] [global201 6])
										(= finCard (self setFinCard: 6 param3))
									)
								)
								(if (== [global201 1] 1)
									(= temp10 6)
								else
									(= temp10 21)
								)
							)
							(
								(and
									[global201 5]
									(== [global201 1] [global201 4])
									(== [global201 1] [global201 5])
								)
								(= finChance 75)
								(= mustLose 1)
								(= finTricks 2)
								(if (== [global201 1] 1)
									(= temp10 6)
								else
									(= temp10 21)
								)
							)
							(else
								(= finChance 50)
								(if (== [global201 (= mustLose 1)] 1)
									(= temp10 5)
								else
									(= temp10 20)
								)
							)
						)
					)
					(else
						(= finChance 50)
						(if (== [global201 (= mustLose 1)] 1)
							(= temp10 5)
						else
							(= temp10 20)
						)
					)
				)
			)
			([global201 2]
				(= finChance 25)
				(= mustLose 2)
				(= finTricks 1)
				(cond
					((and [global201 3] [global201 4])
						(= temp10 0)
					)
					(
						(and
							[global201 5]
							[global201 6]
							(!= [global201 2] [global201 3])
							(or (!= [global201 5] [global201 6]) [global201 7])
						)
						(if (and [global201 7] (== [global201 5] [global201 6]))
							(= finCard (self setFinCard: 7 param3))
						)
						(= temp10 14)
						(= finTricks 2)
					)
					(
						(and
							(== [global201 2] [global201 3])
							[global201 5]
							(or (== [global201 5] [global201 2]) [global201 6])
						)
						(cond
							((!= [global201 2] [global201 5])
								(= finCard (self setFinCard: 5 param3))
							)
							(
								(!=
									[global201 2]
									[global201 6]
									(= finCard (self setFinCard: 6 param3))
								))
						)
						(if (== [global201 2] 1)
							(= temp10 7)
						else
							(= temp10 22)
						)
					)
					((and [global201 4] [global201 5] [global201 6])
						(= finChance 50)
						(cond
							((!= [global201 2] [global201 4])
								(= finCard (self setFinCard: 4 param3))
							)
							((!= [global201 2] [global201 5])
								(= finCard (self setFinCard: 5 param3))
							)
							((!= [global201 2] [global201 6])
								(= finCard (self setFinCard: 6 param3))
							)
						)
						(if (== [global201 (= finTricks 2)] 1)
							(= temp10 9)
						else
							(= temp10 24)
						)
					)
					(
						(and
							[global201 4]
							[global201 5]
							(or
								(== [global201 2] [global201 4])
								(== [global201 2] [global201 5])
							)
						)
						(cond
							((!= [global201 2] [global201 4])
								(= finCard (self setFinCard: 4 param3))
							)
							((!= [global201 2] [global201 5])
								(= finCard (self setFinCard: 5 param3))
							)
						)
						(if (== [global201 2] 1)
							(= temp10 9)
						else
							(= temp10 24)
						)
					)
					((== [global201 2] [global201 4])
						(if (== [global201 2] 1)
							(= temp10 9)
						else
							(= temp10 24)
						)
					)
					((== [global201 2] 1)
						(= temp10 8)
					)
					(else
						(= temp10 23)
					)
				)
			)
			(else
				(= temp10 0)
			)
		)
		(return temp10)
	)
)

(instance workingList of List ; UNUSED
	(properties)
)

(instance sortedList of List ; UNUSED
	(properties)
)

(instance descendingCode of Code ; UNUSED
	(properties)

	(method (doit param1)
		(param1 rank:)
	)
)

