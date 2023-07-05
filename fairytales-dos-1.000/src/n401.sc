;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 401)
(include sci.sh)
(use Main)
(use n010)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	proc401_0 0
)

(local
	local0
	local1 = -1
	[local2 2]
	local4
	local5
	[local6 78] = [110 53 49 120 109 47 130 162 46 140 191 47 150 273 46 160 48 67 170 102 66 180 147 70 190 206 61 200 261 66 210 52 93 220 139 103 230 165 84 235 180 78 240 211 94 250 270 96 260 61 123 270 104 120 280 171 117 290 204 114 300 273 116 310 62 149 320 107 150 330 155 150 340 202 138 350 272 149]
)

(procedure (proc401_0 &tmp temp0 temp1 temp2 temp3)
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
	(User canInput: 1)
	(gTheIconBar disable:)
	(gGame setCursor: 69)
	(gEgo setMotion: 0)
	(= temp0 (gCurRoom picture:))
	(= local4 (gCurRoom lookStr:))
	(gCurRoom lookStr: 0)
	(= local1 gOverlays)
	(= local0 (List new:))
	(for ((= temp3 0)) (< temp3 (gCast size:)) ((++ temp3))
		(if (& ((gCast at: temp3) signal:) $0080)
			(local0 add: (gCast at: temp3))
			(gCast delete: (gCast at: temp3))
		)
	)
	(gCast eachElementDo: #hide)
	(gCurRoom drawPic: 400 10)
	(proc10_27)
	(for
		((= local5 0))
		(and (<= local5 77) (!= gCurRoomNum [local6 local5]))
		((+= local5 3))
	)
	(mapMarker posn: [local6 (+ local5 1)] [local6 (+ local5 2)] setCycle: Fwd)
	(mapSet add: mapMarker)
	(= gTickOffset (- gGameTime (GetTime)))
	(while 1
		(= temp1 (Event new:))
		(= temp2 (temp1 type:))
		(temp1 dispose:)
		(= gGameTime (+ gTickOffset (GetTime)))
		(Animate (mapSet elements:) 1)
		(breakif (OneOf temp2 evKEYBOARD evMOUSEBUTTON evJOYDOWN))
	)
	(HandsOn)
	(NormalEgo 5 global139)
	(mapSet eachElementDo: #dispose eachElementDo: #delete dispose:)
	(gCurRoom drawPic: temp0 10)
	(proc10_27)
	(if (!= (= gOverlays local1) -1)
		(DrawPic gOverlays 10 0 global40)
	)
	(gCast eachElementDo: #show)
	(for ((= temp3 0)) (< temp3 (local0 size:)) ((++ temp3))
		(gCast addToEnd: (local0 at: temp3))
	)
	(local0 release: dispose:)
	(gCurRoom lookStr: local4)
	(HandsOn 1)
	(gTheIconBar enable:)
	(DisposeScript 401)
)

(instance mapSet of Set
	(properties)
)

(instance mapMarker of Prop
	(properties
		view 810
	)
)

