;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 150)
(include sci.sh)
(use Main)
(use eRS)
(use Print)
(use MCyc)
(use LoadMany)
(use Window)
(use Motion)
(use Actor)
(use System)

(public
	rm150 0
)

(local
	i
	curX = 85
	destX
	xDiff
	doThis = 1
	choice = 1
	choice2
	local7
	local8
	local9 = 8
	local10 = 12
	local11 = 15
	local12 = 1
	[local13 25] = [0 0 0 126 0 1 0 121 0 2 0 118 0 3 0 121 0 4 0 126 0 5 0 130 -32768]
	[local38 270] = [85 135 174 211 229 100 139 192 236 51 76 110 144 185 237 264 264 110 164 215 244 118 166 204 223 69 88 124 133 183 223 249 249 103 128 128 161 196 219 219 219 93 113 138 179 199 212 223 86 122 146 146 180 215 237 237 237 117 139 164 188 207 207 207 207 207 207 207 207 124 189 226 251 98 144 197 243 30 51 87 101 165 238 283 283 115 179 230 247 97 150 191 239 39 69 111 133 177 232 277 277 134 171 212 234 104 151 202 244 64 88 132 153 191 232 262 262 124 159 202 236 91 145 193 239 66 86 130 150 201 234 254 254 103 128 128 161 196 219 219 219 96 117 141 186 201 212 222 86 122 146 146 180 215 237 237 237 101 131 156 198 222 222 222 222 222 222 222 222 139 180 202 219 127 145 193 212 45 74 112 148 199 249 280 280 120 172 221 238 104 164 203 248 50 78 119 151 191 256 278 278 131 178 219 236 130 167 200 233 32 59 133 169 221 260 283 283 120 175 221 244 106 165 199 245 51 79 118 144 194 236 272 272 103 128 128 161 196 219 219 219 85 106 136 170 194 218 239 86 122 146 146 180 215 237 237 237 99 122 148 190 216 216 216 216 216 216 325 325 325]
)

(procedure (SlideViewRight)
	(if (<= gHowFast local10)
		(vignette setLoop: (+ (vignette loop:) 1))
	else
		(vignette1 moveSpeed: 0 setMotion: MoveTo 280 80)
		(vignette
			setLoop: (+ (vignette1 loop:) 1)
			moveSpeed: 0
			setMotion: MoveTo 160 80
		)
	)
)

(procedure (SlideViewLeft)
	(if (<= gHowFast local10)
		(vignette setLoop: (+ (vignette loop:) 1))
	else
		(vignette moveSpeed: 0 setMotion: MoveTo 40 80)
		(vignette1
			setLoop: (+ (vignette loop:) 1)
			moveSpeed: 0
			setMotion: MoveTo 160 80
		)
	)
)

(instance rm150 of FPRoom
	(properties
		picture 150
		style 10
	)

	(method (init)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(gTheIconBar disable:)
		(gGame setCursor: 996 1)
		(LoadMany rsVIEW 150 151)
		(balladText init:)
		(vignette init: hide:)
		(vignette1 init: hide:)
		(super init:)
		(if (== (Platform 4) 2)
			(gGameMusic1 number: 150 flags: 1 loop: 1 prevSignal: 0 play:)
		else
			(gGameMusic1 number: 150 flags: 1 loop: 1 prevSignal: 0 play: self)
		)
	)

	(method (handleEvent event)
		(if (and (event type:) (== gCurRoomNum gNewRoomNum))
			(event claimed: 1)
			(gGameMusic1 pause: 1)
			(gCurRoom setScript: sShowChoices)
		)
	)

	(method (dispose)
		(super dispose:)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
	)

	(method (doit &tmp temp0 [temp1 8] [temp9 64])
		(super doit:)
		(cond
			((== (= temp0 (gGameMusic1 prevSignal:)) local8) 0)
			(gFastCast 0)
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
					183
					190
					199
					211
					215
					219
					227
					231
					235
					243
					247
					251
					259
					263
					267
					275
					283
					290
					299
					311
					315
					319
					327
					331
					335
					343
					347
					351
					359
					363
					367
					375
					383
					390
					399
				)
				(= local8 temp0)
				(++ local7)
				(Display {} dsRESTOREPIXELS local12)
				(if (<= local7 36)
					(Message msgGET 150 1 0 0 local7 @temp9)
				else
					(Message msgGET 150 2 0 0 (- local7 36) @temp9)
				)
				(= local12
					(Display @temp9 dsCOORD 35 137 dsCOLOR 41 dsFONT 150 dsALIGN alCENTER dsWIDTH 320 dsSAVEPIXELS)
				)
				(cond
					((== temp0 143)
						(bouncingBall show:)
					)
					((== temp0 159)
						(SlideViewLeft)
					)
					((== temp0 175)
						(SlideViewRight)
					)
					((== temp0 211)
						(SlideViewLeft)
					)
					((== temp0 227)
						(vignette view: 151)
						(SlideViewRight)
					)
					((== temp0 243)
						(vignette1 view: 151)
						(SlideViewLeft)
					)
					((== temp0 275)
						(UnLoad 128 150)
						(SlideViewRight)
					)
					((== temp0 311)
						(SlideViewLeft)
					)
					((== temp0 327)
						(vignette view: 152)
						(SlideViewRight)
					)
					((== temp0 343)
						(vignette1 view: 152)
						(SlideViewLeft)
					)
					((== temp0 359)
						(SlideViewRight)
					)
					((== temp0 375)
						(SlideViewLeft)
					)
				)
			)
			((== temp0 137)
				(cond
					((or (<= gHowFast local9) (== (Platform 4) 2)) 0)
					((>= gHowFast local11)
						(bouncingBall moveSpeed: 4 cycleSpeed: 4 init: hide:)
					)
					(else
						(bouncingBall init: hide:)
					)
				)
			)
			((== temp0 138)
				(balladText dispose:)
				(UnLoad 128 153)
			)
			((== temp0 140)
				(if (<= gHowFast local10)
					(vignette x: 160 y: 80 show:)
				else
					(vignette
						setLoop: 0
						moveSpeed: 5
						setMotion: MoveTo 160 80
						show:
					)
				)
				(vignette1 show:)
			)
			((== temp0 304)
				(LoadMany rsVIEW 152)
			)
			((== temp0 409)
				(if (<= gHowFast local10)
					(vignette hide:)
					(vignette1 hide:)
				else
					(vignette1 setMotion: MoveTo 280 80)
				)
				(Display {} dsRESTOREPIXELS local12)
			)
			((== temp0 -1)
				(if (IsFlag 101)
					(ClearFlag 101)
					(gCurRoom newRoom: 110)
				else
					(gCurRoom newRoom: 26) ; actBreak
				)
			)
		)
	)

	(method (cue)
		(if
			(and
				(> (gGameMusic1 prevSignal:) 141)
				(< (gGameMusic1 prevSignal:) 412)
				(> gHowFast local9)
			)
			(= xDiff (- (= destX [local38 i]) curX))
			(= [local13 2] (+ curX (/ xDiff 10)))
			(= [local13 6] (+ curX (/ (* xDiff 3) 10)))
			(= [local13 10] (+ curX (/ xDiff 2)))
			(= [local13 14] (- destX (/ (* xDiff 3) 10)))
			(= [local13 18] (- destX (/ xDiff 10)))
			(= [local13 22] destX)
			(bouncingBall setCycle: MCyc @local13)
			(++ i)
			(= curX destX)
		)
	)
)

(instance sShowChoices of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame setCursor: 999 1 176 175)
				(switch
					(Print
						posn: 46 160
						font: gUserFont
						addButton: 1 19 0 0 1 0 0 0 ; "Restore"
						addButton: 0 19 0 0 2 55 0 0 ; "Continue"
						addButton: 3 19 0 0 3 110 0 0 ; "Play"
						addButton: 4 19 0 0 4 149 0 0 ; "Help"
						addButton: 2 19 0 0 5 188 0 0 ; "Quit"
						init:
					)
					(0
						(gGameMusic1 pause: 0)
						(= choice 0)
						(= choice2 0)
					)
					(1
						(gGame restore:)
						(= choice 1)
						(= choice2 0)
					)
					(2
						(= choice 0)
						(= choice2 0)
						(= gQuit 1)
					)
					(3
						(= choice 0)
						(gGameMusic1 fade:)
						(gCast eachElementDo: #hide)
						(Animate (gCast elements:) 0)
						(gCurRoom newRoom: 26) ; actBreak
					)
					(4
						(= choice 1)
						(= choice2 1)
					)
				)
				(= cycles 1)
			)
			(1
				(if choice2
					(switch
						(Print
							window: SysWindow
							font: gUserFont
							addTitle: 17 0 0 1 110
							addButton: 1 4 0 0 1 0 0 110 ; "Sierra Customer Service"
							addButton: 2 5 0 0 1 0 17 110 ; "Sierra Sales"
							addButton: 3 6 0 0 1 0 34 110 ; "Sierra Technical Support"
							addButton: 4 7 0 0 1 0 51 110 ; "Technical Trouble-Shooting Tips"
							addButton: 5 8 0 0 1 0 68 110 ; "Warranty Information"
							addButton: 6 9 0 0 1 0 85 110 ; "Game Hints"
							addButton: 0 10 0 0 1 0 102 110 ; "EXIT"
							init:
						)
						(0
							(= choice 1)
							(= choice2 0)
							(= cycles 1)
						)
						(1
							(gMessager say: 11 0 0 0 self 110) ; "Call Sierra Customer Service for inquiries about returned merchandise, back orders, defective merchandise, company policy, and general game information. You can call Sierra Customer Service at |c2|(800) 743-7725|c|, 8:15 A.M. - 4:45 P.M. Pacific time, Monday-Friday."
						)
						(2
							(gMessager say: 12 0 0 0 self 110) ; "To place an order with Sierra On-Line, call |c2|(800) 326-6654|c| from 7:00 a.m. through 7:00 p.m. Pacific Time, Monday through Friday, for convenient, person-to-person service."
						)
						(3
							(gMessager say: 13 0 0 0 self 110) ; "Technical assistance is only a telephone call away. Call |c2|(209) 683-8989|c| for convenient, person-to-person service. If you prefer, you may request assistance by fax |c0|(209) 683-3633|c| or mail."
						)
						(4
							(gMessager say: 14 0 0 0 self 110) ; "If you're experiencing any type of technical difficulties with your program, here are some suggestions we recommend you try."
						)
						(5
							(gMessager say: 15 0 0 0 self 110) ; "If you need to send for replacement diskettes, send the original disk #1 to:"
						)
						(6
							(gMessager say: 16 0 0 0 self 110) ; "No, this isn't a menu of hints. You'd cheat. We know you would, because we play games, too, and we cheat every chance we get."
						)
					)
				else
					(= cycles 1)
				)
			)
			(2
				(if choice2
					(self changeState: 1)
				else
					(= cycles 1)
				)
			)
			(3
				(if choice
					(self changeState: 0)
				else
					(= cycles 1)
				)
			)
			(4
				(gGame setCursor: 996 1)
				(self dispose:)
			)
		)
	)
)

(instance vignette of Actor
	(properties
		x 40
		y 80
		view 150
		priority 6
		signal 16400
		xStep 15
		moveSpeed 0
	)
)

(instance vignette1 of Actor
	(properties
		x 280
		y 80
		view 150
		priority 6
		signal 16400
		xStep 15
		moveSpeed 0
	)
)

(instance bouncingBall of Actor
	(properties
		x 105
		y 130
		view 160
		priority 14
		signal 16400
		cycleSpeed 0
		moveSpeed 0
	)
)

(instance balladText of View
	(properties
		x 160
		y 90
		view 153
		priority 13
		signal 16
	)
)

