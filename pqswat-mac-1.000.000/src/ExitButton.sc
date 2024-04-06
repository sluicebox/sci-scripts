;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4)
(include sci.sh)
(use Main)
(use Button)
(use Plane)
(use Str)
(use Print)
(use Sync)
(use WalkieTalkie)
(use Actor)
(use System)

(public
	proc4_0 0
	proc4_2 2
	proc4_3 3
	proc4_4 4
	proc4_5 5
	proc4_6 6
	proc4_7 7
	proc4_8 8
	proc4_9 9
	proc4_10 10
	proc4_11 11
	proc4_12 12
	proc4_13 13
	proc4_14 14
	proc4_15 15
	proc4_16 16
	proc4_17 17
	proc4_18 18
	proc4_19 19
	proc4_20 20
	proc4_21 21
	proc4_22 22
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
)

(procedure (proc4_0 param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3) ; UNUSED
	(= temp3 0)
	(if (not (> argc 3))
		(= temp1 (param2 x:))
		(= temp2 (param2 y:))
		(if (== argc 3)
			(= temp3 param3)
		)
	else
		(= temp1 param2)
		(= temp2 param3)
		(if (== argc 4)
			(= temp3 param4)
		)
	)
	(= temp0 (GetAngle (param1 x:) (param1 y:) temp1 temp2))
	(param1 setHeading: temp0 temp3)
)

(procedure (proc4_2 param1 param2 param3 &tmp temp0 temp1 temp2) ; UNUSED
	(switch argc
		(0
			(if (gCurRoom inset:)
				(= temp1 30)
				(= temp2 24)
			)
		)
		(1
			(= temp1 30)
			(= temp2 24)
		)
		(2
			(= temp1 param2)
			(= temp2 24)
		)
		(3
			(= temp1 param2)
			(= temp2 param3)
		)
	)
	(= temp0 (ExitButton new:))
	(temp0
		view: 984
		loop: 0
		cel: 0
		posn: temp1 temp2
		roomNum: param1
		disposeNow: 0
		code: 0
		init:
	)
)

(procedure (proc4_3 &tmp [temp0 2])) ; UNUSED

(procedure (proc4_4 &tmp temp0 temp1 temp2)
	(= temp0 (= temp1 (= local1 0)))
	(= temp0 gCast)
	((= temp1 (Plane new:))
		setRect: 0 0 (gThePlane right:) (gThePlane bottom:)
		back: 0
		picture: -2
		priority: 1000
		init:
		addCast: (= gCast (Cast new:))
	)
	(quitView init:)
	(quitYes init:)
	(quitNo init:)
	(temp1 setSize: posn: -1 -1)
	(FrameOut)
	(= local1 (gGame setCursor:))
	(gNormalCursor view: 999 loop: 0)
	(gGame setCursor: gNormalCursor 1)
	(while ((= temp2 (Event new:)) type:)
		(temp2 dispose:)
	)
	(temp2 dispose:)
	(while (== gQuit 2)
		(if ((= temp2 (Event new: 3)) type:)
			(gCast eachElementDo: #handleEvent temp2)
		)
		(temp2 dispose:)
	)
	(gCast dispose:)
	(= gCast temp0)
	(gGame setCursor: local1 1)
	(temp1 dispose:)
)

(procedure (proc4_5 param1 param2 &tmp temp0 temp1 temp2)
	(if global128
		(= global128 0)
		(if (and argc param1)
			(= temp1 param1)
		else
			(= temp1 0)
		)
		(if (> argc 1)
			(= temp2 param2)
			(WalkieTalkie killRobot: temp1 temp2)
		else
			(WalkieTalkie killRobot: temp1)
		)
	)
)

(procedure (proc4_6 param1 param2 param3 param4 param5 param6 param7 &tmp temp0 temp1 temp2)
	(if (> argc 1)
		(= temp1 param2)
	else
		(= temp1 0)
	)
	(if (> argc 2)
		(= temp2 param3)
	else
		(= temp2 0)
	)
	(WalkieTalkie
		doRobot:
			param1
			temp1
			temp2
			(if (> argc 3) param4 else 0)
			(if (not (> argc 7)) self else 0)
			(if (> argc 4) param5 else 0)
			(if (> argc 5) param6 else -1)
			(if (> argc 6) param7 else 0)
	)
	(= global128 param1)
)

(procedure (proc4_7 param1 param2 param3)
	(param1 at: param2 param3)
	(param1 at: (+ param2 1) (>> param3 $0008))
)

(procedure (proc4_8 param1 param2)
	(return
		(+ (& (param1 at: param2) $00ff) (<< (param1 at: (+ param2 1)) $0008))
	)
)

(procedure (proc4_9 &tmp temp0 temp1 temp2)
	(= temp0 (= temp1 (= local1 0)))
	(= temp0 gCast)
	((= temp1 (Plane new:))
		setRect: 0 0 (gThePlane right:) (gThePlane bottom:)
		back: 0
		picture: -2
		priority: 1000
		init:
		addCast: (= gCast (Cast new:))
	)
	(saveView init:)
	(saveYes init:)
	(saveNo init:)
	(temp1 setSize: posn: -1 -1)
	(FrameOut)
	(= local1 (gGame setCursor:))
	(gNormalCursor view: 999 loop: 0)
	(gGame setCursor: gNormalCursor 1)
	(while ((= temp2 (Event new:)) type:)
		(temp2 dispose:)
	)
	(temp2 dispose:)
	(= local2 0)
	(while (not local2)
		(if ((= temp2 (Event new: 3)) type:)
			(gCast eachElementDo: #handleEvent temp2)
		)
		(temp2 dispose:)
	)
	(gCast dispose:)
	(= gCast temp0)
	(gSwatInterface setCursor:)
	(temp1 dispose:)
	(return local2)
)

(procedure (proc4_10 &tmp temp0 temp1 temp2)
	(= temp0 (= temp1 (= local1 0)))
	(= temp0 gCast)
	((= temp1 (Plane new:))
		setRect: 0 0 (gThePlane right:) (gThePlane bottom:)
		back: 0
		picture: -2
		priority: 1000
		init:
		addCast: (= gCast (Cast new:))
	)
	(replayView init:)
	(replayYes init:)
	(replayRestore init:)
	(if argc
		(replayMap init:)
	else
		(replayMetro init:)
	)
	(temp1 setSize: posn: -1 -1)
	(FrameOut)
	(gGame handsOn:)
	(while ((= temp2 (Event new:)) type:)
		(temp2 dispose:)
	)
	(temp2 dispose:)
	(= local2 0)
	(while (not local2)
		(if ((= temp2 (Event new: 3)) type:)
			(gCast eachElementDo: #handleEvent temp2)
		)
		(temp2 dispose:)
	)
	(gCast dispose:)
	(= gCast temp0)
	(gGame handsOff:)
	(temp1 dispose:)
	(return local2)
)

(procedure (proc4_11 param1)
	(return (& [global140 (/ param1 16)] (>> $8000 (mod param1 16))))
)

(procedure (proc4_12 param1)
	(|= [global140 (/ param1 16)] (>> $8000 (mod param1 16)))
)

(procedure (proc4_13 param1)
	(&= [global140 (/ param1 16)] (~ (>> $8000 (mod param1 16))))
)

(procedure (proc4_14 param1 param2) ; UNUSED
	(return (/ (* param2 param1 100) 100))
)

(procedure (proc4_15 &tmp temp0 temp1 temp2 temp3)
	(if gAutoRobot
		(= temp2 (Robot 11)) ; FrameNum
		(= temp3 (gAutoRobot robot:))
		(= temp0 (gAutoRobot x:))
		(= temp1 (gAutoRobot y:))
		(proc4_5)
		(WalkieTalkie showFrame: temp3 (+ temp2 1) temp0 temp1)
		(= global128 temp3)
		(return temp2)
	)
)

(procedure (proc4_16 param1 param2 param3 param4 param5)
	(switch (gGame printLang:)
		(49
			(return param1)
		)
		(33
			(return param2)
		)
		(34
			(return param3)
		)
		(39
			(return param4)
		)
		(else
			(return param5)
		)
	)
)

(procedure (proc4_17 param1 param2 param3 &tmp temp0 temp1 temp2 temp3)
	(= local3 0)
	(if (and (== (gGame printLang:) 49) (ResCheck rsSYNC param1))
		(= local3 1)
		(= local4 (Sync new:))
		(DoSync syncSTART local4 param1)
		(DoSync syncNEXT local4)
		(= local7 (local4 syncTime:))
		(= local8 (local4 syncCue:))
		(Load rsMESSAGE (proc4_18 param1))
		(Load rsSCRIPT 64922 64918)
	)
	(= temp0 (Str format: {%d.vmd} param1))
	(PlayVMD 0 (temp0 data:) 1024) ; Open
	(PlayVMD 1 param2 param3) ; Put
	(PlayVMD 21 0 0 639 359) ; Black
	(if local3
		(if (== local7 -1)
			(= local7 19999)
		)
		(while (== (PlayVMD 14 19 local7) 1) ; WaitEvent
			(if (== local7 19999)
				(PlayVMD 14 3 7) ; WaitEvent
				(break)
			else
				(if local6
					(local6 dispose:)
					(= local6 0)
				)
				(if (!= local8 9999)
					(= temp1 (proc4_18 param1))
					(= temp2 (proc4_19 param1))
					(if (> (= temp3 local8) 34)
						(-= temp3 34)
						(+= temp2 1)
					)
					(= local5 (Print new:))
					(if global102
						(local5
							fore: 255
							x: 105
							y: 376
							width: 420
							font: 20071
							modeless: 2
							addTextF:
								{VMD = %d, msg file = %d, noun = %d, sequence = %d}
								param1
								temp1
								temp2
								temp3
							addText: temp2 0 0 temp3 0 12 temp1
							init:
						)
					else
						(local5
							fore: 255
							x: 105
							y: 376
							width: 420
							font: 20071
							modeless: 2
							addText: temp2 0 0 temp3 0 0 temp1
							init:
						)
					)
					(= local6 (local5 dialog:))
					(FrameOut)
					(gPrints delete: local5)
				else
					(FrameOut)
				)
				(DoSync syncNEXT local4)
				(= local7 (local4 syncTime:))
				(= local8 (local4 syncCue:))
				(if (== local7 -1)
					(= local7 19999)
				)
			)
		)
	else
		(PlayVMD 14 3) ; WaitEvent
	)
	(temp0 dispose:)
	(if local3
		(if local6
			(local6 dispose:)
			(= local6 0)
		)
		(if local4
			(DoSync syncSTOP)
			(local4 dispose:)
			(= local4 0)
		)
	)
	(PlayVMD 6) ; Close
)

(procedure (proc4_18 param1)
	(return
		(cond
			(
				(OneOf
					param1
					10315
					10316
					10317
					10318
					10319
					10320
					10324
					10328
					10335
				)
				1030
			)
			(
				(OneOf
					param1
					10513
					10515
					10516
					10517
					10518
					10519
					10520
					10521
					10524
				)
				1050
			)
			(
				(OneOf
					param1
					10711
					10723
					10724
					10725
					10726
					10727
					10728
					10729
				)
				1070
			)
			(
				(OneOf
					param1
					10802
					10803
					10804
					10805
					10806
					10807
					10808
					10809
					10811
				)
				1080
			)
			(
				(OneOf
					param1
					11015
					11016
					11017
					11018
					11019
					11020
					11022
					11023
					11024
				)
				1100
			)
			((OneOf param1 12014) 1200)
			((OneOf param1 12404 12405) 1240)
			((OneOf param1 13806) 1380)
			((OneOf param1 14208 14209 14210) 1420)
			((OneOf param1 1430 14306 14307 14308 14309 14312 14313 14314) 1430)
			((OneOf param1 14705 14706 14721 14722) 1470)
			(
				(OneOf
					param1
					15117
					15206
					15221
					15222
					15223
					15224
					15225
					15226
					15227
					15228
				)
				1510
			)
			((OneOf param1 196) 190)
			((OneOf param1 200 201) 200)
			((OneOf param1 2108 2109 2110 2111 2112 2113 2116 21160) 210)
			(
				(OneOf
					param1
					29804
					29805
					29808
					29810
					29811
					29819
					29820
					29821
					29822
					29823
					29824
				)
				2980
			)
			((OneOf param1 29913 29914 29915 29916 29917 29918) 2990)
			((OneOf param1 2041) 300)
			((OneOf param1 31407) 3140)
			(
				(OneOf
					param1
					31542
					31543
					31544
					31545
					31548
					31549
					31550
					31551
					31552
					31553
					31554
					31555
					31556
					31557
					31558
					31559
					31560
					31561
					3157
					3158
					3160
					3162
					3163
					3164
					3165
					3166
					3167
					3168
					3169
					3171
					3175
					3176
					3177
					3178
					3185
					3186
					3187
					3188
					3189
					3190
					3191
					3193
					3194
					3195
				)
				315
			)
			((OneOf param1 31604 31627) 3160)
			((OneOf param1 32001 32002 32003 32004 32013 32014 32015) 320)
			((OneOf param1 32057 32058) 3200)
			((OneOf param1 32207) 3220)
			((OneOf param1 32331) 3230)
			((OneOf param1 33306) 3330)
			((OneOf param1 34001 34002 34003 34004 34005 34006) 3400)
			((OneOf param1 34106 34107 34108 34109 34110 34111) 3410)
			(
				(OneOf
					param1
					2029
					4003
					4004
					4005
					4006
					4009
					4010
					4011
					4014
					4015
					4016
					4019
					4020
					4021
					4022
					4023
					4024
					4025
					4026
					4027
					4028
					4030
					4031
					4032
					4033
					4034
					4035
					4036
				)
				4000
			)
			(
				(OneOf
					param1
					40506
					40507
					40508
					40509
					40530
					40560
					40566
					40567
					40568
					40569
					40570
					40571
					40573
					40574
					40575
					40576
					40577
					40578
					40579
					40580
					40581
					40582
					40584
					40586
					40587
					40588
					40589
					40590
					40591
					40592
					40593
					40594
					40595
					4530
				)
				405
			)
			((OneOf param1 40518 40519) 4050)
			((OneOf param1 40604 40607 40805) 4060)
			((OneOf param1 41003) 4100)
			((OneOf param1 41002) 4220)
			((OneOf param1 4000) 4350)
			(
				(OneOf
					param1
					60023
					60029
					60030
					60032
					60034
					60051
					60052
					60053
					60054
					60055
					60056
					60057
					60058
					60065
					60067
					6008
				)
				6000
			)
			((OneOf param1 1810) 6004)
			((OneOf param1 60039 60041 60066) 6400)
			(else 25)
		)
	)
)

(procedure (proc4_19 param1)
	(return
		(cond
			((OneOf param1 41002 10802 1810) 1)
			((OneOf param1 4000 10803 40604 41003) 2)
			((OneOf param1 29913 40607 40518 10804) 3)
			((OneOf param1 29914 10805 40519) 4)
			((OneOf param1 32331 29915 29804 40805 34001 10806) 5)
			((OneOf param1 29805 32207 14705 10807 34002 29916) 6)
			((OneOf param1 34003 29808 12014 14706 10809 29917) 7)
			(
				(OneOf
					param1
					14721
					34004
					10811
					29918
					29810
					14208
					12404
					32057
				)
				8
			)
			(
				(OneOf
					param1
					10808
					32058
					34106
					14312
					29811
					14209
					31407
					10513
					33306
					34005
					13806
					12405
					14722
				)
				9
			)
			((OneOf param1 10515 14313 34006 14210 34107 29819) 10)
			((OneOf param1 34108 29820 4003 14314 15117 10711 10516) 11)
			((OneOf param1 31604 10723 4004 34109 29821 10517 14306 15206) 12)
			(
				(OneOf
					param1
					31627
					15221
					10724
					2108
					29822
					4005
					14307
					10518
					34110
					60066
				)
				13
			)
			(
				(OneOf
					param1
					10519
					10315
					11015
					29823
					1430
					4006
					10725
					60039
					34111
					31552
					15222
					2109
				)
				14
			)
			(
				(OneOf
					param1
					60041
					10316
					15223
					4009
					14309
					29824
					10520
					2110
					10726
					11016
				)
				15
			)
			((OneOf param1 2111 10727 11017 15224 4010 10521 10317) 16)
			((OneOf param1 11018 10318 2112 10524 4011 10728 15225 14308) 17)
			((OneOf param1 15226 10729 4014 2113 11019 10319) 18)
			((OneOf param1 10320 2116 11020 15227 4015 31542 196) 19)
			((OneOf param1 11022 10324 31543 21160 15228 4016) 20)
			((OneOf param1 31544 4019 11023 10328 2041) 21)
			((OneOf param1 4020 10335 31545) 22)
			((OneOf param1 11024 4021 31548) 23)
			((OneOf param1 4022 31549) 24)
			((OneOf param1 4023 31550) 25)
			((OneOf param1 31551) 26)
			((OneOf param1 31553 4024 200) 27)
			((OneOf param1 31555 4025 201) 28)
			((OneOf param1 31554 4027) 29)
			((OneOf param1 31556 4028 32001) 30)
			((OneOf param1 31557 32002 4026 60023) 31)
			((OneOf param1 2029 31558 60029 32003) 32)
			((OneOf param1 32013 31559 60030 4030) 33)
			((OneOf param1 4031 32014 31560 60032) 34)
			((OneOf param1 32004 31561 4032 60034) 35)
			((OneOf param1 32015 60051 3157 4033) 36)
			((OneOf param1 60052 3158 4034) 37)
			((OneOf param1 60053 4035 3160) 38)
			((OneOf param1 4036 3162 60055) 39)
			((OneOf param1 60054 3163) 40)
			((OneOf param1 60056 3164) 41)
			((OneOf param1 3165 60057) 42)
			((OneOf param1 60058 3166) 43)
			((OneOf param1 60065 3167) 44)
			((OneOf param1 60067 3168) 45)
			((OneOf param1 6008 3169) 46)
			((OneOf param1 3171 3175) 48)
			((OneOf param1 3176) 49)
			((OneOf param1 3177) 50)
			((OneOf param1 3178) 51)
			((OneOf param1 3185) 52)
			((OneOf param1 3186) 53)
			((OneOf param1 3187) 54)
			((OneOf param1 3188) 55)
			((OneOf param1 3189) 56)
			((OneOf param1 3190) 57)
			((OneOf param1 3191 40506) 58)
			((OneOf param1 40507 3193) 59)
			((OneOf param1 3194 40508) 60)
			((OneOf param1 40509 3195) 61)
			((OneOf param1 4530) 62)
			((OneOf param1 40530) 63)
			((OneOf param1 40560) 64)
			((OneOf param1 40566) 65)
			((OneOf param1 40567) 66)
			((OneOf param1 40568) 67)
			((OneOf param1 40569) 68)
			((OneOf param1 40570) 69)
			((OneOf param1 40571) 70)
			((OneOf param1 40573) 71)
			((OneOf param1 40574) 72)
			((OneOf param1 40575) 73)
			((OneOf param1 40576) 74)
			((OneOf param1 40577) 75)
			((OneOf param1 40578) 76)
			((OneOf param1 40579) 77)
			((OneOf param1 40580) 78)
			((OneOf param1 40581) 79)
			((OneOf param1 40582) 80)
			((OneOf param1 40584) 81)
			((OneOf param1 40586) 82)
			((OneOf param1 40587) 83)
			((OneOf param1 40588) 84)
			((OneOf param1 40589) 85)
			((OneOf param1 40590) 86)
			((OneOf param1 40591) 87)
			((OneOf param1 40592) 88)
			((OneOf param1 40593) 89)
			((OneOf param1 40594) 90)
			((OneOf param1 40595) 91)
			(else 2)
		)
	)
)

(procedure (proc4_20 param1)
	(return
		(cond
			((OneOf param1 10307 10308 10309 10310 10313) 1030)
			((OneOf param1 10514 10530) 1050)
			((OneOf param1 10701) 1070)
			((OneOf param1 11001 11004 11011) 1100)
			((OneOf param1 12409 12410) 1240)
			((OneOf param1 13705) 1370)
			((OneOf param1 13801 13802) 1380)
			((OneOf param1 13901) 1390)
			((OneOf param1 14205) 1420)
			((OneOf param1 14300 14309) 1430)
			((OneOf param1 14703 14707) 1470)
			((OneOf param1 15100) 1510)
			((OneOf param1 15200 15201 15204 15207) 1520)
			((OneOf param1 15300) 1530)
			(
				(OneOf
					param1
					1961
					1962
					1963
					1964
					1965
					1966
					1967
					1968
					1969
					19691
					19692
					19693
					19694
					19696
				)
				196
			)
			((OneOf param1 2101 2102 21020 2103 2104) 210)
			((OneOf param1 29855) 2980)
			((OneOf param1 29900) 2990)
			((OneOf param1 310 311 312 313) 310)
			((OneOf param1 31100 31102 31108 31109) 3110)
			((OneOf param1 3140 31401 31403 31404 3143) 3140)
			((OneOf param1 3150 3151 3152 3153) 315)
			((OneOf param1 31503 31505) 3150)
			((OneOf param1 31600 31606 31608) 3160)
			((OneOf param1 31700 31701 31702) 3170)
			(
				(OneOf
					param1
					32000
					32005
					32007
					32009
					32010
					32011
					32012
					32016
					32017
					32018
				)
				320
			)
			((OneOf param1 32055 32056) 3200)
			((OneOf param1 32052 32208) 3220)
			((OneOf param1 32301 32302 32321) 3230)
			((OneOf param1 32400 32404 32407 32414 32415) 3240)
			((OneOf param1 32500 32503 32504) 3250)
			((OneOf param1 32701) 3270)
			((OneOf param1 32908 32909 32910) 3290)
			((OneOf param1 33305 33330) 3330)
			((OneOf param1 33601 33607) 3360)
			((OneOf param1 33700 33701 33704 33706) 3370)
			((OneOf param1 33900) 3390)
			((OneOf param1 34101 34102 34103) 3410)
			((OneOf param1 34300) 3430)
			((OneOf param1 34401) 3440)
			((OneOf param1 34540) 3450)
			((OneOf param1 40001) 4000)
			(
				(OneOf
					param1
					4050
					40500
					4051
					40510
					40511
					40512
					4052
					4053
					40535
					40536
					4054
					40546
					4055
					40551
					40552
					40553
					40554
					40555
					40559
					4056
					40561
					40562
					40563
					40564
					40565
					4057
					40571
					4058
					4059
					40598
					40599
					40656
					4951
					4957
					49572
					40596
				)
				405
			)
			((OneOf param1 40602 40802) 4060)
			((OneOf param1 40701) 4070)
			((OneOf param1 40800) 4080)
			((OneOf param1 41000) 4100)
			((OneOf param1 41102) 4110)
			((OneOf param1 41200) 4120)
			((OneOf param1 41600 41601) 4160)
			((OneOf param1 40703 41700) 4170)
			((OneOf param1 41800) 4180)
			((OneOf param1 42500) 4250)
			((OneOf param1 42800 42801) 4280)
			((OneOf param1 42900) 4290)
			((OneOf param1 43000) 4300)
			((OneOf param1 43302 43303) 4330)
			((OneOf param1 43403) 4340)
			(
				(OneOf
					param1
					60004
					60006
					6001
					60010
					60014
					60015
					60016
					60017
					60018
					60019
					60024
					60028
					60031
				)
				6000
			)
			((OneOf param1 60002 60003 60103 60104 60113 60116 60124) 6004)
			((OneOf param1 60045 60047) 6200)
			(
				(OneOf
					param1
					40040
					40042
					40044
					60033
					60035
					60037
					60038
					60040
					60042
					60044
					60046
					60048
				)
				6400
			)
			(else 25)
		)
	)
)

(procedure (proc4_21 param1)
	(return
		(cond
			(
				(OneOf
					param1
					40602
					310
					42500
					42800
					60037
					43000
					41102
					33900
					40800
					41000
					41800
					41200
					34300
					41600
					34401
					40703
					32701
				)
				1
			)
			(
				(OneOf
					param1
					29900
					311
					32301
					40701
					41601
					41700
					42801
					42900
					43403
					60002
					60038
				)
				2
			)
			((OneOf param1 34540 1961 60003 32302 40040 43302 60045) 3)
			(
				(OneOf
					param1
					32500
					43303
					32321
					60047
					29855
					60040
					14703
					60103
					32052
					1962
					40802
					3140
				)
				4
			)
			(
				(OneOf
					param1
					312
					3143
					1963
					15300
					60104
					40042
					32503
					32208
					14707
					33607
				)
				5
			)
			(
				(OneOf
					param1
					32908
					31702
					34103
					313
					32055
					31505
					33601
					40044
					32414
					1965
					12409
					31404
					33706
					60113
					32504
				)
				6
			)
			(
				(OneOf
					param1
					33330
					32909
					10514
					13801
					32415
					31403
					12410
					1966
					33704
					34102
					31503
					60046
					32056
					31102
					13705
					31700
					14205
					60116
				)
				7
			)
			(
				(OneOf
					param1
					60124
					31108
					2101
					13802
					33305
					31600
					31401
					31701
					14300
					60042
					10530
					33701
					32910
					32400
					34101
					1964
				)
				8
			)
			((OneOf param1 1967 10307 32404 33700 31606 60044 31109 2102) 9)
			(
				(OneOf
					param1
					13901
					60048
					10308
					31100
					15200
					15100
					2103
					1968
					40001
					31608
					32407
					10701
				)
				10
			)
			((OneOf param1 11004 10309 2104 15201 1969 60035) 11)
			((OneOf param1 15207 10310 21020 19691 11001 60033) 12)
			((OneOf param1 19692 11011 10313 15204) 13)
			((OneOf param1 19693) 14)
			((OneOf param1 19694 3150) 15)
			((OneOf param1 3151 14309 19696) 16)
			((OneOf param1 60006 3152) 17)
			((OneOf param1 6001 3153) 18)
			((OneOf param1 60010) 19)
			((OneOf param1 32000 60014) 20)
			((OneOf param1 32005 60015) 21)
			((OneOf param1 60016 32009) 22)
			((OneOf param1 32010 60017 4050) 23)
			((OneOf param1 32011 40500 60018) 24)
			((OneOf param1 32012 60019 40559) 25)
			((OneOf param1 32016 60028 40565) 26)
			((OneOf param1 60031 32017 40656) 27)
			((OneOf param1 4058 32018) 28)
			((OneOf param1 60004 32007 4957) 29)
			((OneOf param1 60024 4057) 30)
			((OneOf param1 49572) 31)
			((OneOf param1 40571) 32)
			((OneOf param1 4053) 33)
			((OneOf param1 4052) 34)
			((OneOf param1 40512) 35)
			((OneOf param1 40511) 36)
			((OneOf param1 4951) 37)
			((OneOf param1 4051) 38)
			((OneOf param1 40510) 39)
			((OneOf param1 40535) 40)
			((OneOf param1 40536) 41)
			((OneOf param1 4054) 42)
			((OneOf param1 40546) 43)
			((OneOf param1 4055) 44)
			((OneOf param1 40551) 45)
			((OneOf param1 40552) 46)
			((OneOf param1 40553) 47)
			((OneOf param1 40554) 48)
			((OneOf param1 40555) 49)
			((OneOf param1 4056) 50)
			((OneOf param1 40561) 51)
			((OneOf param1 40562) 52)
			((OneOf param1 40563) 53)
			((OneOf param1 40564) 54)
			((OneOf param1 4059) 55)
			((OneOf param1 40598) 56)
			((OneOf param1 40599) 57)
			((OneOf param1 40596) 93)
			(else 2)
		)
	)
)

(procedure (proc4_22)
	(if
		(or
			(== (gGame printLang:) 49)
			(and (== gCurRoomNum 130) (== (gGame printLang:) 49)) ; profiles
		)
		(return 1)
	else
		(return 0)
	)
)

(instance doUpdateCode of Code ; UNUSED
	(properties)

	(method (doit param1)
		(if (not (& (param1 signal:) $0008))
			(UpdateScreenItem param1)
		)
	)
)

(class ExitButton of View
	(properties
		x 30
		y 24
		view 989
		disposeNow 0
		roomNum 0
		code 0
	)

	(method (init)
		(super init: &rest)
		(gMouseDownHandler addToFront: self)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(if
			(or
				(not (self onMe: event))
				(not (event type:))
				(not (gUser input:))
			)
			(super handleEvent: event)
			(return)
		)
		(= temp1 0)
		(while 1
			(= temp0 ((gUser curEvent:) new:))
			(temp0 localize: gThePlane)
			(cond
				((== (temp0 type:) 2)
					(break)
				)
				((self onMe: temp0)
					(= temp1 (= cel 1))
					(UpdateScreenItem self)
				)
				(else
					(= temp1 (= cel 0))
					(UpdateScreenItem self)
				)
			)
			(FrameOut)
			(temp0 dispose:)
		)
		(temp0 dispose:)
		(= cel 0)
		(UpdateScreenItem self)
		(FrameOut)
		(if temp1
			(event claimed: 1)
			(self doVerb:)
		else
			(super handleEvent: event)
		)
	)

	(method (doit)
		(super doit: &rest)
		(if (and disposeNow (gCurRoom inset:))
			(gCurRoom newRoom: roomNum)
		)
	)

	(method (doVerb)
		(if code
			(code doit:)
		else
			(= disposeNow 1)
		)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)
)

(instance quitView of View
	(properties
		priority 150
		fixPriority 1
		view 151
	)

	(method (init &tmp temp0 temp1)
		(= temp0 (CelWide view loop cel))
		(= temp1 (CelHigh view loop cel))
		(= x (/ (- (- (gThePlane right:) (gThePlane left:)) temp0) 2))
		(= y (/ (- (- (gThePlane bottom:) (gThePlane top:)) temp1) 2))
		(super init: &rest)
	)

	(method (onMe)
		(return 0)
	)
)

(instance quitYes of Button
	(properties
		priority 151
		fixPriority 1
		view 151
		loop 2
	)

	(method (init)
		(= x (+ (quitView x:) 16))
		(= y (+ (quitView y:) 84))
		(super init: &rest)
	)

	(method (doVerb)
		(if (gGame quitCode:)
			(= gQuit 0)
			((gGame quitCode:) doit:)
		else
			(= gQuit 1)
		)
	)
)

(instance quitNo of Button
	(properties
		priority 151
		fixPriority 1
		view 151
		loop 1
		upCel 2
		downCel 3
	)

	(method (init)
		(= x (+ (quitView x:) 166))
		(= y (+ (quitView y:) 84))
		(super init: &rest)
	)

	(method (doVerb)
		(= gQuit 0)
	)
)

(instance saveView of View
	(properties
		priority 150
		fixPriority 1
		view 152
	)

	(method (init &tmp temp0 temp1)
		(= temp0 (CelWide view loop cel))
		(= temp1 (CelHigh view loop cel))
		(= x (/ (- (- (gThePlane right:) (gThePlane left:)) temp0) 2))
		(= y (/ (- (- (gThePlane bottom:) (gThePlane top:)) temp1) 2))
		(super init: &rest)
	)

	(method (onMe)
		(return 0)
	)
)

(instance saveYes of Button
	(properties
		priority 151
		fixPriority 1
		view 152
		loop 1
		keyMessage 110
	)

	(method (init)
		(= x (+ (saveView x:) 14))
		(= y (+ (saveView y:) 83))
		(super init: &rest)
	)

	(method (doVerb)
		(= local2 1)
	)
)

(instance saveNo of Button
	(properties
		priority 151
		fixPriority 1
		view 152
		loop 1
		upCel 2
		downCel 3
		keyMessage 110
	)

	(method (init)
		(= x (+ (saveView x:) 165))
		(= y (+ (saveView y:) 83))
		(super init: &rest)
	)

	(method (doVerb)
		(= local2 2)
	)
)

(instance replayView of View
	(properties
		priority 150
		fixPriority 1
		view 155
	)

	(method (init &tmp temp0 temp1)
		(= temp0 (CelWide view loop cel))
		(= temp1 (CelHigh view loop cel))
		(= x (/ (- (- (gThePlane right:) (gThePlane left:)) temp0) 2))
		(= y (/ (- (- (gThePlane bottom:) (gThePlane top:)) temp1) 2))
		(super init: &rest)
	)

	(method (onMe)
		(return 0)
	)
)

(instance replayYes of Button
	(properties
		priority 151
		fixPriority 1
		view 155
		loop 1
		keyMessage 110
	)

	(method (init)
		(= x (+ (replayView x:) 14))
		(= y (+ (replayView y:) 80))
		(super init: &rest)
	)

	(method (doVerb)
		(= local2 1)
	)
)

(instance replayRestore of Button
	(properties
		priority 151
		fixPriority 1
		view 155
		loop 1
		upCel 2
		downCel 3
	)

	(method (init)
		(= x (+ (replayView x:) 112))
		(= y (+ (replayView y:) 80))
		(super init: &rest)
	)

	(method (doVerb)
		(= local2 2)
	)
)

(instance replayMetro of Button
	(properties
		priority 151
		fixPriority 1
		view 155
		loop 1
		upCel 4
		downCel 5
	)

	(method (init)
		(= x (+ (replayView x:) 210))
		(= y (+ (replayView y:) 80))
		(super init: &rest)
	)

	(method (doVerb)
		(= local2 3)
	)
)

(instance replayMap of Button
	(properties
		priority 151
		fixPriority 1
		view 155
		loop 1
		upCel 6
		downCel 7
	)

	(method (init)
		(= x (+ (replayView x:) 210))
		(= y (+ (replayView y:) 80))
		(super init: &rest)
	)

	(method (doVerb)
		(= local2 4)
	)
)

