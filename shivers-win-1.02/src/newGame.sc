;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 922)
(include sci.sh)
(use Main)
(use n951)
(use Plane)
(use Str)
(use Array)
(use Print)
(use File)
(use Game)
(use Actor)
(use System)

(public
	newGame 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance buttonCast of Cast
	(properties)
)

(instance newGame of Room
	(properties)

	(method (init &tmp temp0)
		(= local2 0)
		(= local4 (IntArray new: 21))
		(= temp0 (Str new:))
		(= local3 (Save 5 {SHIVER} (temp0 data:) (local4 data:))) ; GetSaveFiles
		(temp0 dispose:)
		(gGame handsOn:)
		(gKeyDownHandler addToFront: self)
		(= local1
			((Plane new:)
				picture: 922
				priority: 40
				init: 0 0 320 200
				addCast: buttonCast
				yourself:
			)
		)
		(buttonCast plane: local1)
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
		(backspaceBtn init:)
		(playBtn init:)
		(cancelBtn init:)
		(autosaveBtn init:)
		(playBtn hide:)
		(super init:)
		(switch (Random 0 7)
			(0
				(proc951_9 35031)
				(gSounds play: 35031 0 92 0)
			)
			(1
				(proc951_9 35033)
				(gSounds play: 35033 0 92 0)
			)
			(2
				(proc951_9 35034)
				(gSounds play: 35034 0 92 0)
			)
			(3
				(proc951_9 35036)
				(gSounds play: 35036 0 92 0)
			)
			(4
				(proc951_9 35037)
				(gSounds play: 35037 0 92 0)
			)
			(5
				(proc951_9 35038)
				(gSounds play: 35038 0 92 0)
			)
			(6
				(proc951_9 35039)
				(gSounds play: 35039 0 92 0)
			)
			(7
				(proc951_9 35040)
				(gSounds play: 35040 0 92 0)
			)
		)
	)

	(method (handleEvent event &tmp [temp0 2])
		(switch (event type:)
			(evKEYBOARD
				(cond
					((OneOf (event message:) KEY_A KEY_a)
						(addLetter doit: 0)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_B KEY_b)
						(addLetter doit: 1)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_C KEY_c)
						(addLetter doit: 2)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_D KEY_d)
						(addLetter doit: 3)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_E KEY_e)
						(addLetter doit: 4)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_F KEY_f)
						(addLetter doit: 5)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_G KEY_g)
						(addLetter doit: 6)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_H KEY_h)
						(addLetter doit: 7)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_I KEY_i)
						(addLetter doit: 8)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_J KEY_j)
						(addLetter doit: 9)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_K KEY_k)
						(addLetter doit: 10)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_L KEY_l)
						(addLetter doit: 11)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_M KEY_m)
						(addLetter doit: 12)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_N KEY_n)
						(addLetter doit: 13)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_O KEY_o)
						(addLetter doit: 14)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_P KEY_p)
						(addLetter doit: 15)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_Q KEY_q)
						(addLetter doit: 16)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_R KEY_r)
						(addLetter doit: 17)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_S KEY_s)
						(addLetter doit: 18)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_T KEY_t)
						(addLetter doit: 19)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_U KEY_u)
						(addLetter doit: 20)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_V KEY_v)
						(addLetter doit: 21)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_W KEY_w)
						(addLetter doit: 22)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_X KEY_x)
						(addLetter doit: 23)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_Y KEY_y)
						(addLetter doit: 24)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_Z KEY_z)
						(addLetter doit: 25)
						(event claimed: 1)
					)
					((== (event message:) JOY_UPLEFT)
						(removeLetter doit:)
					)
					((and (== (event message:) KEY_RETURN) (> local2 0))
						(composeName doit:)
					)
				)
			)
		)
		(event claimed: 1)
		(super handleEvent: event &rest)
	)

	(method (dispose)
		(gSounds stop: 35031)
		(gSounds stop: 35033)
		(gSounds stop: 35034)
		(gSounds stop: 35036)
		(gSounds stop: 35037)
		(gSounds stop: 35038)
		(gSounds stop: 35039)
		(gSounds stop: 35040)
		(local4 dispose:)
		(gKeyDownHandler delete: self)
		(local1 dispose:)
		(super dispose:)
	)
)

(class Alphabet of Prop
	(properties
		view 922
	)

	(method (init)
		(super init: buttonCast)
		(gMouseDownHandler add: self)
	)

	(method (handleEvent event &tmp [temp0 2])
		(event localize: local1)
		(if
			(and
				(self onMe: event)
				(& (event type:) evMOUSEBUTTON)
				(gUser canControl:)
			)
			(gGame handsOff:)
			(event claimed: 1)
			(self setScript: sButton)
		)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(buttonCast delete: self)
		(super dispose: &rest)
	)
)

(instance A of Alphabet
	(properties
		x 66
		y 111
	)
)

(instance B of Alphabet
	(properties
		x 157
		y 132
		loop 1
	)
)

(instance C of Alphabet
	(properties
		x 121
		y 132
		loop 2
	)
)

(instance D of Alphabet
	(properties
		x 102
		y 111
		loop 3
	)
)

(instance E of Alphabet
	(properties
		x 93
		y 89
		loop 4
	)
)

(instance F of Alphabet
	(properties
		x 120
		y 111
		loop 5
	)
)

(instance G of Alphabet
	(properties
		x 138
		y 111
		loop 6
	)
)

(instance H of Alphabet
	(properties
		x 156
		y 111
		loop 7
	)
)

(instance I of Alphabet
	(properties
		x 183
		y 89
		loop 8
	)
)

(instance J of Alphabet
	(properties
		x 174
		y 111
		loop 9
	)
)

(instance K of Alphabet
	(properties
		x 192
		y 111
		loop 10
	)
)

(instance L of Alphabet
	(properties
		x 211
		y 111
		loop 11
	)
)

(instance M of Alphabet
	(properties
		x 193
		y 132
		loop 12
	)
)

(instance N of Alphabet
	(properties
		x 175
		y 132
		loop 13
	)
)

(instance O of Alphabet
	(properties
		x 201
		y 89
		loop 14
	)
)

(instance P of Alphabet
	(properties
		x 219
		y 89
		loop 15
	)
)

(instance Q of Alphabet
	(properties
		x 57
		y 89
		loop 16
	)
)

(instance R of Alphabet
	(properties
		x 111
		y 89
		loop 17
	)
)

(instance S of Alphabet
	(properties
		x 84
		y 111
		loop 18
	)
)

(instance T of Alphabet
	(properties
		x 129
		y 89
		loop 19
	)
)

(instance U of Alphabet
	(properties
		x 165
		y 89
		loop 20
	)
)

(instance V of Alphabet
	(properties
		x 139
		y 132
		loop 21
	)
)

(instance W of Alphabet
	(properties
		x 75
		y 89
		loop 22
	)
)

(instance X of Alphabet
	(properties
		x 103
		y 132
		loop 23
	)
)

(instance Y of Alphabet
	(properties
		x 147
		y 89
		loop 24
	)
)

(instance Z of Alphabet
	(properties
		x 85
		y 132
		loop 25
	)
)

(instance backspaceBtn of Alphabet
	(properties
		x 124
		y 153
		loop 26
	)
)

(instance playBtn of Alphabet
	(properties
		x 40
		y 184
		loop 27
	)
)

(instance cancelBtn of Alphabet
	(properties
		x 90
		y 184
		loop 28
	)
)

(instance autosaveBtn of Alphabet
	(properties
		x 151
		y 184
		loop 29
	)

	(method (init)
		(if (IsFlag 60)
			(self loop: 30)
		else
			(self loop: 29)
		)
		(super init: &rest)
	)
)

(instance letter1 of Actor
	(properties
		x 94
		y 79
		priority 240
		fixPriority 1
		view 922
		loop -65
		cel 2
	)

	(method (init)
		(super init: buttonCast)
	)
)

(instance letter2 of Actor
	(properties
		y 79
		priority 241
		fixPriority 1
		view 922
		loop -65
		cel 2
	)

	(method (init)
		(super init: buttonCast)
	)
)

(instance letter3 of Actor
	(properties
		y 79
		priority 242
		fixPriority 1
		view 922
		loop -65
		cel 2
	)

	(method (init)
		(super init: buttonCast)
	)
)

(instance letter4 of Actor
	(properties
		y 79
		priority 243
		fixPriority 1
		view 922
		loop -65
		cel 2
	)

	(method (init)
		(super init: buttonCast)
	)
)

(instance letter5 of Actor
	(properties
		y 79
		priority 244
		fixPriority 1
		view 922
		loop -65
		cel 2
	)

	(method (init)
		(super init: buttonCast)
	)
)

(instance letter6 of Actor
	(properties
		y 79
		priority 245
		fixPriority 1
		view 922
		loop -65
		cel 2
	)

	(method (init)
		(super init: buttonCast)
	)
)

(instance letter7 of Actor
	(properties
		y 79
		priority 246
		fixPriority 1
		view 922
		loop -65
		cel 2
	)

	(method (init)
		(super init: buttonCast)
	)
)

(instance letter8 of Actor
	(properties
		y 79
		priority 247
		fixPriority 1
		view 922
		loop -65
		cel 2
	)

	(method (init)
		(super init: buttonCast)
	)
)

(instance sButton of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 1)
				(UpdateScreenItem client)
				(switch (client loop:)
					(26
						(gSounds play: 15032 0 90 self)
					)
					(27
						(gSounds play: 15038 0 90 self)
					)
					(28
						(gSounds play: 15026 0 90 self)
					)
					(29
						(gSounds play: 15026 0 90 self)
					)
					(30
						(gSounds play: 15026 0 90 self)
					)
					(else
						(gSounds play: 15032 0 90 self)
					)
				)
			)
			(1
				(gGame handsOn:)
				(if (and (< local2 8) (< (client loop:) 26))
					(addLetter doit: (client loop:))
				)
				(if (and (> local2 0) (== (client loop:) 26))
					(removeLetter doit:)
				)
				(if (== (client loop:) 27)
					(composeName doit:)
				)
				(if (== (client loop:) 28)
					(gCurRoom newRoom: 910) ; shiversLogo
				)
				(if (or (== (client loop:) 29) (== (client loop:) 30))
					(if (IsFlag 60)
						(ClearFlag 60)
						(client loop: 29)
					else
						(SetFlag 60)
						(client loop: 30)
					)
				)
				(client cel: 0)
				(UpdateScreenItem client)
				(= cycles 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance addLetter of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(if (and (< local2 8) (< param1 27))
			(switch local2
				(0
					(letter1 loop: param1 init:)
				)
				(1
					(letter2
						loop: param1
						x: (+ (CelWide 922 (letter1 loop:) 2) (letter1 x:))
						init:
					)
				)
				(2
					(letter3
						loop: param1
						x: (+ (CelWide 922 (letter2 loop:) 2) (letter2 x:))
						init:
					)
				)
				(3
					(letter4
						loop: param1
						x: (+ (CelWide 922 (letter3 loop:) 2) (letter3 x:))
						init:
					)
				)
				(4
					(letter5
						loop: param1
						x: (+ (CelWide 922 (letter4 loop:) 2) (letter4 x:))
						init:
					)
				)
				(5
					(letter6
						loop: param1
						x: (+ (CelWide 922 (letter5 loop:) 2) (letter5 x:))
						init:
					)
				)
				(6
					(letter7
						loop: param1
						x: (+ (CelWide 922 (letter6 loop:) 2) (letter6 x:))
						init:
					)
				)
				(7
					(letter8
						loop: param1
						x: (+ (CelWide 922 (letter7 loop:) 2) (letter7 x:))
						init:
					)
				)
			)
			(++ local2)
			(playBtn show:)
		)
	)
)

(instance removeLetter of Code
	(properties)

	(method (doit)
		(if (> local2 0)
			(switch (- local2 1)
				(0
					(letter1 loop: -65 hide:)
				)
				(1
					(letter2 loop: -65 hide:)
				)
				(2
					(letter3 loop: -65 hide:)
				)
				(3
					(letter4 loop: -65 hide:)
				)
				(4
					(letter5 loop: -65 hide:)
				)
				(5
					(letter6 loop: -65 hide:)
				)
				(6
					(letter7 loop: -65 hide:)
				)
				(7
					(letter8 loop: -65 hide:)
				)
			)
			(if (== (-- local2) 0)
				(playBtn hide:)
			)
		)
	)
)

(instance composeName of Code
	(properties)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp4 1)
		(global528 at: 0 (+ (letter1 loop:) 65))
		(global528 at: 1 (+ (letter2 loop:) 65))
		(global528 at: 2 (+ (letter3 loop:) 65))
		(global528 at: 3 (+ (letter4 loop:) 65))
		(global528 at: 4 (+ (letter5 loop:) 65))
		(global528 at: 5 (+ (letter6 loop:) 65))
		(global528 at: 6 (+ (letter7 loop:) 65))
		(global528 at: 7 (+ (letter8 loop:) 65))
		(global528 at: 8 0)
		(= global539 local3)
		(= temp4 1)
		(for ((= temp0 0)) (< temp0 local3) ((++ temp0))
			(= temp1 (File new:))
			(= temp2 (Str new:))
			(= temp3 (Str format: {%s%d.SG} gCurSaveDir (local4 at: temp0)))
			(temp1 name: (temp3 data:))
			(temp1 open: 1 readString: temp2 10 close:)
			(temp2 strip:)
			(if (== (KString 7 (temp2 data:) (global528 data:)) 0) ; StrCmp
				(gSounds stop: 35031)
				(gSounds stop: 35033)
				(gSounds stop: 35034)
				(gSounds stop: 35036)
				(gSounds stop: 35037)
				(gSounds stop: 35038)
				(gSounds stop: 35039)
				(gSounds stop: 35040)
				(gGame setCursor: gNormalCursor)
				(switch
					(Print
						addBitmap: 928 7 0
						addButtonBM: 928 4 0 0 {} 130 40
						addButtonBM: 928 5 0 1 {} 80 40
						init:
					)
					(0
						(temp1 dispose:)
						(temp3 dispose:)
						(temp2 dispose:)
						(return)
					)
					(1
						(= global539 (local4 at: temp0))
						(= temp4 2)
					)
				)
			)
			(temp1 dispose:)
			(temp3 dispose:)
			(temp2 dispose:)
		)
		(if (== temp4 1)
			(if (> (+ local3 1) 20)
				(gSounds stop: 35031)
				(gSounds stop: 35033)
				(gSounds stop: 35034)
				(gSounds stop: 35036)
				(gSounds stop: 35037)
				(gSounds stop: 35038)
				(gSounds stop: 35039)
				(gSounds stop: 35040)
				(gGame setCursor: gNormalCursor)
				(switch
					(Print
						addBitmap: 928 0 0
						addButtonBM: 928 2 0 0 {} 105 40
						init:
					)
					(0
						(return)
					)
				)
			)
			(if (not (FileIO 17 2 (KString 9 gCurSaveDir))) ; CheckFreeSpace, StrGetData
				(gSounds stop: 35031)
				(gSounds stop: 35033)
				(gSounds stop: 35034)
				(gSounds stop: 35036)
				(gSounds stop: 35037)
				(gSounds stop: 35038)
				(gSounds stop: 35039)
				(gSounds stop: 35040)
				(gGame setCursor: gNormalCursor)
				(switch
					(Print
						addBitmap: 928 6 0
						addButtonBM: 928 2 0 0 {} 105 40
						init:
					)
					(0
						(return)
					)
				)
			)
			(for ((= temp5 0)) 1 ((++ temp5))
				(for ((= temp0 0)) (< temp0 local3) ((++ temp0))
					(breakif (== temp5 (local4 at: temp0)))
				)
				(if (== temp0 local3)
					(break)
				)
			)
			(= global539 temp5)
		)
		(gCurRoom newRoom: 930) ; introMovie
	)
)

