;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 786)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Menu)
(use Actor)
(use System)

(public
	SlthOMtr 0
)

(local
	[local0 20] = [786 0 29 4 786 1 55 12 786 2 81 14 786 3 107 11 786 4 133 9]
	local20
	local21
	local22
	local23 = -1
	[local24 5]
	[local29 3]
	local32
	[local33 96] = [0 1 786 5 1 3 786 6 4 3 786 7 7 8 786 8 15 12 786 9 27 5 786 10 32 1 786 11 33 1 786 12 34 1 786 13 35 10 786 14 45 3 786 15 48 2 786 16 50 4 786 17 54 1 786 18 55 5 786 19 60 1 786 20 61 1 786 21 62 4 786 22 66 1 786 23 67 4 786 24 71 1 786 25 72 2 786 26 74 1 786 27 75 1 786 28]
	[local129 150] = [786 29 786 30 786 31 786 32 786 33 786 34 786 35 786 33 786 36 786 37 786 38 786 34 786 35 786 39 786 40 786 41 786 42 786 43 786 44 786 45 786 46 786 47 786 48 786 49 786 50 786 51 786 52 786 53 786 54 786 55 786 56 786 57 786 33 786 58 786 59 786 60 786 61 786 62 786 63 786 64 786 65 786 66 786 67 786 55 786 68 786 69 786 34 786 35 786 34 786 35 786 70 786 33 786 34 786 40 786 36 786 70 786 38 786 34 786 39 786 40 786 38 786 38 786 71 786 72 786 67 786 73 786 46 786 70 786 69 786 34 786 40 786 70 786 70 786 33 786 33]
	[local279 84] = [786 74 786 75 786 76 786 77 786 78 786 79 786 80 786 81 786 82 786 83 786 84 786 85 786 86 786 87 786 88 786 89 786 90 786 91 786 92 786 93 786 94 786 95 786 96 786 97 786 98 786 99 786 100 786 101 786 102 786 103 786 104 786 105 786 106 786 107 786 108 786 109 786 110 786 111 786 112 786 113 786 114 786 115]
)

(procedure (localproc_0 param1 &tmp temp0 temp1)
	(= temp0 (/ param1 16))
	(= temp1 (<< $0001 (mod param1 16)))
	(|= [local24 temp0] temp1)
)

(procedure (localproc_1 param1)
	(localproc_0 (+ param1 80))
)

(procedure (localproc_2 &tmp temp0 temp1 [temp2 2])
	(if (& global135 $0001)
		(localproc_0 0)
	else
		(localproc_1 0)
		(localproc_1 19)
	)
	(if (!= ((gInventory at: 12) owner:) 35) ; soup_bone
		(localproc_0 1)
	else
		(localproc_1 9)
	)
	(if (!= ((gInventory at: 17) owner:) 59) ; carrot
		(localproc_0 2)
	else
		(localproc_1 20)
	)
	(if (!= ((gInventory at: 11) owner:) 53) ; crackers
		(localproc_0 3)
	else
		(localproc_1 14)
	)
	(if (gEgo has: 5) ; skeleton_key
		(localproc_0 4)
	else
		(localproc_1 1)
	)
	(if (gEgo has: 16) ; matches
		(localproc_0 5)
	else
		(localproc_1 35)
	)
	(if (gEgo has: 1) ; monocle
		(localproc_0 6)
	else
		(localproc_1 21)
	)
	(if (!= gCorpseFlags 127)
		(localproc_1 2)
	)
	(if (& gCorpseFlags $0040) ; Lillian
		(localproc_0 7)
	)
	(if (& gCorpseFlags $0008) ; Ethel
		(localproc_0 8)
	)
	(if (& gCorpseFlags $0001) ; Gertie
		(localproc_0 9)
	)
	(if (& gCorpseFlags $0004) ; Gloria
		(localproc_0 10)
	)
	(if (& gCorpseFlags $0020) ; Clarence
		(localproc_0 11)
	)
	(if (& gCorpseFlags $0002) ; Wilbur
		(localproc_0 12)
	)
	(if (& gCorpseFlags $0010) ; Jeeves & Fifi
		(localproc_0 14)
		(localproc_0 13)
	)
	(if global139
		(localproc_0 16)
		(localproc_0 21)
		(localproc_0 18)
	)
	(if global140
		(localproc_0 16)
		(localproc_0 15)
		(localproc_0 22)
	)
	(if global143
		(localproc_0 17)
		(localproc_0 26)
		(localproc_0 24)
	)
	(if global144
		(localproc_0 17)
		(localproc_0 25)
		(localproc_0 23)
	)
	(if (or (not global139) (not global140) (not global143) (not global144))
		(localproc_1 4)
	)
	(if (& [global148 3] $0008)
		(localproc_0 19)
	else
		(localproc_1 5)
	)
	(if (& global205 $0001)
		(localproc_0 20)
	else
		(localproc_1 22)
	)
	(if (< global136 6)
		(localproc_0 27)
	else
		(localproc_1 14)
		(localproc_1 15)
	)
	(if (or (not (gEgo has: 7)) (not (gEgo has: 3))) ; crowbar, oilcan
		(localproc_1 10)
	)
	(if (and (IsFlag 1) (IsFlag 2))
		(localproc_0 28)
	else
		(localproc_1 37)
	)
	(if (and (IsFlag 3) (IsFlag 12))
		(localproc_0 29)
	else
		(localproc_1 36)
	)
	(if (and global184 (& global142 $0002))
		(localproc_0 30)
	else
		(localproc_1 23)
	)
	(= temp0 4)
	(= temp1 0)
	(while (<= temp0 12)
		(if (IsFlag temp0)
			(++ temp1)
		)
		(++ temp0)
	)
	(if (> temp1 1)
		(localproc_0 31)
	else
		(localproc_1 6)
	)
	(if (or (IsFlag 3) (IsFlag 12))
		(localproc_0 32)
	else
		(localproc_1 36)
	)
	(if (!= (>> gAtticFirstTime $0008) 9)
		(localproc_1 7)
	)
	(if (gEgo has: 22) ; pouch
		(localproc_0 33)
	else
		(localproc_1 37)
	)
	(if (IsFlag 14)
		(localproc_0 34)
	else
		(localproc_1 11)
	)
	(if (IsFlag 4)
		(localproc_0 35)
	else
		(localproc_1 29)
	)
	(if (IsFlag 5)
		(localproc_0 36)
	else
		(localproc_1 31)
	)
	(= temp0 6)
	(for ((= temp1 37)) (<= temp0 12) ((++ temp1))
		(if (IsFlag temp0)
			(localproc_0 temp1)
		else
			(localproc_1 6)
		)
		(++ temp0)
	)
	(if (IsFlag 11)
		(localproc_0 42)
	else
		(localproc_1 32)
	)
	(if (IsFlag 12)
		(localproc_0 43)
	else
		(localproc_1 38)
		(localproc_1 33)
	)
	(if (and (gEgo has: 8) (IsFlag 13)) ; cigar_butt
		(localproc_0 44)
	else
		(localproc_1 28)
	)
	(if (IsFlag 15)
		(localproc_0 45)
	else
		(localproc_1 8)
	)
	(if (IsFlag 16)
		(localproc_0 46)
	)
	(if (IsFlag 17)
		(localproc_0 47)
	)
	(if (IsFlag 18)
		(localproc_0 48)
	)
	(if (IsFlag 19)
		(localproc_0 49)
	)
	(if
		(or
			(not (IsFlag 16))
			(not (IsFlag 17))
			(not (IsFlag 18))
			(not (IsFlag 19))
		)
		(localproc_1 4)
		(localproc_1 16)
	)
	(if gGertieRoomState
		(localproc_0 50)
		(localproc_0 52)
	else
		(localproc_1 17)
	)
	(if (and global125 global107)
		(localproc_0 51)
	else
		(localproc_1 12)
	)
	(if (and (IsFlag 20) global107)
		(localproc_0 53)
	else
		(localproc_1 12)
		(localproc_1 30)
	)
	(if (IsFlag 21)
		(localproc_0 54)
	else
		(localproc_1 4)
		(localproc_1 13)
	)
	(localproc_0 55)
	(localproc_0 59)
	(if (IsFlag 23)
		(localproc_0 57)
		(localproc_0 56)
		(localproc_0 60)
	else
		(localproc_1 4)
		(localproc_1 16)
	)
	(if (IsFlag 22)
		(localproc_0 58)
	else
		(localproc_1 4)
		(localproc_1 27)
	)
	(if (IsFlag 24)
		(localproc_0 61)
	else
		(localproc_1 4)
		(localproc_1 13)
	)
	(if (and (IsFlag 25) (IsFlag 26))
		(localproc_0 62)
	else
		(localproc_1 39)
	)
	(if (and (IsFlag 27) (or (& gCorpseFlags $0020) (IsFlag 28))) ; Clarence
		(localproc_0 63)
	else
		(localproc_1 34)
	)
	(if (and (IsFlag 29) (IsFlag 30))
		(localproc_0 64)
	else
		(localproc_1 25)
	)
	(if (and (IsFlag 31) (IsFlag 32))
		(localproc_0 65)
	else
		(localproc_1 26)
	)
	(if (& global205 $0002)
		(localproc_0 66)
	else
		(localproc_1 40)
	)
	(if (IsFlag 45)
		(localproc_0 68)
		(localproc_0 69)
	else
		(localproc_1 18)
	)
	(if global126
		(localproc_0 68)
		(localproc_0 70)
	else
		(localproc_1 18)
	)
	(if (not (IsFlag 33))
		(localproc_0 67)
		(localproc_0 68)
	else
		(localproc_1 7)
	)
	(if (!= gPrevRoomNum 785) ; goHome
		(localproc_0 74)
	else
		(localproc_1 7)
		(localproc_1 41)
	)
	(if (IsFlag 34)
		(localproc_0 71)
		(if (or (gEgo has: 21) (gEgo has: 8)) ; cane, cigar_butt
			(localproc_0 72)
		else
			(localproc_1 17)
			(localproc_1 24)
		)
	else
		(localproc_1 24)
	)
	(if (and global107 (not (IsFlag 33)))
		(localproc_0 73)
	else
		(localproc_1 12)
	)
)

(procedure (localproc_3 &tmp temp0 temp1 temp2 temp3 [temp4 25])
	(= temp0 0)
	(= temp2 0)
	(= temp1 0)
	(= temp3 1)
	(while (< temp0 75)
		(if (& [local24 temp2] temp3)
			(++ temp1)
		)
		(if (== (<<= temp3 $0001) 0)
			(++ temp2)
			(= temp3 1)
		)
		(++ temp0)
	)
	(if (== temp1 75)
		(= local20 0)
		(= local21 144)
	else
		(= temp1 (/ (= temp1 (* (= temp1 (/ (*= temp1 100) 75)) 105)) 100))
		(cond
			((<= (= local21 (- 248 temp1)) 170)
				(= local20 1)
			)
			((<= local21 196)
				(= local20 2)
			)
			((<= local21 222)
				(= local20 3)
			)
			(else
				(= local20 4)
			)
		)
	)
)

(procedure (localproc_4 param1)
	(*= param1 4)
	(Display
		[local0 param1]
		[local0 (++ param1)]
		dsCOORD
		35
		[local0 (++ param1)]
		dsWIDTH
		85
		dsCOLOR
		(& [local0 (++ param1)] local23)
		dsBACKGROUND
		-1
		dsFONT
		4
	)
)

(procedure (localproc_5 &tmp temp0 temp1 temp2 [temp3 160])
	(for ((= temp0 0)) (< temp0 42) ((++ temp0))
		(= temp1 (/ temp0 16))
		(= temp2 (<< $0001 (mod temp0 16)))
		(if (& [local29 temp1] temp2)
			(switch
				(Print
					(Format ; "H I N T %s"
						@temp3
						786
						116
						[local279 (* temp0 2)]
						[local279 (+ (* temp0 2) 1)]
					)
					#mode
					1
					#width
					280
					#button
					{__MORE__}
					1
					#button
					{ RESTORE }
					2
					#button
					{ RESTART }
					3
					#button
					{__QUIT__}
					4
				)
				(2
					(gGame restore:)
				)
				(3
					(gGame restart:)
				)
				(4
					(= gQuit 1)
					(break)
				)
			)
		)
	)
)

(procedure (localproc_6 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 [temp7 10])
	(= global61 1)
	(DrawPic 86 4 1 1)
	(Display
		[local33 (+ local32 2)]
		[local33 (+ local32 3)]
		dsCOORD
		18
		7
		dsWIDTH
		163
		dsCOLOR
		8
		dsBACKGROUND
		-1
		dsFONT
		4
	)
	(= temp0 25)
	(= temp6 0)
	(= temp2 [local33 local32])
	(= temp1 [local33 (+ local32 1)])
	(if (< local32 92)
		(= temp5 0)
		(while (< temp5 temp1)
			(= temp3 (/ temp2 16))
			(= temp4 (<< $0001 (mod temp2 16)))
			(if (& [local24 temp3] temp4)
				(Display
					[local129 (* temp2 2)]
					[local129 (+ (* temp2 2) 1)]
					dsCOORD
					23
					temp0
					dsWIDTH
					158
					dsCOLOR
					8
					dsBACKGROUND
					-1
					dsFONT
					4
				)
				(+= temp0 9)
			else
				(= temp6 1)
			)
			(++ temp5)
			(++ temp2)
		)
	else
		(if (& gAtticFirstTime $00ff)
			(Format @temp7 {%u:%u} (>> gAtticFirstTime $0008) (& gAtticFirstTime $00ff))
		else
			(Format @temp7 {%u:00} (>> gAtticFirstTime $0008))
		)
		(Display @temp7 dsCOORD 23 temp0 dsWIDTH 50 dsCOLOR 8 dsBACKGROUND -1 dsFONT 4)
	)
	(if temp6
		(Display 786 117 dsCOORD 23 temp0 dsWIDTH 50 dsCOLOR 4 dsBACKGROUND -1 dsFONT 4) ; "INCOMPLETE"
	)
)

(procedure (localproc_7)
	(= global61 0)
	(nBWindow hide:)
	(DrawPic 86 5 1 global61)
	(gAddToPics doit:)
	(liquid setScript: Flash)
)

(procedure (localproc_8)
	(if (< local32 92)
		(+= local32 4)
		(localproc_6)
	)
)

(procedure (localproc_9)
	(if local32
		(-= local32 4)
		(localproc_6)
	)
)

(instance SlthOMtr of Rm
	(properties
		picture 87
	)

	(method (init &tmp temp0)
		(super init:)
		(TheMenuBar state: 0)
		(User canControl: 1 canInput: 0)
		(Load rsFONT 4)
		(LoadMany rsSOUND 17 27 119)
		(localproc_2)
		(localproc_3)
		(liquid setPri: 3 setMotion: MoveTo 133 local21 self init:)
		(soundFX number: 119 loop: 1 play:)
		(Display 786 118 dsCOORD 75 1 dsWIDTH 140 dsCOLOR 8 dsBACKGROUND -1 dsFONT 0) ; "SLEUTH-O-METER"
		(Display 786 118 dsCOORD 76 0 dsWIDTH 140 dsCOLOR 15 dsBACKGROUND -1 dsFONT 0) ; "SLEUTH-O-METER"
		(for ((= temp0 0)) (< temp0 5) ((++ temp0))
			(localproc_4 temp0)
		)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (cue)
		(soundFX stop:)
		(gConMusic number: 27 loop: -1 play:)
		(= local22 11)
		(self setScript: Notes)
	)
)

(instance Notes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (-- local22)
					(^= local23 $ffff)
					(localproc_4 local20)
					(= state -1)
					(= cycles 5)
				else
					(= cycles 1)
				)
			)
			(1
				(switch
					(Print ; "Would you like to review your notes?"
						786
						119
						#at
						185
						30
						#width
						100
						#mode
						1
						#button
						{___Yes__}
						1
						#button
						{__Quit__}
						2
					)
					(1
						(= cycles 1)
					)
					(2
						(= gQuit 1)
					)
				)
			)
			(2
				(DrawPic 86 4)
				(liquid hide:)
				(gAddToPics add: Tulane LauraBow doit:)
				(silhouette init: stopUpd:)
				(lightning init: stopUpd:)
				(nBWindow init: hide:)
				(liquid setScript: Flash)
				(= cycles 1)
			)
			(3
				(if (liquid script:)
					(= state 2)
				else
					(repeat
						(switch
							(Print ; "NOTEBOOK"
								786
								120
								#at
								195
								8
								#mode
								1
								#button
								{ Open }
								1
								#button
								{ Exit }
								2
							)
							(1
								(= local32 0)
								(localproc_6)
								(nBWindow show:)
								(repeat
									(switch
										(Print ; "NOTEBOOK"
											786
											120
											#at
											195
											8
											#mode
											1
											#button
											{\19}
											1
											#button
											{\18}
											2
											#button
											{CLOSE}
											3
										)
										(1
											(localproc_8)
										)
										(2
											(localproc_9)
										)
										(3
											(localproc_7)
											(= state 2)
											(break)
										)
									)
								)
								(break)
							)
							(2
								(if (== local20 0)
									(repeat
										(switch
											(Print ; "Congratulations, you have attained the highest possible sleuth rating. The curtain will now fall. We hope you enjoyed the performance."
												786
												121
												#width
												235
												#mode
												1
												#button
												{__RESTORE__}
												1
												#button
												{__RESTART__}
												2
												#button
												{___QUIT___}
												3
											)
											(1
												(gGame restore:)
											)
											(2
												(gGame restart:)
											)
											(3
												(= gQuit 1)
												(break)
											)
										)
									)
									(break)
								)
								(repeat
									(switch
										(Print ; "Some portions of your notes are rather scanty. You can replay the game to gain additional information."
											786
											122
											#width
											290
											#mode
											1
											#button
											{__HINTS__}
											1
											#button
											{ RESTORE }
											2
											#button
											{ RESTART }
											3
											#button
											{__QUIT__}
											4
										)
										(1
											(localproc_5)
											(if (== gQuit 1)
												(break)
											)
										)
										(2
											(gGame restore:)
										)
										(3
											(gGame restart:)
										)
										(4
											(= gQuit 1)
											(break)
										)
									)
								)
								(break)
							)
						)
					)
				)
				(= cycles 1)
			)
			(4
				(client setScript: 0)
			)
		)
	)
)

(instance Flash of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 6)
			)
			(1
				(silhouette cel: (^ (silhouette cel:) $0001) forceUpd:)
				(lightning cel: (^ (lightning cel:) $0001) forceUpd:)
				(if (silhouette cel:)
					(soundFX number: 17 loop: 1 priority: 15 play:)
					(= state 0)
				)
				(= cycles 6)
			)
			(2
				(client setScript: 0)
			)
		)
	)
)

(instance Tulane of PV
	(properties
		y 66
		x 98
		view 186
		loop 2
	)
)

(instance LauraBow of PV
	(properties
		y 176
		x 100
		view 186
		loop 3
	)
)

(instance silhouette of Prop
	(properties
		y 188
		x 256
		view 186
	)
)

(instance lightning of Prop
	(properties
		y 143
		x 256
		view 186
		loop 1
	)
)

(instance nBWindow of Prop
	(properties
		x 187
		view 186
		loop 4
	)
)

(instance liquid of Act
	(properties
		y 255
		x 133
		yStep 1
		view 187
		xStep 0
	)
)

(instance soundFX of Sound
	(properties)
)

