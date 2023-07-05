;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm8 0
	proc8_1 1
)

(local
	[local0 100]
	[local100 41]
	local141
	local142
	local143
	local144
	local145
	local146
	local147
	local148
	local149
	local150
	local151
	local152
	local153
	local154
)

(procedure (localproc_0 &tmp temp0)
	(while ((= temp0 (Event new:)) type:)
		(temp0 dispose:)
	)
	(temp0 dispose:)
)

(procedure (localproc_1 param1)
	(if (<= 97 param1 122)
		(return (- param1 32))
	else
		(return param1)
	)
)

(procedure (proc8_1)
	(Print &rest #font 7 #width 168 #at 70 20)
)

(procedure (localproc_2) ; UNUSED
	(Display &rest dsCOORD 73 local143 dsFONT 7 dsCOLOR 0 dsBACKGROUND 0)
	(+= local143 10)
)

(instance compCursor of Prop
	(properties)
)

(instance fileCursor of Prop
	(properties)
)

(instance lite1 of View
	(properties)
)

(instance lite2 of View
	(properties)
)

(instance shaw of View
	(properties)
)

(instance rm8 of Rm
	(properties
		picture 8
		style 7
	)

	(method (init)
		(super init:)
		(HandsOff)
		(User canInput: 1)
		(Load rsVIEW 9)
		(lite1 view: 9 loop: 2 cel: 0 posn: 256 178 init: stopUpd:)
		(lite2 view: 9 loop: 2 cel: 1 posn: 234 143 init: stopUpd:)
		(shaw view: 9 loop: 3 cel: 0 posn: 83 150 init: addToPic:)
		(Format @local100 8 0)
		(self setScript: rm8Script)
	)
)

(instance rm8Script of Script
	(properties)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((Said '/book,instruction,cocksucker')
						(Print 8 1) ; "It's your typical computer manual - completely unreadable by normal human beings. You're better off without it."
					)
					((Said 'look/switch,button,power')
						(Print 8 2) ; "You find the power switch on the back of the computer."
					)
					((Said 'look/computer')
						(Print 8 3) ; "The computer is turned off."
					)
					((Said 'exit,walk,go,japanesestop')
						(gCurRoom newRoom: gPrevRoomNum)
					)
					((Said 'type,enter,cd,cd')
						(Print 8 4) ; "First, turn on the computer, then you can type it."
					)
					(
						(or
							(Said
								'turn,log<on,logon[/computer,power,button,switch]'
							)
							(Said
								'japaneseput,flip,press,start,press[/computer,button,power,switch]'
							)
							(Said 'japaneseturnon[/computer,switch]')
							(Said 'japaneseturnon[/switch<computer]')
						)
						(lite1 hide:)
						(lite2 hide:)
						(rm8 setScript: computerScript)
					)
					((Said '[<around,at][/!*]')
						(Print 8 5) ; "The new computer system is the latest in crime-fighting technology."
					)
				)
			)
		)
	)
)

(instance computerScript of Script
	(properties)

	(method (doit)
		(if (> local151 1)
			(-- local151)
		)
		(if (== local151 1)
			(= local151 0)
			(self cue:)
		)
		(if (and (not local149) (not local147) (gCast contains: fileCursor))
			(fileCursor dispose:)
			(self changeState: 1)
		)
		(cond
			((<= (compCursor x:) 123)
				(compCursor x: 123)
			)
			((>= (compCursor x:) 236)
				(compCursor x: 236)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(compCursor
					view: 9
					posn: 123 22
					cycleSpeed: 3
					setCycle: Fwd
					init:
				)
				(= local151 5)
			)
			(1
				(for ((= local143 24)) (<= local143 114) ((+= local143 10))
					(Display 8 6 dsCOORD 73 local143 dsFONT 7 dsCOLOR 0 dsBACKGROUND 0)
				)
				(if (gCast contains: fileCursor)
					(fileCursor dispose:)
				)
				(if (not local146)
					(self cue:)
				)
			)
			(2
				(= local150 1)
				(Display 8 7 dsCOORD 73 14 dsFONT 7 dsCOLOR 0)
				(Display 8 8 dsCOORD 73 14 dsFONT 7 dsCOLOR 9 dsBACKGROUND 0) ; "COMMAND>"
			)
			(3
				(Display 8 9 dsCOORD 73 14 dsFONT 7 dsCOLOR 0 dsBACKGROUND 0)
				(Display 8 9 dsCOORD 73 15 dsFONT 7 dsCOLOR 0 dsBACKGROUND 0)
				(Display 8 10 dsCOORD 73 14 dsFONT 7 dsCOLOR 14 dsBACKGROUND 0) ; "Session Complete."
				(= gNewRoomNum gPrevRoomNum)
			)
		)
	)

	(method (handleEvent event &tmp [temp0 4])
		(switch (event type:)
			($0040 ; direction
				(if (or local147 local149)
					(event claimed: 1)
					(switch (event message:)
						(JOY_UP
							(cond
								((> (fileCursor y:) 40)
									(fileCursor
										posn:
											(fileCursor x:)
											(- (fileCursor y:) 10)
									)
									(-- local152)
								)
								((== (fileCursor x:) 71)
									(= local152 11)
									(fileCursor posn: 162 33)
								)
								(else
									(= local152 1)
									(fileCursor posn: 71 33)
								)
							)
						)
						(JOY_DOWN
							(cond
								((< (fileCursor y:) 114)
									(++ local152)
									(fileCursor
										posn:
											(fileCursor x:)
											(+ (fileCursor y:) 10)
									)
								)
								((== (fileCursor x:) 71)
									(= local152 20)
									(fileCursor posn: 162 123)
								)
								(else
									(= local152 10)
									(fileCursor posn: 71 123)
								)
							)
						)
						(else
							(if (== (fileCursor x:) 71)
								(+= local152 10)
								(fileCursor posn: 162 (fileCursor y:))
							else
								(-= local152 10)
								(fileCursor posn: 71 (fileCursor y:))
							)
						)
					)
				)
			)
			(evKEYBOARD
				(if
					(or
						(== (= local141 (event message:)) KEY_F6)
						(== local141 KEY_F8)
						(== local141 KEY_F10)
					)
					(Print 8 11) ; "Calm down. You have no need of your gun here."
					(event claimed: 1)
				)
				(if local150
					(event claimed: 1)
					(= local154 (StrLen @local100))
					(cond
						((and (< KEY_SPACE (event message:) $007f) (< local154 13))
							(StrAt @local100 local154 (localproc_1 local141))
							(++ local154)
							(StrAt @local100 local154 0)
							(Display
								(Format @temp0 {%c} local141)
								dsCOORD
								(compCursor x:)
								(- (compCursor y:) 8)
								dsFONT
								7
								dsCOLOR
								9
								dsBACKGROUND
								0
							)
							(compCursor x: (+ (compCursor x:) 6))
						)
						((and (== JOY_UPLEFT local141) local154)
							(-- local154)
							(StrAt @local100 local154 0)
							(compCursor x: (- (compCursor x:) 6))
							(Display
								8
								12
								dsCOORD
								(compCursor x:)
								(- (compCursor y:) 8)
								dsFONT
								7
								dsCOLOR
								0
								dsBACKGROUND
								0
							)
						)
						((== local141 KEY_RETURN)
							(Display 8 13 dsCOORD 123 14 dsCOLOR 0 dsFONT 7 dsBACKGROUND 0)
							(Display 8 13 dsCOORD 123 15 dsCOLOR 0 dsFONT 7 dsBACKGROUND 0)
							(= local154 0)
							(compCursor x: 123)
							(cond
								(local146
									(cond
										((not (StrCmp @local100 {CRIMINAL}))
											(= local145 3)
											(= local146 0)
											(self changeState: 1)
										)
										((not (StrCmp @local100 {SIERRA}))
											(= local145 1)
											(= local146 0)
											(self changeState: 1)
										)
										((not (StrCmp @local100 {PERSONNEL}))
											(= local144 2)
											(= local146 0)
											(= local148 1)
											(self changeState: 1)
										)
										(
											(and
												(not
													(StrCmp @local100 {HOMICIDE})
												)
												(== local145 3)
											)
											(= local144 4)
											(= local146 0)
											(= local148 1)
											(self changeState: 1)
										)
										(
											(and
												(not (StrCmp @local100 {VICE}))
												(== local145 3)
											)
											(= local144 7)
											(= local146 0)
											(= local148 1)
											(self changeState: 1)
										)
										(
											(and
												(not
													(StrCmp @local100 {BURGLARY})
												)
												(== local145 3)
											)
											(= local144 5)
											(= local146 0)
											(= local148 1)
											(self changeState: 1)
										)
										(
											(and
												(not
													(StrCmp @local100 {FIREARMS})
												)
												(== local145 3)
											)
											(= local144 6)
											(= local146 0)
											(= local148 1)
											(self changeState: 1)
										)
										(else
											(= local145 0)
											(= local146 0)
											(self changeState: 1)
										)
									)
									(if local148
										(Display
											8
											14
											dsCOORD
											73
											14
											dsCOLOR
											0
											dsFONT
											7
											dsBACKGROUND
											0
										)
										(Display ; "PASSWORD:"
											8
											15
											dsCOORD
											73
											14
											dsCOLOR
											9
											dsFONT
											7
											dsBACKGROUND
											0
										)
									)
								)
								(local148
									(= local148 0)
									(cond
										(
											(and
												(not
													(StrCmp @local100 {ICECREAM})
												)
												(== local144 4)
											)
											(= local145 local144)
										)
										(
											(and
												(not
													(StrCmp
														@local100
														{PISTACHIO}
													)
												)
												(== local144 2)
											)
											(= local145 local144)
											(SetScore 2 120)
										)
										(
											(and
												(not (StrCmp @local100 {MIAMI}))
												(== local144 7)
											)
											(= local145 local144)
											(SetScore 2 121)
										)
										(else
											(Print 8 16 #time 3) ; "ACCESS DENIED!"
										)
									)
									(self changeState: 1)
								)
								(local149
									(switch local152
										(1
											(proc8_1 8 17)
											(if (!= (gGame parseLang:) 1)
												(Print 8 18)
											)
										)
										(2
											(proc8_1 8 19)
											(if (!= (gGame parseLang:) 1)
												(Print 8 20)
											)
										)
										(3
											(proc8_1 8 21)
											(if (!= (gGame parseLang:) 1)
												(Print 8 22)
											)
										)
										(4
											(proc8_1 8 23)
											(if (!= (gGame parseLang:) 1)
												(Print 8 24)
											)
										)
										(5
											(proc8_1 8 25)
											(proc8_1 8 26)
											(if (!= (gGame parseLang:) 1)
												(Print 8 27)
												(Print 8 28)
											)
										)
										(6
											(proc8_1 8 29)
											(if (!= (gGame parseLang:) 1)
												(Print 8 30)
											)
										)
										(7
											(proc8_1 8 31)
											(proc8_1 8 32)
											(if (!= (gGame parseLang:) 1)
												(Print 8 33)
												(Print 8 34)
											)
										)
										(8
											(proc8_1 8 35)
											(if (!= (gGame parseLang:) 1)
												(Print 8 36)
											)
										)
										(9
											(proc8_1 8 37)
											(if (!= (gGame parseLang:) 1)
												(Print 8 38)
											)
										)
										(10
											(proc8_1 8 39)
											(if (!= (gGame parseLang:) 1)
												(Print 8 40)
											)
										)
										(11
											(proc8_1 8 41)
											(if (!= (gGame parseLang:) 1)
												(Print 8 42)
											)
										)
										(12
											(proc8_1 8 43)
											(if (!= (gGame parseLang:) 1)
												(Print 8 44)
											)
										)
										(13
											(proc8_1 8 45)
											(if (!= (gGame parseLang:) 1)
												(Print 8 46)
											)
										)
										(14
											(proc8_1 8 47)
											(if (!= (gGame parseLang:) 1)
												(Print 8 48)
											)
										)
										(15
											(proc8_1 8 49)
											(if (!= (gGame parseLang:) 1)
												(Print 8 50)
											)
										)
									)
								)
								(local147
									(switch local145
										(4
											(switch local152
												(1
													(proc8_1 8 51)
													(proc8_1 8 52)
													(if
														(!=
															(gGame parseLang:)
															1
														)
														(Print 8 53)
														(Print 8 54)
													)
												)
												(2
													(proc8_1 8 55)
													(if
														(!=
															(gGame parseLang:)
															1
														)
														(Print 8 56)
													)
												)
												(3
													(proc8_1 8 57)
													(proc8_1 8 58)
													(if
														(!=
															(gGame parseLang:)
															1
														)
														(Print 8 59)
													)
												)
												(4
													(proc8_1 8 60)
													(if
														(!=
															(gGame parseLang:)
															1
														)
														(Print 8 61)
													)
												)
												(5
													(proc8_1 8 62)
													(if
														(!=
															(gGame parseLang:)
															1
														)
														(Print 8 63)
													)
												)
												(6
													(proc8_1 8 64)
													(proc8_1 8 65)
													(if
														(!=
															(gGame parseLang:)
															1
														)
														(Print 8 66)
														(Print 8 67)
													)
												)
												(7
													(proc8_1 8 68)
													(if
														(!=
															(gGame parseLang:)
															1
														)
														(Print 8 53)
													)
												)
												(11
													(proc8_1 8 69)
													(proc8_1 8 70)
													(if
														(!=
															(gGame parseLang:)
															1
														)
														(Print 8 71)
													)
												)
												(12
													(proc8_1 8 72)
													(proc8_1 8 73)
													(if
														(!=
															(gGame parseLang:)
															1
														)
														(Print 8 74)
														(Print 8 75)
													)
												)
												(13
													(proc8_1 8 76)
													(if
														(!=
															(gGame parseLang:)
															1
														)
														(Print 8 77)
													)
												)
												(14
													(proc8_1 8 78)
													(if
														(!=
															(gGame parseLang:)
															1
														)
														(Print 8 79)
													)
												)
												(15
													(proc8_1 8 80)
													(if
														(!=
															(gGame parseLang:)
															1
														)
														(Print 8 81)
													)
												)
												(16
													(proc8_1 8 82)
													(if
														(!=
															(gGame parseLang:)
															1
														)
														(Print 8 83)
													)
												)
											)
										)
										(2
											(switch local152
												(1
													(proc8_1 8 84)
													(proc8_1 8 85)
													(if
														(!=
															(gGame parseLang:)
															1
														)
														(Print 8 86)
														(Print 8 87)
													)
												)
												(2
													(proc8_1 8 88)
													(proc8_1 8 89)
													(proc8_1 8 90)
													(if
														(!=
															(gGame parseLang:)
															1
														)
														(Print 8 91)
														(Print 8 92)
														(Print 8 93)
													)
												)
												(3
													(proc8_1 8 94)
													(proc8_1 8 95)
													(proc8_1 8 96)
													(if
														(!=
															(gGame parseLang:)
															1
														)
														(Print 8 97)
														(Print 8 98)
														(Print 8 99)
													)
												)
												(4
													(proc8_1 8 100)
													(proc8_1 8 101)
													(proc8_1 8 102)
													(if
														(!=
															(gGame parseLang:)
															1
														)
														(Print 8 103)
														(Print 8 104)
														(Print 8 105)
													)
												)
												(5
													(proc8_1 8 106)
													(proc8_1 8 107)
													(if
														(!=
															(gGame parseLang:)
															1
														)
														(Print 8 108)
														(Print 8 109)
													)
												)
												(6
													(proc8_1 8 110)
													(proc8_1 8 111)
													(if
														(!=
															(gGame parseLang:)
															1
														)
														(Print 8 112)
														(Print 8 113)
													)
												)
												(7
													(proc8_1 8 114)
													(proc8_1 8 115)
													(if
														(!=
															(gGame parseLang:)
															1
														)
														(Print 8 116)
														(Print 8 117)
													)
												)
												(8
													(proc8_1 8 118)
													(proc8_1 8 119)
													(proc8_1 8 120)
													(if
														(!=
															(gGame parseLang:)
															1
														)
														(Print 8 121)
														(Print 8 122)
														(Print 8 123)
													)
												)
												(9
													(proc8_1 8 124)
													(proc8_1 8 125)
													(if
														(!=
															(gGame parseLang:)
															1
														)
														(Print 8 126)
														(Print 8 127)
													)
												)
												(10
													(proc8_1 8 128)
													(proc8_1 8 129)
													(proc8_1 8 130)
													(if
														(!=
															(gGame parseLang:)
															1
														)
														(Print 8 131)
														(Print 8 132)
														(Print 8 133)
													)
													(SetFlag 56)
												)
												(11
													(proc8_1 8 134)
													(proc8_1 8 135)
													(if
														(!=
															(gGame parseLang:)
															1
														)
														(Print 8 136)
														(Print 8 123)
													)
												)
												(12
													(proc8_1 8 137)
													(proc8_1 8 138)
													(proc8_1 8 139)
													(if
														(!=
															(gGame parseLang:)
															1
														)
														(Print 8 140)
														(Print 8 141)
														(Print 8 142)
													)
												)
												(13
													(proc8_1 8 143)
													(proc8_1 8 144)
													(proc8_1 8 145)
													(proc8_1 8 146)
													(if
														(!=
															(gGame parseLang:)
															1
														)
														(Print 8 147)
														(Print 8 148)
														(Print 8 149)
														(Print 8 150)
													)
												)
												(14
													(proc8_1 8 151)
													(proc8_1 8 152)
													(if
														(!=
															(gGame parseLang:)
															1
														)
														(Print 8 153)
														(Print 8 123)
													)
												)
												(15
													(proc8_1 8 154)
													(proc8_1 8 155)
													(if
														(!=
															(gGame parseLang:)
															1
														)
														(Print 8 156)
														(Print 8 157)
													)
												)
												(16
													(proc8_1 8 158)
													(proc8_1 8 159)
													(if
														(!=
															(gGame parseLang:)
															1
														)
														(Print 8 160)
														(Print 8 161)
													)
												)
												(17
													(proc8_1 8 162)
													(if
														(!=
															(gGame parseLang:)
															1
														)
														(Print 8 163)
													)
												)
											)
										)
										(7
											(switch local152
												(1
													(proc8_1 8 164)
													(proc8_1 8 165)
													(if
														(!=
															(gGame parseLang:)
															1
														)
														(Print 8 166)
														(Print 8 167)
													)
												)
												(2
													(proc8_1 8 168)
													(proc8_1 8 169)
													(if
														(!=
															(gGame parseLang:)
															1
														)
														(Print 8 170)
														(Print 8 171)
													)
												)
												(3
													(proc8_1 8 172)
													(proc8_1 8 173)
													(if
														(!=
															(gGame parseLang:)
															1
														)
														(Print 8 174)
														(Print 8 175)
													)
												)
												(4
													(proc8_1 8 176)
													(proc8_1 8 177)
													(if
														(!=
															(gGame parseLang:)
															1
														)
														(Print 8 178)
														(Print 8 179)
													)
												)
												(5
													(proc8_1 8 180)
													(proc8_1 8 181)
													(if
														(!=
															(gGame parseLang:)
															1
														)
														(Print 8 182)
														(Print 8 183)
													)
												)
												(6
													(proc8_1 8 184)
													(proc8_1 8 185)
													(if
														(!=
															(gGame parseLang:)
															1
														)
														(Print 8 186)
														(Print 8 187)
													)
												)
												(7
													(proc8_1 8 188)
													(proc8_1 8 189)
													(if
														(!=
															(gGame parseLang:)
															1
														)
														(Print 8 190)
														(Print 8 191)
													)
												)
												(8
													(proc8_1 8 192)
													(proc8_1 8 193)
													(if
														(!=
															(gGame parseLang:)
															1
														)
														(Print 8 194)
														(Print 8 195)
													)
												)
												(9
													(proc8_1 8 196)
													(proc8_1 8 197)
													(if
														(!=
															(gGame parseLang:)
															1
														)
														(Print 8 198)
														(Print 8 199)
													)
												)
												(11
													(proc8_1 8 200)
													(proc8_1 8 201)
													(if
														(!=
															(gGame parseLang:)
															1
														)
														(Print 8 202)
														(Print 8 203)
													)
												)
												(12
													(proc8_1 8 204)
													(proc8_1 8 205)
													(if
														(!=
															(gGame parseLang:)
															1
														)
														(Print 8 206)
														(Print 8 207)
													)
												)
												(13
													(proc8_1 8 208)
													(proc8_1 8 209)
													(if
														(!=
															(gGame parseLang:)
															1
														)
														(Print 8 210)
														(Print 8 211)
													)
												)
												(14
													(proc8_1 8 212)
													(proc8_1 8 213)
													(if
														(!=
															(gGame parseLang:)
															1
														)
														(Print 8 214)
														(Print 8 215)
													)
												)
												(15
													(proc8_1 8 216)
													(proc8_1 8 217)
													(if
														(!=
															(gGame parseLang:)
															1
														)
														(Print 8 218)
														(Print 8 219)
													)
												)
												(16
													(proc8_1 8 220)
													(proc8_1 8 221)
													(if
														(!=
															(gGame parseLang:)
															1
														)
														(Print 8 222)
														(Print 8 223)
													)
												)
											)
										)
									)
								)
							)
							(Format @local100 8 0)
						)
					)
					(cond
						(
							(and
								(not (StrCmp @local100 {DIR}))
								(not local146)
								(not local148)
							)
							(Format @local100 8 0)
							(Display 8 13 dsCOORD 123 14 dsCOLOR 0 dsFONT 7 dsBACKGROUND 0)
							(Display 8 13 dsCOORD 123 15 dsCOLOR 0 dsFONT 7 dsBACKGROUND 0)
							(compCursor x: 123)
							(switch local145
								(0
									(Display 8 224 dsCOORD 73 24 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "Criminal (DIR)"
									(Display 8 225 dsCOORD 73 34 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "Sierra (DIR)"
									(Display 8 226 dsCOORD 73 44 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "Personnel (DIR)"
								)
								(1
									(Display 8 227 dsCOORD 73 24 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "POLICE QUEST"
									(Display 8 228 dsCOORD 73 34 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "KING'S QUEST"
									(Display 8 229 dsCOORD 73 44 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "KQ II"
									(Display 8 230 dsCOORD 73 54 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "KQ III"
									(Display 8 231 dsCOORD 73 64 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "KQ IV"
									(Display 8 232 dsCOORD 73 74 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "SILPHEED"
									(Display 8 233 dsCOORD 73 84 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "MANHUNTER"
									(Display 8 234 dsCOORD 73 94 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "THEXDER"
									(Display 8 235 dsCOORD 73 104 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "GOLD RUSH"
									(Display
										(Format @local0 8 236) ; "MOTHER GOOSE"
										dsCOORD
										73
										114
										dsCOLOR
										9
										dsFONT
										7
										dsBACKGROUND
										0
									)
									(Display
										(Format @local0 8 237) ; "| SPACE QUEST"
										dsCOORD
										160
										24
										dsCOLOR
										9
										dsFONT
										7
										dsBACKGROUND
										0
									)
									(Display
										(Format @local0 8 238) ; "| SQ II"
										dsCOORD
										160
										34
										dsCOLOR
										9
										dsFONT
										7
										dsBACKGROUND
										0
									)
									(Display
										(Format @local0 8 239) ; "| SQ III"
										dsCOORD
										160
										44
										dsCOLOR
										9
										dsFONT
										7
										dsBACKGROUND
										0
									)
									(Display
										(Format @local0 8 240) ; "| LSL I"
										dsCOORD
										160
										54
										dsCOLOR
										9
										dsFONT
										7
										dsBACKGROUND
										0
									)
									(Display
										(Format @local0 8 241) ; "| LSL II"
										dsCOORD
										160
										64
										dsCOLOR
										9
										dsFONT
										7
										dsBACKGROUND
										0
									)
									(= local149 1)
									(= local152 1)
									(fileCursor
										view: 9
										loop: 1
										posn: 71 32
										init:
									)
								)
								(2
									(Display
										(Format @local0 8 242) ; "Gelepsi, Mario"
										dsCOORD
										73
										24
										dsCOLOR
										9
										dsFONT
										7
									)
									(Display
										(Format @local0 8 243) ; "Haines, Calvin"
										dsCOORD
										73
										34
										dsCOLOR
										9
										dsFONT
										7
									)
									(Display
										(Format @local0 8 244) ; "Simpson, James"
										dsCOORD
										73
										44
										dsCOLOR
										9
										dsFONT
										7
									)
									(Display
										(Format @local0 8 245) ; "Adams, Robert"
										dsCOORD
										73
										54
										dsCOLOR
										9
										dsFONT
										7
									)
									(Display
										(Format @local0 8 246) ; "Waters, Laura"
										dsCOORD
										73
										64
										dsCOLOR
										9
										dsFONT
										7
									)
									(Display
										(Format @local0 8 247) ; "Jerome, William"
										dsCOORD
										73
										74
										dsCOLOR
										9
										dsFONT
										7
									)
									(Display 8 248 dsCOORD 73 84 dsCOLOR 9 dsFONT 7) ; "Willis, John"
									(Display 8 249 dsCOORD 73 94 dsCOLOR 9 dsFONT 7) ; "Jones, Steve"
									(Display 8 250 dsCOORD 73 104 dsCOLOR 9 dsFONT 7) ; "Walters, Kim"
									(Display 8 251 dsCOORD 73 114 dsCOLOR 9 dsFONT 7) ; "Pratt, Lloyd"
									(Display 8 252 dsCOORD 155 24 dsCOLOR 9 dsFONT 7) ; "| Dooley, John"
									(Display 8 253 dsCOORD 155 34 dsCOLOR 9 dsFONT 7) ; "| Watts, Laura"
									(Display 8 254 dsCOORD 155 44 dsCOLOR 9 dsFONT 7) ; "| Pierson, James"
									(Display 8 255 dsCOORD 155 54 dsCOLOR 9 dsFONT 7) ; "| Robinson, Keith"
									(Display 8 256 dsCOORD 155 64 dsCOLOR 9 dsFONT 7) ; "| Hall, Fletcher"
									(Display 8 257 dsCOORD 155 74 dsCOLOR 9 dsFONT 7) ; "| Bonds, Sonny"
									(Display 8 258 dsCOORD 155 84 dsCOLOR 9 dsFONT 7) ; "| Mills, Kenneth"
									(= local147 1)
									(= local152 1)
									(fileCursor
										view: 9
										loop: 1
										posn: 71 32
										init:
									)
								)
								(3
									(Display 8 259 dsCOORD 73 24 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "Homicide (DIR)"
									(Display 8 260 dsCOORD 73 34 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "Vice (DIR)"
									(Display 8 261 dsCOORD 73 44 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "Burglary (DIR)"
									(Display 8 262 dsCOORD 73 54 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "FireArms (DIR)"
								)
								(4
									(Display 8 263 dsCOORD 73 24 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "Taselli, Jason"
									(Display 8 264 dsCOORD 73 34 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "Loofin, Jasper"
									(Display 8 265 dsCOORD 73 44 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "Martin, Richard"
									(Display 8 266 dsCOORD 73 54 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "Botts, Rambus"
									(Display 8 267 dsCOORD 73 64 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "Granandez, Jose"
									(Display 8 268 dsCOORD 73 74 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "Martinez, Chico"
									(Display 8 269 dsCOORD 73 84 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "South, Julia"
									(Display 8 270 dsCOORD 158 24 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "| West, Lonnie"
									(Display 8 271 dsCOORD 158 34 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "| Bains, Jessie"
									(Display 8 272 dsCOORD 158 44 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "| Smith, Kenneth"
									(Display 8 273 dsCOORD 158 54 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "| Loofin, Mary"
									(Display 8 274 dsCOORD 158 64 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "| Swift, Peter"
									(Display 8 275 dsCOORD 158 74 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "| South, Lorin"
									(= local147 1)
									(= local152 1)
									(fileCursor
										view: 9
										loop: 1
										posn: 71 32
										init:
									)
								)
								(7
									(Display 8 276 dsCOORD 73 24 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "Simms, Victor"
									(Display 8 277 dsCOORD 73 34 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "Colby, Donald"
									(Display 8 278 dsCOORD 73 44 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "Snider, Wilma"
									(Display 8 279 dsCOORD 73 54 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "Mulkins, Jack"
									(Display 8 280 dsCOORD 73 64 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "Ramsey, Clyde"
									(Display 8 281 dsCOORD 73 74 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "Quikel, Norma"
									(Display 8 282 dsCOORD 73 84 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "Jones, Robin"
									(Display 8 283 dsCOORD 73 94 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "Snow, George"
									(Display 8 284 dsCOORD 73 104 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "Catskill, Frank"
									(Display 8 285 dsCOORD 154 24 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "| Valencia, Jose"
									(Display 8 286 dsCOORD 154 34 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "| Dickey, Moffit"
									(Display 8 287 dsCOORD 154 44 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "| Wilkans, Marie"
									(Display 8 288 dsCOORD 154 54 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "| Roberts, Woody"
									(Display 8 289 dsCOORD 154 64 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "| Fogg, Maynard"
									(Display 8 290 dsCOORD 154 74 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "| Bridford, R."
									(= local147 1)
									(= local152 1)
									(fileCursor
										view: 9
										loop: 1
										posn: 71 32
										init:
									)
								)
							)
							(localproc_0)
						)
						(
							(or
								(not (StrCmp @local100 {QUIT}))
								(not (StrCmp @local100 {LOGOUT}))
								(not (StrCmp @local100 {EXIT}))
								(not (StrCmp @local100 {BYE}))
							)
							(self changeState: 3)
						)
						((not (StrCmp @local100 {CD}))
							(Format @local100 8 0)
							(Display 8 14 dsCOORD 73 14 dsCOLOR 0 dsFONT 7 dsBACKGROUND 0)
							(Display 8 291 dsCOORD 73 14 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "DIR? >"
							(= local149 0)
							(= local147 0)
							(= local146 1)
							(localproc_0)
						)
					)
				)
			)
		)
	)
)

