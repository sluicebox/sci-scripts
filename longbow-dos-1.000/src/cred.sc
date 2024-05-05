;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 96)
(include sci.sh)
(use Main)
(use Interface)
(use verseScript)
(use Osc)
(use LoadMany)
(use DCIcon)
(use Game)
(use Actor)
(use System)

(public
	cred 0
)

(local
	local0
	local1
	local2
	local3 = 114
	local4 = 26
	local5
	local6
	[local7 2]
	local9
)

(instance cred of Rm
	(properties
		picture 95
		style 15
	)

	(method (init)
		(HandsOff)
		(gRgnMusic prevSignal: 0)
		(gMouseDownHandler add: theMumble)
		(gKeyDownHandler add: theMumble)
		(LoadMany rsPIC 95 905 803 96)
		(LoadMany rsVIEW 95 905 906)
		(if (IsFlag 0)
			(= local9 10)
		else
			(= local9 -32762)
		)
		(super init:)
		(gRgnMusic2 number: 905 play:)
		(AddToAddToPics bowPiece)
		(hand setPri: 13 init:)
		(grin setPri: 13 init:)
		(arrow setPri: 13 init:)
		(Graph grDRAW_LINE 63 67 0 130 local3 -1 -1)
		(Graph grDRAW_LINE 63 66 0 129 local4 -1 -1)
		(Graph grDRAW_LINE 71 68 189 127 local3 -1 -1)
		(Graph grDRAW_LINE 71 67 189 126 local4 -1 -1)
		(self setScript: theMumble)
	)

	(method (doit &tmp temp0 temp1)
		(++ local6)
		(= temp0 3)
		(if (and local5 (== (mod local6 8) 0))
			(Palette palANIMATE 241 255 -1)
		)
		(cond
			((== (mod local6 80) 0)
				(Palette palANIMATE 216 218 temp0)
				(Palette palANIMATE 233 235 temp0)
				(Palette palANIMATE 225 227 temp0)
			)
			((== (mod local6 80) 16)
				(Palette palANIMATE 217 219 temp0)
				(Palette palANIMATE 234 236 temp0)
				(Palette palANIMATE 227 229 temp0)
			)
			((== (mod local6 80) 32)
				(Palette palANIMATE 218 220 temp0)
				(Palette palANIMATE 235 237 temp0)
				(Palette palANIMATE 228 230 temp0)
			)
			((== (mod local6 80) 48)
				(Palette palANIMATE 219 221 temp0)
				(Palette palANIMATE 236 238 temp0)
				(Palette palANIMATE 229 231 temp0)
			)
			((== (mod local6 80) 64)
				(Palette palANIMATE 220 222 temp0)
				(Palette palANIMATE 237 239 temp0)
				(Palette palANIMATE 230 232 temp0)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(gRgnMusic flags: (| (gRgnMusic flags:) $0001))
		(gMouseDownHandler delete: theMumble)
		(gKeyDownHandler delete: theMumble)
		(super dispose: &rest)
	)
)

(instance bowPiece of PicView
	(properties
		x 216
		y 100
		view 95
		loop 3
		priority 15
		signal 16384
	)
)

(instance quitIcon of DCIcon
	(properties
		view 903
		cycleSpeed 18
	)

	(method (init)
		((= cycler (Osc new:)) init: self 1)
	)
)

(instance hand of Prop
	(properties
		x 44
		y 63
		view 95
		signal 16384
	)
)

(instance grin of Prop
	(properties
		x 99
		y 77
		view 95
		loop 1
		signal 16384
	)
)

(instance arrow of Actor
	(properties
		x 69
		y 67
		view 95
		loop 2
		signal 16384
	)
)

(instance titleName of PicView
	(properties
		x 45
		y 93
		view 905
	)
)

(instance NWview of PicView
	(properties
		view 905
	)
)

(instance NEview of PicView
	(properties
		x 258
		y 41
		view 906
	)
)

(instance SWview of PicView
	(properties
		x 63
		y 154
		view 906
		cel 4
	)
)

(instance theMumble of Script
	(properties)

	(method (doit)
		(if (== (gRgnMusic prevSignal:) -1)
			(HandsOn)
			(gCurRoom newRoom: 95) ; open
		)
		(super doit: &rest)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(event claimed: 1)
		(if
			(or
				(and (& (event modifiers:) emSHIFT) (& (event type:) evMOUSEBUTTON))
				(and (& (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
			)
			(self dispose:)
			(gCurRoom newRoom: 95) ; open
		)
		(if
			(or
				(== (event type:) evMOUSEBUTTON)
				(and (& (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
			)
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gGame setCursor: 5 1)
				(= seconds 3)
			)
			(1
				(self setScript: bowString self)
			)
			(2
				(= ticks 30)
			)
			(3
				(gSFX number: 908 loop: 1 play:)
				(= ticks 30)
			)
			(4
				(grin setCel: 1)
				(= ticks 24)
			)
			(5
				(gCurRoom drawPic: 95)
				(grin init:)
				(Graph grDRAW_LINE 0 142 38 142 local3 -1 -1)
				(Graph grDRAW_LINE 0 141 38 141 local4 -1 -1)
				(Graph grDRAW_LINE 47 142 65 142 local3 -1 -1)
				(Graph grDRAW_LINE 46 141 66 141 local4 -1 -1)
				(Graph grDRAW_LINE 72 142 78 142 local3 -1 -1)
				(Graph grDRAW_LINE 73 141 86 141 local4 -1 -1)
				(Graph grDRAW_LINE 82 142 85 142 local3 -1 -1)
				(Graph grDRAW_LINE 107 142 131 142 local3 -1 -1)
				(Graph grDRAW_LINE 107 141 160 141 local4 -1 -1)
				(Graph grDRAW_LINE 148 142 160 142 local3 -1 -1)
				(Graph grDRAW_LINE 168 142 189 142 local3 -1 -1)
				(Graph grDRAW_LINE 168 141 189 141 local4 -1 -1)
				(gCurRoom overlay: 96)
				(Animate 0)
				(= ticks 60)
			)
			(6
				(repeat
					(gGame setCursor: 999 1 293 168)
					(switch
						(Print ; "Welcome to Sherwood Forest. What is your pleasure?"
							96
							0
							#mode
							1
							#button
							{___Start____}
							1
							#button
							{__Restore___}
							2
							#button
							{Introduction}
							3
							#icon
							quitIcon
							1
							0
						)
						(1
							(gGame restart:)
						)
						(2
							(gGame restore:)
						)
						(3
							(self cue:)
							(return)
						)
					)
				)
			)
			(7
				(gGame setCursor: 5)
				(gRgnMusic
					number: 100
					loop: 1
					play: self
					flags: (& (gRgnMusic flags:) $fffe)
				)
				(= local5 1)
			)
			(8
				(gCast eachElementDo: #dispose)
				(= local5 0)
				(gCurRoom drawPic: 905 local9)
				(AddToAddToPics titleName SWview NEview)
			)
			(9
				(titleName cel: 1)
				(SWview cel: 4)
				(NEview cel: 0)
				(gCurRoom drawPic: 905 local9)
				(AddToAddToPics titleName SWview NEview)
			)
			(10
				(titleName cel: 2)
				(NWview x: 45 y: 93 cel: 4)
				(SWview cel: 4 x: 66)
				(NEview cel: 0)
				(gCurRoom drawPic: 905 local9)
				(AddToAddToPics titleName NWview SWview NEview)
			)
			(11
				(titleName x: 45 y: 93 cel: 5)
				(NWview x: 90 y: 131 cel: 6)
				(SWview x: 268 y: 100 cel: 2)
				(gCurRoom drawPic: 905 local9)
				(AddToAddToPics titleName NWview SWview)
			)
			(12
				(titleName x: 52 y: 89 cel: 3)
				(NWview x: 57 y: 91 cel: 4)
				(SWview x: 280 y: 65 cel: 2)
				(NEview x: 49 y: 149 cel: 5)
				(gCurRoom drawPic: 905 local9)
				(AddToAddToPics titleName NWview SWview NEview)
			)
			(13
				(titleName x: 45 y: 93 cel: 7)
				(SWview x: 256 y: 42 cel: 0)
				(NEview x: 45 y: 150 cel: 5)
				(gCurRoom drawPic: 905 local9)
				(AddToAddToPics titleName SWview NEview)
			)
			(14
				(titleName x: 41 y: 102 cel: 8)
				(NWview x: 161 y: 102 cel: 9)
				(SWview x: 91 y: 43 cel: 0)
				(NEview x: 209 y: 155 cel: 4)
				(gCurRoom drawPic: 905 local9)
				(AddToAddToPics titleName NWview SWview NEview)
			)
			(15
				(titleName x: 77 y: 90 cel: 10)
				(SWview x: 245 y: 43 cel: 0)
				(NEview x: 67 y: 150 cel: 5)
				(gCurRoom drawPic: 905 local9)
				(AddToAddToPics titleName SWview NEview)
			)
			(16)
			(17
				(HandsOn)
				(gCurRoom newRoom: 95) ; open
				(self dispose:)
			)
		)
	)
)

(instance bowString of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 95)
				(AddToAddToPics bowPiece)
				(arrow posn: 183 84 init:)
				(hand init: setCel: 1)
				(grin init:)
				(= ticks 4)
			)
			(1
				(hand dispose:)
				(arrow dispose:)
				(= local0 (Graph grSAVE_BOX 0 132 189 141 1))
				(= local1 (Graph grSAVE_BOX 0 143 189 151 1))
				(Graph grDRAW_LINE 30 139 159 139 local3 -1 -1)
				(Graph grDRAW_LINE 70 136 119 136 local3 -1 -1)
				(Graph grDRAW_LINE 90 133 99 133 local3 -1 -1)
				(Graph grDRAW_LINE 30 144 159 144 local4 -1 -1)
				(Graph grDRAW_LINE 70 147 119 147 local4 -1 -1)
				(Graph grDRAW_LINE 90 150 99 150 local4 -1 -1)
				(Graph grDRAW_LINE 0 142 189 142 local3 1 -1)
				(Graph grDRAW_LINE 0 141 189 141 local4 1 -1)
				(Graph grREDRAW_BOX 0 64 189 148)
				(= ticks 4)
			)
			(2
				(gSFX number: 906 loop: 1 play:)
				(Graph grRESTORE_BOX local0)
				(Graph grRESTORE_BOX local1)
				(Graph grREDRAW_BOX 0 132 189 141)
				(Graph grREDRAW_BOX 0 143 189 151)
				(= ticks 4)
			)
			(3
				(= local0 (Graph grSAVE_BOX 0 132 189 141 1))
				(= local1 (Graph grSAVE_BOX 0 143 189 151 1))
				(Graph grDRAW_LINE 30 139 159 139 local4 -1 -1)
				(Graph grDRAW_LINE 30 144 159 144 local3 -1 -1)
				(Graph grREDRAW_BOX 0 64 189 148)
				(= ticks 4)
			)
			(4
				(Graph grRESTORE_BOX local0)
				(Graph grRESTORE_BOX local1)
				(Graph grREDRAW_BOX 0 132 189 141)
				(Graph grREDRAW_BOX 0 143 189 151)
				(= ticks 4)
			)
			(5
				(self dispose:)
			)
		)
	)
)

