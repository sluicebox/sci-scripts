;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 170)
(include sci.sh)
(use Main)
(use eRS)
(use Print)
(use MCyc)
(use Motion)
(use Actor)
(use System)

(public
	rm170 0
)

(local
	local0
	local1 = 85
	local2
	local3
	local4 = 1
	local5
	local6
	local7
	local8 = 8
	local9 = 12
	local10 = 15
	local11 = 1
	local12
	[local13 25] = [0 0 0 126 0 1 0 121 0 2 0 118 0 3 0 121 0 4 0 126 0 5 0 130 -32768]
	[local38 105] = [55 125 183 219 243 90 141 208 251 46 78 151 151 205 244 275 275 136 176 210 240 99 151 201 253 26 52 113 146 197 242 280 280 125 159 194 219 108 134 169 214 38 63 103 119 173 217 278 278 120 179 228 253 93 138 180 227 37 67 109 140 195 243 279 279 103 128 128 161 196 219 219 219 84 113 142 199 216 228 241 86 122 146 146 180 215 237 237 237 99 122 148 190 216 216 216 216 216 216 216 216 325 325 325 325]
	[local143 105] = [55 121 152 198 235 102 135 211 252 43 69 143 143 202 231 253 278 138 174 220 243 95 144 205 257 56 93 118 153 195 238 265 265 122 160 186 219 98 131 191 227 68 84 129 163 186 209 237 237 131 167 213 231 74 109 169 240 42 81 114 159 190 232 268 268 103 128 128 161 196 219 219 219 68 97 135 165 186 207 249 86 122 146 146 180 215 237 237 237 99 129 155 171 217 217 217 217 217 217 217 217 325 325 325 325]
	[local248 105] = [55 120 175 219 235 97 127 184 242 49 65 65 118 148 194 236 236 140 171 207 228 60 148 212 258 87 96 104 119 138 182 227 227 127 157 185 209 88 120 193 223 32 42 84 115 182 215 272 272 116 182 230 250 69 138 190 235 42 71 95 131 166 232 270 270 103 128 128 161 196 219 219 219 71 123 164 202 226 236 246 86 122 146 146 180 215 237 237 237 78 107 146 168 225 225 225 225 225 225 225 225 325 325 325 325]
	[local353 100]
	[local453 100]
	[local553 200]
)

(procedure (localproc_0)
	(if (<= gHowFast local9)
		(vignette view: (+ (vignette view:) 1))
	else
		(vignette1 moveSpeed: 0 setMotion: MoveTo 280 75)
		(vignette
			view: (+ (vignette1 view:) 1)
			moveSpeed: 0
			setMotion: MoveTo 160 75
		)
	)
)

(procedure (localproc_1)
	(if (<= gHowFast local9)
		(vignette view: (+ (vignette view:) 1))
	else
		(vignette moveSpeed: 0 setMotion: MoveTo 40 75)
		(vignette1
			view: (+ (vignette view:) 1)
			moveSpeed: 0
			setMotion: MoveTo 160 75
		)
	)
)

(instance rm170 of FPRoom
	(properties
		picture 150
		style 10
	)

	(method (init)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(gTheIconBar disable:)
		(gGame handsOff: setCursor: 996 1)
		(balladText init:)
		(vignette init:)
		(vignette1 init:)
		(super init:)
		(cond
			((<= gScore 939)
				(Message msgGET 170 2 0 0 2 @local453) ; "out of 999 points! Not bad fer a tenderfoot!"
			)
			((and (>= gScore 940) (<= gScore 998))
				(Message msgGET 170 2 0 0 3 @local453) ; "out of 999 points! Hold yer head up high, Buckaroo!"
			)
			((>= gScore 999)
				(Message msgGET 170 2 0 0 4 @local453) ; "out of 999 points! Yer mama'd be so proud!"
			)
		)
		(Message msgGET 170 2 0 0 1 @local353) ; "Copyright (c) 1993 Sierra On-Line. Copyright (c) 1993 Screw Loose Amusements. Thank you for playing FREDDY PHARKAS, FRONTIER PHARMACIST.  You done REAL good, kid!  Yer final score wuz"
		(Format @local553 {%s %d %s\n} @local353 gScore @local453)
		(SetQuitStr @local553)
		(gCurRoom setScript: sStartMusic)
	)

	(method (handleEvent event)
		(if (and (event type:) (== gCurRoomNum gNewRoomNum))
			(gGameMusic1 pause: 1)
			(event claimed: 1)
			(gGame setCursor: 999 1 198 175)
			(switch
				(Print
					posn: 50 160
					addButton: 1 3 0 0 1 0 0 170 ; "Restore"
					addButton: 2 3 0 0 2 (proc0_16 54 60 54 60 60) 0 170 ; "Restart"
					addButton: 0 3 0 0 3 (proc0_16 125 120 125 120 120) 0 170 ; "Continue"
					addButton: 3 3 0 0 4 179 0 170 ; "Quit"
					init:
				)
				(0
					(gGameMusic1 pause: 0)
				)
				(1
					(gGame restore:)
					(gGameMusic1 pause: 0)
				)
				(2
					(gGame restart:)
					(gGameMusic1 pause: 0)
				)
				(3
					(= gQuit 1)
				)
			)
			(gGame setCursor: 996 1)
		)
	)

	(method (dispose)
		(super dispose:)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
	)

	(method (doit &tmp temp0 [temp1 8] [temp9 64])
		(super doit:)
		(= temp0 (gGameMusic1 prevSignal:))
		(cond
			(script)
			((== temp0 local7) 0)
			(
				(OneOf
					temp0
					143
					147
					151
					159
					163
					167
					175
					179
					183
					191
					195
					199
					207
					215
					222
					231
				)
				(= local7 temp0)
				(++ local6)
				(Display {} dsRESTOREPIXELS local11)
				(Message msgGET 170 1 0 0 local6 @temp9)
				(= local11
					(Display @temp9 dsCOORD 35 137 dsCOLOR 41 dsFONT 150 dsALIGN alCENTER dsWIDTH 320 dsSAVEPIXELS)
				)
				(cond
					((== temp0 143)
						(cond
							((or (<= gHowFast local8) (== (Platform 4) 2)) 0)
							((>= gHowFast local10)
								(bouncingBall moveSpeed: 4 cycleSpeed: 4 init:)
							)
							(else
								(bouncingBall init:)
							)
						)
					)
					((== temp0 159)
						(localproc_1)
					)
					((== temp0 175)
						(localproc_0)
					)
					((== temp0 191)
						(localproc_1)
					)
					((== temp0 207)
						(localproc_0)
					)
				)
			)
			((== temp0 138)
				(balladText dispose:)
				(UnLoad 128 171)
			)
			((== temp0 140)
				(if (<= gHowFast local9)
					(vignette x: 160 y: 75 show:)
				else
					(vignette moveSpeed: 5 setMotion: MoveTo 160 75 show:)
				)
				(vignette1 show:)
			)
			((== temp0 243)
				(if (<= gHowFast local9)
					(vignette hide:)
					(vignette1 hide:)
				else
					(vignette setMotion: MoveTo 40 75)
				)
				(Display {} dsRESTOREPIXELS local11)
				(= local12 1)
			)
			((== temp0 245)
				(UnLoad 128 170)
				(gCast eachElementDo: #dispose)
				(gCurRoom setScript: sHalfDome)
			)
			((and local12 (== temp0 -1))
				(gCurRoom setScript: sTheEnd)
			)
		)
	)

	(method (cue &tmp [temp0 20])
		(if
			(and
				(> (gGameMusic1 prevSignal:) 141)
				(< (gGameMusic1 prevSignal:) 244)
				(> gHowFast local8)
			)
			(= local3
				(-
					(= local2
						(switch (gGame printLang:)
							(33 [local248 local0])
							(49 [local143 local0])
							(else [local38 local0])
						)
					)
					local1
				)
			)
			(= [local13 2] (+ local1 (/ local3 10)))
			(= [local13 6] (+ local1 (/ (* local3 3) 10)))
			(= [local13 10] (+ local1 (/ local3 2)))
			(= [local13 14] (- local2 (/ (* local3 3) 10)))
			(= [local13 18] (- local2 (/ local3 10)))
			(= [local13 22] local2)
			(bouncingBall setCycle: MCyc @local13)
			(++ local0)
			(= local1 local2)
		)
	)
)

(instance sStartMusic of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(if (== (Platform 4) 2)
					(gGameMusic1 number: 152 flags: 1 loop: 1 prevSignal: 0 play:)
				else
					(gGameMusic1
						number: 152
						flags: 1
						loop: 1
						prevSignal: 0
						play: gCurRoom
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance sHalfDome of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_15 1 3 self)
			)
			(1
				(horseAndFreddy init:)
				(gCurRoom style: 100 drawPic: 180)
				(= cycles 1)
			)
			(2
				(proc0_15 0 3 self)
			)
			(3
				(horseAndFreddy setCycle: End self)
			)
			(4
				(horseSound play:)
				(horseAndFreddy setLoop: 1 setCel: 0 setCycle: Fwd)
				(= cycles 1)
			)
			(5
				(freddyHead init: setPri: 15)
				(PalVary pvINIT 180 10)
				(= cycles 1)
			)
			(6
				(if
					(and
						(== (gGameMusic1 prevSignal:) 20)
						(not (freddyHead cycler:))
					)
					(freddyHead setCycle: End self)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(7
				(freddyHead cel: 0)
				(if
					(and
						(== (gGameMusic1 prevSignal:) 30)
						(!= (freddyHead loop:) 3)
					)
					(freddyHead loop: 3 cel: 0 setCycle: End self)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(8
				(freddyHead dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sTheEnd of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and local5 (== (PalVary pvGET_CURRENT_STEP) 64))
			(self cue:)
			(= local5 0)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(horseAndFreddy stopUpd:)
				(theEndView
					setScale: 10
					setScale:
					setPri: 15
					setStep: 5 5
					init:
					hide:
				)
				(= cycles 3)
			)
			(1
				(for ((= local0 10)) (< local0 129) ((+= local0 6))
					(Animate (gCast elements:) 1)
					(theEndView scaleX: local0 scaleY: local0 show:)
				)
				(= cycles 1)
			)
			(2
				(= local5 1)
				(PalVary pvUNINIT)
				(PalVary pvINIT 170 5)
			)
			(3
				(proc0_15 1 0 self)
			)
			(4
				(PalVary pvUNINIT)
				(gCurRoom newRoom: 790)
				(self dispose:)
			)
		)
	)
)

(instance vignette of Actor
	(properties
		x 40
		y 75
		view 1700
		priority 6
		signal 16400
		xStep 15
		moveSpeed 0
	)
)

(instance vignette1 of Actor
	(properties
		x 280
		y 75
		view 1700
		priority 6
		signal 16400
		xStep 15
		moveSpeed 0
	)
)

(instance bouncingBall of Actor
	(properties
		x 85
		y 130
		view 160
		priority 14
		signal 16400
		cycleSpeed 0
		moveSpeed 0
	)
)

(instance theEndView of Actor
	(properties
		x 152
		y 126
		view 175
		loop 4
	)
)

(instance horseAndFreddy of Prop
	(properties
		x 157
		y 81
		view 175
		cycleSpeed 12
	)
)

(instance freddyHead of Prop
	(properties
		x 155
		y 35
		view 175
		loop 2
		signal 16384
	)
)

(instance balladText of View
	(properties
		x 160
		y 90
		view 171
		priority 13
		signal 16
	)
)

(instance horseSound of FPSound
	(properties
		flags 1
		number 2114
	)
)

