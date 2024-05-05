;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1)
(include sci.sh)
(use Main)
(use Interface)
(use Stock)
(use WL)
(use PlayDealer)
(use n315)
(use n316)
(use n317)
(use n318)
(use n322)
(use theSliders)
(use Game)

(public
	rm1 0
	proc1_1 1
)

(procedure (proc1_1)
	(return
		(and
			global323
			(not (gTheCardToss mover:))
			(not (gTheAutoCardToss mover:))
			(not (gTheAutoCardToss2 mover:))
		)
	)
)

(procedure (localproc_0 &tmp temp0 temp1)
	(cond
		((proc0_6 119)
			(return 0)
		)
		((proc0_6 118)
			(if
				(and
					(not (gTheStock size:))
					(not ((gTheWastePiles at: 0) size:))
					(>= global400 500)
					(not (gTheCardToss mover:))
					(not (gTheAutoCardToss mover:))
					(not (gTheAutoCardToss2 mover:))
				)
				(return 1)
			)
		)
		((proc0_6 127)
			(for ((= temp0 0)) (< temp0 (gTheColumns size:)) ((++ temp0))
				(if (not ((gTheColumns at: temp0) size:))
					(return 0)
				)
			)
			(if (> global400 60)
				(return 1)
			)
		)
		((proc0_6 126)
			(for ((= temp0 0)) (< temp0 (gTheColumns size:)) ((++ temp0))
				(if (not ((gTheColumns at: temp0) size:))
					(return 0)
				)
			)
			(if (> global400 125)
				(return 1)
			)
		)
		((== global400 52)
			(cond
				((proc0_6 108)
					(for
						((= temp0 (= temp1 0)))
						(< temp0 (gTheColumns size:))
						((++ temp0))
						
						(if (== ((gTheColumns at: temp0) size:) 13)
							(++ temp1)
						)
					)
					(if (== temp1 4)
						(return 1)
					)
				)
				((proc0_6 109)
					(for ((= temp0 0)) (< temp0 (gTheColumns size:)) ((++ temp0))
						(if ((gTheColumns at: temp0) size:)
							(return 0)
						)
					)
					(return 1)
				)
				(else
					(return 1)
				)
			)
		)
	)
	(return 0)
)

(instance rm1 of Rm
	(properties)

	(method (init &tmp [temp0 5])
		(= picture (+ 11 global679))
		(super init:)
		(gOptions_sol doit: 0)
		(= gTheStock theStock)
		(= global311 (= gTheFoundations theFoundations))
		(= gTheColumns theColumns)
		(= gTheReserves theReserves)
		(= global405 1)
		(= gATempList aTempList)
		(= gGameName gameName)
		(if (proc0_6 122)
			(proc322_3)
		)
		(if (proc0_6 124)
			(proc315_4)
		)
		(if (proc0_6 118)
			(proc323_3)
		)
		(proc316_1)
		(gTheColumns eachElementDo: #init)
		(gTheWastePiles eachElementDo: #init)
		(gTheReserves eachElementDo: #init)
		(gTheFoundations eachElementDo: #init)
		(gTheColumns eachElementDo: #init2)
		(gTheWastePiles eachElementDo: #init2)
		(gTheReserves eachElementDo: #init2)
		(gTheFoundations eachElementDo: #init2)
		(gTheDealer init:)
		(proc0_2)
		(if (proc0_6 118)
			((ScriptID 323 0) eachElementDo: #draw) ; theSliders
		)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4)
		(if
			(and
				global687
				(not (gTheTransferList size:))
				(not (gTheTransferList2 size:))
				(not (gTheTransferList3 size:))
			)
			(= global687 0)
			(proc323_4)
		)
		(if (and (== global685 1) (!= global685 2))
			(if script
				(script doit:)
			else
				(DisposeScript (+ 325 (- [global430 (mod global337 100)] 1)))
				(= global685 2)
			)
			(return)
		)
		(if (and (!= global685 2) (= global685 (localproc_0)))
			(= script (ScriptID (+ 325 (- [global430 (mod global337 100)] 1))))
			(script init:)
			(return)
		)
		(if (PlayDealer currentlyActive:)
			(PlayDealer doit:)
		else
			(switch state
				(0
					(if (not global303)
						(++ global303)
						(if (not (gTheDealer dealNextCard:))
							(++ state)
							(if ((gTheColumns at: 0) foundationWithin:)
								(proc0_2)
								(proc318_1 (gTheColumns at: 0))
							)
							(if global323
								(= state 2)
							)
							(self cue:)
						)
					)
				)
				(2
					(cond
						((and global678 (not (gTheCardToss mover:)))
							(if (or (not (proc0_6 101)) (not (gTheStock size:)))
								(if
									(or
										(gTheCardToss mover:)
										(gTheAutoCardToss mover:)
										(gTheAutoCardToss2 mover:)
									)
									(return)
								)
								(if
									(and
										(global311 size:)
										(= temp4
											((global311 at: 0)
												isThereADimmedObject: 1
											)
										)
									)
									(temp4
										eachElementDo: #whiten
										updateCoords:
										showUpdate:
									)
									(proc0_2)
								)
								(for
									((= temp0 0))
									(< temp0 (global311 size:))
									((++ temp0))
									
									(for
										((= temp2 0))
										(< temp2 (gTheInputList size:))
										((++ temp2))
										
										(if
											(and
												(not
													(global311
														contains:
															(gTheInputList
																at: temp2
															)
													)
												)
												((gTheInputList at: temp2) size:)
												(!=
													((gTheInputList at: temp2)
														dimRule:
													)
													8
												)
											)
											(cond
												(
													(==
														((gTheInputList at: temp2)
															dimRule:
														)
														1
													)
													(for
														((= temp3 0))
														(<
															temp3
															((gTheInputList
																	at: temp2
																)
																size:
															)
														)
														((++ temp3))
														
														(if
															(and
																((= temp1
																		((gTheInputList
																				at:
																					temp2
																			)
																			at:
																				temp3
																		)
																	)
																	faceUp:
																)
																((global311
																		at:
																			temp0
																	)
																	moveOK2:
																		temp1
																		((global311
																				at:
																					temp0
																			)
																			lastCard:
																		)
																		0
																)
															)
															(temp1 dim:)
															((gTheInputList
																	at: temp2
																)
																giveUpCards:
															)
															(gTheCardToss
																init:
																	temp1
																	(global311
																		at:
																			temp0
																	)
															)
															(= global683 0)
															(return)
														)
													)
												)
												(
													(and
														((= temp1
																((gTheInputList
																		at:
																			temp2
																	)
																	lastCard:
																)
															)
															faceUp:
														)
														((global311 at: temp0)
															moveOK2:
																temp1
																((global311
																		at:
																			temp0
																	)
																	lastCard:
																)
																0
														)
													)
													(temp1 dim:)
													((gTheInputList at: temp2)
														giveUpCards:
													)
													(gTheCardToss
														init:
															temp1
															(global311
																at: temp0
															)
													)
													(= global683 0)
													(return)
												)
											)
										)
									)
								)
							)
							(if global683
								(Print 1 0) ; "Auto Play feature is not applicable at this time."
							)
							(= global678 0)
						)
						((and (not global303) (proc1_1))
							(++ global303)
							(self cue:)
						)
					)
				)
				(3
					(gTheTransferList endHand:)
					(gTheTransferList2 endHand:)
					(gTheTransferList3 endHand:)
					(gTheInputList eachElementDo: #endHand)
					(++ global303)
					(self cue:)
				)
			)
		)
	)

	(method (cue)
		(if (PlayDealer currentlyActive:)
			(PlayDealer cue:)
		else
			(switch state
				(0
					(= global303 0)
				)
				(1
					(= global318 1)
					(= global303 0)
					(= global330 1)
					(++ state)
					(if (proc0_6 122)
						(proc322_1)
					)
					(if (proc0_6 118)
						(proc323_4)
					)
				)
				(2
					(if (proc1_1)
						(= global303 0)
						(++ state)
						(= global330 0)
					)
				)
				(3
					(proc0_2)
					(gTheDealer init:)
					(gTheDeck endHand: reShuffle:)
					(gTheStock reDeal:)
					(= global402 (= global303 (= state (= global413 0))))
					(= global400 (gTheFoundations doit:))
					(cond
						((proc0_6 100)
							(= global400 4)
						)
						((proc0_6 101)
							(= global400 4)
							(gTheFoundations
								eachElementDo: #dontBuildFoundationsYet 1
							)
						)
						((proc0_6 103)
							(= global400 4)
						)
						((proc0_6 110)
							(= global400 4)
						)
						((proc0_6 117)
							(= global400 -3)
						)
						((proc0_6 119)
							(if (== global323 1)
								(global418 eachElementDo: #init)
							)
						)
						((proc0_6 120)
							(= global407 2)
						)
						((proc0_6 121)
							(= global400 4)
						)
						((proc0_6 122)
							(= global400 4)
						)
						((proc0_6 123)
							(proc317_0)
							(= global400 3)
							(if (not global404)
								(= global684 -1)
							)
						)
						((proc0_6 124)
							(= global407 2)
							(proc315_1)
						)
						((proc0_6 125)
							(= global400 -12)
							(= global407 3)
						)
						((proc0_6 126)
							((gTheWastePiles at: 0) autoFill: 1)
						)
					)
					(= global323 (= global685 0))
					(= global678 0)
					(proc0_4)
					(gTheFoundations eachElementDo: #init 0 eachElementDo: #init2)
					(gTheStock eachElementDo: #whiten)
				)
			)
		)
	)

	(method (dispose)
		(gTheFoundations dispose:)
		(gTheColumns dispose:)
		(theStock dispose:)
		(gTheWastePiles dispose:)
		(gTheReserves dispose:)
		(super dispose:)
	)
)

(instance theStock of Stock
	(properties)
)

(instance gameName of DEdit
	(properties
		text {______________________________}
		max 24
	)
)

(instance theFoundations of WL
	(properties)

	(method (doit &tmp temp0)
		(= temp0 0)
		(if size
			(for ((= global301 0)) (< global301 size) ((++ global301))
				(+= temp0 ((self at: global301) size:))
			)
		)
		(return temp0)
	)
)

(instance theColumns of WL
	(properties)
)

(instance theReserves of WL
	(properties)
)

(instance aTempList of WL
	(properties)
)

