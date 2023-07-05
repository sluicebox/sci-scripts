;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1050)
(include sci.sh)
(use Main)
(use interrogation)
(use GKTeller)
(use Array)

(public
	grace 0
	sarge 1
)

(local
	local0
	local1
	local2 = -1
)

(instance grace of Interrogation
	(properties
		curNoun 4
		verb 54
		color 2
		view 971
	)

	(method (setPersonals)
		(= personals (IntArray with: 25 26 27 105 29))
		(= personalIndex (IntArray with: 1 2 2 3 0))
	)

	(method (showCases)
		(super
			showCases:
				23 ; What do you do after work?
				(IsNotInterrogationFlag 9)
				24 ; How old are you?
				(IsNotInterrogationFlag 10)
				16 ; How come we haven't gone out yet?
				(IsNotInterrogationFlag 11)
				21 ; How do you like working at St. George's?
				(IsNotInterrogationFlag 12)
				29 ; Ritter's Phone Nbr
				(and (IsInterrogationFlag 7) (IsNotInterrogationFlag 21))
				47 ; Look up a Madame Cazaunoux.
				(and (IsFlag 60) (IsNotFlag 72))
				49 ; Check out Malia Gedde.
				(IsFlag 65)
				48 ; See what you can find on Rada drums.
				(and (IsFlag 51) (IsNotFlag 73))
				50 ; I have a pattern I need you to research.
				(and (gEgo has: 38) (IsNotFlag 36)) ; reconVeve
				26 ; Messages
				(or (not local0) (not local1))
				27 ; More Messages
				local1
		)
	)

	(method (cue)
		(switch iconValue
			(8 ; Voodoo Hounfour
				(= iconValue 60) ; "Do you know anything about a secret Voodoo hounfour?"
				(if (SetInterrogationFlag 13)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(13 ; Black Voodoo
				(= iconValue 51) ; "Do you know anything about black Voodoo?"
				(if (SetInterrogationFlag 14)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(25 ; Herself
				(= iconValue 73) ; "Yeah, right, Knight."
				(if (SetInterrogationFlag 8)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(4 ; Snakes
				(= iconValue 91) ; "(LIGHTLY SARCASTIC--RESPONDING TO QUESTION ABOUT SNAKES)Doing a family tree, Gabriel?"
				(if (SetInterrogationFlag 19)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(14 ; Schattenj\84ger
				(= iconValue 89) ; "Have you ever heard of a Schattenj\84ger?"
				(if (SetInterrogationFlag 20)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(10 ; V\82v\82
				(= iconValue 93) ; "V\82v\82s? No, what are they?"
				(if (SetInterrogationFlag 18)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(23 ; What do you do after work?
				(SetInterrogationFlag 9)
				(self doVerb:)
			)
			(24 ; How old are you?
				(SetInterrogationFlag 10)
				(self doVerb:)
			)
			(16 ; How come we haven't gone out yet?
				(SetInterrogationFlag 11)
				(self doVerb:)
			)
			(103 ; Just tell me anything at all.
				(= iconValue
					(if (>= local2 5)
						(Random 80 85)
					else
						(+ 80 (++ local2))
					)
				)
				(self sayMessage:)
			)
			(104 ; Nothing, I guess. Never mind.
				(self goTop:)
				(self doVerb:)
			)
			(21 ; How do you like working at St. George's?
				(SetInterrogationFlag 12)
				(self doVerb:)
			)
			(29 ; Ritter's Phone Nbr
				(SetInterrogationFlag 21)
				(SetFlag 55)
				(self doVerb:)
			)
			(49 ; Check out Malia Gedde.
				(SetFlag 15)
				(ClearFlag 65)
				(gEgo getPoints: 130 2 1)
				(self doVerb:)
			)
			(116 ; I can't think of anything.
				(self goTop:)
				(self doVerb:)
			)
			(47 ; Look up a Madame Cazaunoux.
				(SetFlag 72)
				(gEgo getPoints: -999 2)
				(self doVerb:)
			)
			(48 ; See what you can find on Rada drums.
				(SetFlag 73)
				(gEgo getPoints: -999 2)
				(self doVerb:)
			)
			(50 ; I have a pattern I need you to research.
				(SetFlag 36)
				(gEgo getPoints: -999 2)
				(self doVerb:)
			)
			(26 ; Messages
				(= local0 1)
				(= iconValue
					(if
						(cond
							((== gDay 1)
								(IsNotInterrogationFlag 5)
							)
							((== gDay 3)
								(IsNotInterrogationFlag 7)
							)
							(else 0)
						)
						(= local1 1)
						(cond
							((== gDay 3)
								(if (IsInterrogationFlag 6)
									(SetInterrogationFlag 7)
									102
								else
									(SetInterrogationFlag 6)
									101
								)
							)
							((IsInterrogationFlag 4)
								(SetInterrogationFlag 5)
								78
							)
							((IsInterrogationFlag 3)
								(SetInterrogationFlag 4)
								79
							)
							((IsInterrogationFlag 2)
								(SetInterrogationFlag 3)
								77
							)
							(else
								(SetInterrogationFlag 2)
								76
							)
						)
					else
						75
					)
				)
				(self sayMessage:)
			)
			(78 ; "Your friend Detective Mosely called. Talkative, isn't he?"
				(SetFlag 63)
				(gEgo getPoints: 116 2 1)
				(self doVerb:)
			)
			(77 ; "Your Grandmother called...."
				(SetFlag 101)
				(gEgo getPoints: 150 2)
				(self doVerb:)
			)
			(27 ; More Messages
				(= iconValue
					(if
						(cond
							((== gDay 1)
								(IsNotInterrogationFlag 5)
							)
							((== gDay 3)
								(IsNotInterrogationFlag 7)
							)
							(else 0)
						)
						(cond
							((== gDay 3)
								(SetInterrogationFlag 7)
								102
							)
							((IsInterrogationFlag 4)
								(SetInterrogationFlag 5)
								78
							)
							((IsInterrogationFlag 3)
								(SetInterrogationFlag 4)
								79
							)
							(else
								(SetInterrogationFlag 3)
								77
							)
						)
					else
						106
					)
				)
				(self sayMessage:)
			)
			(3 ; New Orleans
				(= iconValue
					(cond
						((> gDay 5) 70)
						((not (SetInterrogationFlag 17)) 68)
						(else 69)
					)
				)
				(self sayMessage:)
			)
			(1 ; Voodoo
				(= iconValue
					(cond
						((> gDay 5) 97)
						((not (SetInterrogationFlag 15)) 95)
						(else 96)
					)
				)
				(self sayMessage:)
			)
			(2 ; Voodoo Murders
				(= iconValue
					(cond
						((> gDay 1) 100)
						((not (SetInterrogationFlag 16)) 98)
						(else 99)
					)
				)
				(self sayMessage:)
			)
			(15 ; Rada Drums
				(= iconValue
					(cond
						((gEgo has: 14) 88) ; drumBook
						((IsFlag 73) 87)
						(else 86)
					)
				)
				(self sayMessage:)
			)
			(9 ; Animal Masks
				(= iconValue 107) ; "Do you know anything about animal masks?"
				(if (SetInterrogationFlag 22)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(6 ; Cabrit Sans Cor'
				(= iconValue 109) ; "Do you know what cabrit sans cor' means?"
				(if (SetInterrogationFlag 23)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(11 ; Damballah
				(= iconValue 111) ; "Have you ever heard of Damballah?"
				(if (SetInterrogationFlag 24)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(7 ; Marie Laveau
				(= iconValue 114) ; "Do you know anything about Marie Laveau?"
				(if (SetInterrogationFlag 25)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(5 ; St. John's Eve
				(= iconValue 71) ; "St. John's Eve? Never heard of it. It must be a local custom. New Orleanians love any excuse to celebrate."
				(if (SetInterrogationFlag 356)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(10 ; V\82v\82
				(= iconValue 93) ; "V\82v\82s? No, what are they?"
				(if (SetInterrogationFlag 18)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(else
				(self doVerb:)
			)
		)
	)
)

(instance sarge of Interrogation
	(properties
		curNoun 2
		verb 27
		color 3
		index 1
		view 972
	)

	(method (setPersonals)
		(= personals (IntArray with: 18 17 19 22))
		(= personalIndex (IntArray with: 1 2 3 4))
	)

	(method (showCases)
		(super showCases: 18 (and (IsFlag 76) (IsNotFlag 11)) 22 (IsNotFlag 12)) ; Crime Scene, Photographs
	)

	(method (cue)
		(switch iconValue
			(9 ; Animal Masks
				(= iconValue 107) ; "I see plenty of masks during Mardi Gras. Not many animals, though. Course, there're plenty of animals underneath."
				(if (SetInterrogationFlag 35)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(6 ; Cabrit Sans Cor'
				(= iconValue 109) ; "Do you know what cabrit sans cor' means?"
				(if (SetInterrogationFlag 36)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(11 ; Damballah
				(= iconValue 111) ; "No. Sounds foreign or somethin'."
				(if (SetInterrogationFlag 37)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(12 ; Ogoun Badagris
				(= iconValue 120) ; "Hell, no."
				(if (SetInterrogationFlag 39)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(7 ; Marie Laveau
				(= iconValue 114) ; "Marie who? Is she the one that hangs out on Conte and Nash?"
				(if (SetInterrogationFlag 38)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(15 ; Rada Drums
				(= iconValue 86) ; "I like Lawrence Welk, myself."
				(if (SetInterrogationFlag 40)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(14 ; Schattenj\84ger
				(= iconValue 89) ; "Can't say that I have, but it sounds dirty."
				(if (SetInterrogationFlag 350)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(4 ; Snakes
				(= iconValue 91) ; "What does this look like? A zoo?"
				(if (SetInterrogationFlag 351)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(10 ; V\82v\82
				(= iconValue 93) ; "Revays? Never heard of it."
				(if (SetInterrogationFlag 352)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(1 ; Voodoo
				(= iconValue 95) ; "Me? Nothin'. I'm a Catholic boy."
				(if (SetInterrogationFlag 353)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(2 ; Voodoo Murders
				(= iconValue 98) ; "What do you know about the Voodoo Murders?"
				(if (SetInterrogationFlag 354)
					(++ iconValue)
					(if (SetInterrogationFlag 355)
						(++ iconValue)
					)
				)
				(self sayMessage:)
			)
			(22 ; Photographs
				(SetFlag 12)
				(self doVerb:)
			)
			(17 ; Himself
				(= iconValue 57) ; "Who, me? I'm the desk sergeant, Frick. Why?"
				(if (SetInterrogationFlag 28)
					(++ iconValue)
					(if (SetInterrogationFlag 29)
						(++ iconValue)
					)
				)
				(self sayMessage:)
			)
			(3 ; New Orleans
				(= iconValue 68) ; "I'll tell ya, I'm glad as hell it's not Mardi Gras. If it weren't for that one month a year, being a cop in New Orleans would be a real pleasure."
				(if (SetInterrogationFlag 30)
					(++ iconValue)
					(if (SetInterrogationFlag 31)
						(++ iconValue)
					)
				)
				(self sayMessage:)
			)
			(8 ; Voodoo Hounfour
				(= iconValue 60) ; "Hound WHAT?"
				(if (SetInterrogationFlag 32)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(5 ; St. John's Eve
				(= iconValue 71) ; "A bunch of crazies out there on St. John's Eve, that's what. We're busy all night."
				(if (SetInterrogationFlag 33)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(13 ; Black Voodoo
				(= iconValue 51) ; "Black? Voodoo? Isn't that kinda the same thing?"
				(if (SetInterrogationFlag 26)
					(++ iconValue)
					(if (SetInterrogationFlag 27)
						(++ iconValue)
					)
				)
				(self sayMessage:)
			)
			(19 ; Detective Mosely
				(SetFlag 66)
				(= iconValue
					(cond
						((IsNotFlag 11)
							(if (IsFlag 76) 63 else 62)
						)
						((IsNotFlag 16) 64)
						((< gDay 6) 65)
						((IsNotFlag 76) 66)
						(else 67)
					)
				)
				(self sayMessage:)
			)
			(62 ; "(RENUM)I'm here to see Detective Mosely."
				(SetFlag 76)
				(gEgo getPoints: 123 2 1)
				(self doVerb:)
			)
			(64 ; "(RENUM)I'm here to see Detective Mosely."
				(ClearFlag 76)
				(SetFlag 100)
				(self doVerb:)
			)
			(66 ; "(RENUM)I'm here to see Detective Mosely."
				(SetFlag 76)
				(self doVerb:)
			)
			(18 ; Crime Scene
				(= iconValue 54) ; "Where is the crime scene? Is it related to the Voodoo Murders?"
				(if (SetFlag 95)
					(++ iconValue)
					(if (SetInterrogationFlag 34)
						(++ iconValue)
					)
				)
				(self sayMessage:)
			)
			(else
				(self doVerb:)
			)
		)
	)
)

