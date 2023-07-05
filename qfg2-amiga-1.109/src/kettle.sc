;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 131)
(include sci.sh)
(use Feature)

(public
	kettle 0
	fireplace 1
	niche 2
	ceiling 3
	cupboard 4
	sackOSomething 5
	wheelbarrow 6
	workbench 7
	workbench2 8
	alcove 9
	urns 10
	bigUrn 11
	hook 12
	hook2 13
	skull 14
	potOnStove 15
)

(instance kettle of Feature
	(properties
		x 51
		y 92
		noun '/caldron,pan'
		nsTop 86
		nsLeft 39
		nsBottom 99
		nsRight 63
		description {the black cauldron}
		lookStr {The red-enamelled black cauldron is encrusted and empty.}
	)
)

(instance fireplace of Feature
	(properties
		x 58
		y 112
		noun '/oven,chimney,(place<fire)'
		nsTop 104
		nsLeft 23
		nsBottom 120
		nsRight 93
		description {the wood-burning oven}
		lookStr {Under the cauldron is a wood-burning oven.  No fire is presently lit.}
	)
)

(instance niche of Feature
	(properties
		x 7
		y 96
		noun '/niche,alcove,window'
		nsTop 78
		nsLeft 2
		nsBottom 114
		nsRight 12
		description {the niche}
		lookStr {The niche is empty.}
	)
)

(instance ceiling of Feature
	(properties
		x 159
		y 20
		noun '/ceiling'
		nsTop -1
		nsBottom 42
		nsRight 318
		description {the strangely patterned ceiling}
		lookStr {The ceiling reminds you of a night you spent in the land of Haight-Ashbury many years ago.  As a matter of fact, the whole place is like that.}
	)
)

(instance cupboard of Feature
	(properties
		x 304
		y 102
		noun '/armoire,armoire,(board<cup)'
		nsTop 50
		nsLeft 289
		nsBottom 154
		nsRight 319
		description {the cupboard}
		lookStr {The cupboard is closed.}
	)
)

(instance wheelbarrow of Feature
	(properties
		x 41
		y 172
		noun '/barrow,barrow'
		nsTop 164
		nsLeft 10
		nsBottom 180
		nsRight 73
		description {the wheelbarrow}
		lookStr {It isn't your garden variety wheelbarrow.}
	)
)

(instance workbench of Feature
	(properties
		x 197
		y 141
		noun '/workbench,counter,bench'
		nsTop 130
		nsLeft 163
		nsBottom 152
		nsRight 232
		description {Harik's workbench}
		lookStr {It is Harik's workbench.}
	)
)

(instance workbench2 of Feature
	(properties
		x 245
		y 135
		noun '/workbench,counter,bench'
		nsTop 122
		nsLeft 231
		nsBottom 149
		nsRight 259
		description {Harik's workbench}
		lookStr {It is Harik's workbench.}
	)
)

(instance sackOSomething of Feature
	(properties
		x 23
		y 173
		noun '/bag,bag'
		nsTop 167
		nsLeft 12
		nsBottom 180
		nsRight 35
		description {the sack }
		lookStr {It is a sack filled with sand.}
	)
)

(instance alcove of Feature
	(properties
		x 162
		y 72
		noun '/alcove,platform'
		nsTop 52
		nsLeft 128
		nsBottom 93
		nsRight 196
		description {the alcove for burning incense}
		lookStr {The alcove contains censers and burning incense.  The next game will be uncensered.}
	)
)

(instance urns of Feature
	(properties
		x 276
		y 158
		noun '/urn,boob'
		nsTop 135
		nsLeft 243
		nsBottom 181
		nsRight 310
		description {the ululation of urns}
		lookStr {Last week's urnings.}
	)
)

(instance bigUrn of Feature
	(properties
		x 234
		y 166
		noun '/urn,boob<big'
		nsTop 153
		nsLeft 215
		nsBottom 180
		nsRight 253
		description {the very large urn}
		lookStr {How much does a Grecian urn?}
	)
)

(instance hook of Feature
	(properties
		x 50
		y 74
		noun '/hook,hang'
		nsTop 65
		nsLeft 46
		nsBottom 83
		nsRight 55
		description {the cauldron hook}
		lookStr {The hook is often used to hold the red-enamelled black cauldron off the fire.}
	)
)

(instance hook2 of Feature
	(properties
		x 67
		y 64
		noun '/hook,hang'
		nsTop 62
		nsLeft 55
		nsBottom 67
		nsRight 80
		description {the cauldron hook}
		lookStr {The hook holds the black cauldron off the fire.  It was a donation from Peter Pan's personal mementos.}
	)
)

(instance skull of Feature
	(properties
		x 244
		y 80
		noun '/skull'
		nsTop 76
		nsLeft 240
		nsBottom 84
		nsRight 249
		description {the skull}
		lookStr {Part of Harik's father-in-law.  Just wouldn't fit in an urn.}
	)
)

(instance potOnStove of Feature
	(properties
		x 29
		y 99
		noun '/pan,contain'
		nsTop 95
		nsLeft 22
		nsBottom 103
		nsRight 37
		description {the pot on the stove}
		lookStr {Whatever was in this pot before, you're glad it's not there now.}
	)
)

