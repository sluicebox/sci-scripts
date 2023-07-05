;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3800)
(include sci.sh)
(use Main)
(use WriteFeature)
(use Menu)

(class AlienLine of Obj
	(properties
		verb 0
		line 0
		threadDone 0
		yesHot 0
		yesLine 0
		noHot 0
		noLine 0
		whenHot 0
		whenLine 0
		howHot 0
		howLine 0
		whyHot 0
		whyLine 0
	)

	(method (new param1 param2 param3 param4 param5 param6 param7 param8 param9 param10 param11 param12 &tmp temp0)
		(= temp0 (super new:))
		(temp0 line: param1)
		(temp0 verb: param2)
		(if (== argc 3)
			(temp0 threadDone: 1)
		else
			(temp0 yesHot: param3)
			(temp0 yesLine: param4)
			(temp0 noHot: param5)
			(temp0 noLine: param6)
			(temp0 whenHot: param7)
			(temp0 whenLine: param8)
			(temp0 howHot: param9)
			(temp0 howLine: param10)
			(temp0 whyHot: param11)
			(temp0 whyLine: param12)
			(temp0 threadDone: 0)
		)
		(return temp0)
	)
)

(class CommentPicker of Obj
	(properties
		path 0
	)

	(method (init)
		(= path (List new:))
		(switch global244
			(1
				(path
					add:
						(AlienLine new: 1 0 1 2 1 7 1 12 1 13 1 14)
						(AlienLine new: 2 53 0 0 1 7 1 4 1 5 1 6)
						(AlienLine new: 4 55 1)
						(AlienLine new: 5 56 1)
						(AlienLine new: 6 57 1)
						(AlienLine new: 7 58 1 2 0 0 1 9 1 10 1 11)
						(AlienLine new: 9 60 1)
						(AlienLine new: 10 61 1)
						(AlienLine new: 11 62 1)
						(AlienLine new: 12 63 1)
						(AlienLine new: 13 64 1)
						(AlienLine new: 14 65 1)
				)
			)
			(2
				(path
					add:
						(AlienLine new: 15 0 1 16 1 23 1 30 0 0 1 31)
						(AlienLine new: 16 53 1 17 1 18 1 19 1 20 1 21)
						(AlienLine new: 17 66 1)
						(AlienLine new: 18 54 1)
						(AlienLine new: 19 55 1)
						(AlienLine new: 20 56 1)
						(AlienLine new: 21 57 1 22 1 22 1 22 1 22 1 22)
						(AlienLine new: 22 67 1)
						(AlienLine new: 23 58 1 24 1 25 1 27 1 26 1 28)
						(AlienLine new: 24 59 1 17 1 18 1 19 1 20 1 21)
						(AlienLine new: 25 69 1)
						(AlienLine new: 26 71 1)
						(AlienLine new: 27 70 1)
						(AlienLine new: 28 62 1 17 1 18 1 19 1 20 1 21)
						(AlienLine new: 30 63 1)
						(AlienLine new: 31 65 1 32 1 34 1 35 0 0 1 36)
						(AlienLine new: 32 74 1 17 1 18 1 19 1 20 1 21)
						(AlienLine new: 34 76 1)
						(AlienLine new: 35 77 1)
						(AlienLine new: 36 78 1)
				)
			)
			(3
				(path
					add:
						(AlienLine new: 37 0 1 38 1 68 1 90 1 103 1 109)
						(AlienLine new: 38 53 1 39 1 39 1 48 1 55 1 62)
						(AlienLine new: 39 66 1 40 1 41 1 43 1 44 1 45)
						(AlienLine new: 40 79 1)
						(AlienLine new: 41 80 1 42 1 42 1 42 1 42 1 42)
						(AlienLine new: 42 81 1)
						(AlienLine new: 43 82 1)
						(AlienLine new: 44 83 1)
						(AlienLine new: 45 84 1 46 1 46 1 46 1 46 1 46)
						(AlienLine new: 46 85 1)
						(AlienLine new: 48 55 1 49 1 50 1 51 1 52 1 53)
						(AlienLine new: 49 86 1)
						(AlienLine new: 50 87 1)
						(AlienLine new: 51 88 1)
						(AlienLine new: 52 89 1)
						(AlienLine new: 53 90 1 54 1 54 1 54 1 54 1 54)
						(AlienLine new: 54 91)
						(AlienLine new: 55 56 1 56 1 57 1 58 1 59 1 60)
						(AlienLine new: 56 92 1)
						(AlienLine new: 57 93 1)
						(AlienLine new: 58 94 1)
						(AlienLine new: 59 95 1)
						(AlienLine new: 60 96 1 61 1 61 1 61 1 61 1 61)
						(AlienLine new: 61 97 1)
						(AlienLine new: 62 57 1 63 1 64 1 66 1 65 1 67)
						(AlienLine new: 63 98 1)
						(AlienLine new: 64 99 1)
						(AlienLine new: 65 100 1)
						(AlienLine new: 66 101 1)
						(AlienLine new: 67 102 1)
						(AlienLine new: 68 58 1 70 1 69 1 78 1 76 1 84)
						(AlienLine new: 69 103 1)
						(AlienLine new: 70 59 1 72 1 71 1 73 1 74 1 75)
						(AlienLine new: 71 104 1)
						(AlienLine new: 72 105 1)
						(AlienLine new: 73 106 1)
						(AlienLine new: 74 107 1)
						(AlienLine new: 75 108 1)
						(AlienLine new: 76 61 1 77 1 77 1 77 1 77 1 77)
						(AlienLine new: 77 109 1)
						(AlienLine new: 78 60 1 83 1 79 1 81 1 80 1 82)
						(AlienLine new: 79 110 1)
						(AlienLine new: 80 113 1)
						(AlienLine new: 81 112 1)
						(AlienLine new: 82 114 1)
						(AlienLine new: 83 111 1)
						(AlienLine new: 84 62 1 89 1 85 1 87 1 86 1 88)
						(AlienLine new: 85 115 1)
						(AlienLine new: 86 118 1)
						(AlienLine new: 87 117 1)
						(AlienLine new: 88 119 1)
						(AlienLine new: 89 116 1)
						(AlienLine new: 90 63 1 91 1 97 1 98 1 99 1 101)
						(AlienLine new: 91 120 1 93 1 92 1 94 1 95 1 96)
						(AlienLine new: 92 121 1)
						(AlienLine new: 93 122 1)
						(AlienLine new: 94 123 1)
						(AlienLine new: 95 124 1)
						(AlienLine new: 96 125 1)
						(AlienLine new: 97 126 1)
						(AlienLine new: 98 127 1)
						(AlienLine new: 99 128 1 100 1 100 1 100 1 100 1 100)
						(AlienLine new: 100 129 1)
						(AlienLine new: 101 130 1 102 1 102 1 102 1 102 1 102)
						(AlienLine new: 102 131 1)
						(AlienLine new: 103 64 1 108 1 104 1 106 1 105 1 107)
						(AlienLine new: 104 132 1)
						(AlienLine new: 105 135 1)
						(AlienLine new: 106 134 1)
						(AlienLine new: 107 136 1)
						(AlienLine new: 108 133 1)
						(AlienLine new: 109 65 1 110 1 116 0 0 1 117 1 118)
						(AlienLine new: 110 74 1 112 1 111 1 113 1 114 1 115)
						(AlienLine new: 111 137 1)
						(AlienLine new: 112 138 1)
						(AlienLine new: 113 139 1)
						(AlienLine new: 114 140 1)
						(AlienLine new: 115 141 1)
						(AlienLine new: 116 142 1)
						(AlienLine new: 117 143 1)
						(AlienLine new: 118 78 1)
				)
			)
		)
	)

	(method (dispose)
		(if path
			(path eachElementDo: #dispose)
			(path release: dispose:)
		)
		(= path 0)
	)

	(method (findLine param1 &tmp temp0 temp1)
		(for ((= temp0 (path first:))) temp0 ((= temp0 (path next: temp0)))
			(= temp1 (path value: temp0))
			(if (== (temp1 line:) param1)
				(return temp1)
			)
		)
		(PrintDebug {Line %d not found} param1)
		(return 0)
	)

	(method (isBtnHot param1 &tmp temp0)
		(if (= temp0 (self findLine: global245))
			(switch param1
				(1
					(return (temp0 yesHot:))
				)
				(2
					(return (temp0 noHot:))
				)
				(3
					(return (temp0 whenHot:))
				)
				(4
					(return (temp0 howHot:))
				)
				(5
					(return (temp0 whyHot:))
				)
			)
		else
			(PrintDebug {Btn not hot})
			(return 0)
		)
	)

	(method (getVerb &tmp temp0)
		(if (= temp0 (self findLine: global245))
			(return (temp0 verb:))
		else
			(PrintDebug {Verb not found})
			(return 0)
		)
	)

	(method (getCase &tmp temp0 temp1)
		(= temp0 (self findLine: global245))
		(= temp1 (temp0 line:))
		(cond
			((<= 1 temp1 14)
				(return 1)
			)
			((<= 15 temp1 36)
				(return 2)
			)
			((<= 37 temp1 118)
				(return 3)
			)
			(else
				(PrintDebug {Case not found})
				(return 0)
			)
		)
	)

	(method (doit param1 &tmp temp0)
		(= temp0 (self findLine: global245))
		(= global245
			(switch param1
				(1
					(temp0 yesLine:)
				)
				(2
					(temp0 noLine:)
				)
				(3
					(temp0 whenLine:)
				)
				(4
					(temp0 howLine:)
				)
				(5
					(temp0 whyLine:)
				)
			)
		)
	)
)

