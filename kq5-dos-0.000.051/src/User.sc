;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 996)
(include sci.sh)
(use Main)
(use Interface)
(use Count)
(use Sound)
(use Motion)
(use Menu)
(use System)

(local
	[inputLine 23]
	inputLen
)

(class User of Obj
	(properties
		alterEgo 0
		canInput 0
		controls 0
		echo 32
		prevDir 0
		prompt {Enter input}
		inputLineAddr 0
		x -1
		y -1
		blocks 1
		mapKeyToDir 1
	)

	(method (init inLine length)
		(= inputLineAddr (if argc inLine else @inputLine))
		(= inputLen (if (== argc 2) length else 45))
	)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(= temp0 (Event new: $ffff)) ; evPEEK | evALL_EVENTS
		(temp0 localize:)
		(= global122 (temp0 x:))
		(= global123 (temp0 y:))
		(if (HaveMouse)
			(if (< global123 0)
				(if
					(and
						(& global71 $0008)
						(!= gTheCursor 999)
						canInput
						(& (TheIconBar state:) $0001)
					)
					(gGame setCursor: (= global106 999) 1)
					(temp0 type: evVERB message: KEY_d)
				else
					(temp0 dispose:)
					(= temp0 (Event new:))
				)
			else
				(|= global71 $0008)
				(if
					(and
						(== global106 999)
						(or (User controls:) (& global71 $0004))
					)
					(= global106 global119)
					(proc0_26 (| (HaveMouse) (!= global70 (gUIcons at: 0))))
				)
				(temp0 dispose:)
				(= temp0 (Event new:))
			)
		else
			(if
				(and
					(== global106 999)
					(!= global119 996)
					(or (User controls:) (& global71 $0004))
				)
				(= global106 global119)
				(proc0_26 (| (HaveMouse) (!= global70 (gUIcons at: 0))))
			)
			(temp0 dispose:)
			(= temp0 (Event new:))
		)
		(if (temp0 type:)
			(= gLastEvent temp0)
			(= temp1 (temp0 type:))
			(if (and (!= (temp0 message:) KEY_NUMPAD5) mapKeyToDir)
				(MapKeyToDir temp0)
			)
			(if TheIconBar
				(TheIconBar handleEvent: temp0)
			)
			(if (not (temp0 claimed:))
				(temp0 localize:)
				(if
					(and
						(== (temp0 message:) KEY_RETURN)
						(== global65 (gUIcons at: 1))
						controls
					)
					(temp0 type: evMOUSEBUTTON x: global124 y: global125)
				)
				(if
					(and
						(not (& global71 $0004))
						(or
							(!= (temp0 type:) $0040) ; direction
							(!= global65 (gUIcons at: 1))
						)
					)
					(switch (temp0 type:)
						(evMOUSEBUTTON
							(if
								(and
									controls
									(IsObject alterEgo)
									(gCast contains: alterEgo)
									(!= (temp0 modifiers:) emALT)
								)
								(= global323 (temp0 x:))
								(= global324 (temp0 y:))
								(if
									(or
										(!= (gEgo x:) global323)
										(!= (gEgo y:) global324)
									)
									(if (= temp4 (gCurRoom obstacles:))
										(if global72
											(alterEgo
												setMotion:
													PolyPath
													global323
													global324
											)
										else
											(= temp5
												(AvoidPath
													(alterEgo x:)
													(alterEgo y:)
													global323
													global324
													(temp4 elements:)
													(temp4 size:)
													0
												)
											)
											(= global323 (WordAt temp5 2))
											(= global324 (WordAt temp5 3))
											(Memory memFREE temp5)
											(alterEgo
												setMotion:
													MoveTo
													global323
													global324
											)
										)
									else
										(alterEgo
											setMotion:
												MoveTo
												global323
												global324
										)
									)
								)
								(= prevDir 0)
								(temp0 claimed: 1)
							)
						)
						($0040 ; direction
							(if
								(and
									controls
									(IsObject alterEgo)
									(gCast contains: alterEgo)
								)
								(= temp2 (temp0 message:))
								(= global323 0)
								(= global324 0)
								(if
									(and
										(== temp1 evKEYBOARD)
										(== temp2 prevDir)
										(IsObject (alterEgo mover:))
									)
									(= temp2 0)
								)
								(= prevDir (if (== temp1 evKEYBOARD) temp2 else 0))
								(alterEgo setDirection: temp2)
								(temp0 claimed: 1)
							)
						)
					)
				else
					(switch (temp0 type:)
						(evMOUSEBUTTON
							(temp0
								type: (global65 eType:)
								message: (global65 eMessage:)
								modifiers: (global65 eModifiers:)
							)
							(|= global71 $0040)
						)
						($0040 ; direction
							(if
								(and
									(= temp2 (temp0 message:))
									(== temp1 evKEYBOARD)
									(== temp2 global126)
								)
								(= temp2 0)
							)
							(= global126 temp2)
							(= global128 (= global127 0))
							(temp0 claimed: 1)
						)
						(else
							(if (== (temp0 message:) KEY_RETURN)
								(temp0
									type: (global65 eType:)
									message: (global65 eMessage:)
									modifiers: (global65 eModifiers:)
									x: global124
									y: global125
								)
								(&= global71 $ffbf)
							)
						)
					)
				)
				(if (and (not (temp0 claimed:)) canInput)
					(gSortedFeatures
						add: gCast gFeatures gGame
						handleEvent: temp0
						release:
					)
					(if
						(and
							(not (temp0 claimed:))
							(== (temp0 type:) evVERB)
							(proc0_15 (temp0 message:) 3 5 2 4)
						)
						(proc0_21 temp0)
					)
				)
			)
		)
		(if
			(or
				(and (& global71 $0004) canInput)
				(and (== global65 (gUIcons at: 1)) controls)
				(proc0_15 gTheCursor gWaitCursor 995)
			)
			(if
				(and
					(HaveMouse)
					global126
					(or (!= global122 global124) (!= global123 global125))
				)
				(= global126 0)
			else
				(= global124 global122)
				(= global125 global123)
			)
			(if global126
				(if (not global127)
					(cond
						((== (++ global128) 1)
							(if (== global286 0)
								(++ global128)
								(= global127 5)
							else
								(= global127 10)
							)
						)
						((== global286 0)
							(= global127 3)
						)
						(else
							(= global127 5)
						)
					)
				else
					(-- global127)
				)
				(switch global126
					(1
						(= global154 0)
						(= global155 -1)
					)
					(2
						(= global154 2)
						(= global155 -1)
					)
					(3
						(= global154 2)
						(= global155 0)
					)
					(4
						(= global154 2)
						(= global155 1)
					)
					(5
						(= global154 0)
						(= global155 1)
					)
					(6
						(= global154 -2)
						(= global155 1)
					)
					(7
						(= global154 -2)
						(= global155 0)
					)
					(8
						(= global154 -2)
						(= global155 -1)
					)
					(1
						(= global154 0)
						(= global155 -1)
					)
				)
				(*= global154 global128)
				(*= global155 global128)
				(if (> (+= global124 global154) 319)
					(= global124 319)
				)
				(if (< global124 0)
					(= global124 0)
				)
				(if (> (+= global125 global155) 189)
					(= global125 189)
				)
				(if (< global125 0)
					(= global125 0)
				)
				(= temp6
					(if (proc0_15 gTheCursor gWaitCursor 995)
						gTheCursor
					else
						global106
					)
				)
				(gGame setCursor: temp6 1 global124 global125)
			)
		)
		(temp0 dispose:)
		(= gLastEvent 0)
	)

	(method (getInput event &tmp temp0 temp1)
		(if (!= (event type:) 4)
			(= inputLine 0)
		)
		(if (!= (event message:) echo)
			(Format @inputLine 996 0 (event message:)) ; "%c"
		)
		(= temp0 (Sound pause: blocks))
		(= temp1 (GetInput @inputLine inputLen prompt 67 x y))
		(Sound pause: temp0)
		(return temp1)
	)

	(method (canControl value)
		(if argc
			(= controls value)
			(= prevDir 0)
		)
		(return controls)
	)
)

