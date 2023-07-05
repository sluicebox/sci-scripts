;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 505)
(include sci.sh)
(use Main)
(use Inset)
(use Feature)
(use Sound)
(use Actor)
(use System)

(public
	anOrganizer 0
)

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
	local9
	[local10 20]
	[local30 20]
	local50
)

(procedure (localproc_0)
	(A init:)
	(B init:)
	(C init:)
	(D init:)
	(E init:)
	(F init:)
	(G init:)
	(H init:)
	(I init:)
	(J init:)
	(K init:)
	(L init:)
	(M init:)
	(N init:)
	(O init:)
	(P init:)
	(Q init:)
	(R init:)
	(S init:)
	(T init:)
	(U init:)
	(V init:)
	(W init:)
	(X init:)
	(Y init:)
	(Z init:)
)

(procedure (localproc_1)
	(A dispose:)
	(B dispose:)
	(C dispose:)
	(D dispose:)
	(E dispose:)
	(F dispose:)
	(G dispose:)
	(H dispose:)
	(I dispose:)
	(J dispose:)
	(K dispose:)
	(L dispose:)
	(M dispose:)
	(N dispose:)
	(O dispose:)
	(P dispose:)
	(Q dispose:)
	(R dispose:)
	(S dispose:)
	(T dispose:)
	(U dispose:)
	(V dispose:)
	(W dispose:)
	(X dispose:)
	(Y dispose:)
	(Z dispose:)
	(if (gCast contains: passLet1)
		(passLet1 dispose:)
	)
	(if (gCast contains: passLet2)
		(passLet2 dispose:)
	)
	(if (gCast contains: passLet3)
		(passLet3 dispose:)
	)
	(if (gCast contains: passLet4)
		(passLet4 dispose:)
	)
	(if (gCast contains: passLet5)
		(passLet5 dispose:)
	)
	(if (gCast contains: passLet6)
		(passLet6 dispose:)
	)
	(if (gCast contains: passLet7)
		(passLet7 dispose:)
	)
	(if (gCast contains: passLet8)
		(passLet8 dispose:)
	)
	(if (gCast contains: passLet9)
		(passLet9 dispose:)
	)
)

(procedure (localproc_2)
	(= local9 1)
	(= local30 0)
	(if (gCast contains: A)
		(localproc_1)
	)
	(if local1
		(Display {} dsRESTOREPIXELS local1)
		(= local1 0)
	)
	(if local2
		(Display {} dsRESTOREPIXELS local2)
		(= local2 0)
	)
	(if local3
		(Display {} dsRESTOREPIXELS local3)
		(= local3 0)
	)
	(if local4
		(Display {} dsRESTOREPIXELS local4)
		(= local4 0)
	)
	(if local5
		(Display {} dsRESTOREPIXELS local5)
		(= local5 0)
	)
	(if local6
		(Display {} dsRESTOREPIXELS local6)
		(= local6 0)
	)
)

(procedure (localproc_3 &tmp [temp0 25] temp25)
	(= local8 60)
	(for ((= temp25 1)) (< temp25 7) ((++ temp25))
		(Message msgGET 505 1 0 1 temp25 @temp0)
		(= local7
			(Display @temp0 dsALIGN alLEFT dsFONT 9777 dsCOORD 85 local8 dsCOLOR 0 dsWIDTH 112 dsSAVEPIXELS)
		)
		(switch temp25
			(1
				(= local1 local7)
			)
			(2
				(= local2 local7)
			)
			(3
				(= local3 local7)
			)
			(4
				(= local4 local7)
			)
			(5
				(= local5 local7)
			)
			(6
				(= local6 local7)
			)
		)
		(= temp0 0)
		(Message msgGET 505 1 0 2 temp25 @temp0)
		(Display @temp0 dsALIGN alRIGHT dsFONT 9777 dsCOORD 85 local8 dsCOLOR 0 dsWIDTH 112)
		(+= local8 11)
	)
)

(procedure (localproc_4 &tmp [temp0 25] temp25)
	(= local8 60)
	(for ((= temp25 1)) (< temp25 7) ((++ temp25))
		(Message msgGET 505 1 0 4 temp25 @temp0)
		(= local7
			(Display @temp0 dsALIGN alLEFT dsFONT 9777 dsCOORD 85 local8 dsCOLOR 0 dsWIDTH 112 dsSAVEPIXELS)
		)
		(switch temp25
			(1
				(= local1 local7)
			)
			(2
				(= local2 local7)
			)
			(3
				(= local3 local7)
			)
			(4
				(= local4 local7)
			)
			(5
				(= local5 local7)
			)
			(6
				(= local6 local7)
			)
		)
		(= temp0 0)
		(Message msgGET 505 1 0 5 temp25 @temp0)
		(Display @temp0 dsALIGN alRIGHT dsFONT 9777 dsCOORD 85 local8 dsCOLOR 0 dsWIDTH 112)
		(+= local8 11)
	)
)

(procedure (localproc_5 &tmp [temp0 25] temp25)
	(= local8 60)
	(for ((= temp25 1)) (< temp25 7) ((++ temp25))
		(Message msgGET 505 1 0 6 temp25 @temp0)
		(= local7
			(Display @temp0 dsALIGN alLEFT dsFONT 9777 dsCOORD 85 local8 dsCOLOR 0 dsWIDTH 112 dsSAVEPIXELS)
		)
		(switch temp25
			(1
				(= local1 local7)
			)
			(2
				(= local2 local7)
			)
			(3
				(= local3 local7)
			)
			(4
				(= local4 local7)
			)
			(5
				(= local5 local7)
			)
			(6
				(= local6 local7)
			)
		)
		(= temp0 0)
		(Message msgGET 505 1 0 7 temp25 @temp0)
		(Display @temp0 dsALIGN alRIGHT dsFONT 9777 dsCOORD 85 local8 dsCOLOR 0 dsWIDTH 112)
		(+= local8 11)
	)
)

(procedure (localproc_6)
	(gGame handsOn:)
	(gTheIconBar disable: 0 3 4 5 6 7)
	(gUser canControl: 0)
	(proc0_10 2)
)

(instance sWrongPassword of Script
	(properties)

	(method (changeState newState &tmp [temp0 30])
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(localproc_2)
				(= cycles 2)
			)
			(1
				(Message msgGET 505 1 0 8 1 @temp0) ; "Ha! You don't know the Password! (And I Do!!!)"
				(= local1
					(Display @temp0 dsALIGN alCENTER dsFONT 9777 dsCOORD 85 85 dsCOLOR 0 dsWIDTH 112 dsSAVEPIXELS)
				)
				(= cycles 1)
			)
			(2
				(= ticks 120)
			)
			(3
				(localproc_2)
				(= cycles 2)
			)
			(4
				(localproc_6)
				(= local9 1)
				(= local30 0)
				(self dispose:)
			)
		)
	)
)

(instance sPutLettersUp of Script
	(properties)

	(method (changeState newState &tmp [temp0 25])
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(localproc_2)
				(= cycles 5)
			)
			(1
				(localproc_0)
				(= cycles 5)
			)
			(2
				(Message msgGET 505 1 0 9 1 @temp0) ; "ENTER PASSWORD"
				(= local1
					(Display @temp0 dsALIGN alLEFT dsFONT 9777 dsCOORD 85 95 dsCOLOR 0 dsWIDTH 112 dsSAVEPIXELS)
				)
				(= cycles 1)
			)
			(3
				(localproc_6)
				(self dispose:)
			)
		)
	)
)

(instance sTurnOn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(onButt init:)
				(redLight init:)
				(sOrgSound number: 2 loop: 1 play: 127)
				(= cycles 2)
			)
			(1
				(= ticks 5)
			)
			(2
				(onButt dispose:)
				(localproc_6)
				(self dispose:)
			)
		)
	)
)

(instance sTurnOff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(localproc_2)
				(onButt init:)
				(sOrgSound number: 3 loop: 1 play: 127)
				(redLight dispose:)
				(= cycles 2)
			)
			(1
				(= ticks 5)
			)
			(2
				(onButt dispose:)
				(localproc_6)
				(self dispose:)
			)
		)
	)
)

(instance sShowPhone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(localproc_2)
				(phoneButt init:)
				(sOrgSound number: 9 loop: 1 play: 127)
				(= cycles 2)
			)
			(1
				(= ticks 5)
			)
			(2
				(phoneButt dispose:)
				(localproc_3)
				(= ticks 5)
			)
			(3
				(localproc_6)
				(self dispose:)
			)
		)
	)
)

(instance sShowBirth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(localproc_2)
				(birthButt init:)
				(sOrgSound number: 11 loop: 1 play: 127)
				(= cycles 2)
			)
			(1
				(= ticks 5)
			)
			(2
				(birthButt dispose:)
				(localproc_4)
				(= ticks 5)
			)
			(3
				(localproc_6)
				(self dispose:)
			)
		)
	)
)

(instance sShowPlane of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(localproc_2)
				(planeButt init:)
				(sOrgSound number: 10 loop: 1 play: 127)
				(= cycles 2)
			)
			(1
				(= ticks 5)
			)
			(2
				(planeButt dispose:)
				(localproc_5)
				(= ticks 5)
			)
			(3
				(localproc_6)
				(self dispose:)
			)
		)
	)
)

(instance sShowPassword of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame points: 2 12)
				(keyButt init:)
				(= cycles 1)
			)
			(1
				(= ticks 5)
			)
			(2
				(keyButt dispose:)
				(localproc_2)
				(= local1
					(Display {582} dsALIGN alCENTER dsFONT 9777 dsCOORD 85 83 dsCOLOR 0 dsWIDTH 112 dsSAVEPIXELS)
				)
				(= ticks 5)
			)
			(3
				(localproc_6)
				(self dispose:)
			)
		)
	)
)

(instance sPopLetter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch local9
					(1
						(passLet1
							loop: (register loop:)
							cel: (register cel:)
							init:
						)
					)
					(2
						(passLet2
							loop: (register loop:)
							cel: (register cel:)
							init:
						)
					)
					(3
						(passLet3
							loop: (register loop:)
							cel: (register cel:)
							init:
						)
					)
					(4
						(passLet4
							loop: (register loop:)
							cel: (register cel:)
							init:
						)
					)
					(5
						(passLet5
							loop: (register loop:)
							cel: (register cel:)
							init:
						)
					)
					(6
						(passLet6
							loop: (register loop:)
							cel: (register cel:)
							init:
						)
					)
					(7
						(passLet7
							loop: (register loop:)
							cel: (register cel:)
							init:
						)
					)
					(8
						(passLet8
							loop: (register loop:)
							cel: (register cel:)
							init:
						)
					)
					(9
						(passLet9
							loop: (register loop:)
							cel: (register cel:)
							init:
						)
					)
				)
				(++ local9)
				(= cycles 1)
			)
			(1
				(localproc_6)
				(self dispose:)
			)
		)
	)
)

(instance phoneButt of View
	(properties
		x 84
		y 141
		modNum 505
		view 505
		loop 1
		priority 15
		signal 16400
	)
)

(instance planeButt of View
	(properties
		x 104
		y 141
		modNum 505
		view 505
		loop 1
		cel 1
		priority 15
		signal 16400
	)
)

(instance birthButt of View
	(properties
		x 127
		y 141
		modNum 505
		view 505
		loop 1
		cel 2
		priority 15
		signal 16400
	)
)

(instance keyButt of View
	(properties
		x 148
		y 141
		modNum 505
		view 505
		loop 1
		cel 3
		priority 15
		signal 16400
	)
)

(instance ceButt of View ; UNUSED
	(properties
		x 170
		y 141
		modNum 505
		view 505
		loop 1
		cel 4
		priority 15
		signal 16400
	)
)

(instance redLight of View
	(properties
		x 223
		y 67
		noun 4
		modNum 505
		view 505
		loop 2
		priority 15
		signal 16400
	)
)

(instance onButt of View
	(properties
		x 222
		y 86
		modNum 505
		view 505
		loop 2
		cel 1
		priority 15
		signal 16400
	)
)

(instance enterButt of View ; UNUSED
	(properties
		x 222
		y 103
		modNum 505
		view 505
		loop 2
		cel 2
		priority 15
		signal 16400
	)
)

(instance A of View
	(properties
		x 85
		y 55
		modNum 505
		view 505
		loop 3
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (<= local9 9)
				(StrCat @local30 {A})
				(anOrganizer setScript: sPopLetter 0 self)
			else
				(anOrganizer setScript: sWrongPassword)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance B of View
	(properties
		x 95
		y 55
		modNum 505
		view 505
		loop 3
		cel 1
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (<= local9 9)
				(StrCat @local30 {B})
				(anOrganizer setScript: sPopLetter 0 self)
			else
				(anOrganizer setScript: sWrongPassword)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance C of View
	(properties
		x 105
		y 55
		modNum 505
		view 505
		loop 3
		cel 2
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (<= local9 9)
				(StrCat @local30 {C})
				(anOrganizer setScript: sPopLetter 0 self)
			else
				(anOrganizer setScript: sWrongPassword)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance D of View
	(properties
		x 115
		y 55
		modNum 505
		view 505
		loop 3
		cel 3
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (<= local9 9)
				(StrCat @local30 {D})
				(anOrganizer setScript: sPopLetter 0 self)
			else
				(anOrganizer setScript: sWrongPassword)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance E of View
	(properties
		x 125
		y 55
		modNum 505
		view 505
		loop 3
		cel 4
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (<= local9 9)
				(StrCat @local30 {E})
				(anOrganizer setScript: sPopLetter 0 self)
			else
				(anOrganizer setScript: sWrongPassword)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance F of View
	(properties
		x 135
		y 55
		modNum 505
		view 505
		loop 3
		cel 5
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (<= local9 9)
				(StrCat @local30 {F})
				(anOrganizer setScript: sPopLetter 0 self)
			else
				(anOrganizer setScript: sWrongPassword)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance G of View
	(properties
		x 145
		y 55
		modNum 505
		view 505
		loop 3
		cel 6
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (<= local9 9)
				(StrCat @local30 {G})
				(anOrganizer setScript: sPopLetter 0 self)
			else
				(anOrganizer setScript: sWrongPassword)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance H of View
	(properties
		x 155
		y 55
		modNum 505
		view 505
		loop 3
		cel 7
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (<= local9 9)
				(StrCat @local30 {H})
				(anOrganizer setScript: sPopLetter 0 self)
			else
				(anOrganizer setScript: sWrongPassword)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance I of View
	(properties
		x 165
		y 55
		modNum 505
		view 505
		loop 3
		cel 8
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (<= local9 9)
				(StrCat @local30 {I})
				(anOrganizer setScript: sPopLetter 0 self)
			else
				(anOrganizer setScript: sWrongPassword)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance J of View
	(properties
		x 175
		y 55
		modNum 505
		view 505
		loop 3
		cel 9
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (<= local9 9)
				(StrCat @local30 {J})
				(anOrganizer setScript: sPopLetter 0 self)
			else
				(anOrganizer setScript: sWrongPassword)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance K of View
	(properties
		x 185
		y 55
		modNum 505
		view 505
		loop 3
		cel 10
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (<= local9 9)
				(StrCat @local30 {K})
				(anOrganizer setScript: sPopLetter 0 self)
			else
				(anOrganizer setScript: sWrongPassword)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance L of View
	(properties
		x 85
		y 65
		modNum 505
		view 505
		loop 3
		cel 11
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (<= local9 9)
				(StrCat @local30 {L})
				(anOrganizer setScript: sPopLetter 0 self)
			else
				(anOrganizer setScript: sWrongPassword)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance M of View
	(properties
		x 95
		y 65
		modNum 505
		view 505
		loop 3
		cel 12
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (<= local9 9)
				(StrCat @local30 {M})
				(anOrganizer setScript: sPopLetter 0 self)
			else
				(anOrganizer setScript: sWrongPassword)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance N of View
	(properties
		x 105
		y 65
		modNum 505
		view 505
		loop 3
		cel 13
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (<= local9 9)
				(StrCat @local30 {N})
				(anOrganizer setScript: sPopLetter 0 self)
			else
				(anOrganizer setScript: sWrongPassword)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance O of View
	(properties
		x 115
		y 65
		modNum 505
		view 505
		loop 3
		cel 14
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (<= local9 9)
				(StrCat @local30 {O})
				(anOrganizer setScript: sPopLetter 0 self)
			else
				(anOrganizer setScript: sWrongPassword)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance P of View
	(properties
		x 125
		y 65
		modNum 505
		view 505
		loop 3
		cel 15
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (<= local9 9)
				(StrCat @local30 {P})
				(anOrganizer setScript: sPopLetter 0 self)
			else
				(anOrganizer setScript: sWrongPassword)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance Q of View
	(properties
		x 135
		y 65
		modNum 505
		view 505
		loop 4
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (<= local9 9)
				(StrCat @local30 {Q})
				(anOrganizer setScript: sPopLetter 0 self)
			else
				(anOrganizer setScript: sWrongPassword)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance R of View
	(properties
		x 145
		y 65
		modNum 505
		view 505
		loop 4
		cel 1
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (<= local9 9)
				(StrCat @local30 {R})
				(anOrganizer setScript: sPopLetter 0 self)
			else
				(anOrganizer setScript: sWrongPassword)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance S of View
	(properties
		x 155
		y 65
		modNum 505
		view 505
		loop 4
		cel 2
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (<= local9 9)
				(StrCat @local30 {S})
				(anOrganizer setScript: sPopLetter 0 self)
			else
				(anOrganizer setScript: sWrongPassword)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance T of View
	(properties
		x 165
		y 65
		modNum 505
		view 505
		loop 4
		cel 3
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (<= local9 9)
				(StrCat @local30 {T})
				(anOrganizer setScript: sPopLetter 0 self)
			else
				(anOrganizer setScript: sWrongPassword)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance U of View
	(properties
		x 175
		y 65
		modNum 505
		view 505
		loop 4
		cel 4
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (<= local9 9)
				(StrCat @local30 {U})
				(anOrganizer setScript: sPopLetter 0 self)
			else
				(anOrganizer setScript: sWrongPassword)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance V of View
	(properties
		x 185
		y 65
		modNum 505
		view 505
		loop 4
		cel 5
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (<= local9 9)
				(StrCat @local30 {V})
				(anOrganizer setScript: sPopLetter 0 self)
			else
				(anOrganizer setScript: sWrongPassword)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance W of View
	(properties
		x 85
		y 75
		modNum 505
		view 505
		loop 4
		cel 6
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (<= local9 9)
				(StrCat @local30 {W})
				(anOrganizer setScript: sPopLetter 0 self)
			else
				(anOrganizer setScript: sWrongPassword)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance X of View
	(properties
		x 95
		y 75
		modNum 505
		view 505
		loop 4
		cel 7
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (<= local9 9)
				(StrCat @local30 {X})
				(anOrganizer setScript: sPopLetter 0 self)
			else
				(anOrganizer setScript: sWrongPassword)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance Y of View
	(properties
		x 105
		y 75
		modNum 505
		view 505
		loop 4
		cel 8
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (<= local9 9)
				(StrCat @local30 {Y})
				(anOrganizer setScript: sPopLetter 0 self)
			else
				(anOrganizer setScript: sWrongPassword)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance Z of View
	(properties
		x 115
		y 75
		modNum 505
		view 505
		loop 4
		cel 9
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (<= local9 9)
				(StrCat @local30 {Z})
				(anOrganizer setScript: sPopLetter 0 self)
			else
				(anOrganizer setScript: sWrongPassword)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance passLet1 of View
	(properties
		x 95
		y 115
		noun 11
		modNum 505
		view 505
		priority 15
		signal 16
	)

	(method (doVerb theVerb)
		(screen doVerb: theVerb)
	)
)

(instance passLet2 of View
	(properties
		x 105
		y 115
		noun 11
		modNum 505
		view 505
		priority 15
		signal 16
	)

	(method (doVerb theVerb)
		(screen doVerb: theVerb)
	)
)

(instance passLet3 of View
	(properties
		x 115
		y 115
		noun 11
		modNum 505
		view 505
		priority 15
		signal 16
	)

	(method (doVerb theVerb)
		(screen doVerb: theVerb)
	)
)

(instance passLet4 of View
	(properties
		x 125
		y 115
		noun 11
		modNum 505
		view 505
		priority 15
		signal 16
	)

	(method (doVerb theVerb)
		(screen doVerb: theVerb)
	)
)

(instance passLet5 of View
	(properties
		x 135
		y 115
		noun 11
		modNum 505
		view 505
		priority 15
		signal 16
	)

	(method (doVerb theVerb)
		(screen doVerb: theVerb)
	)
)

(instance passLet6 of View
	(properties
		x 145
		y 115
		noun 11
		modNum 505
		view 505
		priority 15
		signal 16
	)

	(method (doVerb theVerb)
		(screen doVerb: theVerb)
	)
)

(instance passLet7 of View
	(properties
		x 155
		y 115
		noun 11
		modNum 505
		view 505
		priority 15
		signal 16
	)

	(method (doVerb theVerb)
		(screen doVerb: theVerb)
	)
)

(instance passLet8 of View
	(properties
		x 165
		y 115
		noun 11
		modNum 505
		view 505
		priority 15
		signal 16
	)

	(method (doVerb theVerb)
		(screen doVerb: theVerb)
	)
)

(instance passLet9 of View
	(properties
		x 175
		y 115
		noun 11
		modNum 505
		view 505
		priority 15
		signal 16
	)

	(method (doVerb theVerb)
		(screen doVerb: theVerb)
	)
)

(instance screen of Feature
	(properties
		x 141
		y 50
		noun 11
		modNum 505
		nsTop 53
		nsLeft 85
		nsBottom 128
		nsRight 197
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (gCast contains: A)
				(gMessager say: 11 4 8 1 0 505) ; "Just click on each letter and press E when you're done."
			else
				(super doVerb: theVerb)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance phone of Feature
	(properties
		x 97
		y 143
		noun 10
		modNum 505
		nsTop 137
		nsLeft 88
		nsBottom 150
		nsRight 107
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if local0
				(anOrganizer setScript: sShowPhone)
			else
				(gMessager say: 1 4 3 1 0 505) ; "Press ON to activate the organizer."
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance plane of Feature
	(properties
		x 118
		y 143
		noun 9
		modNum 505
		nsTop 137
		nsLeft 109
		nsBottom 150
		nsRight 127
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if local0
				(anOrganizer setScript: sShowPlane)
			else
				(gMessager say: 1 4 3 1 0 505) ; "Press ON to activate the organizer."
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance birth of Feature
	(properties
		x 140
		y 143
		noun 8
		modNum 505
		nsTop 137
		nsLeft 131
		nsBottom 149
		nsRight 149
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if local0
				(anOrganizer setScript: sShowBirth)
			else
				(gMessager say: 1 4 3 1 0 505) ; "Press ON to activate the organizer."
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance keyPic of Feature
	(properties
		x 160
		y 143
		noun 7
		modNum 505
		nsTop 137
		nsLeft 152
		nsBottom 150
		nsRight 169
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if local0
				(sOrgSound number: 12 loop: 1 play: 127)
				(anOrganizer setScript: sPutLettersUp)
			else
				(gMessager say: 1 4 3 1 0 505) ; "Press ON to activate the organizer."
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance ce of Feature
	(properties
		x 182
		y 143
		noun 6
		modNum 505
		nsTop 137
		nsLeft 173
		nsBottom 149
		nsRight 192
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if local0
				(sOrgSound number: 13 loop: 1 play: 127)
				(localproc_2)
			else
				(gMessager say: 1 4 3 1 0 505) ; "Press ON to activate the organizer."
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance on of Feature
	(properties
		x 229
		y 83
		noun 5
		modNum 505
		nsTop 79
		nsLeft 219
		nsBottom 87
		nsRight 239
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if local0
				(anOrganizer setScript: sTurnOff)
				(= local0 0)
			else
				(anOrganizer setScript: sTurnOn)
				(= local0 1)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance light of Feature
	(properties
		x 229
		y 65
		noun 4
		modNum 505
		nsTop 61
		nsLeft 219
		nsBottom 70
		nsRight 239
	)
)

(instance enter of Feature
	(properties
		x 228
		y 100
		noun 3
		modNum 505
		nsTop 96
		nsLeft 219
		nsBottom 105
		nsRight 238
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (gCast contains: A)
				(sOrgSound number: 4 loop: 1 play: 127)
				(if (not (StrCmp @local10 @local30))
					(anOrganizer setScript: sShowPassword)
				else
					(anOrganizer setScript: sWrongPassword)
				)
			else
				(super doVerb: theVerb)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance grill of Feature
	(properties
		x 227
		y 133
		noun 2
		modNum 505
		nsTop 121
		nsLeft 209
		nsBottom 146
		nsRight 246
	)
)

(instance anOrganizer of Inset
	(properties
		view 505
		x 66
		y 44
		hideTheCast 1
		disposeNotOnMe 1
		modNum 505
		noun 1
	)

	(method (doit)
		(super doit:)
		(cond
			((not (self onMe: gMouseX (- gMouseY 10)))
				(if (not local50)
					(gTheCursor loop: 11 cel: 0 init:)
					(= local50 1)
				)
			)
			(local50
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
				(= local50 0)
			)
		)
	)

	(method (init)
		(DrawPic 888 9)
		(super init: &rest)
		(Message msgGET 505 1 0 10 1 @local10) ; "RETHGUALS"
		(= local30 0)
		(SetFlag 5)
		((gTheIconBar at: 2) cursor: 15)
		(localproc_6)
		(screen init:)
		(phone init:)
		(plane init:)
		(birth init:)
		(keyPic init:)
		(ce init:)
		(on init:)
		(light init:)
		(enter init:)
		(grill init:)
	)

	(method (dispose)
		(sOrgSound dispose:)
		(screen dispose:)
		(phone dispose:)
		(plane dispose:)
		(birth dispose:)
		(keyPic dispose:)
		(ce dispose:)
		(on dispose:)
		(light dispose:)
		(enter dispose:)
		(grill dispose:)
		((gTheIconBar at: 2) cursor: 2)
		(ClearFlag 5)
		(DrawPic (gCurRoom picture:))
		(gGame handsOn:)
		(super dispose:)
		(DisposeScript 505)
	)
)

(instance sOrgSound of Sound
	(properties)
)

