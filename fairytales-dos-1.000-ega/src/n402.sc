;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 402)
(include sci.sh)
(use Main)
(use n010)
(use User)
(use Actor)
(use System)

(public
	proc402_0 0
)

(local
	local0 = -1
	local1
	local2
	local3
)

(procedure (proc402_0 &tmp [temp0 2] temp2 temp3 temp4)
	(HandsOff)
	(User canInput: 1)
	(gGame setCursor: 69)
	(gTheIconBar disable:)
	(gEgo setMotion: 0)
	(= local3 (gCurRoom lookStr:))
	(gCurRoom lookStr: 0)
	(= temp2 (gCurRoom picture:))
	(= local0 gOverlays)
	(gCast eachElementDo: #hide)
	(gCurRoom drawPic: 205 10)
	(proc10_27)
	(gEgo posn: 160 101 loop: 2 cel: 0 setPri: 4 normal: 0 setCycle: 0 show:)
	(doorSet add: gEgo doorT doorB)
	(= gTickOffset (- gGameTime (GetTime)))
	(while 1
		(= temp3 (Event new:))
		(= temp4 (temp3 type:))
		(temp3 dispose:)
		(= gGameTime (+ gTickOffset (GetTime)))
		(Animate (doorSet elements:) 1)
		(breakif (OneOf temp4 evKEYBOARD evMOUSEBUTTON evJOYDOWN))
	)
	(= local2 999)
	(doorSet delete: gEgo)
	(doorSet eachElementDo: #dispose eachElementDo: #delete dispose:)
	(gCurRoom drawPic: temp2 10)
	(proc10_27)
	(if (!= (= gOverlays local0) -1)
		(DrawPic gOverlays 10 0 global40)
	)
	(NormalEgo 5 global139)
	(gEgo setPri: -1 posn: 179 103 normal: 1)
	(gCast eachElementDo: #show)
	(gCurRoom lookStr: local3)
	(HandsOn 1)
	(gTheIconBar enable:)
	(DisposeScript 402)
)

(instance doorSet of Set
	(properties)
)

(instance doorT of View
	(properties
		x 105
		y 80
		view 205
		loop 1
	)
)

(instance doorB of View
	(properties
		x 105
		y 108
		view 205
	)
)

