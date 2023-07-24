;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26)
(include sci.sh)
(use Main)
(use PQIconItem)
(use Sound)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	pqInv 0
)

(instance pqInv of PqInv
	(properties)

	(method (init)
		(= gInventory self)
		(self
			helpIconItem: invHelp
			selectIcon: invSelect
			theSlider: invSlider
			okButton: ok
			numRow: 2
			numCol: 4
			numScroll: 4
			itemWide: 35
			itemHigh: 30
			colMargin: 8
			rowMargin: 5
			add:
				funeralMemo
				ammoBaggie
				greenTicket
				evidenceCase
				hickmanStuff
				vest
				stick
				glue
				mirror
				apple
				wallet
				handgun
				shotgun
				fullClip
				emptyClip
				shells
				badge
				newspaper
				coins
				cigarette
				shoe
				pretzels
				folders
				boneBaggie
				eyeProtector
				tape
				pills
				ball
				lighter
				hairspray
				rope
				matches
				keys
				handcuffs
				torch
				stickMirror
				notebook
				protectors
				ammoBox
				hypoBaggie
				washStuff
				photo
				beer
				parkerID
				actionReports
				qualifyMemo
				manilaTicket
				crimeSceneReport
				candyBar
				sodaCan
				skeletonKey
		)
		(self
			add:
				invLook
				invHand
				invSelect
				invHelp
				ok
				invUpArrow
				invDownArrow
				invSlider
			eachElementDo: #highlightColor -1
			eachElementDo: #lowlightColor -1
			eachElementDo: #modNum 11
			state: 2048
		)
		(super init:)
		(self setPlane: 980 0 0)
	)

	(method (doit)
		(super doit: &rest)
		(if (and (== gCurRoomNum 230) curIcon (curIcon isKindOf: InvI))
			(self curIcon: handgun)
		)
	)
)

(instance ok of PQIconItem
	(properties
		noun 41
		signal 195
		mainView 980
		mainLoop 4
		helpVerb 9
	)

	(method (init)
		(self setCursor: 999 0 0)
		(= x 159)
		(= y 5)
		(super init: &rest)
	)
)

(instance invSlider of InvSlider
	(properties
		noun 51
		signal 131
		message 4
		mainView 980
		mainLoop 6
		helpVerb 9
	)

	(method (init)
		(= theUpArrow invUpArrow)
		(= theDnArrow invDownArrow)
		(self setCursor: 999 0 0)
		(= x 183)
		(= y 48)
		(super init: &rest)
	)

	(method (select)
		(if (super select: &rest)
			(return 0)
		)
	)
)

(instance invUpArrow of PQIconItem
	(properties
		noun 49
		signal 131
		message 4
		mainView 980
		mainLoop 8
		helpVerb 9
	)

	(method (init)
		(self setCursor: 999 0 0)
		(= x 183)
		(= y 41)
		(super init: &rest)
	)

	(method (select)
		(if (super select: &rest)
			(gInventory setCurIndex: (- 0 (gInventory numScroll:)))
			((gInventory theSlider:) update: -1)
			(return 0)
		)
	)
)

(instance invDownArrow of PQIconItem
	(properties
		noun 50
		signal 131
		message 4
		mainView 980
		mainLoop 7
		helpVerb 9
	)

	(method (init)
		(self setCursor: 999 0 0)
		(= x 183)
		(= y 107)
		(super init: &rest)
	)

	(method (select)
		(if (super select: &rest)
			(gInventory setCurIndex: (gInventory numScroll:))
			((gInventory theSlider:) update: 1)
			(return 0)
		)
	)
)

(instance invLook of PQIconItem
	(properties
		noun 42
		signal 129
		message 1
		mainView 980
		mainLoop 1
		helpVerb 9
	)

	(method (init)
		(self setCursor: 992 0 0)
		(= x 9)
		(= y 5)
		(super init: &rest)
	)
)

(instance invHand of PQIconItem
	(properties
		noun 43
		signal 129
		message 4
		mainView 980
		mainLoop 2
		helpVerb 9
	)

	(method (init)
		(self setCursor: 993 0 0)
		(= x 47)
		(= y 5)
		(super init: &rest)
	)
)

(instance invHelp of PQIconItem
	(properties
		noun 44
		signal 131
		message 9
		mainView 980
		mainLoop 3
		helpVerb 9
	)

	(method (init)
		(self setCursor: 989 0 0)
		(= x 122)
		(= y 5)
		(super init: &rest)
	)
)

(instance invSelect of PQIconItem
	(properties
		noun 45
		signal 129
		message 58
		mainView 980
		mainLoop 5
		helpVerb 9
	)

	(method (init)
		(self setCursor: 999 0 0)
		(= x 85)
		(= y 5)
		(super init: &rest)
	)
)

(instance stickScr of Script
	(properties)

	(method (cue)
		(stick state: (& (stick state:) $fffe))
		(stick state: (| (stick state:) $0002))
	)
)

(instance mirrorScr of Script
	(properties)

	(method (cue)
		(mirror state: (& (mirror state:) $fffe))
		(mirror state: (| (mirror state:) $0002))
	)
)

(instance funeralMemo of PQInvItem
	(properties
		noun 66
		signal 2
		message 68
		mainView 920
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gGame points: 2 67)
		)
		(super doVerb: theVerb)
	)
)

(instance ammoBaggie of PQInvItem
	(properties
		noun 2
		signal 2
		message 10
		mainView 921
	)
)

(instance greenTicket of PQInvItem
	(properties
		noun 67
		signal 2
		message 69
		mainView 922
	)
)

(instance evidenceCase of PQInvItem
	(properties
		noun 4
		signal 2
		message 12
		mainView 923
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 4) ; Do
			(gInventory hide:)
			(gCaseInv showSelf: global122)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance hickmanStuff of PQInvItem
	(properties
		noun 6
		signal 2
		message 14
		mainView 925
	)
)

(instance vest of PQInvItem
	(properties
		noun 7
		signal 2
		message 15
		mainView 926
	)
)

(instance stick of PQInvItem
	(properties
		noun 8
		signal 2
		message 16
		mainView 927
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 1) ; Look
				(cond
					((& state $0002)
						(gMessager say: noun theVerb 2 0 0 11) ; "The drumstick has a crusty coating of dry glue."
					)
					((& state $0001)
						(gMessager say: noun theVerb 1 0 0 11) ; "The drumstick is coated with sticky glue."
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			((== theVerb 17) ; glue
				(gGame points: 3 81)
				(if (& state $0001)
					(gMessager say: noun theVerb 1 0 0 11) ; "You've applied enough glue!"
				else
					(if (& state $0002)
						(gMessager say: noun theVerb 2 0 0 11) ; "You apply fresh glue to the dried glue surface."
					else
						(gMessager say: noun theVerb 0 0 0 11) ; "You apply glue to the drumstick."
					)
					(&= state $fffd)
					(|= state $0001)
					((ScriptID 0 1) setReal: stickScr 15 0 0) ; StickTimer
				)
			)
			((== theVerb 18) ; mirror
				(cond
					((or (& state $0001) (& (mirror state:) $0001))
						(gGame points: 5 80)
						(gEgo put: 6 put: 8 get: 35) ; stick, mirror, stickMirror
						(gMessager say: noun theVerb 1 1 self 11) ; "You attach the mirror on to the end of the stick."
					)
					((or (& state $0002) (& (mirror state:) $0002))
						(gMessager say: noun theVerb 2 0 0 11) ; "The glue has dried, the mirror will not attach to the stick."
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance glue of PQInvItem
	(properties
		noun 9
		signal 2
		message 17
		mainView 928
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 18) ; mirror
				(gGame points: 3 82)
				(if (& (mirror state:) $0001)
					(gMessager say: noun theVerb 1 0 0 11) ; "There is plenty of glue on the mirror."
				else
					(if (& (mirror state:) $0002)
						(gMessager say: noun theVerb 2 0 0 11) ; "You apply fresh glue to the mirror."
					else
						(gMessager say: noun theVerb 0 0 0 11) ; "You apply glue to the mirror."
					)
					(mirror state: (& (mirror state:) $fffd))
					(mirror state: (| (mirror state:) $0001))
					((ScriptID 0 2) setReal: mirrorScr 15 0 0) ; MirrorTimer
				)
			)
			((== theVerb 16) ; stick
				(gGame points: 3 81)
				(if (& (stick state:) $0001)
					(gMessager say: noun theVerb 1 0 0 11) ; "You have enough glue on the stick!"
				else
					(if (& (stick state:) $0002)
						(gMessager say: noun theVerb 2 0 0 11) ; "You apply fresh glue to the drumstick."
					else
						(gMessager say: noun theVerb 0 0 0 11) ; "You apply glue to the drumstick."
					)
					(stick state: (& (stick state:) $fffd))
					(stick state: (| (stick state:) $0001))
					((ScriptID 0 1) setReal: stickScr 15 0 0) ; StickTimer
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mirror of PQInvItem
	(properties
		noun 10
		signal 2
		message 18
		mainView 929
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 1) ; Look
				(cond
					((& state $0002)
						(gMessager say: noun theVerb 2 0 0 11) ; "The dry glue has left a gummy coating on the mirror."
					)
					((& state $0001)
						(gMessager say: noun theVerb 1 0 0 11) ; "The mirror is coated with glue."
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			((== theVerb 17) ; glue
				(gGame points: 3 82)
				(if (& state $0001)
					(gMessager say: noun theVerb 1 0 0 11) ; "You've applied enough glue!"
				else
					(if (& state $0002)
						(gMessager say: noun theVerb 2 0 0 11) ; "You apply more glue to the dried glue surface."
					else
						(gMessager say: noun theVerb 0 0 0 11) ; "You apply glue to the mirror."
					)
					(&= state $fffd)
					(|= state $0001)
					((ScriptID 0 1) setReal: stickScr 15 0 0) ; StickTimer
				)
			)
			((== theVerb 16) ; stick
				(cond
					((or (& state $0001) (& (stick state:) $0001))
						(gGame points: 5 80)
						(gEgo put: 6 put: 8 get: 35) ; stick, mirror, stickMirror
						(gMessager say: noun theVerb 1 0 self 11) ; "You glue the stick to the mirror."
					)
					((or (& state $0002) (& (stick state:) $0002))
						(gMessager say: noun theVerb 2 0 0 11) ; "The glue has dried. The stick will not attach."
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance apple of PQInvItem
	(properties
		noun 11
		signal 2
		message 19
		mainView 930
	)
)

(instance wallet of PQInvItem
	(properties
		noun 12
		signal 2
		message 20
		mainView 931
	)
)

(instance handgun of PQInvItem
	(properties
		noun 14
		signal 2
		message 22
		mainView 934
	)

	(method (init)
		(super init: &rest)
		(= state 16)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 54) ; ammoBox
				(if (== state 16)
					(gMessager say: 14 54 6 0 0 11) ; "No need to reload, your Beretta 92F is fully loaded."
				else
					(= state 16)
					(gMessager say: 14 54 7 0 0 11) ; "You load your Beretta."
				)
			)
			((!= theVerb 24) ; fullClip
				(super doVerb: theVerb &rest)
			)
			(state
				(gMessager say: noun theVerb 3 0 0 11)
			)
			(else
				(gEgo put: 13 get: 14) ; fullClip, emptyClip
				(= state 15)
				(gMessager say: noun theVerb 0 0 self 11)
			)
		)
	)
)

(instance shotgun of PQInvItem
	(properties
		noun 15
		signal 2
		message 23
		mainView 935
	)

	(method (init)
		(super init: &rest)
		(= state 9)
	)

	(method (doVerb theVerb)
		(cond
			((!= theVerb 26) ; shells
				(super doVerb: theVerb &rest)
			)
			(state
				(gMessager say: noun theVerb 3 0 0 11)
			)
			(else
				(gEgo put: 15) ; shells
				(= state 8)
				(gMessager say: noun theVerb 0 0 self 11)
			)
		)
	)
)

(instance fullClip of PQInvItem
	(properties
		noun 16
		signal 2
		message 24
		mainView 936
	)
)

(instance emptyClip of PQInvItem
	(properties
		noun 17
		signal 2
		message 25
		mainView 937
	)
)

(instance shells of PQInvItem
	(properties
		noun 18
		signal 2
		message 26
		mainView 938
	)
)

(instance badge of PQInvItem
	(properties
		noun 19
		signal 2
		message 27
		mainView 939
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gGame points: 3 72)
			(badgeInset doit:)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance newspaper of PQInvItem
	(properties
		noun 20
		signal 2
		message 28
		mainView 940
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gPqFlags set: 15 14)
			(gGame points: 2 114)
			(super doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance coins of PQInvItem
	(properties
		noun 21
		signal 2
		message 29
		mainView 941
	)
)

(instance cigarette of PQInvItem
	(properties
		noun 22
		signal 2
		message 30
		mainView 942
	)
)

(instance shoe of PQInvItem
	(properties
		noun 23
		signal 2
		message 31
		mainView 943
	)
)

(instance pretzels of PQInvItem
	(properties
		noun 24
		signal 2
		message 32
		mainView 944
	)
)

(instance folders of PQInvItem
	(properties
		noun 25
		signal 2
		message 33
		mainView 945
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gGame points: 4 115)
			(= state 1)
		)
		(super doVerb: theVerb &rest)
	)
)

(instance boneBaggie of PQInvItem
	(properties
		noun 26
		signal 2
		message 34
		mainView 946
	)
)

(instance eyeProtector of PQInvItem
	(properties
		noun 68
		signal 2
		message 70
		mainView 947
	)
)

(instance tape of PQInvItem
	(properties
		noun 28
		signal 2
		message 36
		mainView 948
	)
)

(instance pills of PQInvItem
	(properties
		noun 31
		signal 2
		message 39
		mainView 951
	)
)

(instance ball of PQInvItem
	(properties
		noun 32
		signal 2
		message 40
		mainView 952
	)
)

(instance lighter of PQInvItem
	(properties
		noun 33
		signal 2
		message 41
		mainView 953
	)

	(method (doVerb theVerb)
		(if (== theVerb 42) ; hairspray
			(gEgo put: 28 put: 29 get: 34) ; lighter, hairspray, torch
			(gGame points: 5)
			(gMessager say: noun theVerb 0 0 self 11) ; "Combining the lighter's flame with the aersol spray produces a torch."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance hairspray of PQInvItem
	(properties
		noun 34
		signal 2
		message 42
		mainView 954
	)

	(method (doVerb theVerb)
		(if (== theVerb 41) ; lighter
			(gEgo put: 28 put: 29 get: 34) ; lighter, hairspray, torch
			(gGame points: 5)
			(gMessager say: 33 42 0 0 self 11) ; "Combining the lighter's flame with the aersol spray produces a torch."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance rope of PQInvItem
	(properties
		noun 36
		signal 2
		message 44
		mainView 956
	)
)

(instance matches of PQInvItem
	(properties
		noun 37
		signal 2
		message 45
		mainView 957
	)
)

(instance keys of PQInvItem
	(properties
		noun 38
		signal 2
		message 46
		mainView 958
	)
)

(instance handcuffs of PQInvItem
	(properties
		noun 39
		signal 2
		message 47
		mainView 959
	)
)

(instance torch of PQInvItem
	(properties
		noun 40
		signal 2
		message 48
		mainView 960
	)
)

(instance stickMirror of PQInvItem
	(properties
		noun 47
		signal 2
		message 49
		mainView 961
	)
)

(instance notebook of PQInvItem
	(properties
		noun 53
		signal 2
		message 52
		mainView 962
	)

	(method (doVerb theVerb)
		(switch theVerb
			(67 ; actionReports
				(cond
					((actionReports state:)
						(gMessager say: (actionReports noun:) 52 4 0 0 11)
					)
					((== gDay 2)
						(if (& (actionReports value:) $0001)
							(gMessager say: 73 52 5 0 0 11) ; "There is no need to complete an additional report on the incidents regarding the alley at this time."
						else
							(gGame points: 2)
							(actionReports
								value: (| (actionReports value:) $0001)
							)
							(actionReports state: 1)
							(actionReports noun: 73)
							(gMessager say: 73 52 0 0 0 11) ; "You write up a 3.14 documenting the incidents relating to the alley."
						)
					)
					((or (gPqFlags test: 107) (gPqFlags test: 106))
						(cond
							((gPqFlags test: 108)
								(cond
									((gPqFlags test: 107)
										(if (& (actionReports value:) $0080)
											(gMessager say: 80 52 5 0 0 11) ; "It is unnecessary to complete an additional 3.14 follow-up report on Mitchell Thurman's contact with Luella Parker."
										else
											(gGame points: 2)
											(actionReports
												value:
													(|
														(actionReports value:)
														$0080
													)
											)
											(actionReports state: 1)
											(actionReports noun: 80)
											(gMessager say: 80 52 0 0 0 11) ; "You complete your report on what you know of victim Luella Parker's contact with Mitchell Thurman."
										)
									)
									((& (actionReports value:) $0040)
										(gMessager say: 79 52 5 0 0 11) ; "There is no need to duplicate your work. A report regarding Barbie Cann has already been completed and turned into your murder book."
									)
									(else
										(gGame points: 2)
										(actionReports
											value:
												(| (actionReports value:) $0040)
										)
										(actionReports state: 1)
										(actionReports noun: 79)
										(gMessager say: 79 52 0 0 0 11) ; "You complete follow-up report 3.14 with information regarding victim Luella Parker and stripper Barbie Cann's relationship."
									)
								)
							)
							((gPqFlags test: 106)
								(if (& (actionReports value:) $0040)
									(gMessager say: 79 52 5 0 0 11) ; "There is no need to duplicate your work. A report regarding Barbie Cann has already been completed and turned into your murder book."
								else
									(gGame points: 2)
									(actionReports
										value: (| (actionReports value:) $0040)
									)
									(actionReports state: 1)
									(actionReports noun: 79)
									(gMessager say: 79 52 0 0 0 11) ; "You complete follow-up report 3.14 with information regarding victim Luella Parker and stripper Barbie Cann's relationship."
								)
							)
							((& (actionReports value:) $0080)
								(gMessager say: 80 52 5 0 0 11) ; "It is unnecessary to complete an additional 3.14 follow-up report on Mitchell Thurman's contact with Luella Parker."
							)
							(else
								(gGame points: 2)
								(actionReports
									value: (| (actionReports value:) $0080)
								)
								(actionReports state: 1)
								(actionReports noun: 80)
								(gMessager say: 80 52 0 0 0 11) ; "You complete your report on what you know of victim Luella Parker's contact with Mitchell Thurman."
							)
						)
					)
					((gPqFlags test: 42)
						(if (& (actionReports value:) $0020)
							(gMessager say: 78 52 5 0 0 11) ; "You don't need to fill out another follow-up report on the arm bone."
						else
							(gGame points: 2)
							(actionReports
								value: (| (actionReports value:) $0020)
							)
							(actionReports state: 1)
							(actionReports noun: 78)
							(gMessager say: 78 52 0 0 0 11) ; "You fill out follow-up report form 3.14 with information"
						)
					)
					((gPqFlags test: 100)
						(if (& (actionReports value:) $0010)
							(gMessager say: 77 52 5 0 0 11) ; "No need to duplicate work, your report on Walker is completed."
						else
							(gGame points: 2)
							(actionReports
								value: (| (actionReports value:) $0010)
							)
							(actionReports state: 1)
							(actionReports noun: 77)
							(gMessager say: 77 52 0 0 0 11) ; "You complete report 3.14 documenting assault by Walker."
						)
					)
					((gPqFlags test: 105)
						(if (& (actionReports value:) $0008)
							(gMessager say: 76 52 5 0 0 11) ; "There is no need to duplicate work, your report on Wendy James has already been filed."
						else
							(gGame points: 2)
							(actionReports
								value: (| (actionReports value:) $0008)
							)
							(actionReports state: 1)
							(actionReports noun: 76)
							(gMessager say: 76 52 0 0 0 11) ; "You complete your report on Wendy James's arrest and attempted assault on an officer."
						)
					)
					((gPqFlags test: 37)
						(if (& (actionReports value:) $0004)
							(gMessager say: 75 52 5 0 0 11) ; "No need to duplicate paperwork, you have already documented your conversation with Yo Money."
						else
							(gGame points: 2)
							(actionReports
								value: (| (actionReports value:) $0004)
							)
							(actionReports state: 1)
							(actionReports noun: 75)
							(gMessager say: 75 52 0 0 0 11) ; "You complete a 3.14 documenting your interview of Yo Money."
						)
					)
					((& (actionReports value:) $0002)
						(gMessager say: 74 52 5 0 0 11) ; "You do not need to write another report on the ambush in which you found yourself."
					)
					(else
						(gGame points: 2)
						(actionReports value: (| (actionReports value:) $0002))
						(actionReports state: 1)
						(actionReports noun: 74)
						(gMessager say: 74 52 0 0 0 11) ; "You complete a 3.14 documenting the gunfight and the players involved in the ambush."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ammoBox of PQInvItem
	(properties
		noun 52
		signal 2
		message 54
		mainView 964
	)

	(method (doVerb theVerb)
		(if (== gDay 4)
			(= noun 52)
		else
			(= noun 81)
		)
		(if (== theVerb 22) ; handgun
			(if (== (handgun state:) 16)
				(gMessager say: 14 54 6 0 0 11) ; "No need to reload, your Beretta 92F is fully loaded."
			else
				(handgun state: 16)
				(gMessager say: 14 54 7 0 0 11) ; "You load your Beretta."
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance protectors of PQInvItem
	(properties
		noun 54
		signal 2
		message 55
		mainView 963
	)
)

(instance hypoBaggie of PQInvItem
	(properties
		noun 55
		signal 2
		message 8
		mainView 965
	)
)

(instance washStuff of PQInvItem
	(properties
		noun 56
		signal 2
		message 11
		mainView 966
	)
)

(instance photoSound of Sound
	(properties
		number 918
	)
)

(instance photo of PQInvItem
	(properties
		noun 57
		signal 2
		message 57
		mainView 971
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gGame points: 2 66)
			(if (gCurRoom inset:)
				(super doVerb: theVerb &rest)
			else
				(photoSound play:)
				(photoInset doit:)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance beer of PQInvItem
	(properties
		noun 60
		signal 2
		message 62
		mainView 970
	)
)

(instance parkerID of PQInvItem
	(properties
		noun 64
		signal 2
		message 66
		mainView 975
	)
)

(instance actionReports of PQInvItem
	(properties
		noun 65
		signal 2
		message 67
		mainView 976
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4 ; Do
				(gMessager say: 65 4 0 0 0 11) ; "Standard weight."
			)
			(52 ; notebook
				(cond
					(state
						(gMessager say: noun 52 4 0 0 11) ; MISSING MESSAGE
					)
					((== gDay 2)
						(if (& value $0001)
							(gMessager say: 73 52 5 0 0 11) ; "There is no need to complete an additional report on the incidents regarding the alley at this time."
						else
							(gGame points: 2)
							(|= value $0001)
							(= state 1)
							(= noun 73)
							(super doVerb: theVerb)
						)
					)
					((or (gPqFlags test: 107) (gPqFlags test: 106))
						(cond
							((gPqFlags test: 108)
								(cond
									((gPqFlags test: 107)
										(if (& value $0080)
											(gMessager say: 80 52 5 0 0 11) ; "It is unnecessary to complete an additional 3.14 follow-up report on Mitchell Thurman's contact with Luella Parker."
										else
											(gGame points: 2)
											(|= value $0080)
											(= state 1)
											(= noun 80)
											(super doVerb: theVerb)
										)
									)
									((& value $0040)
										(gMessager say: 79 52 5 0 0 11) ; "There is no need to duplicate your work. A report regarding Barbie Cann has already been completed and turned into your murder book."
									)
									(else
										(gGame points: 2)
										(|= value $0040)
										(= state 1)
										(= noun 79)
										(super doVerb: theVerb)
									)
								)
							)
							((gPqFlags test: 106)
								(if (& value $0040)
									(gMessager say: 79 52 5 0 0 11) ; "There is no need to duplicate your work. A report regarding Barbie Cann has already been completed and turned into your murder book."
								else
									(gGame points: 2)
									(|= value $0040)
									(= state 1)
									(= noun 79)
									(super doVerb: theVerb)
								)
							)
							((& value $0080)
								(gMessager say: 80 52 5 0 0 11) ; "It is unnecessary to complete an additional 3.14 follow-up report on Mitchell Thurman's contact with Luella Parker."
							)
							(else
								(gGame points: 2)
								(|= value $0080)
								(= state 1)
								(= noun 80)
								(super doVerb: theVerb)
							)
						)
					)
					((gPqFlags test: 42)
						(if (& value $0020)
							(gMessager say: 78 52 5 0 0 11) ; "You don't need to fill out another follow-up report on the arm bone."
						else
							(gGame points: 2)
							(|= value $0020)
							(= state 1)
							(= noun 78)
							(super doVerb: theVerb)
						)
					)
					((gPqFlags test: 100)
						(if (& value $0010)
							(gMessager say: 77 52 5 0 0 11) ; "No need to duplicate work, your report on Walker is completed."
						else
							(gGame points: 2)
							(|= value $0010)
							(= state 1)
							(= noun 77)
							(super doVerb: theVerb)
						)
					)
					((gPqFlags test: 105)
						(if (& value $0008)
							(gMessager say: 76 52 5 0 0 11) ; "There is no need to duplicate work, your report on Wendy James has already been filed."
						else
							(gGame points: 2)
							(|= value $0008)
							(= state 1)
							(= noun 76)
							(super doVerb: theVerb)
						)
					)
					((gPqFlags test: 37)
						(if (& value $0004)
							(gMessager say: 75 52 5 0 0 11) ; "No need to duplicate paperwork, you have already documented your conversation with Yo Money."
						else
							(gGame points: 2)
							(|= value $0004)
							(= state 1)
							(= noun 75)
							(super doVerb: theVerb)
						)
					)
					((& value $0002)
						(gMessager say: 74 52 5 0 0 11) ; "You do not need to write another report on the ambush in which you found yourself."
					)
					(else
						(gGame points: 2)
						(|= value $0002)
						(= state 1)
						(= noun 74)
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (moveTo param1)
		(= owner param1)
		(= state 0)
		(self
			signal: (| (self signal:) $0004)
			nsLeft: 0
			nsRight: 0
			nsTop: 0
			nsBottom: 0
		)
		(= noun 65)
	)
)

(instance qualifyMemo of PQInvItem
	(properties
		noun 69
		signal 2
		message 71
		mainView 969
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gGame points: 2 65)
		)
		(super doVerb: theVerb)
	)
)

(instance manilaTicket of PQInvItem
	(properties
		noun 70
		signal 2
		message 72
		mainView 933
	)
)

(instance candyBar of PQInvItem
	(properties
		noun 72
		signal 2
		message 74
		mainView 978
	)
)

(instance crimeSceneReport of PQInvItem
	(properties
		noun 71
		signal 2
		message 73
		mainView 977
	)
)

(instance sodaCan of PQInvItem
	(properties
		noun 82
		signal 2
		message 79
		mainView 918
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (not (gEgo has: 50)) ; skeletonKey
				(gGame points: 4)
				(gEgo get: 50) ; skeletonKey
				(gMessager say: noun theVerb 8 0 self 11) ; "Upon shaking, a skeleton key emerges from the can."
			else
				(gMessager say: noun theVerb 9 0 0 11) ; "The soda can is empty."
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance skeletonKey of PQInvItem
	(properties
		noun 84
		signal 2
		message 80
		mainView 919
	)
)

(instance photoInset of Code
	(properties)

	(method (doit &tmp temp0 temp1 [temp2 4])
		(gInventory hide:)
		(FrameOut)
		(gGame fade: 100 0 10)
		((gCurRoom plane:) drawPic: 971 0)
		(FrameOut)
		(gGame fade: 0 100 100)
		(gMessager say: 57 1 0 0 0 11) ; "The photograph taken of you and Hickman at the lake, the time you caught the 'big one'."
		((User curEvent:) new:)
		(repeat
			(= gGameTime (+ gTickOffset (GetTime)))
			(gTalkers
				eachElementDo: #doit
				firstTrue: #handleEvent (User curEvent:)
			)
			(breakif (gTalkers allTrue: #isModeless 2))
			(gSounds eachElementDo: #check)
			((User curEvent:) new:)
			(FrameOut)
		)
		(FrameOut)
		(while (!= ((= temp1 (Event new:)) type:) evMOUSEBUTTON)
			(temp1 dispose:)
		)
		(temp1 dispose:)
		(gGame fade: 100 0 10)
		((gCurRoom plane:) drawPic: (gCurRoom picture:) 0)
		(gGame fade: 0 100 10)
		(gInventory showSelf:)
	)
)

(instance badgeInset of Code
	(properties)

	(method (doit &tmp temp0 temp1 temp2 temp3)
		(gMessager say: 19 1 0 1 0 11) ; "Your badge is a symbol of your commitment, and your identification."
		(FrameOut)
		(= temp2 (- (badge x:) (/ (CelWide 939 0 1) 2)))
		(= temp3 (- (badge y:) (/ (CelHigh 939 0 1) 2)))
		((= temp0 (View new:))
			view: 939
			loop: 0
			cel: 1
			x: temp2
			y: temp3
			fixPriority: 1
			priority: (+ (GetHighPlanePri) 10)
			init: gInventory
		)
		(badge z: 1000)
		(UpdateScreenItem badge)
		(FrameOut)
		(while (!= ((= temp1 (Event new:)) type:) evMOUSEBUTTON)
			(temp1 dispose:)
		)
		(temp1 dispose:)
		(temp0 dispose:)
		(badge z: 0)
		(UpdateScreenItem badge)
	)
)

