;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 255)
(include sci.sh)
(use Main)
(use System)

(public
	Print 0
	ShowView 1
	GetInput 2
	GetNumber 3
	Printf 4
	MousedOn 5
)

(procedure (StillDown &tmp event ret)
	(= event (Event sel_109:))
	(= ret (!= (event sel_31:) 2))
	(event sel_111:)
	(return ret)
)

(procedure (MousedOn obj event) ; UNUSED
	(return
		(and
			(< (obj sel_7:) (event sel_1:) (obj sel_9:))
			(< (obj sel_6:) (event sel_0:) (obj sel_8:))
		)
	)
)

(procedure (GetInput str maxLen prompt &tmp [temp0 4])
	(if (Print (if (>= argc 3) prompt else {}) 38 str maxLen &rest)
		(StrLen str)
	)
)

(procedure (ShowView txt v l c) ; UNUSED
	(Print txt 79 v l c &rest)
)

(procedure (Print args &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 [temp12 6] temp18 temp19 temp20 [temp21 1001] temp1022 temp1023 temp1024 temp1025 temp1026 temp1027 temp1028 temp1029 temp1030 temp1031 temp1032)
	(= temp1028 0)
	(= temp1029 0)
	(= temp6 (= temp7 -1))
	(= temp1026 (gGame sel_84:))
	(= temp1027 (gGame sel_85:))
	(= temp1032
		(= temp9
			(= temp8
				(= temp18
					(= temp2 (= temp3 (= temp1023 (= temp1030 (= temp19 0)))))
				)
			)
		)
	)
	((= temp0 (Dialog sel_109:)) sel_32: gSystemWindow sel_20: {PrintD})
	(cond
		((u< [args 0] 1000)
			(GetFarText [args 0] [args 1] @temp21)
			(= temp5 2)
		)
		([args 0]
			(StrCpy @temp21 [args 0])
			(= temp5 1)
		)
		(else
			(= temp21 0)
			(= temp5 0)
		)
	)
	(for ((= temp1022 0)) (StrAt @temp21 temp1022) ((++ temp1022))
		(if
			(and
				(== (StrAt @temp21 temp1022) 14848)
				(== (StrAt @temp21 (+ 1 temp1022)) 74)
			)
			(gGame sel_84: 1 sel_85: 81)
			(StrSplit @temp21 @temp21 {#J})
			(gGame sel_84: temp1026 sel_85: temp1027)
			(StrAt @temp21 temp1022 0)
			(if (OneOf 81 temp1026 temp1027)
				((= temp1023 (DText sel_109:))
					sel_23: (+ @temp21 2 temp1022)
					sel_30: 900
					sel_20: {jDText}
				)
			)
		)
	)
	((= temp1 (DText sel_109:)) sel_23: @temp21 sel_30: gUserFont)
	(= temp1024 (if (and temp1023 (== temp1026 81)) temp1023 else temp1))
	(= temp1025
		(cond
			((== temp1027 81) temp1023)
			(temp1023
				(if temp1027
					temp1
				else
					(temp1 sel_111:)
					(= temp1 0)
				)
			)
		)
	)
	(temp1024 sel_175: 4 4 sel_173:)
	(temp0 sel_118: temp1024 sel_173:)
	(if temp1025
		(temp1025 sel_173: sel_175: (temp1024 sel_7:) (+ 4 (temp1024 sel_8:)))
		(temp0 sel_118: temp1025 sel_173:)
	)
	(for ((= temp5 temp5)) (< temp5 argc) ((++ temp5))
		(switch [args temp5]
			(27
				(++ temp5)
				(if (and temp1 (not temp1025))
					(temp1 sel_27: [args temp5])
				)
			)
			(30
				(++ temp5)
				(if temp1
					(temp1 sel_30: [args temp5] sel_173: temp8)
				)
			)
			(67
				(= temp1028 1)
				(= temp8 [args (++ temp5)])
				(temp1024 sel_173: temp8)
				(if temp1025
					(temp1025
						sel_173: temp8
						sel_175: (temp1024 sel_7:) (+ 4 (temp1024 sel_8:))
					)
				)
			)
			(22
				(++ temp5)
				(temp0 sel_22: [args temp5])
			)
			(77
				(++ temp5)
				(temp0 sel_23: [args temp5])
			)
			(64
				(= temp6 [args (++ temp5)])
				(= temp7 [args (++ temp5)])
			)
			(80
				(Animate (gCast sel_24:) 0)
			)
			(38
				(++ temp5)
				((= temp3 (DEdit sel_109:)) sel_23: [args temp5])
				(++ temp5)
				(temp3 sel_34: [args temp5] sel_173:)
			)
			(78
				((= [temp12 temp19] (DButton sel_109:))
					sel_23: [args (++ temp5)]
					sel_74: [args (++ temp5)]
					sel_173:
				)
				(+= temp18 (+ ([temp12 temp19] sel_9:) 4))
				(++ temp19)
			)
			(79
				(= temp1029 1)
				(if (IsObject [args (+ temp5 1)])
					(= temp2 ([args (+ temp5 1)] sel_109:))
					(temp2 sel_173:)
					(+= temp5 1)
				else
					(= temp2 (DIcon sel_109:))
					(temp2
						sel_2: [args (+ temp5 1)]
						sel_3: [args (+ temp5 2)]
						sel_4: [args (+ temp5 3)]
						sel_173:
					)
					(+= temp5 3)
				)
			)
			(111
				(if (and (< (+ temp5 1) argc) (IsObject [args (+ temp5 1)]))
					(temp0 sel_142: [args (+ temp5 1)])
					(++ temp5)
				)
				(if (!= 0 81)
					(if gModelessDialog
						(gModelessDialog sel_111:)
					)
					(= temp9 temp0)
				)
			)
			(32
				(++ temp5)
				(temp0 sel_32: [args temp5])
			)
			(124
				(= temp1032 1)
			)
			(182
				(++ temp5)
				(temp0 sel_182: [args temp5])
			)
		)
	)
	(if temp1032
		(= temp9 0)
	)
	(if
		(and
			(not (or temp1028 temp1029))
			(> (- (temp0 sel_8:) (temp0 sel_6:)) 100)
		)
		(temp1024 sel_173: 300)
		(if temp1025
			(temp1025
				sel_173: 300
				sel_175: (temp1024 sel_7:) (+ 4 (temp1024 sel_8:))
			)
		)
	)
	(if temp2
		(temp2 sel_175: 4 4)
		(if (or (== temp1024 temp1023) (== temp1025 temp1023))
			(= temp1030 8)
		)
		(if (& (temp2 sel_29:) $0010)
			(temp1024
				sel_175: (+ 4 temp1030) (+ (temp2 sel_8:) (temp1024 sel_6:))
				sel_173:
			)
		else
			(temp1024
				sel_175: (+ 4 (temp2 sel_9:) temp1030) (temp1024 sel_6:)
				sel_173:
			)
		)
		(if temp1025
			(temp1025 sel_175: (temp1024 sel_7:) (+ 4 (temp1024 sel_8:)))
		)
		(temp0 sel_118: temp2)
	)
	(temp0 sel_173:)
	(if temp3
		(temp3
			sel_175:
				((or temp1025 temp1024) sel_7:)
				(+ 4 ((or temp1025 temp1024) sel_8:))
		)
		(temp0 sel_118: temp3 sel_173:)
	)
	(= temp20
		(if (> temp18 (temp0 sel_9:))
			4
		else
			(- (temp0 sel_9:) temp18)
		)
	)
	(for ((= temp5 0)) (< temp5 temp19) ((++ temp5))
		([temp12 temp5] sel_175: temp20 (temp0 sel_8:))
		(temp0 sel_118: [temp12 temp5])
		(= temp20 (+ 4 ([temp12 temp5] sel_9:)))
	)
	(temp0 sel_173: sel_186:)
	(if
		(or
			(and temp2 (& (temp2 sel_29:) $0010))
			(and temp2 (not (StrLen @temp21)))
		)
		(temp2
			sel_175:
				(/
					(-
						(- (temp0 sel_9:) (temp0 sel_7:))
						(- (temp2 sel_9:) (temp2 sel_7:))
					)
					2
				)
				4
		)
	)
	(temp0
		sel_175:
			(if (== -1 temp6)
				(temp0 sel_7:)
			else
				temp6
			)
			(if (== -1 temp7)
				(temp0 sel_6:)
			else
				temp7
			)
	)
	(= temp11 (GetPort))
	(temp0
		sel_183: (| (if (temp0 sel_23:) 4) (if temp9 8)) (if temp9 15 else -1)
	)
	(if temp9
		(= gModelessPort (GetPort))
		(SetPort temp11)
		(return (= gModelessDialog temp9))
	else
		(gSounds sel_160: 1)
	)
	(if (and (= temp10 (temp0 sel_120: 178 1)) (not (temp0 sel_120: 178 2)))
		(temp10 sel_29: (| (temp10 sel_29:) $0002))
	)
	(if (== (= temp4 (temp0 sel_57: temp10)) -1)
		(= temp4 0)
	)
	(for ((= temp5 0)) (< temp5 temp19) ((++ temp5))
		(if (== temp4 [temp12 temp5])
			(= temp4 (temp4 sel_74:))
			(break)
		)
	)
	(if (not (temp0 sel_180:))
		(= temp4 1)
	)
	(temp0 sel_111:)
	(gSounds sel_160: 0)
	(return temp4)
)

(procedure (GetNumber string default &tmp [theLine 40]) ; UNUSED
	(= theLine 0)
	(if (> argc 1)
		(Format @theLine 255 0 default) ; "%d"
	)
	(return
		(if (GetInput @theLine 5 string)
			(ReadNumber @theLine)
		else
			-1
		)
	)
)

(procedure (Printf &tmp [str 500])
	(Format @str &rest)
	(Print @str)
)

(class DItem of Obj
	(properties
		sel_20 0
		sel_31 0
		sel_29 0
		sel_6 0
		sel_7 0
		sel_8 0
		sel_9 0
		sel_21 0
		sel_72 0
		sel_74 0
	)

	(method (sel_170 param1)
		(if param1
			(|= sel_29 $0001)
		else
			(&= sel_29 $fffe)
		)
	)

	(method (sel_171 param1)
		(if param1
			(|= sel_29 $0008)
		else
			(&= sel_29 $fff7)
		)
		(self sel_80:)
	)

	(method (sel_132 param1 &tmp temp0 temp1 temp2)
		(if (param1 sel_73:)
			(return 0)
		)
		(= temp0 0)
		(if
			(and
				(& sel_29 $0001)
				(or
					(and (== (= temp1 (param1 sel_31:)) 128) (Said sel_72))
					(and (== temp1 4) (== (param1 sel_37:) sel_21))
					(and (== temp1 1) (self sel_167: param1))
				)
			)
			(param1 sel_73: 1)
			(= temp0 (self sel_172: param1))
		)
		(return temp0)
	)

	(method (sel_167 param1)
		(return
			(and
				(>= (param1 sel_1:) sel_7)
				(>= (param1 sel_0:) sel_6)
				(< (param1 sel_1:) sel_9)
				(< (param1 sel_0:) sel_8)
			)
		)
	)

	(method (sel_172 param1 &tmp temp0 temp1)
		(if (== 1 (param1 sel_31:))
			(= temp1 0)
			(repeat
				(= param1 (Event sel_109: -32768))
				(param1 sel_147:)
				(if (!= (= temp0 (self sel_167: param1)) temp1)
					(HiliteControl self)
					(= temp1 temp0)
				)
				(param1 sel_111:)
				(breakif (not (StillDown)))
			)
			(if temp0
				(HiliteControl self)
			)
			(return temp0)
		else
			(return self)
		)
	)

	(method (sel_177 param1)
		(return (== sel_31 param1))
	)

	(method (sel_178 param1)
		(return (& sel_29 param1))
	)

	(method (sel_57)
		(return sel_74)
	)

	(method (sel_173))

	(method (sel_174 param1 param2)
		(+= sel_9 param1)
		(+= sel_7 param1)
		(+= sel_6 param2)
		(+= sel_8 param2)
	)

	(method (sel_175 param1 param2)
		(self sel_174: (- param1 sel_7) (- param2 sel_6))
	)

	(method (sel_80)
		(DrawControl self)
	)

	(method (sel_179))
)

(class DText of DItem
	(properties
		sel_20 {DText}
		sel_31 2
		sel_23 0
		sel_30 1
		sel_27 0
	)

	(method (sel_109 &tmp temp0)
		((super sel_109:) sel_30: gUserFont sel_117:)
	)

	(method (sel_173 param1 &tmp [temp0 4])
		(TextSize
			@[temp0 0]
			sel_23
			sel_30
			(if argc param1 else 0)
			{\0d\n----------\0d\n}
		)
		(= sel_8 (+ sel_6 [temp0 2]))
		(= sel_9 (+ sel_7 [temp0 3]))
	)
)

(class DIcon of DItem
	(properties
		sel_20 {DIcon}
		sel_31 4
		sel_2 0
		sel_3 0
		sel_4 0
	)

	(method (sel_173 &tmp [temp0 4])
		(= sel_9 (+ sel_7 (CelWide sel_2 sel_3 sel_4)))
		(= sel_8 (+ sel_6 (CelHigh sel_2 sel_3 sel_4)))
	)
)

(class DButton of DItem
	(properties
		sel_20 {DButton}
		sel_31 1
		sel_29 3
		sel_23 0
		sel_30 0
	)

	(method (sel_173 &tmp [temp0 4])
		(TextSize @[temp0 0] sel_23 sel_30 0 0)
		(+= [temp0 2] 2)
		(+= [temp0 3] 2)
		(= sel_8 (+ sel_6 [temp0 2]))
		(= [temp0 3] (* (/ (+ [temp0 3] 15) 16) 16))
		(= sel_9 (+ [temp0 3] sel_7))
	)
)

(class DEdit of DItem
	(properties
		sel_20 {DEdit}
		sel_31 3
		sel_29 1
		sel_23 0
		sel_30 0
		sel_34 0
		sel_33 0
	)

	(method (sel_172 param1)
		(EditControl self param1)
		(return self)
	)

	(method (sel_173 &tmp [temp0 4])
		(= sel_30 gInputFont)
		(TextSize @[temp0 0] {M} sel_30 0 0)
		(= sel_8 (+ sel_6 [temp0 2]))
		(= sel_9 (+ sel_7 (/ (* [temp0 3] sel_34 3) 4)))
		(= sel_33 (StrLen sel_23))
	)
)

(class Dialog of List
	(properties
		sel_20 {Dialog}
		sel_23 0
		sel_32 0
		sel_180 0
		sel_6 0
		sel_7 0
		sel_8 0
		sel_9 0
		sel_22 0
		sel_181 0
		sel_142 0
		sel_136 0
		sel_137 0
		sel_182 0
		sel_139 0
		sel_138 0
	)

	(method (sel_183 param1 param2)
		(if (and (PicNotValid) gCast)
			(Animate (gCast sel_24:) 0)
		)
		(= sel_32 (sel_32 sel_109:))
		(sel_32
			sel_187: sel_6
			sel_188: sel_7
			sel_189: sel_8
			sel_190: sel_9
			sel_77: sel_23
			sel_31: param1
			sel_60: param2
			sel_183:
		)
		(= sel_138 (* sel_22 60))
		(self sel_80:)
	)

	(method (sel_80)
		(self sel_119: 80)
	)

	(method (sel_57 param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(= gGameTime (+ gTickOffset (GetTime)))
		(= temp0 0)
		(= sel_181 1)
		(self sel_119: 110)
		(if sel_180
			(sel_180 sel_171: 0)
		)
		(= sel_180
			(if (and argc param1)
				param1
			else
				(self sel_120: 178 1)
			)
		)
		(if sel_180
			(sel_180 sel_171: 1)
		)
		(if (not sel_180)
			(= temp3 gEatMice)
			(= temp4 (GetTime))
		else
			(= temp3 0)
		)
		(= temp2 0)
		(= sel_139 (+ gTickOffset (GetTime)))
		(while (not temp2)
			(gSounds sel_119: 167)
			(= gGameTime (+ gTickOffset (GetTime)))
			(self sel_119: 179)
			(if sel_182
				(sel_182 sel_57:)
			)
			(= temp1 ((Event sel_109:) sel_147:))
			(if temp3
				(-- temp3)
				(if (== (temp1 sel_31:) 1)
					(temp1 sel_31: 0)
				)
				(while (== temp4 (GetTime))
				)
				(= temp4 (GetTime))
			)
			(= temp2 (self sel_132: temp1))
			(temp1 sel_111:)
			(self sel_167:)
			(if (or (== temp2 -1) (not sel_181))
				(= temp2 0)
				(EditControl sel_180 0)
				(break)
			)
			(Wait 1)
		)
		(= sel_181 0)
		(return temp2)
	)

	(method (sel_167 &tmp temp0)
		(if (and sel_138 (u< (+ sel_138 sel_139) gGameTime))
			(= sel_138 0)
			(self sel_144:)
		)
	)

	(method (sel_144)
		(if (not sel_181)
			(self sel_111:)
		else
			(= sel_181 0)
		)
	)

	(method (sel_111 &tmp temp0)
		(self sel_119: 111 sel_125:)
		(if (== self gModelessDialog)
			(SetPort gModelessPort)
			(= gModelessDialog 0)
			(= gModelessPort 0)
		)
		(if sel_32
			(sel_32 sel_111:)
		)
		(= sel_180 (= sel_32 0))
		(= temp0 sel_142)
		(super sel_111:)
		(if temp0
			(temp0 sel_144:)
		)
	)

	(method (sel_184 &tmp temp0 temp1)
		(if sel_180
			(sel_180 sel_171: 0)
			(= temp1 (self sel_122: sel_180))
			(repeat
				(if (not (= temp1 (self sel_65: temp1)))
					(= temp1 (self sel_124:))
				)
				(= sel_180 (NodeValue temp1))
				(if (& (sel_180 sel_29:) $0001)
					(break)
				)
			)
			(sel_180 sel_171: 1)
			(gGame
				sel_191:
					gTheCursor
					1
					(+
						(sel_180 sel_7:)
						(/ (- (sel_180 sel_9:) (sel_180 sel_7:)) 2)
					)
					(- (sel_180 sel_8:) 3)
			)
		)
	)

	(method (sel_185 &tmp temp0 temp1)
		(if sel_180
			(sel_180 sel_171: 0)
			(= temp1 (self sel_122: sel_180))
			(repeat
				(if (not (= temp1 (self sel_127: temp1)))
					(= temp1 (self sel_126:))
				)
				(= sel_180 (NodeValue temp1))
				(if (& (sel_180 sel_29:) $0001)
					(break)
				)
			)
			(sel_180 sel_171: 1)
			(gGame
				sel_191:
					gTheCursor
					1
					(+
						(sel_180 sel_7:)
						(/ (- (sel_180 sel_9:) (sel_180 sel_7:)) 2)
					)
					(- (sel_180 sel_8:) 3)
			)
		)
	)

	(method (sel_132 param1 &tmp temp0)
		(if (& (param1 sel_31:) $0040)
			(param1 sel_31: 4)
			(switch (param1 sel_37:)
				(5
					(param1 sel_37: 20480)
				)
				(1
					(param1 sel_37: 18432)
				)
				(7
					(param1 sel_37: 19200)
				)
				(3
					(param1 sel_37: 19712)
				)
				(else
					(param1 sel_31: 64)
				)
			)
		)
		(if
			(or
				(param1 sel_73:)
				(== (param1 sel_31:) 0)
				(and
					(!= 1 (param1 sel_31:))
					(!= 4 (param1 sel_31:))
					(!= 64 (param1 sel_31:))
					(!= 256 (param1 sel_31:))
				)
			)
			(EditControl sel_180 param1)
			(return 0)
		)
		(if (= temp0 (self sel_120: 132 param1))
			(EditControl sel_180 0)
			(if (not (temp0 sel_178: 2))
				(if sel_180
					(sel_180 sel_171: 0)
				)
				((= sel_180 temp0) sel_171: 1)
				(temp0 sel_57:)
				(= temp0 0)
			)
		else
			(= temp0 0)
			(cond
				(
					(and
						(or
							(== (param1 sel_31:) 256)
							(and
								(== 4 (param1 sel_31:))
								(== 13 (param1 sel_37:))
							)
						)
						sel_180
						(sel_180 sel_178: 1)
					)
					(= temp0 sel_180)
					(EditControl sel_180 0)
					(param1 sel_73: 1)
				)
				(
					(or
						(and
							(not (self sel_120: 178 1))
							(or
								(and
									(== 4 (param1 sel_31:))
									(== 13 (param1 sel_37:))
								)
								(== 1 (param1 sel_31:))
								(== 256 (param1 sel_31:))
							)
						)
						(and (== 4 (param1 sel_31:)) (== 27 (param1 sel_37:)))
					)
					(param1 sel_73: 1)
					(= temp0 -1)
				)
				(
					(and
						(IsObject sel_180)
						(sel_180 sel_177: 3)
						(== (param1 sel_31:) 4)
						(== (param1 sel_37:) 19712)
					)
					(if (>= (sel_180 sel_33:) (StrLen (sel_180 sel_23:)))
						(self sel_184:)
					else
						(EditControl sel_180 param1)
					)
				)
				(
					(and
						(IsObject sel_180)
						(sel_180 sel_177: 3)
						(== (param1 sel_31:) 4)
						(== (param1 sel_37:) 19200)
					)
					(if (<= (sel_180 sel_33:) 0)
						(self sel_185:)
					else
						(EditControl sel_180 param1)
					)
				)
				(
					(and
						(== 4 (param1 sel_31:))
						(OneOf (param1 sel_37:) 9 19712 20480)
					)
					(param1 sel_73: 1)
					(self sel_184:)
				)
				(
					(and
						(== 4 (param1 sel_31:))
						(OneOf (param1 sel_37:) 3840 19200 18432)
					)
					(param1 sel_73: 1)
					(self sel_185:)
				)
				(else
					(EditControl sel_180 param1)
				)
			)
		)
		(return temp0)
	)

	(method (sel_174 param1 param2)
		(+= sel_9 param1)
		(+= sel_7 param1)
		(+= sel_6 param2)
		(+= sel_8 param2)
	)

	(method (sel_175 param1 param2)
		(self sel_174: (- param1 sel_7) (- param2 sel_6))
	)

	(method (sel_186)
		(self
			sel_175:
				(+
					(sel_32 sel_17:)
					(/
						(-
							(- (sel_32 sel_19:) (sel_32 sel_17:))
							(- sel_9 sel_7)
						)
						2
					)
				)
				(+
					(sel_32 sel_16:)
					(/
						(-
							(- (sel_32 sel_18:) (sel_32 sel_16:))
							(- sel_8 sel_6)
						)
						2
					)
				)
		)
	)

	(method (sel_173 &tmp temp0 temp1 [temp2 4])
		(if sel_23
			(TextSize @[temp2 0] sel_23 0 -1 0)
			(= sel_6 [temp2 0])
			(= sel_7 [temp2 1])
			(= sel_8 [temp2 2])
			(= sel_9 [temp2 3])
		else
			(= sel_9 (= sel_8 (= sel_7 (= sel_6 0))))
		)
		(for ((= temp0 (self sel_124:))) temp0 ((= temp0 (self sel_65: temp0)))
			(= temp1 (NodeValue temp0))
			(if (< (temp1 sel_7:) sel_7)
				(= sel_7 (temp1 sel_7:))
			)
			(if (< (temp1 sel_6:) sel_6)
				(= sel_6 (temp1 sel_6:))
			)
			(if (> (temp1 sel_9:) sel_9)
				(= sel_9 (temp1 sel_9:))
			)
			(if (> (temp1 sel_8:) sel_8)
				(= sel_8 (temp1 sel_8:))
			)
		)
		(+= sel_9 4)
		(+= sel_8 4)
		(self sel_175: 0 0)
	)
)

