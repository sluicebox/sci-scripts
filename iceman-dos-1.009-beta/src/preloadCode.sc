;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 819)
(include sci.sh)
(use Main)
(use Submarine_806)
(use RegionPath)
(use SmoothLooper)
(use System)

(public
	preloadCode 0
)

(instance preloadCode of Code
	(properties)

	(method (doit param1)
		(cond
			(
				(OneOf
					param1
					1
					2
					3
					4
					5
					6
					7
					8
					9
					10
					11
					12
					13
					14
					16
					15
					199
					24
					8
					16
					17
					18
					19
					20
					21
					22
					23
				)
				(cond
					((== global101 0)
						((ScriptID 371) init:) ; tahitiInv
					)
					((== global101 2)
						((ScriptID 372) dispose:) ; subInv
						((ScriptID 371) init:) ; tahitiInv
					)
					((== global101 3)
						((ScriptID 374) dispose:) ; tunaInv
						((ScriptID 371) init:) ; tahitiInv
					)
				)
				(= global101 1)
			)
			(
				(OneOf
					param1
					25
					26
					27
					28
					29
					30
					31
					32
					33
					34
					35
					36
					37
					38
					39
					40
					41
					42
					51
					50
					53
					54
					55
					56
					57
					58
					61
					45
					46
					47
					59
					60
					63
					64
					65
					66
					67
					68
					62
					43
				)
				(cond
					((== global101 0)
						((ScriptID 372) init:) ; subInv
					)
					((== global101 1)
						((ScriptID 371) dispose:) ; tahitiInv
						((ScriptID 372) init:) ; subInv
					)
					((== global101 3)
						((ScriptID 374) dispose:) ; tunaInv
						((ScriptID 372) init:) ; subInv
					)
				)
				(= global101 2)
			)
			(
				(OneOf
					param1
					70
					71
					72
					73
					74
					75
					76
					77
					78
					79
					80
					81
					82
					83
					84
					85
					86
				)
				(cond
					((== global101 0)
						((ScriptID 374) init:) ; tunaInv
					)
					((== global101 1)
						((ScriptID 371) dispose:) ; tahitiInv
						((ScriptID 374) init:) ; tunaInv
					)
					((== global101 2)
						((ScriptID 372) dispose:) ; subInv
						((ScriptID 374) init:) ; tunaInv
					)
				)
				(= global101 3)
			)
		)
		(if
			(OneOf
				param1
				1
				2
				3
				4
				5
				6
				7
				8
				9
				10
				11
				12
				13
				14
				16
				15
				199
				24
				8
				16
			)
			(ScriptID 300) ; tahiti
		)
		(if (OneOf param1 1 2 3 4 5 7 12 13 9 24 8 16)
			(ScriptID 301) ; Water
			RegionPath
		)
		(if (OneOf param1 53 54 55 56 57 58 61 45 46 47)
			SmoothLooper
			(ScriptID 305) ; scubaRg
			RegionPath
		)
		(if (== param1 51) SmoothLooper)
		(if (OneOf param1 59 60 63 64 65 66 67 68 62 43)
			SmoothLooper
			(ScriptID 304) ; cavesRg
		)
		(if (OneOf param1 8 15 16)
			(ScriptID 308) ; oceanRg
		)
		(if
			(OneOf
				param1
				70
				71
				72
				73
				74
				75
				76
				77
				78
				79
				80
				81
				82
				83
				84
				85
				86
			)
			(ScriptID 310) ; tunisia
		)
		(if (OneOf param1 70 71 72)
			(ScriptID 306) ; guardcReg
		)
		(if (OneOf param1 73 74 75 76)
			(ScriptID 311) ; guardfReg
		)
		(if (OneOf param1 77 78 79 80 82 83)
			(ScriptID 312) ; guardjReg
		)
		(if
			(OneOf
				param1
				25
				26
				27
				28
				29
				30
				31
				32
				33
				34
				35
				36
				37
				38
				39
				40
				41
				42
				51
				50
			)
			(ScriptID 314) ; subMarine
			(if (not (OneOf param1 50 51)) Submarine)
			(ScriptID 827)
		)
		(if (not (OneOf param1 11 99 27 3 39 33 25))
			((ScriptID 307) init:) ; debugHandler
		)
		(if (= global54 (not (OneOf param1 39 27)))
			(ScriptID 984)
			(ScriptID 982)
			(= global56 90)
		)
		(Load rsSCRIPT 954)
		(DisposeScript 819)
	)
)

