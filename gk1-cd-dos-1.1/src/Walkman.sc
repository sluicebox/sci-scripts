;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 91)
(include sci.sh)
(use Main)
(use n013)
(use DIcon)
(use DText)
(use Str)
(use Array)
(use Print)
(use System)

(public
	Walkman 0
)

(local
	local0
	local1
	local2
)

(class Walkman of Obj
	(properties
		who 0
		verb 0
		noun 4
		module 0
		machine 0
		media 0
		personals 0
		personalIndex 0
		cases 0
		number 0
		index 0
		case 0
		seq 0
		k 0
		topic 0
		gabe 0
		whom 0
		textItem 0
		whomItem 0
	)

	(method (thisTeller param1 &tmp temp0)
		(return
			(if (= temp0 (global176 at: param1))
				(> (temp0 size:) (+ 1 (temp0 at: 0)))
			else
				0
			)
		)
	)

	(method (doit)
		(= gabe (Str new:))
		(Message msgGET 91 0 0 0 1 (gabe data:)) ; "Gabriel:"
		(self showTapes:)
		(while (!= who -1)
			(if (== who 15)
				(if topic
					(= topic 0)
					(self playMessages:)
				else
					(self showTapes:)
				)
			else
				(self showTopics:)
			)
		)
	)

	(method (showTapes &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		((= machine (Print new:))
			font: 30
			fore: 15
			back: 0
			x: 60
			y: 32
			addIcon: 945 1 0 -4 -4
		)
		(= temp0 0)
		(= temp1 2)
		(= temp2 1)
		(while (< temp0 15)
			(= temp1 (+ 2 (* 49 (mod temp0 4))))
			(= temp2 (+ 1 (* 29 (/ temp0 4))))
			(= temp4 (machine addIcon: 947 1 0 temp1 temp2))
			(if (self thisTeller: temp0)
				(machine addIcon: 947 2 temp0 (+ temp1 4) (+ temp2 2))
				(temp4 value: (+ temp0 1) state: 3)
			)
			(++ temp0)
		)
		(= temp1 (+ 2 (* 49 (mod temp0 4))))
		(= temp2 (+ 1 (* 29 (/ temp0 4))))
		(= temp4 (machine addIcon: 947 1 0 temp1 temp2))
		(if (IsFlag 46)
			(temp4 value: (+ temp0 1) state: 3)
			(machine addIcon: 947 2 temp0 (+ temp1 4) (+ temp2 2))
		)
		((machine addIcon: 947 3 0 202 -4) value: 0 state: 3)
		((machine dialog:) mouseHiliting: 1)
		(= who (- (machine init:) 1))
		(gGkSound1 setLoop: 1 number: 92 play:)
		(if (< -1 who 15)
			(switch who
				(0
					(= verb 54)
					(= module 50)
				)
				(1
					(= verb 27)
					(= module 50)
				)
				(2
					(= verb 82)
					(= module 51)
				)
				(3
					(= verb 83)
					(= module 51)
				)
				(4
					(= verb 103)
					(= module 52)
				)
				(5
					(= verb 102)
					(= module 52)
				)
				(6
					(= verb 110)
					(= module 53)
				)
				(7
					(= verb 109)
					(= module 53)
				)
				(8
					(= verb 112)
					(= module 54)
				)
				(9
					(= verb 111)
					(= module 54)
				)
				(10
					(= verb 117)
					(= module 55)
				)
				(11
					(= verb 118)
					(= module 55)
				)
				(12
					(= verb 127)
					(= module 56)
				)
				(13
					(= verb 126)
					(= module 56)
				)
				(14
					(= verb 128)
					(= module 57)
				)
			)
			(if cases
				(cases dispose:)
				(= cases 0)
			)
			(= cases
				(switch who
					(0
						(IntArray
							with:
								23
								24
								107
								108
								51
								52
								109
								110
								47
								111
								112
								16
								48
								104
								25
								60
								61
								114
								115
								49
								26
								27
								68
								69
								70
								103
								116
								12
								15
								105
								29
								89
								90
								4
								21
								5
								10
								95
								96
								97
								2
						)
					)
					(1
						(IntArray
							with:
								9
								13
								109
								110
								54
								55
								56
								11
								17
								8
								7
								62
								63
								64
								65
								66
								67
								3
								12
								22
								15
								14
								4
								5
								10
								1
								98
								99
								100
						)
					)
					(2
						(IntArray
							with:
								56
								9
								13
								6
								41
								11
								60
								153
								151
								152
								51
								145
								42
								35
								57
								58
								8
								64
								62
								63
								65
								66
								67
								216
								7
								85
								83
								88
								82
								81
								84
								87
								86
								3
								12
								40
								39
								38
								148
								92
								91
								93
								15
								59
								43
								149
								14
								4
								5
								10
								36
								1
								2
						)
					)
					(3
						(IntArray
							with:
								191
								189
								188
								187
								190
								186
								9
								13
								6
								11
								46
								197
								198
								199
								200
								44
								8
								45
								7
								48
								3
								12
								47
								15
								14
								205
								206
								207
								208
								209
								4
								5
								10
								1
								2
								50
						)
					)
					(4
						(IntArray
							with:
								9
								13
								6
								11
								35
								8
								7
								3
								12
								38
								15
								51
								14
								4
								39
								5
								10
								1
								2
						)
					)
					(5
						(IntArray
							with:
								75
								76
								13
								54
								55
								73
								74
								11
								35
								8
								7
								3
								12
								15
								14
								4
								5
								84
								85
								36
								37
								47
								71
								2
								87
								88
								89
						)
					)
					(6
						(IntArray
							with:
								9
								13
								6
								11
								60
								42
								43
								44
								45
								46
								128
								36
								8
								37
								7
								56
								57
								16
								58
								47
								48
								49
								12
								15
								59
								14
								4
								5
								10
								39
								40
								41
								2
						)
					)
					(7
						(IntArray
							with:
								104
								105
								67
								68
								112
								113
								72
								73
								74
								75
								76
								115
								116
								117
								35
								77
								78
								79
								80
								81
								123
								119
								120
								8
								98
								97
								93
								94
								95
								96
								7
								82
								83
								47
								48
								49
								124
								125
								15
								14
								106
								107
								108
								109
								110
								111
								10
								1
								51
								52
								53
						)
					)
					(8
						(IntArray
							with:
								9
								13
								6
								11
								35
								8
								36
								37
								38
								3
								12
								40
								41
								15
								14
								4
								53
								54
								59
								10
								1
								2
						)
					)
					(9
						(IntArray
							with:
								92
								93
								96
								91
								94
								95
								9
								68
								71
								66
								69
								70
								105
								106
								65
								13
								6
								11
								78
								63
								8
								7
								3
								12
								64
								15
								14
								51
								52
								5
								10
								1
								57
								58
								84
						)
					)
					(10
						(IntArray
							with:
								9
								76
								77
								78
								79
								36
								40
								90
								91
								93
								83
								84
								8
								37
								7
								46
								47
								48
								95
								96
								97
								15
								14
								4
								5
								86
								87
								1
								2
						)
					)
					(11
						(IntArray
							with:
								9
								76
								77
								36
								40
								85
								53
								52
								51
								49
								50
								11
								41
								8
								38
								39
								44
								45
								88
								3
								12
								15
								55
								56
								58
								14
								4
								61
								5
								10
								42
								43
								2
						)
					)
					(12
						(IntArray
							with:
								51
								52
								53
								54
								13
								6
								11
								36
								35
								8
								7
								3
								12
								15
								14
								4
								5
								10
								37
								38
								49
								50
								39
								47
								48
						)
					)
					(13
						(IntArray
							with:
								89
								51
								52
								13
								65
								66
								55
								56
								35
								40
								41
								42
								7
								3
								76
								80
								15
								83
								84
								85
								86
								87
								114
								4
								5
								60
								61
								97
								59
								94
								95
								96
								90
								98
								91
								92
								99
								100
								37
								38
								49
								2
						)
					)
					(14
						(IntArray
							with:
								9
								64
								63
								58
								59
								60
								61
								62
								13
								6
								11
								55
								8
								70
								71
								76
								7
								3
								12
								36
								73
								74
								15
								40
								47
								14
								4
								5
								10
								1
								2
								38
						)
					)
				)
			)
			(if (== module 50)
				(= noun 7)
			else
				(= noun 4)
			)
			(if whom
				(whom dispose:)
			)
			(= whom (Str new:))
			(Message msgGET 91 (+ who 1) 0 0 1 (whom data:))
			(= temp6
				(switch who
					(0 1050)
					(1 1050)
					(2 1051)
					(3 1051)
					(4 1052)
					(5 1052)
					(6 1053)
					(7 1053)
					(8 1054)
					(9 1054)
					(10 1055)
					(11 1055)
					(12 1056)
					(13 1056)
					(14 1057)
					(else 0)
				)
			)
			(= temp5 (ScriptID temp6 (mod who 2)))
			(temp5 getTranscript: setPersonals:)
			(if media
				(media dispose:)
			)
			(= media (temp5 transcript:))
			(if personals
				(personals dispose:)
			)
			(= personals (temp5 personals:))
			(if personalIndex
				(personalIndex dispose:)
			)
			(= personalIndex (temp5 personalIndex:))
			(temp5 transcript: 0)
			(temp5 personals: 0)
			(temp5 personalIndex: 0)
			(DisposeScript temp6)
		)
		(if (== who 15)
			(if whom
				(whom dispose:)
			)
			(= whom (Str new:))
			(Message msgGET 91 11 0 0 1 (whom data:)) ; "Prof. Hartridge:"
			(= module 330)
			(= noun 12)
			(= verb 0)
			(= case 1)
			(= topic 1)
		)
	)

	(method (showTopics &tmp temp0 temp1 temp2 temp3 temp4)
		((= machine (Print new:))
			font: 30
			fore: 40
			back: -1
			skip: -1
			x: 60
			y: 32
			classButton: TopicButton
			addIcon: 946 1 0 -4 -4
		)
		(= temp0 (media size:))
		(= temp2 1)
		(= temp1 -1)
		(while (< temp2 temp0)
			(if ((media at: 0) at: temp2)
				(= temp4
					(if
						(==
							(= temp3
								(if (<= temp2 15)
									16
								else
									(+ who 1)
								)
							)
							16
						)
						temp2
					else
						(- temp2 15)
					)
				)
				(++ temp1)
				(machine
					addButton:
						temp2
						temp3
						0
						temp4
						1
						(+ 2 (if (>= temp1 13) 101 else 0))
						(+ 14 (* 8 (mod temp1 13)))
						91
				)
			)
			(++ temp2)
		)
		((machine addIcon: 946 4 0 202 80) value: -1 state: 3)
		(machine addIcon: 946 3 0 202 38)
		((machine addIcon: 946 2 0 202 -4) value: 0 state: 3)
		((machine dialog:) mouseHiliting: 1)
		(= topic (machine init:))
		(switch topic
			(-1
				(= who -1)
			)
			(0
				(self showTapes:)
			)
			(else
				(self playMessages:)
			)
		)
	)

	(method (playMessages &tmp temp0 temp1 temp2)
		((= machine (Print new:))
			font: 30
			fore: 15
			back: 0
			x: 60
			y: 32
			width: 180
		)
		(machine addIcon: 945 1 0 -4 -4)
		(machine addIcon: 945 4 0 202 -4)
		(machine addIcon: 945 4 0 202 104)
		((machine addIcon: 945 9 0 202 86) value: 0 state: 3)
		(machine classIcon: TapeButton)
		((machine addIcon: 945 7 0 202 50)
			value: 1
			myRec: self
			m: module
			n: noun
			v: verb
		)
		((machine addIcon: 945 5 0 202 14)
			value: 2
			myRec: self
			m: module
			n: noun
			v: verb
		)
		((machine addIcon: 945 8 0 202 68)
			value: 3
			myRec: self
			m: module
			n: noun
			v: verb
		)
		((machine addIcon: 945 6 0 202 32)
			value: 4
			myRec: self
			m: module
			n: noun
			v: verb
		)
		(if (== who 15)
			(= seq 2)
		else
			(= number ((media at: 0) at: topic))
			(= index 0)
			(= seq 1)
			(= case ((media at: topic) at: index))
		)
		(= temp1 (Str new:))
		(= whomItem
			(machine
				addText:
					(if
						(==
							1
							(Message msgGET module noun verb case seq (temp1 data:))
						)
						gabe
					else
						whom
					)
					6
					6
			)
		)
		(whomItem fore: 46 font: 30)
		(= textItem (machine addText: temp1 6 16))
		(textItem fore: 46 font: 30)
		(temp1 dispose:)
		((machine dialog:) mouseHiliting: 1)
		(if (& gMsgType $0002)
			(if k
				(k dispose:)
			)
			(= k (IntArray with: 0 0 0 0 0))
			(Message 9 (k data:)) ; msgLAST_MESSAGE
			(DoAudio audPLAY (k at: 0) (k at: 1) (k at: 2) (k at: 3) (k at: 4))
		)
		(machine init:)
		(= local0 (= local1 0))
		(gGkSound1 setLoop: 1 number: 92 play:)
		(if (and (& gMsgType $0002) (not (or local0 local1)))
			(DoAudio audSTOP (k at: 0) (k at: 1) (k at: 2) (k at: 3) (k at: 4))
		)
	)

	(method (dispose)
		(= machine 0)
		(if media
			(media dispose:)
		)
		(if personals
			(personals dispose:)
		)
		(if personalIndex
			(personalIndex dispose:)
		)
		(if cases
			(cases dispose:)
		)
		(if gabe
			(gabe dispose:)
		)
		(if whom
			(whom dispose:)
		)
		(if k
			(k dispose:)
		)
		(= machine (= media (= personals (= personalIndex (= cases 0)))))
		(= k (= gabe (= whom (= number (= case (= seq (= topic 0)))))))
		(super dispose:)
	)
)

(class TopicButton of DText
	(properties
		state 3
		back 0
		skip 0
		highlightColor 46
		lowlightColor 40
	)

	(method (hilite param1 &tmp temp0)
		(= fore (if (and argc param1) highlightColor else lowlightColor))
		(if bitmap
			(DisposeTextBitmap bitmap)
			(= bitmap 0)
		)
		(self draw:)
		(UpdateScreenItem self)
	)
)

(class TapeButton of DIcon
	(properties
		state 1
		myRec 0
		m 0
		n 0
		v 0
	)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(= temp2 (myRec case:))
		(= temp3 (myRec seq:))
		(= temp6 (myRec index:))
		(= temp4 (myRec number:))
		(= temp8 (myRec k:))
		(if (and (& gMsgType $0002) (not (or local0 local1)))
			(DoAudio
				audSTOP
				(temp8 at: 0)
				(temp8 at: 1)
				(temp8 at: 2)
				(temp8 at: 3)
				(temp8 at: 4)
			)
		)
		(if (== 15 (myRec who:))
			(switch value
				(1
					(gGkSound1 setLoop: 1 number: 92 play:)
					(cond
						(local1
							(= local1 0)
						)
						((and (not local0) (!= 34 temp3))
							(++ temp3)
						)
					)
				)
				(2
					(gGkSound1 setLoop: 1 number: 92 play:)
					(cond
						(local0
							(= local0 0)
						)
						((and (not local1) (!= 2 temp3))
							(-- temp3)
						)
					)
				)
				(3
					(gGkSound1 setLoop: 1 number: 91 play:)
					(if (not local0)
						(if local1
							(= local1 0)
						)
						(cond
							((== temp3 34)
								(= local0 1)
							)
							((> (+= temp3 7) 34)
								(= temp3 34)
							)
						)
					)
				)
				(4
					(gGkSound1 setLoop: 1 number: 91 play:)
					(if (not local1)
						(if local0
							(= local0 0)
						)
						(cond
							((== temp3 2)
								(= local1 1)
							)
							((< (-= temp3 7) 2)
								(= temp3 2)
							)
						)
					)
				)
			)
		else
			(= temp5 ((myRec media:) at: (myRec topic:)))
			(switch value
				(1
					(gGkSound1 setLoop: 1 number: 92 play:)
					(cond
						(local0 1)
						(local1
							(= local1 0)
						)
						(else
							(++ temp3)
							(if (not (Message msgSIZE m n v temp2 temp3))
								(++ temp6)
								(if (== temp6 temp4)
									(-- temp6)
									(-- temp3)
									(= local0 1)
								else
									(= temp3 1)
								)
								(= temp2 (temp5 at: temp6))
							)
						)
					)
				)
				(2
					(gGkSound1 setLoop: 1 number: 92 play:)
					(cond
						(local1 1)
						(local0
							(= local0 0)
						)
						((not (-- temp3))
							(if (not temp6)
								(++ temp3)
								(= local1 1)
							else
								(= temp2 (temp5 at: (-- temp6)))
								(for
									((= temp3 1))
									(Message msgSIZE m n v temp2 temp3)
									((++ temp3))
								)
								(-- temp3)
							)
						)
					)
				)
				(3
					(gGkSound1 setLoop: 1 number: 91 play:)
					(if local1
						(= local1 0)
					)
					(if (not local0)
						(while (< (++ temp6) temp4)
							(if
								(!=
									-1
									((myRec cases:) indexOf: (temp5 at: temp6))
								)
								(break)
							)
						)
						(if (== temp6 temp4)
							(-- temp6)
							(= temp2 (temp5 at: temp6))
							(for
								((= temp3 1))
								(Message msgSIZE m n v temp2 temp3)
								((++ temp3))
							)
							(-- temp3)
							(= local0 1)
						else
							(= temp3 1)
						)
						(= temp2 (temp5 at: temp6))
					)
				)
				(4
					(gGkSound1 setLoop: 1 number: 91 play:)
					(if local0
						(= local0 0)
					)
					(if (not local1)
						(= temp3 1)
						(if temp6
							(while (-- temp6)
								(if
									(!=
										-1
										((myRec cases:)
											indexOf: (temp5 at: temp6)
										)
									)
									(break)
								)
							)
						else
							(= local1 1)
						)
						(= temp2 (temp5 at: temp6))
					)
				)
			)
		)
		(myRec case: temp2)
		(myRec seq: temp3)
		(myRec index: temp6)
		(= temp1 (Str new:))
		(if (or local0 local1)
			(Message msgGET 920 3 0 (if local0 15 else 16) 1 (temp1 data:))
		else
			(= temp0
				(if (== 1 (Message msgGET m n v temp2 temp3 (temp1 data:)))
					(myRec gabe:)
				else
					(myRec whom:)
				)
			)
		)
		(= temp7 ((myRec textItem:) text:))
		((myRec textItem:) text: (temp1 data:))
		(temp1 data: temp7 dispose:)
		(KString 4 ((myRec whomItem:) text:)) ; StrFree
		((myRec whomItem:)
			text:
				(KString
					8 ; StrDup
					(if (or local0 local1)
						{ }
					else
						(KString 9 temp0) ; StrGetData
					)
				)
		)
		(= temp0 (myRec whomItem:))
		(= temp1 (myRec textItem:))
		(if (= temp7 (temp0 bitmap:))
			(DisposeTextBitmap temp7)
			(temp0 bitmap: 0)
		)
		(if (= temp7 (temp1 bitmap:))
			(DisposeTextBitmap temp7)
			(temp1 bitmap: 0)
		)
		(temp0 setSize: 180 draw:)
		(temp1 setSize: 180 draw:)
		(UpdateScreenItem temp0)
		(UpdateScreenItem temp1)
		(FrameOut)
		(if (and (& gMsgType $0002) (not (or local0 local1)))
			(if temp8
				(temp8 dispose:)
			)
			(= temp8 (IntArray with: 0 0 0 0 0))
			(Message 9 (temp8 data:)) ; msgLAST_MESSAGE
			(DoAudio
				audPLAY
				(temp8 at: 0)
				(temp8 at: 1)
				(temp8 at: 2)
				(temp8 at: 3)
				(temp8 at: 4)
			)
			(myRec k: temp8)
		)
	)
)

