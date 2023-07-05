;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 701)
(include sci.sh)
(use Main)
(use Interface)
(use Game)
(use Menu)
(use System)

(public
	rm701 0
)

(local
	[local0 40]
)

(procedure (localproc_0 &tmp temp0)
	(while ((= temp0 (Event new:)) type:)
		(temp0 dispose:)
	)
	(temp0 dispose:)
)

(procedure (localproc_1 &tmp temp0 temp1)
	(for ((= temp0 0)) (= temp1 (StrAt @local0 temp0)) ((++ temp0))
		(if (and (>= temp1 97) (<= temp1 122))
			(StrAt @local0 temp0 (- temp1 32))
		)
	)
)

(instance event of Event ; UNUSED
	(properties)
)

(instance rm701 of Rm
	(properties
		picture 701
	)

	(method (init)
		(super init:)
	)

	(method (doit &tmp temp0 temp1)
		(= temp0 (& (GetTime 1) $0007)) ; SysTime12
		(= local0 0)
		(localproc_0)
		(gGame parseLang: 1)
		(Print 701 0 #icon 701 0 temp0 #edit @local0 20) ; "\8e\f3\90M\90l\81F\83{\83\93\83h\8cY\8e\96 \94\ad\90M\8c\b3\81F\83z\81[\83\8b\8cx\95\94 \8f\d8\8b\92\8e\ca\90^\82\cc\90g\8c\b3\8am\94F\82\cc\8c\8f \8eE\90l\8e\96\8c\8f\82P\82W\82U\82V\82T\82P\8d\86\82\cc\8f\d8\8b\92\8e\ca\90^\81i\93Y\95t\81j\82\cc \90l\95\a8\82\cc\96\bc\8e\9a\82\f0\95\f1\8d\90\82\b7\82\e9\82\b1\82\c6\81B \8e\8a\8b}\81A\89\ba\82\cc\8b\f3\97\93\82\c9\95\d4\93\9a\82\b7\82\e9\82\b1\82\c6\81I"
		(= gQuit 1)
		(localproc_1)
		(switch temp0
			(0
				(if (not (StrCmp @local0 {GRANANDEZ}))
					(= gQuit 0)
				)
			)
			(1
				(if (not (StrCmp @local0 {SIMMS}))
					(= gQuit 0)
				)
			)
			(2
				(if (not (StrCmp @local0 {TASELLI}))
					(= gQuit 0)
				)
			)
			(3
				(if (not (StrCmp @local0 {COLBY}))
					(= gQuit 0)
				)
			)
			(4
				(if (not (StrCmp @local0 {BAINS}))
					(= gQuit 0)
				)
			)
			(5
				(if (not (StrCmp @local0 {SNIDER}))
					(= gQuit 0)
				)
			)
			(6
				(if (not (StrCmp @local0 {JONES}))
					(= gQuit 0)
				)
			)
			(else
				(if (not (StrCmp @local0 {DICKEY}))
					(= gQuit 0)
				)
			)
		)
		(if gQuit
			(Print 701 1) ; "Sorry Bonds, you'll need to do better than that!"
		else
			(MenuBar draw:)
			(SL enable:)
			(gGame parseLang: 81)
			(gGame restart:)
		)
	)
)

