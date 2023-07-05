;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2)
(include sci.sh)
(use Main)
(use eRS)
(use Actor)
(use System)

(public
	rm002 0
)

(instance rm002 of PQRoom
	(properties
		picture 1
	)

	(method (init)
		(Palette palSET_FROM_RESOURCE 999 2)
		(Load rsPIC 100)
		(Load rsVIEW 105)
		(gLongSong number: 50 loop: -1 play:)
		(self setRegions: 127 setScript: rmScript) ; intro
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(super init:)
	)
)

(instance cycleColors of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Palette palANIMATE 208 213 1)
				(Palette palANIMATE 213 218 1)
				(Palette palANIMATE 218 223 1)
				(Palette palANIMATE 223 228 1)
				(Palette palANIMATE 229 234 -1)
				(Palette palANIMATE 234 239 -1)
				(Palette palANIMATE 239 244 -1)
				(Palette palANIMATE 244 249 -1)
				(= cycles 1)
				(= state -1)
			)
		)
	)
)

(instance rmScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 3])
		(switch (= state newState)
			(0
				(self setScript: cycleColors)
				(= cycles 1)
			)
			(1
				(= cycles 15)
			)
			(2
				(gCurRoom style: 100 overlay: 100)
				(= cycles 15)
			)
			(3
				(III init:)
				(= seconds 7)
			)
			(4
				(III dispose:)
				(gCurRoom style: 3 drawPic: 1 overlay: 82)
				(= seconds 10)
			)
			(5
				(self setScript: 0)
				(= cycles 1)
			)
			(6
				(gCurRoom drawPic: 98 10)
				(= cycles 2)
			)
			(7
				(gCurRoom newRoom: 3)
			)
		)
	)
)

(instance III of Prop
	(properties
		x 161
		y 172
		description {III}
		view 105
		priority 10
		signal 1
	)
)

